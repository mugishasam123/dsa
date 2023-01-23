import java.util.Random;

public class ShuffleSort<Item> {

    public String sort(Item[] arr) {

        for (int i = 0; i < arr.length; i++) {
            Random rand = new Random();
            int random = rand.nextInt(i+1);
            Item swap = arr[i];
            arr[i] = arr[random];
            arr[random] = swap;
        }
       
        return arr.toString();
    }

    public static void main(String[] args) {
        ShuffleSort<Integer> shuffle = new ShuffleSort<>();
    
    Integer[] arr = {1,2,3,4,5,6,7,8,9};
    System.out.println(shuffle.sort(arr));
    }
}
