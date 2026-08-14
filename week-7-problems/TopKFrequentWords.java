package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TopKFrequentWords {

    @Test
    public void test() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        Assertions.assertEquals(Arrays.asList("love", "i"), topKFreqEleHeap(words, k));
    }

    public List<String> topKFreqEle(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        for (Map.Entry<String, Integer> entry : entries) {
            if (k > 0) {
                strings.add(entry.getKey());
            }
            k--;
        }
        return strings;
    }

    public List<String> topKFreqEleHeap(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> output = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }
        for (int i=0;i<k;i++){
            output.add(pq.poll().getKey());
        }
        return output;
    }

}
