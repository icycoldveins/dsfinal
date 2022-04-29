import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Athena {
    // Write a method which, given a List of strings, returns what
    // Strings appeared in the array and how many times each word appeared.
    // You may assume that each String holds a single word.
    public static Map<String, Integer> wordCount(List<String> words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
    // Given an integer array nums, return true if any value appears at least twice in the
    //  array, and return false if every element is distinct.


    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    } 
    
    public static void main(String[] args) {

    }

}
