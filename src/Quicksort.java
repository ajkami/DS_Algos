import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));

        quicksort(numbers,0, numbers.length - 1);

        System.out.println("After: ");
        System.out.println(Arrays.toString(numbers));
    }


    private static void quicksort(int[] array, int lowIndex, int highIndex) { // low/high index is the bounds of the array so that it will sort the subarrays properly

        if (lowIndex >= highIndex) {
            return; // return because array is done sorting. Only one element left in the sorting array
        }
        int pivot = array[highIndex]; // setting our pivot to the last element of the array

        int leftPointer = partitioning(array, lowIndex, highIndex, pivot);

        // now recursion
        // TODO: 2022-08-11 Review the recursion for this method
        quicksort(array,lowIndex, leftPointer - 1); // low index is the first number of the array that we are sorting (lowIndex) and high index is one before the pivot
        quicksort(array,leftPointer + 1,highIndex); // highIndex is the end of our list. (goes from one after the pivot to the end of the array
    }

    private static int partitioning(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            // TODO: 2022-08-12 Remember to put the <= and >= because if the array[left/right pointer] are equal to the pivot it should keep looking
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) { // while the value that the lp is pointing at is less than the pivot AND the left pointer is smaller than the right
                leftPointer++; // pointer going up by one
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) { // while the value that the rp is pointing at is greater than the pivot AND the left pointer is smaller than the right
                rightPointer--; // pointer going down by one
            }

            swap(array, leftPointer,rightPointer); // when array[leftPointer] > pivot and array[rightPointer] < pivot we want to swap these two elements
        }

        // TODO: 2022-08-11 Review this part (kinda confusing)
        if (array[leftPointer] > array[highIndex]) { // if the number at the left pointer is higher than the pivot
            swap(array, leftPointer, highIndex); // swap left pointer with pivot  (high index is always our pivot)
        } else {
            leftPointer = highIndex; // if the above is not the case, then the array is done sorting. So by returning highIndex it returns the sorted number in its position
        }
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
