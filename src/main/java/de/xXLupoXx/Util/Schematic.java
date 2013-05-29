package de.xXLupoXx.Util;/*  *  *    This class is free software: you can redistribute it and/or modify  *    it under the terms of the GNU General Public License as published by  *    the Free Software Foundation, either version 3 of the License, or  *    (at your option) any later version.  *  *    This class is distributed in the hope that it will be useful,  *    but WITHOUT ANY WARRANTY; without even the implied warranty of  *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the  *    GNU General Public License for more details.  *  *    You should have received a copy of the GNU General Public License  *    along with this class.  If not, see <http://www.gnu.org/licenses/>.  *  */

import net.minecraft.server.v1_5_R3.NBTCompressedStreamTools;
import net.minecraft.server.v1_5_R3.NBTTagCompound;
import net.minecraft.server.v1_5_R3.NBTTagList;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * * @author Max
 */
public class Schematic {
    private byte[] blocks;
    private byte[] data;
    private short width;
    private short lenght;
    private short height;
    private NBTTagList entities;
    private NBTTagList tileentities;


    public Schematic(byte[] blocks, byte[] data, short width, short lenght, short height, NBTTagList entities, NBTTagList tileentities) {
        this.blocks = blocks;
        this.data = data;
        this.width = width;
        this.lenght = lenght;
        this.height = height;
        this.entities = entities;
        this.tileentities = tileentities;
    }

    /**
     * @return the blocks
     */
    public byte[] getBlocks() {
        return blocks;
    }

    /**
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @return the width
     */
    public short getWidth() {
        return width;
    }

    /**
     * @return the lenght
     */
    public short getLenght() {
        return lenght;
    }

    /**
     * @return the height
     */
    public short getHeight() {
        return height;
    }

    public NBTTagList getEntities() {
        return entities;
    }

    public NBTTagList getTileentities() {
        return tileentities;
    }

    public static void pasteSchematic(World world, Location loc, Schematic schematic) {
        byte[] blocks = schematic.getBlocks();
        byte[] blockData = schematic.getData();
        short length = schematic.getLenght();
        short width = schematic.getWidth();
        short height = schematic.getHeight();
        NBTTagList entities = schematic.getEntities();
        NBTTagList tileentities = schematic.getTileentities();
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                for (int z = 0; z < length; ++z) {
                    int index = y * width * length + z * width + x;
                    Block block = new Location(world, x + loc.getX(), y + loc.getY(), z + loc.getZ()).getBlock();
                    block.setTypeIdAndData(blocks[index], blockData[index], true);
                }
            }
        }
    }


    public static Schematic loadSchematic(File file) throws IOException {
        //InputStream fis = getClass().getResourceAsStream("medievalhouse.schematic");
        FileInputStream stream = new FileInputStream(file);
        NBTTagCompound schematicTag = NBTCompressedStreamTools.a(stream);
        if (!schematicTag.getName().equals("Schematic")) {
            throw new IllegalArgumentException("Tag \"Schematic\" does not exist or is not first");
        }
        short width = schematicTag.getShort("Width");
        short length = schematicTag.getShort("Height");
        short height = schematicTag.getShort("Length");
        byte[] blocks = schematicTag.getByteArray("Blocks");
        byte[] blockData = schematicTag.getByteArray("Data");
        NBTTagList entities = schematicTag.getList("Entities");
        NBTTagList tileentities = schematicTag.getList("TileEntities");
        return new Schematic(blocks, blockData, width, length, height, entities, tileentities);
    }
}