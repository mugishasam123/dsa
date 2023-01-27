public class InsertionSort {

    public void sort(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {

            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    public void print(int[] a) {

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }


    public static void main(String[] args) {
        InsertionSort sortAlgo = new InsertionSort();
        int [] arr = {3,9,12,1,8,43,87,0};
       sortAlgo.sort(arr);
       sortAlgo.print(arr);
    }
}
