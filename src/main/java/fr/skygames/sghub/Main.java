package fr.skygames.sghub;

import fr.skygames.sghub.commands.BungeeCommand;
import fr.skygames.sghub.managers.Manager;
import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private final Manager manager = new Manager(this);
    private static LuckPerms luckPerms;

    @Override
    public void onEnable() {
        instance = this;
        luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        manager.init();
        getCommand("bcommand").setExecutor(new BungeeCommand());
    }

    @Override
    public void onDisable() {
        manager.shutdown();
    }

    public static Main getInstance() {
        return instance;
    }

    public static LuckPerms getLuckPerms() {
        return luckPerms;
    }
}
