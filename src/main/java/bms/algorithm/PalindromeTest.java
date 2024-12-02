package bms.algorithm;

import bms.datastructure.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PalindromeTest {


    @Test
    public void checkCase() {
        int x = 10000;
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            int y = x % 10;
            x /= 10;
            digits.add(y);
        }
        for (int i = 0; i < digits.size() / 2; i++) {
            if (digits.get(i) == digits.get(digits.size() - i - 1)) {
                continue;
            } else
                break;
        }

    }

    public boolean isPalindrome(ListNode head) {



        ListNode slow, fast;

        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right, left;
        right = ListNode.reverse(slow);
        left = head;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


}
