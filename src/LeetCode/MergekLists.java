package LeetCode;

public class MergekLists {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 1)
                return lists[0];
            ListNode[] tlists = new ListNode[lists.length / 2 + 1];
            int l = 0;
            for (int i = 0; i < lists.length; i++) {
                if (i + 1 < lists.length) {
                    tlists[l++] = merge2Lists(lists[i], lists[i + 1]);
                    i++;
                } else tlists[l++] = lists[i];
            }
            return mergeKLists(tlists);
        }

        public ListNode merge2Lists(ListNode node1, ListNode node2) {
            ListNode head = new ListNode(0);
            head.next = null;
            ListNode temp = head;
            while (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    temp.next = node1;
                    node1 = node1.next;
                } else {
                    temp.next = node2;
                    node2 = node2.next;
                }
                temp = temp.next;
            }
            while (node1 != null) {
                temp.next = node1;
                node1 = node1.next;
                temp = temp.next;
            }
            while (node2 != null) {
                temp.next = node2;
                node2 = node2.next;
                temp = temp.next;
            }
            return head.next;
        }
    }
}
