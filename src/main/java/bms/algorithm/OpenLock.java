package bms.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode #752. Open the Lock
 */
public class OpenLock {
    // Opening the lock in least possible attempts
    int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<String>();
        Set<String> deadEndSet = new HashSet<>();
        for (String d : deadends) {
            deadEndSet.add(d);
        }
        q.offer("0000");
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                // 종료 조건.
                if (deadEndSet.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                visited.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                    }
                }
            }
            step++;

        }

        return -1;
    }

    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] ='0';
        ch[j]++;
        return new String(ch);
    }

    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        ch[j]--;
        return new String(ch);
    }




}
