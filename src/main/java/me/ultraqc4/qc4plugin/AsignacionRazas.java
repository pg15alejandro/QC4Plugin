package me.ultraqc4.qc4plugin;

import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scoreboard.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AsignacionRazas extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();


        if (block.getType() == Material.GRASS) {
            Player player = event.getPlayer();

            if (player.getScoreboard().getPlayerTeam(player) == null) {
                event.setCancelled(true);
            }
        }
    }
}
