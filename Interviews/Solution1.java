import java.io.*;
import java.util.*;

/*
You are with your friends in a castle, where there are multiple rooms named after flowers. Some of the rooms contain treasures - we call them the treasure rooms. 

Each room contains a single instruction that tells the player which room to go to next.

 *** instructions_1 *** 

 lily --------      daisy  sunflower
               |       |     |
               v       v     v
 jasmin ->  tulip      violet    -> rose --->
            ^    |      ^             ^     |
            |    |      |             |     |
            -----     iris             -----

 
 *** instructions_2 *** 

 lily --------      
               |     
               v      
 jasmin ->  tulip -- > violet  


Write a function that takes two parameters as input:
* a list containing the treasure rooms, and
* a list of instructions represented as pairs of (source_room, destination_room)

and returns a collection of all the rooms that satisfy the following two conditions:

* at least two *other* rooms have instructions pointing to this room
* this room's instruction immediately leads to a treasure room 

Examples 

instructions_1 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "tulip"], 
    ["rose", "rose"],
    ["violet", "rose"], 
    ["sunflower", "violet"],
    ["daisy", "violet"],
    ["iris", "violet"]
]

treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]
treasure_rooms_2 = ["lily", "jasmin", "violet"]  

instructions_2 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "violet"],
    ["violet", "violet"]       
]
treasure_rooms_3 = ["violet"]


filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction leads to a treasure room (tulip itself)
* violet can be accessed from daisy, sunflower and iris. Violet's instruction leads to a treasure room (rose)

filter_rooms(treasure_rooms_2, instructions_1) => []
* none of the rooms reachable from tulip or violet are treasure rooms

filter_rooms(treasure_rooms_3, instructions_2) => [tulip]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction leads to a treasure room (violet)

All the test cases: 
filter_rooms(treasure_rooms_1, instructions_1)    => ["tulip", "violet"]
filter_rooms(treasure_rooms_2, instructions_1)    => [] 
filter_rooms(treasure_rooms_3, instructions_2)    => [tulip]

Complexity Analysis variables:
N: treasure rooms
P: instructions
*/
public class Solution1 {

    static Set<Object> treasureRooms(String[][] instructions, String[] treasure_rooms) {

        int count = 0;
        ArrayList<String> dest_rooms = new ArrayList<String>();
        for (int i = 0; i < instructions.length; i++) {
            dest_rooms.add(instructions[i][1]);
        }

        Set<String> set = new HashSet<>();
        Set<String> duplicateElements = new HashSet<>();
        Set<Object> final_rooms = new HashSet<>();
        for (int i = 0; i < dest_rooms.size(); i++) {
            if (!set.add(dest_rooms.get(i))) {
                duplicateElements.add(dest_rooms.get(i));
            }
        }

        for (int i = 0; i < duplicateElements.size(); i++) {

            for (int j = 0; j < instructions.length; j++) {
                if (instructions[j][0] == duplicateElements.toArray()[i]) {
                    if (Arrays.asList(treasure_rooms).contains(instructions[j][1])) {
                        // System.out.println(duplicateElements.toArray()[i]);
                        final_rooms.add(duplicateElements.toArray()[i]);
                    }

                }
            }

        }

        return final_rooms;

    }

    public static void main(String[] argv) {
        String[][] instructions_1 = {
                { "jasmin", "tulip" },
                { "lily", "tulip" },
                { "tulip", "tulip" },
                { "rose", "rose" },
                { "violet", "rose" },
                { "sunflower", "violet" },
                { "daisy", "violet" },
                { "iris", "violet" }
        };

        String[][] instructions_2 = {
                { "jasmin", "tulip" },
                { "lily", "tulip" },
                { "tulip", "violet" },
                { "violet", "rose" },
                { "sunflower", "violet" }
        };

        String[] treasure_rooms_1 = { "lily", "tulip", "violet", "rose" };
        String[] treasure_rooms_2 = { "lily", "jasmin", "violet" };
        String[] treasure_rooms_3 = { "violet" };

        // set count=0
        // loop through instructions1
        // count dest_rooms that apperas to more than once
        // if we find dest_rooms in our init array we skip it
        // check return intersection of dest_rooms and treasure rooms

        System.out.println(treasureRooms(instructions_2, treasure_rooms_2));

    }
}
