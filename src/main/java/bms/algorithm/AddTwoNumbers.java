package bms.algorithm;

import bms.datastructure.ListNode;

public class AddTwoNumbers {

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int fValue = 0;
            if (l1 != null) fValue += l1.val;
            if (l2 != null) fValue += l2.val;

            ListNode listNode = new ListNode(fValue);

            boolean override = false;
            while (l1 != null || l2 != null) {
                int value = 0;
                if (override) {
                    value = 1;
                    override = false;
                }
                if (l1 != null && l2 != null) {
                    value += l1.val + l2.val;
                } else if (l1 != null) {
                    value += l1.val;
                } else if (l2 != null) {
                    value += l2.val;
                }
                if (value > 9) {
                    override = true;
                    value -= 10;
                }
                listNode.next = new ListNode(value);
                if (l1 != null && l1.next != null) l1 = l1.next;
                else l1 = null;
                if (l2 != null && l2.next != null) l2 = l2.next;
                else l2 = null;
            }
            return listNode;
        }
    }

    public static void main(String[] args) {


        int[] testnum = new int[]{2,7,11,15};
        int testTarget = 9;

       // int[] ans = solution.addTwoNumbers(testnum, testTarget);

//        System.out.println(Arrays.toString(ans));
    }
}
