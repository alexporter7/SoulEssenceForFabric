package com.github.soulessence;

import com.github.soulessence.block.SoulRechargerBlock;
import com.github.soulessence.block.SoulRechargerBlockEntity;
import com.github.soulessence.item.SoulEssenceItem;
import com.github.soulessence.item.SoulItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

public class SoulEssence implements ModInitializer {

	public static final String MOD_ID = "soulessence";

	public static final ItemGroup SOUL_ITEM_GROUP = FabricItemGroupBuilder
			.build(new Identifier(MOD_ID, "soul_item_group"), () -> new ItemStack(SoulEssence.CREEPER_SOUL_ITEM));

	public static final Identifier SOUL_RECHARGER_IDENTIFIER = new Identifier(MOD_ID, "soul_recharger_block");
	public static final Block SOUL_RECHARGER_BLOCK;
	public static final BlockItem SOUL_RECHARGER_BLOCK_ITEM;
	public static final BlockEntityType<SoulRechargerBlockEntity> SOUL_RECHARGER_BLOCK_ENTITY_TYPE;

	static {
		SOUL_RECHARGER_BLOCK = Registry.register(Registry.BLOCK, SOUL_RECHARGER_IDENTIFIER,
				new SoulRechargerBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f)));
		SOUL_RECHARGER_BLOCK_ITEM = Registry.register(Registry.ITEM, SOUL_RECHARGER_IDENTIFIER,
				new BlockItem(SOUL_RECHARGER_BLOCK, new Item.Settings().group(SOUL_ITEM_GROUP)));
		SOUL_RECHARGER_BLOCK_ENTITY_TYPE = Registry
				.register(Registry.BLOCK_ENTITY_TYPE, SOUL_RECHARGER_IDENTIFIER,
				BlockEntityType.Builder
						.create(SoulRechargerBlockEntity::new, SOUL_RECHARGER_BLOCK)
						.build(null));
	}

	public static final Item CREEPER_SOUL_ITEM =
			new SoulItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulItem.SoulItemType.CREEPER);
	public static final Item ENDERMAN_SOUL_ITEM =
			new SoulItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulItem.SoulItemType.ENDERMAN);
	public static final Item SKELETON_SOUL_ITEM =
			new SoulItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulItem.SoulItemType.SKELETON);
	public static final Item ZOMBIE_SOUL_ITEM =
			new SoulItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulItem.SoulItemType.ZOMBIE);

	public static final Item CREEPER_SOUL_ESSENCE_ITEM =
			new SoulEssenceItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulEssenceItem.SoulEssenceItemType.CREEPER);
	public static final Item ENDERMAN_SOUL_ESSENCE_ITEM =
			new SoulEssenceItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulEssenceItem.SoulEssenceItemType.CREEPER);
	public static final Item SKELETON_SOUL_ESSENCE_ITEM =
			new SoulEssenceItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulEssenceItem.SoulEssenceItemType.CREEPER);
	public static final Item ZOMBIE_SOUL_ESSENCE_ITEM =
			new SoulEssenceItem(new FabricItemSettings().group(SOUL_ITEM_GROUP), SoulEssenceItem.SoulEssenceItemType.CREEPER);

	@Override
	public void onInitialize() {

		registerItem(new Identifier(MOD_ID, "creeper_soul_item"), CREEPER_SOUL_ITEM);
		registerItem(new Identifier(MOD_ID, "enderman_soul_item"), ENDERMAN_SOUL_ITEM);
		registerItem(new Identifier(MOD_ID, "skeleton_soul_item"), SKELETON_SOUL_ITEM);
		registerItem(new Identifier(MOD_ID, "zombie_soul_item"), ZOMBIE_SOUL_ITEM);

		registerItem(new Identifier(MOD_ID, "creeper_soul_essence_item"), CREEPER_SOUL_ESSENCE_ITEM);
		registerItem(new Identifier(MOD_ID, "enderman_soul_essence_item"), ENDERMAN_SOUL_ESSENCE_ITEM);
		registerItem(new Identifier(MOD_ID, "skeleton_soul_essence_item"), SKELETON_SOUL_ESSENCE_ITEM);
		registerItem(new Identifier(MOD_ID, "zombie_soul_essence_item"), ZOMBIE_SOUL_ESSENCE_ITEM);

	}

	private void registerItem(Identifier identifier, Item item) {
		Registry.register(Registry.ITEM, identifier, item);
		System.out.printf("Registered %s item from %s%n", identifier.getPath(), identifier.getNamespace());
	}
}
