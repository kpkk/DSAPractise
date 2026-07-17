package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    @Test
    public void test() {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = Arrays.asList(
                List.of("eat", "tea", "ate"),
                List.of("bat"),
                List.of("tan", "nat")
        );
        Assertions.assertEquals(list, groupAnagrams(s));
    }

    /**
     * Initialise a hashmap with String as key and List<Strings> as value
     * iterate the array from left to right using a pointer i
     * create new Array list and add the string at the current index (key, list.of(""))
     * for every string at index i
     *  - add the string to the list defined above ->list.of("eat") -> value part of the map
     *  - compute the sorted version of the string / ascii array to store that as a key
     *  - check if the sorted version of the string / ascii array is present in the map
     *      - if yes, update the entry, just add the current list string to the existing list
     *      - if no, create a new entry in the map, with key as sorted / ascii version of the string and list of strings
     *  - repeat above steps, till the pointer reaches the
     * return the map.values() as a list
     * TC: O(n) // ascii approach ; TC: O(n)* O(nlogn) sorted approach
     * SC: O(n)
     *
     * @param s
     * @return
     */

    public List<List<String>> groupAnagrams(String[] s){
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0;i<s.length;i++){
            String currentStr = s[i];
            ArrayList<String> valueList = new ArrayList<>();
            valueList.add(currentStr);
            // sorted version
           // String sortedString = returnSortedStrVersion(currentStr);

            // ascii
            String sortedString = returnAsciiVersionOfString(currentStr); // O(26)-O(1)
            if(map.containsKey(sortedString)){
                List<String> strings = map.get(sortedString);
                strings.addAll(valueList);
                map.put(sortedString, strings);
            }else
                map.put(sortedString, valueList);
        }
        return new ArrayList<>(map.values());
    }


    public String returnSortedStrVersion(String s){
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    public String returnAsciiVersionOfString(String s){
        int[] ascii=new int[26];
        for (int i=0;i<s.length();i++){
            ascii[s.charAt(i)-'a']++;
        }
        return Arrays.toString(ascii);
    }


}
