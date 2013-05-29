package de.xXLupoXx.Dungeons;

import org.bukkit.World;

import java.util.HashMap;
import java.util.Map;

public class Dungeons {
    private Map<String, World> dungeonBlueprints = new HashMap<String, World>(); //Stores the raw dungeons that will be instantiated

    public void addDungeon(String name, World world) {
        if (!dungeonBlueprints.containsKey(name)) {
            dungeonBlueprints.put(name, world);
        }          //Throw Exception
    }

    public World getDungeon(String name) {
        if (dungeonBlueprints.containsKey(name)) {
            return dungeonBlueprints.get(name);
        }
        return null;
    }

    public Map<String, World> getAllDungeons() {
        return dungeonBlueprints;
    }

    public void deleteDungeon(String name) {
        if (dungeonBlueprints.containsKey(name)) {
            dungeonBlueprints.remove(name);
        }
    }
}