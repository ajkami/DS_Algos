public class bubbleSort {

    public static void bubblesort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length -1; // once you get to the end of the array for a sweep, the last element will be in place
        while (!isSorted) {
            isSorted = true; // start this as true whenever you start
            for (int i = 0; i < lastUnsorted; i++) { // only go to array.length - 1 because we check for array[i+1] and dont want an out of bounds error
                if (array[i] > array[i + 1]) {
                    swap(array,i,i+1);
                    isSorted = false; // if we had to swap elements then the array is not sorted
                }
            }
            lastUnsorted--; // decrement each time as once you sweep through the array another element from the end will be in the proper place. (speeds up bubblesort)
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
