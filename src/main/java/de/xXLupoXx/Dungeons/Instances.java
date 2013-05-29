package de.xXLupoXx.Dungeons;

import de.xXLupoXx.DungeonMasterPlugin;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class Instances {
    private List<Instance> activeDungeons = new LinkedList<Instance>();
    private Dungeons dungeons = new Dungeons();
    private DungeonMasterPlugin plugin;

    public Instances(DungeonMasterPlugin plugin) {
        this.plugin = plugin;
    }

    public UUID createInstance(String name) {          //TODO mit chunks
        Instance tmpInstance = new Instance();
        tmpInstance.setGroupstrength(1);
        File copyWorld = plugin.getServer().getWorld(dungeons.getDungeon(name).getUID()).getWorldFolder();
        File tmp = copyWorld;   //TODO Working Rename/Move Code
        File newWorld = new File(copyWorld.toURI());
        FileUtil.copy(copyWorld, newWorld);
        tmpInstance.setWorld(dungeons.getDungeon(name)); //TODO Insert copy of the World!
        activeDungeons.add(tmpInstance);
        return tmpInstance.getUuid();
    }
}