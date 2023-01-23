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

        for (int i = 0; i < arr.length; i++) {
           System.out.println(arr[i]);
        }
       
        return arr.toString();
    }

    public static void main(String[] args) {
        ShuffleSort<String> shuffle = new ShuffleSort<>();
    
    String[] arr = {"a","b","c","d"};
    System.out.println(shuffle.sort(arr));
    }
}
