package com.github.happyrogelio7.cooldownmanagerexample;

import org.bukkit.plugin.java.JavaPlugin;

public final class CooldownManagerExample extends JavaPlugin {

    /*
     Code by: HappyRogelio7
     Github: https://github.com/HappyRogelio7
     License: Custom
     Link: https://github.com/HappyRogelio7/CooldownManagerMC1
     */

    private static CooldownManagerExample instance;

    public static CooldownManagerExample getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
