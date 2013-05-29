package de.xXLupoXx.Util;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DMPlayer {

    private static List<DMPlayer> playerList = new ArrayList<DMPlayer>();
    private Map<String, Integer> dungenLockout = new HashMap<String, Integer>();

    private String playerName = "DM_JohnDoe_DEBUG";

    private boolean inGroup = false;

    public DMPlayer(String playerName) {
        this.playerName = playerName;
    }

    public DMPlayer(Player player) {
        if(player != null) {
            this.playerName = player.getName();
        }
    }

    public String getName() {
        return this.playerName;
    }

    public static boolean isDMPlayer(String name) {
        for(DMPlayer player : playerList) {
            if(player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDMPlayer(Player player) {
        return isDMPlayer(player.getName());
    }

    public static DMPlayer getDMPlayer(String name) {
        for (DMPlayer player : playerList) {
            if(player.getName().equals(name)) {
                return player;
            }
        }

        DMPlayer tmpPlayer = new DMPlayer(name);
        playerList.add(tmpPlayer);
        return tmpPlayer;
    }

    public boolean hasLockout(String instanceName) {
        return this.dungenLockout.containsKey(instanceName);
    }

    public boolean isInGroup() {
        return inGroup;
    }

    public void setInGroup(boolean flag) {
        inGroup = flag;
    }

    public int getRemainingLockout(String instanceName) {
        if(hasLockout(instanceName)) {
            return this.dungenLockout.get(instanceName);
        }
        return Integer.MIN_VALUE;
    }

    public void setDungenLockout(String instanceName, int timeinminutes) {
        this.dungenLockout.put(instanceName,timeinminutes);
    }

    public static DMPlayer getDMPlayer(Player player) {
        return getDMPlayer(player.getName());
    }

    public static List<DMPlayer> getAllPlayers() {
        return playerList;
    }

    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        else if (o instanceof Player) {
            Player player = (Player)o;
            return playerName.equals(player.getName());
        }
        else if (o instanceof DMPlayer) {
            return this == o;
        }
        return false;
    }

}
