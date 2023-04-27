package fr.skygames.sghub.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!event.getPlayer().hasPermission("sg.break")) {
            event.getPlayer().sendMessage("§cVous n'avez pas la permission de casser des blocs !");
            event.setCancelled(true);
        }
    }

}
