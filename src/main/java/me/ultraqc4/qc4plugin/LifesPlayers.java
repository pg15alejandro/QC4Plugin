package me.ultraqc4.qc4plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

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


    final HashMap<Player, Integer> deaths = new HashMap<>();
    @EventHandler
    public void playerDeath(PlayerDeathEvent event){
        final Player playerP = event.getEntity();

        deaths.put(playerP, deaths.getOrDefault(playerP,0) + 1 );
        System.out.println("Player " + playerP.getDisplayName() + " death " + deaths + " times");

        Team teamT = playerP.getScoreboard().getEntryTeam(playerP.getName());
        String team = teamT.getName();



        //BLUBBERS
    }

}
