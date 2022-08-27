import java.util.Arrays;
import java.util.Random;

public class qsnew {
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

    public static void quicksort(int[] array, int lowIndex, int highIndex) {

        if(lowIndex >= highIndex) {
            return;
        }
        int pivot = array[highIndex];

        int leftPointer = partitioning(array,lowIndex,highIndex,pivot);

        quicksort(array,lowIndex,leftPointer-1);
        quicksort(array,leftPointer+1,highIndex);
    }

    public static int partitioning(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer) {

            while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array,leftPointer,rightPointer);
        }

        if(array[leftPointer] > pivot) {
            swap(array,leftPointer,highIndex);
        }else{
            leftPointer = highIndex;
        }
        return leftPointer;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

