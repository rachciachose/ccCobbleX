// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.cccobblex.listeners;

import org.bukkit.event.EventHandler;
import pl.best241.rdbplugin.pubsub.PubSub;
import org.bukkit.plugin.Plugin;
import pl.best241.cccobblex.messages.MessagesData;
import pl.best241.cccobblex.CcCobbleX;
import pl.best241.rdbplugin.events.PubSubRecieveMessageEvent;
import org.bukkit.event.Listener;

public class PubSubRecieveMessageListener implements Listener
{
    @EventHandler
    public static void pubSubRecieveMessageListener(final PubSubRecieveMessageEvent event) {
        if (event.getChannel().equals("reloadAllMessagesRequest")) {
            MessagesData.loadMessages((Plugin)CcCobbleX.getPlugin());
            PubSub.broadcast("reloadAllMessagesResponse", CcCobbleX.getPlugin().getName());
        }
    }
}
