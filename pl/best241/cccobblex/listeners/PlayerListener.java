// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.cccobblex.listeners;

import pl.best241.cccobblex.managers.DropManager;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Event;
import pl.best241.cccobblex.messages.MessagesData;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import pl.best241.cccobblex.CcCobbleX;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.Listener;

public class PlayerListener implements Listener
{
    @EventHandler
    public static void onCraftItem(final CraftItemEvent event) {
        if (event.getRecipe().getResult().isSimilar(CcCobbleX.getCobbleX())) {
            if (event.getInventory().contains(Material.COBBLESTONE, 576)) {
                ((Player)event.getWhoClicked()).sendMessage(MessagesData.youHaveOpenedCobbleX);
                final ItemStack result = event.getInventory().getResult();
                event.getInventory().clear();
                event.getInventory().setResult(result);
                ((Player)event.getWhoClicked()).updateInventory();
            }
            else {
                ((Player)event.getWhoClicked()).sendMessage(MessagesData.youNeedItemsToCraftIt);
                event.setCancelled(true);
                event.setResult(Event.Result.DENY);
            }
        }
    }
    
    @EventHandler
    public static void onBlockPlace(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final ItemStack item = player.getItemInHand().clone();
        if (CcCobbleX.getCobbleX().isSimilar(item)) {
            item.setAmount(1);
            player.getInventory().removeItem(new ItemStack[] { item });
            DropManager.giveDrop(event.getBlock().getLocation());
            player.sendMessage(MessagesData.youChangedCobblestone);
            event.getBlock().setType(Material.AIR);
        }
    }
}
