package leetcode_1_10;

class Solution_7 {
    public int reverse(int x) {
        /**
         * lc 7 整数反转
         * 思路就是把每一位抠出来，
         * 先%10把最后一位抠出来，再/10
         * 最后计算结果是先*10再加上抠出来的最后一位
         */
        int res = 0;
        while(x != 0) {
            /**
             * 注意这段代码可能溢出的情况 res = res * 10 + t
             * 分res是整数还是负数两种情况
             *      正数时：res * 10 + t > Integer.MAX_VALUE
             *      负数时：res * 10 + t < Integer.MIN_VALUE
             * 然后移项之后继续判断
             */
            if(res > 0 && res > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            if(res < 0 && res < (Integer.MIN_VALUE - x % 10) / 10) return 0;
            int t = x % 10;
            x = x / 10;
            res = res * 10 + t;
        }
        return res;
    }
}
public class No_7_Reverse_Integer {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(new Solution_7().reverse(x));
    }
}
