/**
 *
 */
package clothingcraft.items;


import clothingcraft.items.ClothingCraftFabricItemList.Colors;
import clothingcraft.items.ClothingCraftPatternItemList.Category;
import clothingcraft.items.ClothingCraftPatternItemList.Purpose;
import clothingcraft.util.RecipeUtil;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.LinkedHashMap;

import static clothingcraft.items.ItemWardrobeArmor.*;

/**
 * List of wardrobe items and their registrations into the world.
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 2/12/217 7:39 PM (-7:0 GMT)
 */
public class ClothingCraftWardrobeItemList {

    public static LinkedHashMap<String, ItemArmor.ArmorMaterial> armorMaterialMap =
            new LinkedHashMap<String, ItemArmor.ArmorMaterial>();
    // armorPrefix map
    public static LinkedHashMap<String, Integer> armorPrefixMap =
            new LinkedHashMap<String, Integer>();
    // outfitKey to armorType to Item map
    public static LinkedHashMap<String, LinkedHashMap<Purpose, Item>> outfitPurposeItemMap =
            new LinkedHashMap<String, LinkedHashMap<Purpose, Item>>();


    public static void preInit() {
        registerArmorMaterialAndPrefix("apronbrown", 1, new int[]{0, 0, 1, 0}, 9); // recipe done
        registerArmorMaterialAndPrefix("apronbutcher", 1, new int[]{0, 0, 1, 0}, 9); // recipe done
        registerArmorMaterialAndPrefix("aprongreen", 1, new int[]{0, 0, 1, 0}, 9); // recipe done
        registerArmorMaterialAndPrefix("apronwhite", 1, new int[]{0, 0, 1, 0}, 9); // recipe done
        registerArmorMaterialAndPrefix("angelwings", 4, new int[]{0, 4, 0, 0}, 9); // recipe done
        registerArmorMaterialAndPrefix("artist", 10, new int[]{2, 7, 5, 0}, 9); // recipe done
        registerArmorMaterialAndPrefix("ballcapblack", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("ballcapblue", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("ballcappurple", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("ballcapred", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("businesssuit", 10, new int[]{0, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("construction", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("costumechicken", 10, new int[]{2, 7, 0, 1}, 9);
        registerArmorMaterialAndPrefix("costumecreeper", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("costumedinocyan", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("costumedinomagenta", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("costumedinored", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("costumehotdog", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("costumenyancat", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("dresscoral", 4, new int[]{0, 0, 3, 0}, 9);
        registerArmorMaterialAndPrefix("dressgalaxy", 12, new int[]{4, 8, 6, 0}, 9);
        registerArmorMaterialAndPrefix("dressglowstone", 12, new int[]{3, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("dresslavendar", 4, new int[]{0, 0, 3, 0}, 9);
        registerArmorMaterialAndPrefix("dressmint", 4, new int[]{0, 0, 3, 0}, 9);
        registerArmorMaterialAndPrefix("dresswedding", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("earmuffslavendar", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("fairywings", 4, new int[]{0, 4, 0, 0}, 9);
        registerArmorMaterialAndPrefix("farmer", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("glassesblack", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("glassesred", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hairbowcoral", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hairbowlavendar", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hairbowmint", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hairpiecerainbow", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hairpiecedaisychain", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hathalo", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hatmushroom", 1, new int[]{1, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hatpig", 1, new int[]{2, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("hatsheep", 1, new int[]{2, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("headphones", 1, new int[]{3, 0, 0, 0}, 9);
        registerArmorMaterialAndPrefix("longsleevegalaxy", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("lumberjack", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("king", 25, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("mage", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("pajamasblack", 2, new int[]{0, 3, 2, 0}, 9);
        registerArmorMaterialAndPrefix("pajamasblue", 2, new int[]{0, 3, 2, 0}, 9);
        registerArmorMaterialAndPrefix("pajamasgreen", 2, new int[]{0, 3, 2, 0}, 9);
        registerArmorMaterialAndPrefix("pajamasmint-w-flowers", 2, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("pajamasred", 2, new int[]{0, 3, 2, 0}, 9);
        registerArmorMaterialAndPrefix("pajamasyellow-w-orangedots", 2, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("policeofficer", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("pantsjeans", 3, new int[]{0, 0, 3, 0}, 9);
        registerArmorMaterialAndPrefix("pantskhaki", 3, new int[]{0, 0, 3, 0}, 9);
        registerArmorMaterialAndPrefix("queen", 25, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("scrubs", 10, new int[]{2, 3, 2, 2}, 9);
        registerArmorMaterialAndPrefix("shirt-w-bowtie", 2, new int[]{0, 3, 0, 0}, 9);
        registerArmorMaterialAndPrefix("slippersbunny", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("slipperskitty", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("slippersteddy", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("sushichef", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("sweatercyan", 3, new int[]{0, 3, 0, 0}, 9);
        registerArmorMaterialAndPrefix("sweaterlavendar", 3, new int[]{0, 3, 0, 0}, 9);
        registerArmorMaterialAndPrefix("sweaterteddy", 3, new int[]{0, 3, 0, 0}, 9);
        registerArmorMaterialAndPrefix("swimsuiteblue", 1, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("swimsuitemagenta", 1, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("tanktopwhite", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("tanktoporange", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("tanktoporange2", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("tanktoppink", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("tanktopheart", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("teecookie", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("teecreeper", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("teecupcake", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("teediamond", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("teegrass", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("teemushroom", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("teetiedye", 10, new int[]{0, 2, 0, 0}, 9);
        registerArmorMaterialAndPrefix("tuxedoblack", 10, new int[]{0, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("tuxedoglow", 12, new int[]{0, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("workboots", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("scientist", 10, new int[]{2, 7, 5, 0}, 9);
        registerArmorMaterialAndPrefix("shoesblack", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoesblue", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoeslime", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoesmagenta", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoesorange", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoespink", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoespurple", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoesred", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoesruby", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoeswhite", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shoesyellow", 2, new int[]{0, 0, 0, 1}, 9);
        registerArmorMaterialAndPrefix("shortsblue-w-flowers", 1, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("shortsblue-w-whitestripes", 1, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("shortsred-w-whitestripe", 1, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("shortswhite-w-reddots", 1, new int[]{0, 0, 2, 0}, 9);
        registerArmorMaterialAndPrefix("skirtgray", 3, new int[]{0, 0, 3, 0}, 9);
        registerArmorMaterialAndPrefix("skirtruffled", 3, new int[]{0, 0, 3, 0}, 9);
    }

    public static void init() {
        // angelwings",   4, new int[] { 0, 4, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("angelwings", getPurposeByArmorType(BODY)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.costume, Purpose.chest),
                        getFabric(Colors.bluelight),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.feather, Items.string, Items.feather
                })
        );

        // construction", 10, new int[] { 2, 7, 5, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("construction", getPurposeByArmorType(HEAD)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.helm),
                        getFabric(Colors.yellow),
                        ClothingCraftToolsItemList.measuringTape,
                        Items.iron_helmet
                })
        );
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("construction", getPurposeByArmorType(BODY)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.chest),
                        getFabric(Colors.yellow),
                        getFabric(Colors.orange),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.iron_pickaxe
                })
        );
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("construction", getPurposeByArmorType(LEGS)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.pants),
                        getFabric(Colors.bluedark),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.iron_pickaxe
                })
        );
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("construction", getPurposeByArmorType(FEET)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.boots),
                        getFabric(Colors.brown),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.leather
                })
        );

        // apronbrown",   1, new int[] { 0, 1, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("apronbrown", getPurposeByArmorType(LEGS)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.pants),
                        getFabric(Colors.brown),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.string
                })
        );

        // apronbutcher", 1, new int[] { 0, 1, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("apronbutcher", getPurposeByArmorType(LEGS)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.pants),
                        getFabric(Colors.white),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.string,
                        Items.cooked_porkchop
                })
        );

        // aprongreen",   1, new int[] { 0, 1, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("aprongreen", getPurposeByArmorType(LEGS)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.pants),
                        getFabric(Colors.green),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.string,
                        Items.cooked_porkchop
                })
        );

        // apronwhite",   1, new int[] { 0, 1, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("apronwhite", getPurposeByArmorType(LEGS)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.pants),
                        getFabric(Colors.white),
                        ClothingCraftToolsItemList.needleAndThread,
                        Items.string
                })
        );

        // artist", 	   10, new int[] { 2, 7, 5, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("construction", getPurposeByArmorType(HEAD)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.helm),
                        getFabric(Colors.black),
                        ClothingCraftToolsItemList.measuringTape
                })
        );
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("construction", getPurposeByArmorType(BODY)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.chest),
                        getFabric(Colors.white),
                        ClothingCraftToolsItemList.needleAndThread
                })
        );
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("construction", getPurposeByArmorType(LEGS)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.career, Purpose.pants),
                        getFabric(Colors.bluedark),
                        ClothingCraftToolsItemList.needleAndThread
                })
        );

        // ballcapblack", 1, new int[] { 1, 0, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("ballcapblack", getPurposeByArmorType(HEAD)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.casual, Purpose.helm),
                        getFabric(Colors.black),
                        ClothingCraftToolsItemList.measuringTape
                })
        );
        // ballcapblue",  1, new int[] { 1, 0, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("ballcapblue", getPurposeByArmorType(HEAD)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.casual, Purpose.helm),
                        getFabric(Colors.bluedark),
                        ClothingCraftToolsItemList.measuringTape
                })
        );
        // ballcappurple",1, new int[] { 1, 0, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("ballcappurple", getPurposeByArmorType(HEAD)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.casual, Purpose.helm),
                        getFabric(Colors.purple),
                        ClothingCraftToolsItemList.measuringTape
                })
        );
        // ballcapred",   1, new int[] { 1, 0, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("ballcapred", getPurposeByArmorType(HEAD)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        getPattern(Category.casual, Purpose.helm),
                        getFabric(Colors.red),
                        ClothingCraftToolsItemList.measuringTape
                })
        );
        // businesssuit", 10, new int[] { 0, 7, 5, 0 }, 9);
        // costumecreeper",10, new int[] { 2, 7, 5, 0 }, 9);
        // dresscoral",   4, new int[] { 0, 0, 3, 0 }, 9);
        // dresslavendar",4, new int[] { 0, 0, 3, 0 }, 9);
        // dressmint",    4, new int[] { 0, 0, 3, 0 }, 9);
        // earmuffslavendar" , 1, new int[] { 1, 0, 0, 0 }, 9);
        // farmer",       10, new int[] { 2, 7, 5, 0 }, 9);
        // glassesblack", 1, new int[] { 1, 0, 0, 0 }, 9);
        GameRegistry.addRecipe(new ItemStack(
                        getOutfitItem("ballcapred", getPurposeByArmorType(HEAD)), 1),
                RecipeUtil.createRecipeObject(new Item[]{
                        null, getPattern(Category.career, Purpose.helm), null,
                        Items.glass_bottle, getFabric(Colors.black), Items.glass_bottle
                })
        );

        // glassesred",   1, new int[] { 1, 0, 0, 0 }, 9);
        // hairbowcoral", 1, new int[] { 1, 0, 0, 0 }, 9);
        // hairbowlavendar", 1, new int[] { 1, 0, 0, 0 }, 9);
        // hairbowmint",  1, new int[] { 1, 0, 0, 0 }, 9);
        // hairpiecerainbow" , 1, new int[] { 1, 0, 0, 0 }, 9);
        // longsleevegalaxy", 10, new int[] { 0, 2, 0, 0 }, 9);
        // lumberjack",   10, new int[] { 2, 7, 5, 0 }, 9);
        // mage",         10, new int[] { 2, 7, 5, 0 }, 9);
        // pajamasblack", 2, new int[] { 0, 3, 2, 0 }, 9);
        // pajamasblue",  2, new int[] { 0, 3, 2, 0 }, 9);
        // pajamasgreen", 2, new int[] { 0, 3, 2, 0 }, 9);
        // pajamasred", 2, new int[] { 0, 3, 2, 0 }, 9);
        // policeofficer",10, new int[] { 2, 7, 5, 0 }, 9);
        // scrubs",       10, new int[] { 2, 3, 2, 2 }, 9);
        // slippersbunny",2, new int[] { 0, 0, 0, 1 }, 9);
        // slipperskitty",2, new int[] { 0, 0, 0, 1 }, 9);
        // slippersteddy",2, new int[] { 0, 0, 0, 1 }, 9);
        // sushichef",    10, new int[] { 2, 7, 5, 0 }, 9);
        // tanktopwhite", 10, new int[] { 0, 2, 0, 0 }, 9);
        // tanktoporange",10, new int[] { 0, 2, 0, 0 }, 9);
        // tanktoppink",  10, new int[] { 0, 2, 0, 0 }, 9);
        // tanktopheart", 10, new int[] { 0, 2, 0, 0 }, 9);
        // teecookie",    10, new int[] { 0, 2, 0, 0 }, 9);
        // teecreeper",   10, new int[] { 0, 2, 0, 0 }, 9);
        // teecupcake",   10, new int[] { 0, 2, 0, 0 }, 9);
        // teediamond",   10, new int[] { 0, 2, 0, 0 }, 9);
        // teegrass",     10, new int[] { 0, 2, 0, 0 }, 9);
        // teemushroom",  10, new int[] { 0, 2, 0, 0 }, 9);
        // tuxedoblack",  10, new int[] { 0, 7, 5, 0 }, 9);
        // tuxedoglow",   12, new int[] { 0, 7, 5, 0 }, 9);
        // workboots",    2, new int[] { 0, 0, 0, 1 }, 9);
        // shoesblack",   2, new int[] { 0, 0, 0, 1 }, 9);
        // shoesblue",    2, new int[] { 0, 0, 0, 1 }, 9);
        // shoeslime",    2, new int[] { 0, 0, 0, 1 }, 9);
        // shoesmagenta", 2, new int[] { 0, 0, 0, 1 }, 9);
        // shoesorange",  2, new int[] { 0, 0, 0, 1 }, 9);
        // shoespink",    2, new int[] { 0, 0, 0, 1 }, 9);
        // shoespurple",  2, new int[] { 0, 0, 0, 1 }, 9);
        // shoesred",     2, new int[] { 0, 0, 0, 1 }, 9);
        // shoesruby",    2, new int[] { 0, 0, 0, 1 }, 9);
        // shoeswhite",   2, new int[] { 0, 0, 0, 1 }, 9);
        // shoesyellow",  2, new int[] { 0, 0, 0, 1 }, 9);
    }

    private static void registerArmorMaterialAndPrefix(String outfitKey, int durability, int[] reductions, int enchatability) {
        ArmorMaterial enumArmorMaterial =
                EnumHelper.addArmorMaterial(outfitKey.toUpperCase(), durability, reductions, enchatability);
        armorMaterialMap.put(outfitKey, enumArmorMaterial);
        int armorPrefix = 0;
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            armorPrefix = RenderingRegistry.addNewArmourRendererPrefix("angelwings");
        armorPrefixMap.put(outfitKey, armorPrefix);

        int armorType = 0;
        for (int reductionValue : reductions) {
            if (reductionValue > 0) {
                createRegisterWardrobeArmorItem(outfitKey, armorType);
            }
            armorType++;
        }


    }

    private static void createRegisterWardrobeArmorItem(String outfitKey, int armorType) {

        Item outfitItem = new ItemWardrobeArmor(
                outfitKey,
                /*
                 * outfitKey populates the following within the ItemWardrobeArmor class
				 * unlocalizedName = item.[unlocalizedName].name=[displayedItemName]
				 * itemTextureName = ClothingCraftInfo.MODID + ":textures/items/[imageName]"
				 * armorTextureName textures/models/wardrobe/..._layer_[1 or 2]
				 */
                armorMaterialMap.get(outfitKey),
                armorPrefixMap.get(outfitKey), // renderIndex: 0 = cloth, 1 = chain, 2 = iron, 3 = diamond, 4 = gold
                armorType // armorType: 0=helmet, 1=chestplate, 2=leggings, 3=boots
        );
        // load the outfitKey to armorType to Item map
        if (outfitPurposeItemMap.get(outfitKey) == null) {
            outfitPurposeItemMap.put(outfitKey, new LinkedHashMap<Purpose, Item>());
        }
        outfitPurposeItemMap.get(outfitKey).put(getPurposeByArmorType(armorType), outfitItem);
        // register item with game environment
        String registerItemKey = "wardrobe_" +
                outfitKey.toLowerCase() +
                ItemWardrobeArmor.getTextureSuffix(armorType);
        GameRegistry.registerItem(outfitItem, registerItemKey);

    }

    /**
     * Resolves the stored sewing pattern item reference from the map container in this class
     *
     * @param enumCategory ClothingCraftPatternItemList.CATEGORY enumeration element
     * @param enumPurpose  ClothingCraftPatternItemList.PURPOSE enumeration element
     * @return associated sewing pattern item, null if none exists
     */
    public static Item getPattern(Category enumCategory, Purpose enumPurpose) {
        return ClothingCraftPatternItemList.patternsItemMap.get(enumCategory).get(enumPurpose);
    }

    /**
     * Resolves the stored sewing fabric item reference from the map container in this class
     *
     * @param enumColor ClothingCraftFabricItemList.COLORS enumeration element
     * @return associated sewing fabric item, null if none exists.
     */
    public static Item getFabric(Colors enumColor) {
        return ClothingCraftFabricItemList.fabricItemsMap.get(enumColor);
    }

    /**
     * Resolves the stored wardrobe (outfit) item reference from the map container in this class
     *
     * @param outfitKey String representation of map key:
     *                  REQUIRED, null value will throw an IlleagalArgumentException
     * @param purpose   ClothingCraftPatternItemList.PURPOSE enumeration element:
     *                  REQUIRED, null value will throw an IlleagalArgumentException
     * @return associated wardrobe (outfit) item, null if none exists
     */
    public static Item getOutfitItem(String outfitKey, Purpose purpose) {
        Item result = null;
        LinkedHashMap<Purpose, Item> outfitMap = outfitPurposeItemMap.get(outfitKey);
        if (outfitMap != null && purpose != null) {
            result = outfitMap.get(purpose);
        } else {
            if (outfitMap == null)
                throw new IllegalArgumentException("null argument: outfitKey");
            if (purpose == null)
                throw new IllegalArgumentException("null argument: purpose");
        }
        return result;
    }

    /**
     * Resolves an input integer (0-3) to an associated PURPOSE enumeration
     *
     * @param armorType 0 = HEAD, 1 = BODY, 2 = LEGS, 3 = FEET, default resolves to null value
     * @return ClothingCraftPatternItemList.PURPOSE enumeration element<br/>
     * <ul>
     * <li>HEAD (0) = PURPOSE.helm</li>
     * <li>BODY (1) = PURPOSE.chest</li>
     * <li>LEGS (2) = PURPOSE.pants</li>
     * <li>FEET (3) = PURPOSE.boots</li>
     * </ul>
     */
    public static Purpose getPurposeByArmorType(int armorType) {
        Purpose result = null;
        switch (armorType) {
            case 0:
                result = Purpose.helm;
                break;
            case 1:
                result = Purpose.chest;
                break;
            case 2:
                result = Purpose.pants;
                break;
            case 3:
                result = Purpose.boots;
                break;
            default:
        }
        return result;
    }

}
