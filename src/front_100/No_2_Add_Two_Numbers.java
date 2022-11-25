package front_100;

import java.util.List;

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

class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 该题本质上就是大数相加的变种，学习如何利用t表示个位数和进位
         */
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) { //这里不能&& 如果用&& 如果还有进位就丢失了，要使用或
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next; //写到里面，不为空的时候再访问next
            }
            ;
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next; //写到里面，不为空的时候再访问next
            }
            curr.next = new ListNode(t % 10);
            curr = curr.next;
            t = t / 10;
        }
        return res.next;
    }
}

public class No_2_Add_Two_Numbers {
    public static void main(String[] args) {
        Solution_2 s2 = new Solution_2();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = s2.addTwoNumbers(l1, l2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
