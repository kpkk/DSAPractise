package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {

    @Test
    public void test() {
        int[] tickets = {2, 3, 2};
        int k = 2;
        Assertions.assertEquals(6, timeRequiredToBuyTickets(tickets, k));
    }

    @Test
    public void test1() {
        int[] tickets = {5, 1, 1, 1};
        int k = 0;
        Assertions.assertEquals(8, timeRequiredToBuyTickets(tickets, k));
    }

    public int timeRequiredToBuyTickets(int[] tickets, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int timer=0;
        for (int i=0;i<tickets.length;i++){
            deque.add(i);
        }
        while (!deque.isEmpty()){
            timer++;
            Integer poll = deque.poll();
            tickets[poll]--;
            if(tickets[poll]!=0)
                deque.offer(poll);
            else{
                if(poll==k) return timer;
            }
        }
        return timer;
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();

        // Step 1: Push all person indices into the queue line 👥
        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }

        // Step 2: Process the line round-robin style 🔄
        while (!q.isEmpty()) {
            time++; // Each transaction takes exactly 1 second
            int front = q.poll();
            tickets[front]--; // Buy one ticket

            // Step 3: Check if they need to go to the back or if they are done
            if (tickets[front] != 0) {
                q.add(front); // Put them back at the end of the line
            } else {
                // If our target person 'k' finishes, exit immediately! 🎉
                if (front == k) {
                    return time;
                }
            }
        }
        return time;
    }
}
