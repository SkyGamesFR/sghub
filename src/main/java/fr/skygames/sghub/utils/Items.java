package fr.skygames.sghub.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Items {

    public static ItemStack COMPASS() {
        ItemBuilder builder = new ItemBuilder(Material.COMPASS);
        builder.setName("§6§lMenu");
        builder.setLore("§7Cliquez pour ouvrir le menu");
        return builder.toItemStack();
    }

    public static ItemStack PLAYER_HEAD(Player player) {
        ItemBuilder builder = new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3);
        builder.setSkullOwner(player.getName());
        builder.setName("§6§l" + player.getName());
        builder.setLore("§7Cliquez pour ouvrir le menu");
        return builder.toItemStack();
    }

}
