package clothingcraft.generation;

import clothingcraft.blocks.ClothingCraftCottonBlockList;
import clothingcraft.blocks.ClothingCraftHaliteBlockList;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class ClothingCraftWorldGen implements IWorldGenerator {

    private WorldGenerator generatorHaliteOre; //Generates Halite Ore (used in Overworld)
    private PlantGenerator generatorCottonWildPlant; // Generates Cotton Plants (used in Overworld)

    public ClothingCraftWorldGen() {
        this.generatorHaliteOre = new WorldGenMinable(ClothingCraftHaliteBlockList.haliteOre, 3);
        this.generatorCottonWildPlant = new PlantGenerator(ClothingCraftCottonBlockList.cottonWildPlant, 3);

    }


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
                         IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0: //Overworld
                runOreGenerator(generatorHaliteOre, world, random, chunkX, chunkZ,
                        2, // chancesToSpawn
                        2,  // minHeight
                        64 // maxHeight
                );
                runPlantGenerator(generatorCottonWildPlant, world, random, chunkX, chunkZ);
                break;
            case -1: //Nether

                break;
            case 1: //End

                break;
        }
    }

    private void runOreGenerator(WorldGenerator generator, World world, Random random, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++) {
            int x = chunk_X * 16 + random.nextInt(16);
            int y = minHeight + random.nextInt(heightDiff);
            int z = chunk_Z * 16 + random.nextInt(16);
            generator.generate(world, random, x, y, z);
        }
    }

    private boolean runPlantGenerator(PlantGenerator generator, World world, Random random, int chunkX, int chunkZ) {
        // calculate the y coordinate find first dirt or grass 1 sky above it.
        int x = (chunkX << 4) + random.nextInt(16) + 8;
        int y = random.nextInt(128);
        int z = (chunkZ << 4) + random.nextInt(16) + 8;

        return generator.generate(world, random, x, y, z);
    }
}