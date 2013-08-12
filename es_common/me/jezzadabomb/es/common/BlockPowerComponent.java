package me.jezzadabomb.es.common;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPowerComponent {
    public interface PowerComponent {
        /** Available types of components for IonNetComponent. */
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

        /** What type of component this IonNetComponent is. */
        public PowerComponentType getPowerComponentType();
        /** Whether an ion tube can connect on a specific side or not. */
        public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side);
    }
    public interface IPowerNetSource extends PowerComponent{
        /** Request ions from a block. Return as many ions as possible, up to the amount requested. */
        public int requestIons(World w, int x, int y, int z, int particles);
        /** Put ions back after a request. It's related to StaticIonNetRouter's design. */
        public void giveBack(World w, int x, int y, int z, int particles);
        /** How full this component is (0.0F - 1.0F). StaticIonNetRouter will always get ions from the fullest component available first. */
        public float getFill(World w, int x, int y, int z);
    }
}