package me.jezzadabomb.es.core.util;

import net.minecraft.util.DamageSource;

public class DamageSourceRad extends DamageSource {

    public static DamageSource beta = (new DamageSourceRad("beta")).setDamageBypassesArmor();
    
    protected DamageSourceRad(String par1Str) {
        super(par1Str);
    }

}
