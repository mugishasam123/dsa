
public class SelectionSort {

    public void sort(int[] a) {

        int n = a.length;

        for (int i = 0; i < n - 1; i++) {

            int min = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[min])
                    min = j;

            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
        
       
    }
    public void print(int [] a) {
            
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }


    public static void main(String[] args) {
        SelectionSort sortAlgo = new SelectionSort();
        int [] arr = {3,9,12,1,8,43,87,0};
       sortAlgo.sort(arr);
       sortAlgo.print(arr);
    }
}