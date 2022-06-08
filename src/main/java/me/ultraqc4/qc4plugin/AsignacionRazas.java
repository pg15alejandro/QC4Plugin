package me.ultraqc4.qc4plugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Team;


public class AsignacionRazas implements Listener {

    enum Races{
        HUMANOS,
        GOBLINS,
        ELFOS,
        ORCOS
    }
//HUMANOS CAN USE BERRIES, CANT USE LIGHT BERRIES, COCOA, REMOLACHA
//GOBLINS CAN USE LIGHT BERRIES, CANT USE BERRIES, COCOA, REMOLACHA
//ELFOS CAN USE COCOA, CANT USE BERRIES, LIGHT BERRIES, REMOLACHA
//ORCOS CAN USE REMOLACHA, CANT USE BERRIES, LIGHT BERRIES, COCOA

public void JungleLogs(Block block, String team, BlockBreakEvent event) {
    Block plantedR = block.getLocation().add(1, 0, 0).getBlock();
    Block plantedL = block.getLocation().add(0, 0, 1).getBlock();
    Block plantedF = block.getLocation().subtract(1, 0, 0).getBlock();
    Block plantedB = block.getLocation().subtract(0, 0, 1).getBlock();

    if (plantedR.getType() == Material.COCOA || plantedL.getType() == Material.COCOA
            || plantedF.getType() == Material.COCOA || plantedB.getType() == Material.COCOA
    ) {
        if (!team.equals(Races.ELFOS.toString())) {
            event.setCancelled(true);
        }
    }
}
    public void BerriesBlocks(Block block, String team, BlockBreakEvent event){
    Block plantedGB = block.getLocation().add(0,1,0).getBlock();
    if (plantedGB.getType() == Material.SWEET_BERRY_BUSH && !team.equals(Races.HUMANOS.toString()))
    {
        event.setCancelled(true);
    }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        System.out.println(block.getType());
        Player playerP = event.getPlayer();
        Team teamT = playerP.getScoreboard().getEntryTeam(playerP.getName());
        String team;

        if (teamT == null) return;

        team = teamT.getName().toUpperCase();

        System.out.println("Team " + team);
        System.out.println("Block Type " + block.getType());


       if (block.getType() == Material.FARMLAND)
       {
        Block planted = block.getLocation().add(0,1,0).getBlock();
        if (planted.getType() == Material.WHEAT) event.setCancelled(true);
       }


        switch(block.getType())
        {
            case FARMLAND:
                Block planted = block.getLocation().add(0,1,0).getBlock();
                if (planted.getType() == Material.SWEET_BERRY_BUSH && !team.equals(Races.HUMANOS.toString()))
                {
                    event.setCancelled(true);
                }
                else if (planted.getType() == Material.BEETROOTS && !team.equals(Races.ORCOS.toString())) {
                    event.setCancelled(true);
                }
                break;

            case GRASS_BLOCK:
                BerriesBlocks(block, team, event);
                break;

            case DIRT:
                BerriesBlocks(block, team, event);
                break;

            case COARSE_DIRT:
                BerriesBlocks(block, team, event);
                break;

            case ROOTED_DIRT:
                BerriesBlocks(block, team, event);
                break;

            case PODZOL:
                BerriesBlocks(block, team, event);
                break;

            case JUNGLE_LOG:
                JungleLogs(block, team, event);
                break;

            case STRIPPED_JUNGLE_LOG:
                JungleLogs(block, team, event);
                break;

            case SWEET_BERRY_BUSH:
                if(!team.equals(Races.HUMANOS.toString()))
                {
                System.out.println("CASE 1");
                    event.setCancelled(true);
                }
                break;

            case GLOW_BERRIES:
                if(!team.equals(Races.GOBLINS.toString()))
                {
                System.out.println("CASE 2");
                    event.setCancelled(true);
                }
                break;

            case COCOA:
                if(!team.equals(Races.ELFOS.toString()))
                {
                System.out.println("CASE 3");
                    event.setCancelled(true);
                }
                break;

            case BEETROOTS:
                if(!team.equals(Races.ORCOS.toString()))
                {
                 System.out.println("CASE 4");
                    event.setCancelled(true);
                }
                break;
        }
    }
}
