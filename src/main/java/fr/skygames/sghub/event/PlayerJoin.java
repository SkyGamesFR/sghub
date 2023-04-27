package fr.skygames.sghub.event;

import fr.skygames.sghub.Main;
import fr.skygames.sghub.managers.Manager;
import fr.skygames.sghub.utils.Items;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.platform.PlayerAdapter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener {

    private final Location spawnLocation;
    private final LuckPerms luckPerms = Main.getLuckPerms();

    public PlayerJoin(World world, double x, double y, double z, float yaw, float pitch) {
        this.spawnLocation = new Location(world, x, y, z, yaw, pitch);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(luckPerms == null) {
            System.out.println("§4§lLuckPerms is null");
            return;
        }

        PlayerAdapter<Player> adapter = luckPerms.getPlayerAdapter(Player.class);
        CachedMetaData metaData = adapter.getMetaData(player);
        String group = (metaData.getPrefix() != null) ? metaData.getPrefix() + " " : "";

        event.setJoinMessage(group + player.getName() + ChatColor.BOLD + ChatColor.GRAY + ChatColor.GOLD + " a rejoint le hub !");

        player.getInventory().clear();
        player.getEquipment().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setExp(0);
        player.teleport(spawnLocation);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

        ItemStack compass = Items.COMPASS();
        player.getInventory().setItem(4, compass);

        ItemStack playerHead = Items.PLAYER_HEAD(player);
        player.getInventory().setItem(0, playerHead);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
}