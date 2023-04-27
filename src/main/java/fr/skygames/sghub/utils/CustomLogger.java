package fr.skygames.sghub.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomLogger {

    private final Plugin plugin;
    private final Logger logger;

    public CustomLogger(Plugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void severe(String message) {
        log(Level.SEVERE, message);
    }

    private void log(Level level, String message) {
        String formattedMessage = ChatColor.translateAlternateColorCodes('&', message);
        logger.log(level, "[" + plugin.getName() + "] " + formattedMessage);
    }
}
