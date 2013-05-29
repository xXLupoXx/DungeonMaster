package de.xXLupoXx.Chunk;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DungeonGenerator extends ChunkGenerator
{      //This is where you stick your populators - these will be covered in another tutorial

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world)
    {
        return Arrays.asList((BlockPopulator) new BlankPopulator());
    }      //This needs to be set to return true to override minecraft's default behaviour

    @Override
    public boolean canSpawn(World world, int x, int z)
    {
        return true;
    }      //This converts relative chunk locations to bytes that can be written to the chunk

    public int xyzToByte(int x, int y, int z)
    {
        return (x * 16 + z) * 128 + y;
    }

    @Override
    public byte[][] generateBlockSections(World world, Random random, int chunkx, int chunkz, BiomeGrid biomes)
    {
        byte[][] result = new byte[world.getMaxHeight() / 16][];
        int y = 0;
        for (int x = 0 ; x < 16 ; x++)
        {
            for (int z = 0 ; z < 16 ; z++)
            {
                setBlock(result, x, y, z, (byte) Material.GLASS.getId());
            }
        }
        return result;
    }

    void setBlock(byte[][] result, int x, int y, int z, byte blkid)
    {
        if (result[y >> 4] == null)
        {
            result[y >> 4] = new byte[4096];
        }
        result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
    }
}