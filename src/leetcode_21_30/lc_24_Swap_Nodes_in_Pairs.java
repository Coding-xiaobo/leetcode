package leetcode_21_30;

class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        //需要三个指针 注意连接的顺序
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null) {
            ListNode a = p.next, b = a.next;
            p.next = b;
            a.next = b.next;
            b.next = a;
            p = a;
        }
        return dummy.next;
    }
}
public class lc_24_Swap_Nodes_in_Pairs {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode ans = new Solution_24().swapPairs(list);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
