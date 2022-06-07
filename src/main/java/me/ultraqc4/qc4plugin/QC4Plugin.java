package me.ultraqc4.qc4plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class QC4Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("START");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("END");
    }
}
