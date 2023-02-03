import java.util.Arrays;

class BubbleSort{

    static void Sort(int [] arr){

        boolean isSorted = false;
        int lastUnsorted = arr.length-1;

        while (!isSorted){
            isSorted=true;
            for(int i =0;i<lastUnsorted;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i]= arr[i+1];
                    arr[i+1]=temp;
                    isSorted=false;
                }
            }
            lastUnsorted--;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String []args){

        int [] arr={10,70,2,8,0,1};
        BubbleSort.Sort(arr);
    }
}