public class mergeSort {
    public static void mergesort(int[] array) {
        mergeSort(array, 0 , array.length - 1);
    }

    public static void mergeSort(int[] array, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) { // if the array is 1 number only then you're done and that number is in the correct spot
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array,leftStart,middle);
        mergeSort(array,middle + 1, rightEnd);
        mergeHalves(array,leftStart,rightEnd);
    }

    public static void mergeHalves(int[] array, int leftStart, int rightEnd)
    {

    }
}
