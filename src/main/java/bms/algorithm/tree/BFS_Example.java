package bms.algorithm.tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS_Example {

    class Node {
        int val = 0;
        Node leftNode = new Node();
        Node rightNode = new Node();
    }

    int BFS(Node start, Node target) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur == target) {
                return step;
            }
            // 인접노드 방문 여부 확인
            if (!visited.contains(cur.leftNode)) {
                queue.offer(cur.leftNode);
                visited.add(cur.leftNode);
            }

            if (!visited.contains(cur.rightNode)) {
                queue.offer(cur.rightNode);
                visited.add(cur.rightNode);
            }
            step++;
        }
        return step;
    }

}
