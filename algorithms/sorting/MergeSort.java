public class MergeSort {

    public void sort(int[] arr, int lb, int ub) {

        if (lb < ub) {
            int md = (lb + ub) / 2;
            sort(arr, lb, md);
            sort(arr, md + 1, ub);
            merge(arr, lb, md, ub);
        }

   

    }

    private static void merge(int[] arr, int lb, int md, int ub) {

        int i = lb;
        int j = md + 1;
        int k = lb;
        while (i <= md && j <= ub) {
            if (arr[i] <= arr[j]) {
                arr[k] = arr[i++];
            } else {
                arr[k] = arr[j++];

            }

            k++;
        }

        while (j < ub) {
            arr[k] = arr[j++];
            k++;
        }

        while (i < md) {
            arr[k] = arr[i++];
            k++;
        }

    }

  

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 23, 1, 45, 8, 0, 26 };
          mergeSort.sort(arr, 0, 5);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
