public class ShellSort {

    public void sort(int[] a) {
        int n = a.length;
        for (int gap = n; gap >= 1; gap /= 2) {
            for (int j = gap; j < n; j++) {
                for (int i = j - gap; i >= 0; i = i - gap) {
                    if (a[i + gap] > a[i])
                        break;
                    int swap = a[i + gap];
                    a[i + gap] = a[i];
                    a[i] = swap;
                }
            }
        }

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

  
    public static void main(String[] args) {
        ShellSort shell = new ShellSort();
        int [] a={23,14,6,78,1,34,3,0};
        shell.sort(a);
    }

}
