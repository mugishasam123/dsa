package exercises;


import java.util.*;



public class ArrayReverse {
    

    static void reverse(Integer arr[]) 
    { 
        Collections.reverse(Arrays.asList(arr)); 
        System.out.println("Reversed Array:" + Arrays.asList(arr)); 

       
    } 

    static void reverseArray(int [] arr)  { 
        int size = arr.length;
        int i, temp; 
        for (i = 0; i < size / 2; i++) { 
            temp = arr[i]; 
            arr[i] = arr[size - i - 1]; 
            arr[size - i - 1] = temp; 
        } 
        /*print the reversed array*/
       System.out.println("Reversed Array: \n" + Arrays.toString(arr)); 
    }

    public static void main(String[] args) {
        
        Integer [] arr = {1,10,3,4,5};
        reverse(arr);
     
    }
}
