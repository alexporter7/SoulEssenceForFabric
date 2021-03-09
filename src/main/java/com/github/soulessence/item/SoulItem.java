package com.github.soulessence.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

import java.util.InputMismatchException;
import java.util.Objects;

public class SoulItem extends Item {

    private final SoulItemType type;

    public SoulItem(Settings settings, SoulItemType soulItemType) {
        super(settings);
        this.type = soulItemType;
    }

    public SoulItemType getType() {
        return type;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) return ActionResult.SUCCESS;

        ItemStack stackInHand =
                Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getPlayer().getActiveHand());
        if(stackInHand.getItem() instanceof SoulItem) {
            switch(getType()) {
                case CREEPER:
                    CreeperEntity creeperEntity = new CreeperEntity(EntityType.CREEPER, context.getWorld());
                    break;
                case ZOMBIE:
                    ZombieEntity zombieEntity = new ZombieEntity(EntityType.ZOMBIE, context.getWorld());
                    break;
                case ENDERMAN:
                    EndermanEntity endermanEntity = new EndermanEntity(EntityType.ENDERMAN, context.getWorld());
                    break;
                case SKELETON:
                    SkeletonEntity skeletonEntity = new SkeletonEntity(EntityType.SKELETON, context.getWorld());
                    break;
                case GENERIC:
                    throw new InputMismatchException("Input type was generic which means Item did not get instantiated properly");
            }
        }

        return ActionResult.SUCCESS;
    }

    public enum SoulItemType {
        CREEPER,
        ENDERMAN,
        ZOMBIE,
        SKELETON,
        GENERIC
    }

}
