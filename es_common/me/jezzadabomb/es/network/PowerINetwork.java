package me.jezzadabomb.es.network;

import me.jezzadabomb.es.lib.Reference;

public abstract class PowerINetwork {
    
    private PowerINetwork(){}
    public static final int SEARCH_INTERVAL = Reference.convertSecondsToTicks(2);
    
    /** An Power Storage machine. */
    public interface PowerCollector extends INetwork{
        /** A getter for the current amount of ions in this machine. */
        public int getPowerAmount();
        /** A getter for the maximum amount of ions this machine can store. */
        public int getPowerBufferSize();
    }
    
    /** An Power Sink. Needs to be refilled by Sources in the network. */
    public interface PowerSink extends PowerCollector{
        /** Refill the ion storage if all the conditions are met. Call every tick. */
        public void refillPowerBuffer();
    }
    
    /** An Power Source. Refills Sinks in the network. */
    public interface PowerSource extends PowerCollector{
        /** Make an ion request. Returns as many ions as possible. */
        public int requestPower(int photon);
        /** Return excess ions from the last request back to the machine. */
        public void returnPower(int photon);
        /** Return how full the Power Buffer is. Generators should return a number > 1.0F to get priority over other sources. */
        public float getPowerFill();
    }
    
    /** An Power Relay. Is both a sink and a source. */
    public interface PowerRelay extends PowerSink, PowerSource{}
    
    /** An Power Generator. It's a source that produces it's own ions. */
    public interface PowerGenerator extends PowerCollector{
        /** How many ions are in the overflow buffer */
        public int getPowerOverflow();
        /** Try to drain the ion overflow buffer into the main storage buffer. */
        public void drainPowerOverflow();
    }
    
}
