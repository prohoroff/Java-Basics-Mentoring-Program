package by.prohor.binary_search;

/**
 * Created by Artsiom Prokharau 24.06.2021
 */

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9};


        Iteratively iteratively = new Iteratively();
        int search = iteratively.search(arr, 2, 0, arr.length - 1);
        System.out.println(search);
    }
}
