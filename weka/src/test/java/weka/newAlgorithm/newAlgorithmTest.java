package weka.newAlgorithm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import weka.core.AlgVectorTest;
import weka.test.WekaTestSuite;



public class newAlgorithmTest
        extends TestCase {

    // nous avons choisi d'implementer l'algorithme de tri quicksort afin de le tester
    // source : https://github.com/careercup/ctci/blob/master/java/Chapter%2011/Introduction/Quicksort.java

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int partition(int arr[], int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be an element.

        while (left <= right) { // Until we've gone through the whole array
            // Find element on left that should be on right
            while (arr[left] < pivot) {
                left++;
            }

            // Find element on right that should be on left
            while (arr[right] > pivot) {
                right--;
            }

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left > index - 1) { // Sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) { // Sort right half
            quickSort(arr, index, right);
        }
    }

    public void testNewAlgoClassTest() {
        int[] arr = {11, 2, 1, 0, 3, 8, 10, 5, 7, 6, 9, 4};
        int[] arr_sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        quickSort(arr, 0, arr.length -1 );
        System.out.println(arr);
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != arr_sorted[i]){
                fail("problem with the quicksort algorithm");
            }
        }
    }

    public static Test suite() { return new TestSuite(newAlgorithmTest.class);}

    public static void main(String []args) {
        junit.textui.TestRunner.run(suite());
    }
}