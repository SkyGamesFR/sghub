package fr.skygames.sghub.utils;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.skygames.sghub.Main;
import fr.skygames.sghub.event.PluginMessage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PluginMessageHelper {

    private static final String BUNGEECORD_CHANNEL = "BungeeCord";

    private PluginMessageHelper() {}

    public static void registerChannels(Plugin plugin) {
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, BUNGEECORD_CHANNEL, new PluginMessage());
        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, BUNGEECORD_CHANNEL);
    }

    public static void sendPluginMessage(Player player, String sub, String[] args) {
        final ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(sub);

        for (String arg : args) {
            out.writeUTF(arg);
        }

        player.sendPluginMessage(Main.getInstance(), BUNGEECORD_CHANNEL, out.toByteArray());
    }

    public static void receivePluginMessage(String channel, Player player, byte[] bytes) {
        if(!channel.equals(BUNGEECORD_CHANNEL)) return;

        final ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
        final String sub = in.readUTF();

        switch(sub) {
            case "GetServer":
                final String server = in.readUTF();
                System.out.println("Server: " + server);
                break;
            case "PlayerCount":
                final String server2 = in.readUTF();
                final int playerCount = in.readInt();
                System.out.println("Server: " + server2 + " | PlayerCount: " + playerCount);
                break;
            case "PlayerList":
                final String server3 = in.readUTF();
                final String playerList = in.readUTF();
                System.out.println("Server: " + server3 + " | PlayerList: " + playerList);
                break;
            case "GetServers":
                final String servers = in.readUTF();
                System.out.println("Servers: " + servers);
                break;
            case "Message":
                final String message = in.readUTF();
                System.out.println("Message: " + message);
                break;
            case "IP":
                final String server4 = in.readUTF();
                final String ip = in.readUTF();
                System.out.println("Server: " + server4 + " | IP: " + ip);
                break;
            default:
                player.sendMessage("§cErreur lors de la réception du message BungeeCord");
        }
    }

}
