package de.xXLupoXx.Dungeons;

import org.bukkit.World;

import java.util.UUID;

public class Instance {
    private UUID uuid;
    private int groupstrength = 1;
    private World world;

    public Instance() {
        uuid = UUID.randomUUID();
    }

    public Instance(int groupstrength, World world) {
        uuid = UUID.randomUUID();
        this.groupstrength = groupstrength;
        this.world = world;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setGroupstrength(int value) {
        groupstrength = value;
    }

    public int getGroupstrength() {
        return groupstrength;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }
}