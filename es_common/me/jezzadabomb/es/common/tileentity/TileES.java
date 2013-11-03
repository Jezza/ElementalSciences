package me.jezzadabomb.es.common.tileentity;

import me.jezzadabomb.es.common.lib.Strings;
import me.jezzadabomb.es.common.lib.util.ESLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileES extends TileEntity {

    protected ESLogger log = new ESLogger();
    
    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;

    public TileES() {

        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
    }

    public void printDebug(String msg){
        log.print(msg, 4);
    }
    
    public ForgeDirection getOrientation() {

        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    public void setOrientation(int orientation) {

        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState() {

        return state;
    }

    public void setState(byte state) {

        this.state = state;
    }

    public boolean hasCustomName() {

        return customName != null && customName.length() > 0;
    }

    public String getCustomName() {

        return customName;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {

        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(Strings.NBT_TE_DIRECTION_KEY)) {
            orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(Strings.NBT_TE_DIRECTION_KEY));
        }

        if (nbtTagCompound.hasKey(Strings.NBT_TE_STATE_KEY)) {
            state = nbtTagCompound.getByte(Strings.NBT_TE_STATE_KEY);
        }

        if (nbtTagCompound.hasKey(Strings.NBT_TE_CUSTOM_NAME)) {
            customName = nbtTagCompound.getString(Strings.NBT_TE_CUSTOM_NAME);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte(Strings.NBT_TE_DIRECTION_KEY, (byte) orientation.ordinal());
        nbtTagCompound.setByte(Strings.NBT_TE_STATE_KEY, state);

        if (this.hasCustomName()) {
            nbtTagCompound.setString(Strings.NBT_TE_CUSTOM_NAME, customName);
        }
    }

    // @Override
    // public Packet getDescriptionPacket() {
    //
    // return PacketTypeHandler.populatePacket(new PacketTileUpdate(xCoord,
    // yCoord, zCoord, orientation, state, customName));
    // }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("TileEE Data - xCoord: %d, yCoord: %d, zCoord: %d, customName: '%s', orientation: %s, state: %d\n", xCoord, yCoord, zCoord, customName, orientation, state));

        return stringBuilder.toString();
    }

}
