package leetcode_1_10;

class Solution_8 {
    public int myAtoi(String s) {
        //1. 去掉前导空格
        int k = 0;
        while (k < s.length() && s.charAt(k) == ' ') k++;
        if (k == s.length()) return 0;
        //2. 判断正负号
        int minus = 1;
        if (s.charAt(k) == '-') {
            minus = -1;
            k++;
        } else if (s.charAt(k) == '+') {
            k++;
        }
        //3. 判断0~9
        int num = 0;
        while(k < s.length()) {
            if(s.charAt((k)) < '0' || s.charAt(k) > '9') break;
            int digit = s.charAt(k) - '0';
            //判断是否越界 注意这里逻辑是先判断正数还是负数
            if(minus == 1 && num > ((Integer.MAX_VALUE - digit) / 10)) return Integer.MAX_VALUE;
            if(minus == -1 && -num < (Integer.MIN_VALUE + digit) / 10) return Integer.MIN_VALUE;
            num = num * 10 + digit;
            k++;
        }
        return minus == 1 ? num : -num;
    }
}
public class No_8_String_to_Integer {
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(new Solution_8().myAtoi(s));
    }
}
