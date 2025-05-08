package net.mura.firstmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.mura.firstmod.FirstMod;

public class ModBlocks {

    public static final Block PINK_THING_BLOCK = registerBlock("pink_thing_block", AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block RAW_PINK_THING_BLOCK = registerBlock("raw_pink_thing_block", AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));


    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {

        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(FirstMod.MOD_ID, name));

        Block block = new Block(blockSettings.registryKey(key));

        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, key, block);

    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.info("registering mod blocks");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_THING_BLOCK);
            entries.add(ModBlocks.RAW_PINK_THING_BLOCK);
        });
    }
}
