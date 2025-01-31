package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = createTag("echo_logs");
        public static final TagKey<Block> STRIPPED_LOGS = createTag("stripped_logs");
        public static final TagKey<Block> WOOD = createTag("wood");
        public static final TagKey<Block> STRIPPED_WOOD = createTag("stripped_wood");
        public static final TagKey<Block> TRANSMITTABLE = createTag("transmittable");

        public static final TagKey<Block> GLOOM_SCULK_REPLACEABLE = createTag("gloom_sculk_replaceable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }

    public static class Others {
        public static final TagKey<Structure> ALL_STRUCTURES = structureTag("all_structures");
        private static TagKey<Structure> structureTag(String string) {
            return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation(string));
        }
    }
    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = createTag("echo_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }
}
