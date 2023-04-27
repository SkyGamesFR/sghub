package fr.skygames.sghub.managers;

import fr.skygames.sghub.Main;
import fr.skygames.sghub.event.BlockBreak;
import fr.skygames.sghub.event.InventoryClick;
import fr.skygames.sghub.event.PlayerInteract;
import fr.skygames.sghub.event.PlayerJoin;
import fr.skygames.sghub.utils.CustomLogger;
import fr.skygames.sghub.utils.PluginMessageHelper;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Manager {

    private final Plugin plugin;
    private final CustomLogger logger;

    private static LuckPerms luckPerms;

    public Manager(Main plugin) {
        this.plugin = plugin;
        this.logger = new CustomLogger(plugin);
        luckPerms = Main.getLuckPerms();
    }

    public void init() {
        this.logger.info("Enabling Plugin...");

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            logger.info("LuckPerms found!");
        }

        logger.info("Registering PluginMessageListener...");
        PluginMessageHelper.registerChannels(plugin);

        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(plugin.getServer().getWorld("world"), -0.514,49,-0.499, -180, 5), plugin);
        pm.registerEvents(new InventoryClick(plugin), plugin);
        pm.registerEvents(new PlayerInteract(), plugin);
        pm.registerEvents(new BlockBreak(), plugin);
    }

    public void shutdown() {
        this.logger.info("Disabling Plugin...");
    }

}
