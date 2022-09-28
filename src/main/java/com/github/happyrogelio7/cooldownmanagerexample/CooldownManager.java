package com.github.happyrogelio7.cooldownmanagerexample;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    /*
     Code by: HappyRogelio7
     Github: https://github.com/HappyRogelio7
     License: Custom
     Link: https://github.com/HappyRogelio7/CooldownManagerMC1
     */

    public final Map<UUID, Integer> cooldowns = new HashMap<>();

    public static final int DEFAULT_COOLDDOWN = 15;

    public static final int CUSTOM_COOLDDOWN = 5;

    //public final int CUSTOM_CONFIG_FILE_COOLDDOWN = YourPlugin.getInstance().getConfig().getInt("cooldown.time.in_seconds", DEFAULT);

    public void setCooldowns(Player p, int time) {
        if (time < 1) {
            cooldowns.remove(p.getUniqueId());
        } else {
            cooldowns.put(p.getUniqueId(), time);
        }
    }

    public int getCooldowns(Player p) {
        return cooldowns.getOrDefault(p.getUniqueId(), 0);
    }

    public void setCooldowns(UUID p, int time) {
        if (time < 1) {
            cooldowns.remove(p);
        } else {
            cooldowns.put(p, time);
        }
    }

    public int getCooldowns(UUID p) {
        return cooldowns.getOrDefault(p, 0);
    }

    public void setRunnable(Player p, CooldownManagerExample plugin){

        new BukkitRunnable() {
            @Override
            public void run() {

                int timeleft = getCooldowns(p.getUniqueId());
                setCooldowns(p.getUniqueId(), --timeleft);

                if (timeleft == 0) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 20, 20);

    }

    public void setRunnable(UUID p, CooldownManagerExample plugin){

        new BukkitRunnable() {
            @Override
            public void run() {

                int timeleft = getCooldowns(p);
                setCooldowns(p, --timeleft);

                if (timeleft == 0) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 20, 20);

    }


    //////////////////////////////////////////////////
    //////////////////////////////////////////////////

    public void setCooldownsFile(Player p, int time) {
        if (time < 1) {
            //REMOVE cooldown.
            CooldownManagerExample.getInstance().getConfig().set("data-player" + p.getUniqueId() + ".cooldown", 0);
        } else {
            //ADD cooldown.
            CooldownManagerExample.getInstance().getConfig().set("data-player" + p.getUniqueId() + ".cooldown", time);
        }
    }

    public void setRunnableFile(Player p, CooldownManagerExample plugin){

        new BukkitRunnable() {
            @Override
            public void run() {

                int timeleft = getCooldowns(p);
                setCooldownsFile(p, --timeleft);

                if (timeleft == 0) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 20, 20);

    }


}
