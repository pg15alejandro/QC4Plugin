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

    @EventHandler
    public void playerDeath(PlayerDeathEvent event){

        Player playerP = event.getEntity();
        Team teamT = playerP.getScoreboard().getEntryTeam(playerP.getName());
        String team = teamT.getName();

        if (team.equals("ELFOS") || team.equals("ORCOS") )
        {
            RemoveLife(playerP);
        }
    }
    public void AddLife(Integer amountToAdd, Player playerP)
    {
        Objective remainingLifesSb = playerP.getScoreboard().getObjective("Vidas");
        Score vidas = remainingLifesSb.getScore(playerP.getName());
        Integer remainingLifes = amountToAdd + vidas.getScore();
        vidas.setScore(remainingLifes);
    }
    public void RemoveLife(Player playerP){

        Objective remainingLifesSb = playerP.getScoreboard().getObjective("Vidas");
        Score lifes = remainingLifesSb.getScore(playerP.getName());
        Integer remainingLifes = lifes.getScore() - 1;
        lifes.setScore(remainingLifes);

        if (remainingLifes < 0)
        {
            playerP.kickPlayer("LIMITE DE MUERTES ALCANZADO");
            Bukkit.getBanList(BanList.Type.NAME).addBan(playerP.getName(), "LIMITE DE MUERTES ALCANZADO", null , "UltraQC 4" );
        }
    }

}
