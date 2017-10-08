/**
 *
 */
package clothingcraft.util;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Makes creating and registering recipes easier for Minecraft Forge mods
 *
 * @author NinjaSoldier40
 * @since 02/17/2017 12:34 PM (-07:00 GMT)
 */
public class RecipeUtil {

    /**
     * Creates the <CODE>Object[]</CODE> array needed by Minecraft item/block recipes
     *
     * @param items array of <CODE>Item</CODE>s needed for the standard recipe
     * @return the object array properly formatted for a Minecraft recipe
     */
    public static Object[] createRecipeObject(Item[] items) {
        Object[] result = null;
        if (items != null && items.length > 0 && items.length < 10) {
            String row1 = "XXX", row2 = "XXX", row3 = "XXX";
            result = new Object[]{row1, row2, row3};

            int iidx = 0;
            for (Item item : items) {
                if (item != null) {
                    if (iidx > -1 && iidx < 3) {
                        result[0] = replaceCharAt((String) result[0], iidx, Character.toChars((iidx + 48))[0]);
                    } else if (iidx > 2 && iidx < 6) {
                        result[1] = replaceCharAt((String) result[1], iidx - 3, Character.toChars((iidx + 48))[0]);
                    } else if (iidx > 5 && iidx < 9) {
                        result[2] = replaceCharAt((String) result[2], iidx - 6, Character.toChars((iidx + 48))[0]);
                    }
                    result = appendValue(result, Character.toChars((iidx + 48))[0]);
                    result = appendValue(result, item);
                }
                iidx++;
            }
        }

        return result;
    }

    /**
     * Replaces a <CODE>Character</CODE> at the <CODE>index</CODE> with the <CODE>newChar</CODE> value
     *
     * @param inStr   String value to be changed
     * @param index   position of the character to be replaced
     * @param newChar new character to replace at the index position
     * @return the updated string with the newly replaced character
     */
    private static String replaceCharAt(String inStr, int index, char newChar) {
        StringBuilder newStr = new StringBuilder(inStr);
        newStr.setCharAt(index, newChar);
        inStr = newStr.toString();

        return inStr;
    }


    /**
     * Appends the <CODE>newObj</CODE> to the <CODE>objArray</CODE>.
     *
     * @param objArray array that object is to be added to
     * @param newObj   object to be added
     * @return new <CODE>Object</CODE> array with original elements, with <CODE>newObj</CODE> as last element
     */
    private static Object[] appendValue(Object[] objArray, Object newObj) {

        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(objArray));
        temp.add(newObj);
        return temp.toArray();

    }

}
