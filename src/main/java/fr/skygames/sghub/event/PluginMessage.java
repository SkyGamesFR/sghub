package fr.skygames.sghub.event;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import fr.skygames.sghub.utils.PluginMessageHelper;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessage implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        PluginMessageHelper.receivePluginMessage(channel, player, message);
    }
}
