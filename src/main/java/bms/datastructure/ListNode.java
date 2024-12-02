package bms.datastructure;

import bms.algorithm.AddTwoNumbers;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {

        public int val;
        public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

    // 일부만 반전시키기
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode reverseN(ListNode head, int n) {
        ListNode successor = null;
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode reverseKGroup(ListNode head, int k) {

        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }

        // 앞 k개 요소 반전
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;

    }

    ListNode reverse(ListNode head, boolean isInduced) {

        ListNode pre, cur, next;
        cur = head; pre = null; next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;


    }

    ListNode reverse(ListNode a, ListNode b) {

        ListNode pre, cur, next;
        cur = a; pre = null; next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;


    }

}
