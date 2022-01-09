package dev.denismasterherobrine.gravelores.config;

import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;

import javax.xml.validation.Validator;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Configuration {
    public static final String CATEGORY_WORLDGEN = "worldgen";
    public static final String CATEGORY_INTEGRATIONS = "integrations";

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ArrayList<String> defaultOreList = new ArrayList<String>();

    public static ForgeConfigSpec.BooleanValue isStepHeightEnabled;
    private final ForgeConfigSpec.ConfigValue<List<? extends String>> GravelOresWhitelist;

    static {
        COMMON_BUILDER.comment("General Gravel Ores Worldgen Settings").push(CATEGORY_WORLDGEN);

        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public Configuration(ForgeConfigSpec.ConfigValue<List<? extends String>> gravelOresBlacklist) {
        GravelOresWhitelist = COMMON_BUILDER.comment("List of enabled Minecraft's gravel ore variants for Gravel Ores world generation can be written here. Define blocks as it is written through F3+G.")
                .defineList("GravelOresWhitelist", Arrays.asList(
                        "gravelores:vanilla_gravel_coal_ore",
                        "gravelores:vanilla_gravel_iron_ore",
                        "gravelores:vanilla_gravel_gold_ore",
                        "gravelores:vanilla_gravel_diamond_ore",
                        "gravelores:vanilla_gravel_emerald_ore",
                        "gravelores:vanilla_gravel_lapis_ore",
                        "gravelores:vanilla_gravel_redstone_ore"
                ), Objects::nonNull);
    }



    public static void loadConfig(ForgeConfigSpec spec, Path path) {

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
}
