package me.jezzadabomb.es.core.util;

import me.jezzadabomb.es.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public final class IconRegistry {
    
    public static Icon colliderPipe_joint;
    public static Icon powerConduit_xJoint;
    public static Icon powerConduit_zJoint;
    public static Icon powerConduit_yJoint;

    public static final IconRegistry instance = new IconRegistry();

    public void loadAllBlocks(IconRegister register){
        colliderPipe_joint = loadBlock(register, "colliderPipe_joint");
        powerConduit_xJoint = loadBlock(register, "powerConduit_xJoint");
        powerConduit_zJoint = loadBlock(register, "powerConduit_zJoint");
        powerConduit_yJoint = loadBlock(register, "powerConduit_yJoint");
    }

    private Icon loadBlock(IconRegister register, String name){
        return register.registerIcon(Reference.MOD_ID + ":" + name);
    }
}