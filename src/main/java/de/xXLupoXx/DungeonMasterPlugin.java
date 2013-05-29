package de.xXLupoXx;

import de.xXLupoXx.Listener.DMChunkListener;
import org.bukkit.plugin.java.JavaPlugin;

public class DungeonMasterPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DMChunkListener(this),this);
    }

    @Override
    public void onDisable() {
    }
}