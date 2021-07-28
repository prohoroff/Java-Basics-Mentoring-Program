package by.prohor.binary_search.sort;

import java.util.Arrays;

/**
 * Created by Artsiom Prokharau 19.06.2021
 */

public class SortedMerge implements Sort{

    @Override
    public void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        sort(left);
        sort(right);

        merge(array, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {

        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;

        int allLength = left.length + right.length;

        while (allLength > 0) {

            if (leftIndex >= left.length) {
                arr[targetIndex] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                arr[targetIndex] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                arr[targetIndex] = left[leftIndex++];
            } else {
                arr[targetIndex] = right[rightIndex++];
            }

            targetIndex++;
            allLength--;
        }
    }


}
