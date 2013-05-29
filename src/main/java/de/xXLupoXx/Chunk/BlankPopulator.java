package de.xXLupoXx.Chunk;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class BlankPopulator extends BlockPopulator
{
    @Override
    public void populate(World world, Random random, Chunk chunk)
    {
        //Well it's a blank populator isn't it?
    }
}