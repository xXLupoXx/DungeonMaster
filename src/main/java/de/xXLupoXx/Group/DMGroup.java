package de.xXLupoXx.Group;

import de.xXLupoXx.Util.DMPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DMGroup {

    private UUID uuid;
    private List<DMPlayer> players = new ArrayList<DMPlayer>();

    public DMGroup () {
        this.uuid = UUID.randomUUID();
    }

    public void addPlayer(Player player) {
        addPlayer(DMPlayer.getDMPlayer(player));

    }

    public void addPlayer(DMPlayer player) {
        if(!this.containsPlayer(player)) {
            players.add(player);
        }
    }

    public void deletePlayer(Player player) {
        deletePlayer(DMPlayer.getDMPlayer(player));

    }

    public void deletePlayer(DMPlayer player) {
        if(this.containsPlayer(player)) {
            this.players.remove(player);
        }
    }

    public boolean containsPlayer(Player player) {
        return containsPlayer(DMPlayer.getDMPlayer(player));
    }

    public boolean containsPlayer(DMPlayer player) {
        return players.contains(player);
    }

    public List<DMPlayer> getPlayers() {
        return this.players;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String toString() {
        String tmp = "Group ID: " + uuid.toString() + "\n";
        int i = 0;
        for(DMPlayer player : players) {
            tmp += "Member " + ++i +": " +  player.toString() + "\n";
        }
        return tmp;
    }

    public boolean equals(Object o) {
        if(o instanceof DMGroup) {
            DMGroup group = (DMGroup)o;
            if(group.getPlayers().size() != this.players.size()) {
                for(int i = 0; i < this.players.size(); i++) {
                    if(!this.players.get(i).equals(group.getPlayers().get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

}
