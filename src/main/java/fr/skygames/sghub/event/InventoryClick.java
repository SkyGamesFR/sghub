package fr.skygames.sghub.event;

import fr.skygames.sghub.Main;
import fr.skygames.sghub.utils.PluginMessageHelper;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.*;

public class InventoryClick implements Listener {

    private final Plugin plugin;

    public InventoryClick(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        if (event.getCurrentItem() != null) {
            ItemStack clickedItem = event.getCurrentItem();
            switch (clickedItem.getItemMeta().getDisplayName()) {
                case "§6§lSIGMA Σ":
                    PluginMessageHelper.sendPluginMessage(player, "Connect", new String[]{"sigma"});
                    player.sendMessage("§7[§6§lSkyGames§7] §6§lΣ §7» §7Vous avez été téléporté sur le serveur §6§lSIGMA");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    break;
                case "§6§lTAU τ":
                    PluginMessageHelper.sendPluginMessage(player, "Connect", new String[]{"tau"});
                    player.sendMessage("§7[§6§lSkyGames§7] §6§lτ §7» §7Vous avez été téléporté sur le serveur §6§lTAU");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    break;
                case "§6§lUPSILON υ":
                    PluginMessageHelper.sendPluginMessage(player, "Connect", new String[]{"upsilon"});
                    player.sendMessage("§7[§6§lSkyGames§7] §6§lυ §7» §7Vous avez été téléporté sur le serveur §6§lUPSILON");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    break;
                case "§6§lPHI φ":
                    PluginMessageHelper.sendPluginMessage(player, "Connect", new String[]{"phi"});
                    player.sendMessage("§7[§6§lSkyGames§7] §6§lφ §7» §7Vous avez été téléporté sur le serveur §6§lPHI");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    break;
                case "§6§lDiscord":
                    player.spigot().sendMessage((new ComponentBuilder("Le lien du discord est: https://skygames.fr/discord"))
                            .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://skygames.fr/discord"))
                            .create());
                    break;
                case "§6§lSite":
                    player.spigot().sendMessage((new ComponentBuilder("Le lien du site est: https://skygames.fr"))
                            .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://skygames.fr/"))
                            .create());
                    break;
                case "§6§lStatistiques":
                    player.sendMessage("§7[§6§lSkyGames§7] §6§lStatistiques §7» §4Prochainement disponible");
                    break;
                case "§6§lAmis":
                    player.sendMessage("§7[§6§lSkyGames§7] §6§lAmis §7» §4Prochainement disponible");
                    break;
                case "§6§lParamètres":
                    player.sendMessage("§7[§6§lSkyGames§7] §6§lParamètres §7» §4Prochainement disponible");
                    break;
                case "§6§lRetour":
                    player.closeInventory();
                    break;
                default:
                    break;
            }
        }
    }

}
