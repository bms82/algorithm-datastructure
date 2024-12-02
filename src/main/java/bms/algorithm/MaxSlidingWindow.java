package bms.algorithm;

import java.util.*;

public class MaxSlidingWindow {

    int[] maxSlidingWindow(int[] nums, int k) {



        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k -1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                res.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;


    }

    class MonotonicQueue {
        private LinkedList<Integer> q = new LinkedList<>();
        public void push(int n) {
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }
        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }

        public int max() {
            return q.getFirst();
        }

    }
}
