package net.vrmodel.forge;

import net.minecraftforge.fml.common.Mod;
import net.vrmodel.VRModelMod;

@Mod(VRModelMod.MOD_ID)
public class VRModelModForge {
    public VRModelModForge() {
        VRModelMod.init();
    }
}
