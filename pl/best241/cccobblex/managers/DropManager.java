// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.cccobblex.managers;

import org.bukkit.Location;
import org.bukkit.Material;
import java.util.Random;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;

public class DropManager
{
    private static ArrayList<ItemStack> items;
    private static final Random random;
    
    private static void loadItems() {
        (DropManager.items = new ArrayList<ItemStack>()).add(new ItemStack(Material.GOLDEN_APPLE));
        DropManager.items.add(new ItemStack(Material.CARROT));
        DropManager.items.add(new ItemStack(Material.CROPS));
        DropManager.items.add(new ItemStack(Material.ENDER_PEARL));
        DropManager.items.add(new ItemStack(Material.PAPER));
        DropManager.items.add(new ItemStack(Material.SLIME_BALL));
        DropManager.items.add(new ItemStack(Material.LAVA_BUCKET));
        DropManager.items.add(new ItemStack(Material.APPLE));
        DropManager.items.add(new ItemStack(Material.ANVIL));
        DropManager.items.add(new ItemStack(Material.WORKBENCH));
        DropManager.items.add(new ItemStack(Material.TNT));
        DropManager.items.add(new ItemStack(Material.SADDLE));
        DropManager.items.add(new ItemStack(Material.MELON));
        DropManager.items.add(new ItemStack(Material.BOOKSHELF));
    }
    
    public static void giveDrop(final Location loc) {
        if (DropManager.items == null) {
            loadItems();
        }
        final ItemStack item = DropManager.items.get(DropManager.random.nextInt(DropManager.items.size()));
        item.setAmount(1 + DropManager.random.nextInt(6));
        loc.getWorld().dropItemNaturally(loc, item);
    }
    
    static {
        random = new Random();
    }
}
