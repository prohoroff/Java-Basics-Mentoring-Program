package by.prohor.binary_search;

/**
 * Created by Artsiom Prokharau 19.06.2021
 */

public class Recursively implements BinarySearch {

    @Override
    public int search(int[] sortedArray, int key, int low, int high) {

        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return search(sortedArray, key, low, middle - 1);
        } else {
            return search(sortedArray, key, middle + 1, high);
        }
    }
}
