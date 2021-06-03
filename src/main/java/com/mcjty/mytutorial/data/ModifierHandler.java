package com.mcjty.mytutorial.data;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.fixes.EntityHealth;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class ModifierHandler {
    @SubscribeEvent
    public static void onMobSlay(LivingDeathEvent event){
        DamageSource source = event.getSource();
        if(!(source.getEntity() instanceof PlayerEntity)){
            return;
        }
        // DataParameter<EntityHealth> health = new DataParameter<EntityHealth>(1, );

        if(event.getEntity() instanceof ZombieEntity ){
            ZombieEntity.createLivingAttributes()
                    .add(Attributes.ATTACK_DAMAGE, (Attributes.ATTACK_DAMAGE.getDefaultValue() * .01D))
                    .add(Attributes.MAX_HEALTH, (Attributes.MAX_HEALTH.getDefaultValue() * .01D));
        }
        if(event.getEntity() instanceof SkeletonEntity){
            SkeletonEntity.createLivingAttributes()
                    .add(Attributes.ATTACK_DAMAGE, (Attributes.ATTACK_DAMAGE.getDefaultValue() * .01D))
                    .add(Attributes.MAX_HEALTH, (Attributes.MAX_HEALTH.getDefaultValue() * .01D))
                    .add(Attributes.ARMOR, (Attributes.ARMOR.getDefaultValue() * .01D));
        }
        if(event.getEntity() instanceof SpiderEntity){
            SpiderEntity.createLivingAttributes()
                    .add(Attributes.ATTACK_SPEED, (Attributes.ATTACK_SPEED.getDefaultValue() * .01D))
                    .add(Attributes.KNOCKBACK_RESISTANCE, (Attributes.KNOCKBACK_RESISTANCE.getDefaultValue() * .01D))
                    .add(Attributes.MAX_HEALTH, (Attributes.MAX_HEALTH.getDefaultValue() * .01D));
        }
        if(event.getEntity() instanceof PiglinEntity){
            PiglinEntity.createLivingAttributes()
                    .add(Attributes.MOVEMENT_SPEED, (Attributes.MOVEMENT_SPEED.getDefaultValue() * .01D))
                    .add(Attributes.ATTACK_DAMAGE, (Attributes.ATTACK_DAMAGE.getDefaultValue() * .01D))
                    .add(Attributes.MAX_HEALTH, (Attributes.MAX_HEALTH.getDefaultValue() * .01D));
        }
        if(event.getEntity() instanceof EndermanEntity){
            EndermanEntity.createLivingAttributes()
                    .add(Attributes.MOVEMENT_SPEED, (Attributes.MOVEMENT_SPEED.getDefaultValue() * .01D))
                    .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, (Attributes.SPAWN_REINFORCEMENTS_CHANCE.getDefaultValue() * .04D))
                    .add(Attributes.MAX_HEALTH, (Attributes.MAX_HEALTH.getDefaultValue() * .01D));
        }
    }
}
