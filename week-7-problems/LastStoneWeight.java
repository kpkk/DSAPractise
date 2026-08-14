package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class LastStoneWeight {

    @Test
    public void test() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        Assertions.assertEquals(1, lastStoneWeight(stones));
    }

    @Test
    public void test1() {
        int[] stones = {2, 2};
        Assertions.assertEquals(0, lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length==1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (!pq.isEmpty()) {
            Integer firstStone = pq.poll();
            Integer secondStone = pq.poll();
            if (firstStone != secondStone) {
                pq.offer(firstStone - secondStone);
            }
            if(pq.size()==1) return pq.peek();
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
