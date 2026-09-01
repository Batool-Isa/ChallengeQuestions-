import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Nothing in the main method will be tested
        int[] arr = {1, 2, 56, 4, 6, 3, 2};
        int[] res = findLargestAndSmallest(arr);
        for (int i : res) {
            System.out.println(i);
        }

        Object[] rr = removeDuplicatesFromArray(arr);
        for (Object h: rr) {
            System.out.println(h);
        }

        int[] aaa  = {5,4};
        System.out.println(sumOfTwoLargest(aaa));

        int[] numbers = {1,2,2,3,4,5,5};
        int[] num3 = {2,3,6,8,9,999};
        System.out.println("Sorted Merged Arrays: "+ Arrays.toString(mergeSortedArrays(numbers, num3)));
    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     * <p>
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the largest and smallest.
     * <p>
     * You MAY ONLY use arrays, not other collections types (ie Lists).
     * <p>
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int[] array) {
        // variables to hold the smallest and largest num
        int smallest = array[0];
        int largest = array[array.length - 1];
        for (int i : array) {
            if (i < smallest) {
                smallest = i;
            }
            if (i > largest) {
                largest = i;
            }
        }
        int[] resultArr = new int[2];
        resultArr[0] = smallest;
        resultArr[1] = largest;
        return resultArr;

    }


    /**
     * Question 2: Remove duplicates from an array
     * <p>
     * You are given an array of ints that might have duplicates. You must remove any duplicates from the array,
     * and return an array that doesn't contain duplicates. The order of the elements in the original array
     * does not need to be kept the same.
     * <p>
     * You MAY use any collections types you wish, but the method must return an array.
     * <p>
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param array An array of ints that may or may not include duplicates
     * @return An array of ints that doesn't contain duplicates.
     */
    public static Object[] removeDuplicatesFromArray(int[] array) {
        Arrays.sort(array);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Integer k : array) {
            arr.add(k);
        }
        for (int j = 0; j < arr.size() - 1; j++) {
            if ((arr.get(j)).equals(arr.get(j + 1))) {
                arr.remove(j + 1);
                j--;
            }
        }
        //convert the arraylist back to array
        Integer[] result = arr.toArray(Integer[]::new);
        return result;
    }

    /**
     * Given an array of integers, return the sum of the two largest values.
     * <p>
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     * <p>
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers of any size.
     * @return Sum of the two largest values
     */
    public static int sumOfTwoLargest(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
        return array[0];
        }

            int largest ;
            int secLargest ;

            if (array[0] >= array[1]){
                largest = array[0];
                secLargest = array[1];
            }else{
                largest = array[1];
                secLargest = array[0];
            }
            // loop from third elements to the rest of an array
            for (int n =2; n < array.length; n++) {
                if (array[n] >= largest) {
                    secLargest = largest;
                    largest = array[n];
                } else if ( array[n] >= secLargest ) {
                    secLargest = array[n];
                }
            }
          ///  System.out.println("Largest: " + largest + "Sec: "+ secLargest);
            return largest + secLargest;

    }

    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     * <p>
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     * <p>
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     * <p>
     * For example:
     * array1 = [1,4,7,9,0,0,0]
     * array2 = [1,5,11]
     * returned array = [1,1,4,5,7,9,11]
     * <p>
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] num = new int[array1.length + array2.length];
        // copy first array into new array and then 2nd array to the new array
        System.arraycopy(array1, 0, num,0,array1.length);
        System.arraycopy(array2, 0, num, array2.length, array2.length);
        Arrays.sort(num);
        return num;
    }
}