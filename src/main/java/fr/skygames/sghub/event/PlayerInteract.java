package fr.skygames.sghub.event;

import fr.skygames.sghub.utils.Gui;
import fr.skygames.sghub.utils.Heads;
import fr.skygames.sghub.utils.ItemBuilder;
import fr.skygames.sghub.utils.Items;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getPlayer().getInventory().getItemInMainHand() != null) {
            ItemStack item = event.getItem();
            Player p = event.getPlayer();

            if(item == null) return;

            if(item.getType() == Material.COMPASS) {
                Gui.openTravelGui(event, player);
            }

            if(item.getType() == Material.SKULL_ITEM) {
                Gui.openPlayerProfile(event, player);
            }
        }
    }


}
