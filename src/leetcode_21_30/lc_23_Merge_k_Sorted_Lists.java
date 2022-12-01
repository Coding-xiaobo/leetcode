package leetcode_21_30;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        /**
         * 将合并两个有序链表的思想应用于k个链表
         * 只不过用 堆 去维护k个指针 这样堆顶的元素就是最小值
         * 堆取出堆顶元素的时间复杂度是O(1)
         * 插入堆的时间复杂度是O(logn)
         */

        //重写compare比较函数
        Queue<ListNode> q = new PriorityQueue<>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    //比较
                    return o1.val - o2.val;
                }
            }
        );
        for(ListNode list: lists) {
            if(list != null) {
                q.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!q.isEmpty()) {
            ListNode minNode = q.poll(); //取出堆中最小的
            curr.next = minNode; //连到链表上
            curr = curr.next; // curr后移
            if(minNode.next != null) {
                q.offer(minNode.next); //把更新后的指针插回来
            }
        }
        return dummy.next;
    }
}

public class lc_23_Merge_k_Sorted_Lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[] {l1, l2, l3};
        ListNode ans = new Solution_23().mergeKLists(lists);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
