package com.github.soulessence.item;

import net.minecraft.item.Item;

public class SoulEssenceItem extends Item {

    private final SoulEssenceItemType type;
    private int soulPower;

    public SoulEssenceItem(Settings settings, SoulEssenceItemType type) {
        super(settings);
        this.type = type;
    }

    public int getSoulPower() {
        return this.soulPower;
    }

    public void setSoulPower(int soulPower) {
        this.soulPower = soulPower;
    }

    public SoulEssenceItemType getType() {
        return this.type;
    }

    public enum SoulEssenceItemType {
        CREEPER,
        ENDERMAN,
        ZOMBIE,
        SKELETON,
        GENERIC
    }
}
