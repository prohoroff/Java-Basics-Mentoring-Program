package by.prohor.binary_search;

/**
 * Created by Artsiom Prokharau 19.06.2021
 */

public class Iteratively implements BinarySearch{

    @Override
    public int search(int[] sortedArray, int key, int low, int high) {
        int index = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

}
