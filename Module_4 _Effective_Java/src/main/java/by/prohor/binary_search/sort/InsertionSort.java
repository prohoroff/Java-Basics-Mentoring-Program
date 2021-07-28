package by.prohor.binary_search.sort;

import java.util.Arrays;

/**
 * Created by Artsiom Prokharau 19.06.2021
 */

public class InsertionSort  implements Sort{

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = temp;
        }
    }
}
