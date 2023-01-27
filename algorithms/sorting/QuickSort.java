import java.util.Arrays;

public class QuickSort {

    public String sort(int[] arr, int lb, int ub) {

        if (lb < ub) {
            int pivot = partition(arr, lb, ub);
          
            sort(arr, lb, pivot);
            sort(arr, pivot + 1, ub);
        }

        return Arrays.toString(arr);
    }

    public int partition(int[] arr, int lb, int ub) {

        int sortedEl = arr[lb];
        int start = lb-1;
        int end = ub+1;

        while (true) {
            do {
                start++;
            } while (arr[start] < sortedEl);

            // Find rightmost element smaller
            // than or equal to pivot
            do {
                end--;
            } while (arr[end] > sortedEl);

            if (start >= end)
            return end;
            
            arr[start] = arr[end];
            arr[end] = sortedEl;

        }

        
    }

    public static void main(String[] args) {
        int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        QuickSort quickSort = new QuickSort();
       
        System.out.println( quickSort.sort(arr, 0, 8));
    }

}
