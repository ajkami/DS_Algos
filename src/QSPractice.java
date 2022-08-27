import java.util.Arrays;
import java.util.Random;

public class QSPractice {
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

    private static void quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) { // if lowIndex is greater than (for quicksort above) or equal to (for quicksort below) the high index, then there is only one element in the array so that item is now sorted
            return;
        }

        int pivot = array[highIndex]; // setting the pivot as the highest index in the list

        int leftPointer = partitioning(array,lowIndex,highIndex,pivot); // partitioning in order to get our left pointer

        quicksort(array,lowIndex,leftPointer - 1); // quicksort recursion for the lower half of the array
        quicksort(array,leftPointer + 1, highIndex); // quicksort recursion for the higher half of the array

    }

    private static int partitioning(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex; // setting the left pointer to lowIndex
        int rightPointer = highIndex; // setting the right pointer to highIndex

        while(leftPointer < rightPointer) { // while the pointers arent pointing to the same number

            while(array[leftPointer] <= pivot && leftPointer < rightPointer) { // while the left pointer value is less than the pivot. (have to do leftPointer < rightPointer so that an extra incrementation isnt done when the parent while loops conditions arent met)
                leftPointer++; // incrementing leftPointer by one
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) { // same thing as above but while the right pointer value is greater than the pivot
                rightPointer--; // decrementing the rightPointer by one
            }

            swap(array,array[leftPointer],array[rightPointer]); // swapping the values that the lp and rp are pointing to as the lp value will be higher than the pivot, and the rp value will be lower than the pivot
        }

        if(array[leftPointer] > array[highIndex]) { // this puts the pivot in the correct position. ( if the lp value is above the pivot value then they should swap to sort)
            swap(array,leftPointer,highIndex);
        } else {
            leftPointer = highIndex; // if the above is not the case, then there is only one element in the array so return lp as highIndex so the value will be returned in the proper position. (as of line 24
        }
        return leftPointer; // returning the left pointer
    }

    private static void swap(int[] array, int index1, int index2 ) { // simple swap function to swap the lp and rp values
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
