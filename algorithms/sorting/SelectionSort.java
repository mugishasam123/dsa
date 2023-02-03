import java.util.Arrays;

public class SelectionSort {

    static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int lowestNUmber = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[lowestNUmber])
                    lowestNUmber = j;
            }

            if (lowestNUmber != i) {
                int temp = arr[lowestNUmber];
                arr[lowestNUmber] = arr[i];
                arr[i] = temp;

            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String [] args){
        int [] arr = {1,4,7,9,3};
        SelectionSort.sort(arr);
    }
}