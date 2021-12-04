package com.rabbitcompany.chatmanager;

import com.rabbitcompany.chatmanager.listeners.PlayerMessageListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class ChatManager extends JavaPlugin {

    private final YamlConfiguration conf = new YamlConfiguration();

    @Override
    public void onEnable() {
        File co = new File(getDataFolder(), "config.yml");
        if(!co.exists()) saveResource("config.yml", false);

        try{
            this.conf.load(co);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) new PlayerMessageListener(this);
    }

    @Override
    public void onDisable() {}

    public YamlConfiguration getConf() { return this.conf; }
}
