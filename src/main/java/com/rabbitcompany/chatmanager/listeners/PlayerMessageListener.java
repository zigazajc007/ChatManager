package com.rabbitcompany.chatmanager.listeners;

import com.rabbitcompany.chatmanager.ChatManager;
import com.rabbitcompany.chatmanager.utils.Colors;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerMessageListener implements Listener {

    private final ChatManager chatManager;

    public PlayerMessageListener(ChatManager plugin){
        chatManager = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerPlaceholderChat(AsyncPlayerChatEvent event){
        String format = Colors.toHex(Colors.color(PlaceholderAPI.setPlaceholders(event.getPlayer(), chatManager.getConf().getString("format", "&7{display_name} &7> {message}").replace("{name}", event.getPlayer().getName()).replace("{display_name}", event.getPlayer().getDisplayName()))));
        event.setFormat(format.replace("{message}", event.getMessage()));
    }

}
