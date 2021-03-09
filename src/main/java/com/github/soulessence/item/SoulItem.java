package com.github.soulessence.item;

import net.minecraft.item.Item;

public class SoulItem extends Item {

    private final SoulItemType type;

    public SoulItem(Settings settings, SoulItemType soulItemType) {
        super(settings);
        this.type = soulItemType;
    }

    public SoulItemType getType() {
        return type;
    }

    public enum SoulItemType {
        CREEPER,
        ENDERMEN,
        ZOMBIE,
        SKELETON,
        GENERIC
    }

}
