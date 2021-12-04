package com.rabbitcompany.chatmanager.utils;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Colors {

    private static final Pattern hex_pattern = Pattern.compile("(?<!\\\\)(&#[a-fA-F0-9]{6})");

    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String toHex(String message) {
        Matcher matcher = hex_pattern.matcher(message);
        while (matcher.find()) {
            String color = message.substring(matcher.start(), matcher.end());
            if(color.matches("(?<!\\\\)(&#[a-fA-F0-9]{6})")){
                message = message.replace(color, net.md_5.bungee.api.ChatColor.of(color.replace("&", "")).toString());
            }
            matcher = hex_pattern.matcher(message);
        }
        return message;
    }
}
