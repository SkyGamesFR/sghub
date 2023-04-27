package fr.skygames.sghub.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gui {

    public static void openTravelGui(PlayerInteractEvent event, Player player) {
        Inventory travelGui = Bukkit.createInventory(null, 54, "§7HUB");

        fillInventory(travelGui);

        travelGui.setItem(13, new ItemBuilder(Material.DIAMOND_SWORD).setName("§6§lSIGMA Σ")
                .setLore("§7Cliquez pour rejoindre le serveur §6§lSIGMA Σ")
                .toItemStack());
        travelGui.setItem(31, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§6§lTAU τ")
                .setLore("§7Cliquez pour rejoindre le serveur §6§lTAU τ")
                .toItemStack());
        travelGui.setItem(23, new ItemBuilder(Material.DIAMOND_AXE).setName("§6§lUPSILON υ")
                .setLore("§7Cliquez pour rejoindre le serveur §6§lUPSILON υ")
                .toItemStack());
        travelGui.setItem(21, new ItemBuilder(Material.DIAMOND_HOE).setName("§6§lPHI φ")
                .setLore("§7Cliquez pour rejoindre le serveur §6§lPHI Φ")
                .toItemStack());

        travelGui.setItem(37, Heads.EARTH.getDiscordHead());
        travelGui.setItem(43, Heads.EARTH.getEarthHead());

        player.openInventory(travelGui);

        event.setCancelled(true);
    }

    public static void openPlayerProfile(PlayerInteractEvent event, Player player) {
        Inventory profileGui = Bukkit.createInventory(null, 54, "§7" + player.getName());

        fillInventory(profileGui);

        ItemStack playerHead = Items.PLAYER_HEAD(player);
        ItemMeta playerHeadMeta = playerHead.getItemMeta();
        playerHeadMeta.setDisplayName("§6§l" + player.getName());
        playerHead.setItemMeta(playerHeadMeta);

        ItemStack playerStats = new ItemStack(Material.PAPER);
        ItemMeta playerStatsMeta = playerStats.getItemMeta();
        playerStatsMeta.setDisplayName("§6§lStatistiques");
        playerStats.setItemMeta(playerStatsMeta);

        ItemStack playerFriends = new ItemStack(Material.NAME_TAG);
        ItemMeta playerFriendsMeta = playerFriends.getItemMeta();
        playerFriendsMeta.setDisplayName("§6§lAmis");
        playerFriends.setItemMeta(playerFriendsMeta);

        ItemStack playerSettings = new ItemStack(Material.REDSTONE_COMPARATOR);
        ItemMeta playerSettingsMeta = playerSettings.getItemMeta();
        playerSettingsMeta.setDisplayName("§6§lParamètres");
        playerSettings.setItemMeta(playerSettingsMeta);

        ItemStack playerBack = new ItemStack(Material.ARROW);
        ItemMeta playerBackMeta = playerBack.getItemMeta();
        playerBackMeta.setDisplayName("§6§lRetour");
        playerBack.setItemMeta(playerBackMeta);

        // set items in profile gui
        profileGui.setItem(4, playerHead);
        profileGui.setItem(20, playerStats);
        profileGui.setItem(22, playerFriends);
        profileGui.setItem(24, playerSettings);
        profileGui.setItem(40, playerBack);


        player.openInventory(profileGui);

        event.setCancelled(true);
    }

    private static void fillInventory(Inventory gui) {
        for (int i = 0; i < 54; i++) {
            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) Math.round(Math.random() * 15));
            ItemMeta glassMeta = glass.getItemMeta();
            glassMeta.setDisplayName(" ");
            glass.setItemMeta(glassMeta);
            gui.setItem(i, glass);
        }
    }
}
