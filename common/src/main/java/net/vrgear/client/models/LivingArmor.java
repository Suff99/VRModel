package net.vrgear.client.models;


import net.minecraft.world.entity.LivingEntity;

public interface LivingArmor {
    LivingEntity getLiving();

    void setLiving(LivingEntity entity);
}
