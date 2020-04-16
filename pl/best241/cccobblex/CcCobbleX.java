// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.cccobblex;

import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pl.best241.cccobblex.messages.MessagesData;
import pl.best241.cccobblex.listeners.PubSubRecieveMessageListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import pl.best241.cccobblex.listeners.PlayerListener;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CcCobbleX extends JavaPlugin
{
    private static ItemStack cobbleX;
    private static ShapedRecipe cobbleXrecipe;
    private static CcCobbleX plugin;
    
    public void onEnable() {
        CcCobbleX.plugin = this;
        CcCobbleX.cobbleXrecipe = loadRecipe();
        this.getServer().addRecipe((Recipe)CcCobbleX.cobbleXrecipe);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PubSubRecieveMessageListener(), (Plugin)this);
        MessagesData.loadMessages((Plugin)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lable, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("cx")) {
            if (sender instanceof Player) {
                final Player player = (Player)sender;
                int cobbleNumber = 0;
                for (final ItemStack item : player.getInventory().getContents()) {
                    if (item != null) {
                        if (item.getType() == Material.COBBLESTONE) {
                            cobbleNumber += item.getAmount();
                        }
                    }
                }
                if (cobbleNumber >= 576) {
                    player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.COBBLESTONE, 576) });
                    player.getInventory().addItem(new ItemStack[] { getCobbleX().clone() });
                    player.sendMessage(MessagesData.youCraftedCobbleX);
                }
                else {
                    player.sendMessage(MessagesData.youHaventGotEnoughtCobble);
                }
            }
            else {
                sender.sendMessage(MessagesData.commandOnlyForPlayers);
            }
        }
        return false;
    }
    
    private static ShapedRecipe loadRecipe() {
        (CcCobbleX.cobbleX = new ItemStack(Material.COBBLESTONE)).addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
        final ItemMeta meta = CcCobbleX.cobbleX.getItemMeta();
        meta.setDisplayName(MessagesData.cobblexName);
        final ArrayList<String> lore = new ArrayList<String>();
        lore.add(MessagesData.putOnGroundToHaveFun);
        meta.setLore((List)lore);
        CcCobbleX.cobbleX.setItemMeta(meta);
        final ShapedRecipe shapedReciepe = new ShapedRecipe(new ItemStack(CcCobbleX.cobbleX));
        shapedReciepe.shape(new String[] { "ccc", "ccc", "ccc" });
        shapedReciepe.setIngredient('c', Material.COBBLESTONE);
        return shapedReciepe;
    }
    
    public static ItemStack getCobbleX() {
        return CcCobbleX.cobbleX;
    }
    
    public static ShapedRecipe getCobbleXRecipe() {
        return CcCobbleX.cobbleXrecipe;
    }
    
    public static boolean isCobbleX(final ItemStack item) {
        if (item.getType() != Material.COBBLESTONE) {
            return false;
        }
        if (item.getEnchantmentLevel(Enchantment.ARROW_DAMAGE) != 10) {
            return false;
        }
        if (item.getItemMeta().getDisplayName() == null) {
            if (MessagesData.cobblexName == null) {
                return true;
            }
        }
        else if (item.getItemMeta().getDisplayName().equals(MessagesData.cobblexName)) {
            return true;
        }
        return false;
    }
    
    public static CcCobbleX getPlugin() {
        return CcCobbleX.plugin;
    }
}
