package me.ultraqc4.qc4plugin;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import sun.jvm.hotspot.debugger.posix.elf.ELFException;
import sun.util.calendar.BaseCalendar;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.HashMap;

public class LifesPlayers implements Listener {


    enum Races{
            HUMANOS,
            GOBLINS,
            ELFOS,
            ORCOS
        }

    /*HUMANOS
      GOBLINS
      ORCOS 3;
      ELFOS 3

    */


   // final HashMap<Player, Integer> deaths = new HashMap<>();
    @EventHandler
    public void playerDeath(PlayerDeathEvent event){
        final Player playerP = event.getEntity();

        //deaths.put(playerP, deaths.getOrDefault(playerP,0) + 1 );
       // System.out.println("Player " + playerP.getDisplayName() + " death " + deaths + " times");
//        Team teamT = playerP.getScoreboard().getEntryTeam(playerP.getName());
//        String team = teamT.getName();

        Objective playerScore = playerP.getScoreboard().getObjective("Deaths");

        Score score = playerScore.getScore(playerP.getName());
        Integer scoreI = score.getScore();

        if (playerP.getScoreboard().getEntryTeam(playerP.getName()).equals(Races.ORCOS.toString()) ||
            playerP.getScoreboard().getEntryTeam(playerP.getName()).equals(Races.ELFOS.toString()))
        {
            if (scoreI >= 3)
            {
                Bukkit.getBanList(BanList.Type.NAME).addBan(playerP.getName(), "LIMITE DE MUERTES ALCANZADO", null , "UltraQC 4" );
            }
        }

        System.out.println("ALEXCAN99 SCORE IS " + scoreI);



        //BLUBBERS
    }

}
