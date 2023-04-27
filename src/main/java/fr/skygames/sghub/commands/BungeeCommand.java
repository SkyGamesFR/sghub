package fr.skygames.sghub.commands;

import fr.skygames.sghub.utils.PluginMessageHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BungeeCommand implements CommandExecutor {

    private final String[] subs = new String[] {
            "Connect", "ConnectOther", "Message", "PlayerCount", "PlayerList", "GetServers", "GetServer", "IP", "Server", "UUIDOther"
    };

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can execute this command!");
            return true;
        }

        if(label.equalsIgnoreCase("bcommand")) {
            if(args.length >= 1) {
                final String subCommand = args[0];

                if(isSubCommand(subCommand)) {
                    final String[] args2 = Arrays.copyOfRange(args, 1, args.length);
                    PluginMessageHelper.sendPluginMessage((Player) sender, subCommand, args2);
                } else {
                    sender.sendMessage("§cSubcommand not found!");
                }
            } else {
                sender.sendMessage("§cUsage: /bungee <subcommand>");
            }
            return true;
        }

        return false;
    }

    private boolean isSubCommand(String subCommand) {
        for (String sub : subs) {
            if(sub.equalsIgnoreCase(subCommand)) {
                return true;
            }
        }
        return false;
    }
}
