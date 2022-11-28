package leetcode_1_10;

class Solution_9 {
    public boolean isPalindrome(int x) {
        /**
         * 先判断负数 然后利用整数反转的思想
         */
        if(x < 0) return false;
        int temp = x;
        int res = 0;
        while(x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res == temp;
    }
}
public class No_9_Palindrome_Number {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(new Solution_9().isPalindrome(x));
    }
}
