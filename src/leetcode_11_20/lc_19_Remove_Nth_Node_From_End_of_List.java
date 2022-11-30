package leetcode_11_20;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 有可能删除的是头节点，使用虚拟头节点好一些
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy; ListNode slow = dummy;
        while(n != 0 && fast.next != null) {
            fast = fast.next;
            n--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

public class lc_19_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode ans = new Solution_19().removeNthFromEnd(head, n);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
