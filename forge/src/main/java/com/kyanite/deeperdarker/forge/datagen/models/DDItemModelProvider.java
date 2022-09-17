package com.kyanite.deeperdarker.forge.datagen.models;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDItemModelProvider extends ItemModelProvider {
    private final ModelFile GENERATED = getExistingFile(mcLoc("item/generated"));
    private final ModelFile HANDHELD = getExistingFile(mcLoc("item/handheld"));

    public DDItemModelProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void registerModels() {
        // BLOCKS
        blockModel(DDBlocks.ECHO_PLANKS);
        blockModel(DDBlocks.ECHO_LOG);
        blockModel(DDBlocks.STRIPPED_ECHO_LOG);
        blockModel(DDBlocks.STRIPPED_ECHO_WOOD);
        blockModel(DDBlocks.ECHO_WOOD);
        blockModel(DDBlocks.ECHO_LEAVES);
        blockModel(DDBlocks.ECHO_SLAB);
        blockModel(DDBlocks.ECHO_FENCE, "inventory");
        blockModel(DDBlocks.ECHO_STAIRS);
        blockModel(DDBlocks.ECHO_BUTTON, "inventory");
        blockModel(DDBlocks.ECHO_PRESSURE_PLATE);
        itemModel(() -> DDBlocks.ECHO_DOOR.get().asItem(), GENERATED);
        blockModel(DDBlocks.ECHO_TRAPDOOR, "bottom");
        blockModel(DDBlocks.ECHO_FENCE_GATE);
        itemModel(() -> DDBlocks.ECHO_SIGN.get().asItem(), GENERATED);

        blockModel(DDBlocks.SCULK_STONE);
        blockModel(DDBlocks.SCULK_STONE_SLAB);
        blockModel(DDBlocks.SCULK_STONE_STAIRS);
        blockModel(DDBlocks.SCULK_STONE_WALL, "inventory");

        blockModel(DDBlocks.COBBLED_SCULK_STONE);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_SLAB);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.COBBLED_SCULK_STONE_WALL, "inventory");

        blockModel(DDBlocks.POLISHED_SCULK_STONE);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_SLAB);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_STAIRS);
        blockModel(DDBlocks.POLISHED_SCULK_STONE_WALL, "inventory");

        blockModel(DDBlocks.SCULK_STONE_BRICKS);
        blockModel(DDBlocks.SCULK_STONE_BRICK_SLAB);
        blockModel(DDBlocks.SCULK_STONE_BRICK_STAIRS);
        blockModel(DDBlocks.SCULK_STONE_BRICK_WALL, "inventory");

        blockModel(DDBlocks.SCULK_STONE_COAL_ORE);
        blockModel(DDBlocks.SCULK_STONE_IRON_ORE);
        blockModel(DDBlocks.SCULK_STONE_COPPER_ORE);
        blockModel(DDBlocks.SCULK_STONE_GOLD_ORE);
        blockModel(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        blockModel(DDBlocks.SCULK_STONE_EMERALD_ORE);
        blockModel(DDBlocks.SCULK_STONE_LAPIS_ORE);
        blockModel(DDBlocks.SCULK_STONE_DIAMOND_ORE);
        blockModel(DDBlocks.INFESTED_SCULK);

        getBuilder(getName(DDBlocks.SCULK_VINES.get())).parent(GENERATED).texture("layer0", "block/" + getName(DDBlocks.SCULK_VINES_PLANT.get()));

        blockModel(DDBlocks.SCULK_JAW);
        blockModel(DDBlocks.SCULK_GLEAM);
        blockModel(DDBlocks.ANCIENT_VASE);
        blockModel(DDBlocks.ECHO_SOIL);

        itemModel(DDItems.HEART_OF_THE_DEEP, GENERATED);
        itemModel(DDItems.REINFORCED_ECHO_SHARD, GENERATED);
        itemModel(DDItems.WARDEN_CARAPACE, GENERATED);
        itemModel(DDItems.SOUL_DUST, GENERATED);
        getBuilder(getName(DDItems.SCULK_TRANSMITTER.get()) + "_on").parent(GENERATED).texture("layer0", "item/" + getName(DDItems.SCULK_TRANSMITTER.get()) + "_on");

        itemModel(DDItems.WARDEN_SWORD, HANDHELD);
        itemModel(DDItems.WARDEN_HELMET, GENERATED);
        itemModel(DDItems.WARDEN_CHESTPLATE, GENERATED);
        itemModel(DDItems.WARDEN_LEGGINGS, GENERATED);
        itemModel(DDItems.WARDEN_BOOTS, GENERATED);
        itemModel(DDItems.WARDEN_SHOVEL, HANDHELD);
        itemModel(DDItems.WARDEN_PICKAXE, HANDHELD);
        itemModel(DDItems.WARDEN_AXE, HANDHELD);
        itemModel(DDItems.WARDEN_HOE, HANDHELD);

        withExistingParent(getName(DDItems.SCULK_LEECH_SPAWN_EGG.get()), mcLoc("item/template_spawn_egg"));
        withExistingParent(getName(DDItems.SCULK_SNAPPER_SPAWN_EGG.get()), mcLoc("item/template_spawn_egg"));
        withExistingParent(getName(DDItems.SHATTERED_SPAWN_EGG.get()), mcLoc("item/template_spawn_egg"));
        withExistingParent(getName(DDItems.SHRIEK_WORM_SPAWN_EGG.get()), mcLoc("item/template_spawn_egg"));

        itemModel(DDItems.ECHO_BOAT, GENERATED);
        itemModel(DDItems.ECHO_CHEST_BOAT, GENERATED);

        getBuilder("wanderers_notebook").parent(GENERATED).texture("layer0", "item/wanderers_notebook");
    }

    public void blockModel(Supplier<? extends Block> block) {
        withExistingParent(getName(block.get()), modLoc("block/" + getName(block.get())));
    }

    public String getName(Block block) {
        return block.builtInRegistryHolder().key().location().getPath();
    }

    public String getName(Item item) {
        return item.builtInRegistryHolder().key().location().getPath();
    }

    public void blockModel(Supplier<? extends Block> block, String suffix) {
        withExistingParent(getName(block.get()), modLoc("block/" + getName(block.get()) + "_" + suffix));
    }


    public void itemModel(Supplier<? extends Item> item, ModelFile modelFile) {
        getBuilder(getName(item.get())).parent(modelFile).texture("layer0", "item/" + getName(item.get()));
    }
}
