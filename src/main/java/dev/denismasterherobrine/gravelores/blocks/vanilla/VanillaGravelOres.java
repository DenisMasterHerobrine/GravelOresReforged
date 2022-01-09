package dev.denismasterherobrine.gravelores.blocks.vanilla;

import dev.denismasterherobrine.gravelores.GravelOres;
import dev.denismasterherobrine.gravelores.tab.GravelOresCreativeTab;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class VanillaGravelOres {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GravelOres.MOD_ID);

    public static final RegistryObject VANILLA_COAL_ORE = registerBlock("vanilla_gravel_coal_ore", () -> new FallingBlock(AbstractBlock.Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .harvestLevel(1)
            .harvestTool(ToolType.SHOVEL)
            .strength(0.6f)
    ));

    public static final RegistryObject VANILLA_IRON_ORE = registerBlock("vanilla_gravel_iron_ore", () -> new FallingBlock(AbstractBlock.Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .harvestLevel(2)
            .harvestTool(ToolType.SHOVEL)
            .strength(0.75f)
    ));

    public static final RegistryObject VANILLA_GOLD_ORE = registerBlock("vanilla_gravel_gold_ore", () -> new FallingBlock(AbstractBlock.Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .harvestLevel(3)
            .harvestTool(ToolType.SHOVEL)
            .strength(1.35f)
    ));

    public static final RegistryObject VANILLA_LAPIS_ORE = registerBlock("vanilla_gravel_lapis_ore", () -> new FallingBlock(AbstractBlock.Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .harvestLevel(2)
            .harvestTool(ToolType.SHOVEL)
            .strength(0.9f)
    ));

    public static final RegistryObject VANILLA_REDSTONE_ORE = registerBlock("vanilla_gravel_redstone_ore", () -> new FallingBlock(AbstractBlock.Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .harvestLevel(3)
            .harvestTool(ToolType.SHOVEL)
            .strength(1.5f)
    ));

    public static final RegistryObject VANILLA_DIAMOND_ORE = registerBlock("vanilla_gravel_diamond_ore", () -> new FallingBlock(AbstractBlock.Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .harvestLevel(3)
            .harvestTool(ToolType.SHOVEL)
            .strength(2f)
    ));

    public static final RegistryObject VANILLA_EMERALD_ORE = registerBlock("vanilla_gravel_emerald_ore", () -> new FallingBlock(AbstractBlock.Properties.of(Material.SAND)
            .sound(SoundType.GRAVEL)
            .requiresCorrectToolForDrops()
            .harvestLevel(3)
            .harvestTool(ToolType.SHOVEL)
            .strength(2f)
    ));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
            VanillaGravelOresItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(GravelOresCreativeTab.GRAVEL_ORES_TAB)));
    }
}
