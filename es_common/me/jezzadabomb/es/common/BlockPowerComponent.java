package me.jezzadabomb.es.common;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPowerComponent {
    public interface PowerComponent {
        
        public enum PowerComponentType {
            /** A tube. Transports ions between components. */
            TUBE,

            /** Main Control Device, used for emmision and collection. */
            CONTROLLER,

            /** Used as a separate source, then the controller. */
            SOURCE,
            
            /** Used for the collection of power, for storage or machines.*/
            COLLECTOR
        }
        
        public PowerComponentType getPowerComponentType();
        
        public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side);
    }
    public interface IPowerNetSource extends PowerComponent{
        
        public int requestPower(World w, int x, int y, int z, int positrons);
        
        public void giveBack(World w, int x, int y, int z, int positrons);
        
        public float getFill(World w, int x, int y, int z);
    }
}