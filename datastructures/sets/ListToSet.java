package datastructures.sets;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ListToSet{

    public static void main(String[] args) {
        Set<Integer> set = Arrays.asList(1,2,3,4,1,2).stream().collect(Collectors.toSet());
        System.out.println(set);
    }
}