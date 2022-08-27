import java.util.Arrays;
import java.util.Random;

public class Bubsort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("After: ");
        System.out.println(Arrays.toString(numbers));
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if(array[i] > array[i+1]) {
                    swap(array,i,i+1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
