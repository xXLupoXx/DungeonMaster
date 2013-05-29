package de.xXLupoXx.Listener;

import de.xXLupoXx.DungeonMasterPlugin;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class DMChunkListener implements Listener
{
    DungeonMasterPlugin plugin;

    public DMChunkListener(DungeonMasterPlugin plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChunkLoad(final ChunkLoadEvent event)
    {
        Chunk chunk = event.getChunk();
        if (!chunk.getBlock(chunk.getX(), chunk.getZ(), 0).hasMetadata("DM_Modified_Chuck"))
        {
            chunk.getBlock(chunk.getX(), chunk.getZ(), 0).setMetadata("DM_Modified_Chuck", new FixedMetadataValue(plugin, true));
        }
    }
}