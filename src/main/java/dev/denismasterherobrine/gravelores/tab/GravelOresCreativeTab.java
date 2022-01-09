package dev.denismasterherobrine.gravelores.tab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class GravelOresCreativeTab {
    public static final ItemGroup GRAVEL_ORES_TAB = new ItemGroup("gravelores") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.GRAVEL);
        }
    };
}
