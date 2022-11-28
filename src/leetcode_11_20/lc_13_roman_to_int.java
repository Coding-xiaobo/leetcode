package leetcode_11_20;

import java.util.HashMap;
import java.util.Map;
class Solution_13 {
    public int romanToInt(String s) {
        /**
         * 和12题返回来，要看每一个字母对应阿拉伯数字是多少
         * 只有4和9代表的是负数，其他的都是相加就是结果 4和9要减掉
         * 前面一个字母要是比后面一个字母小，就要减去
         */
        Map<Character, Integer> hash = new HashMap<>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);

        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && hash.get(s.charAt(i)) < hash.get(s.charAt(i + 1)))
                res -= hash.get(s.charAt(i));
            else
                res += hash.get(s.charAt(i));
        }
        return res;
    }
}
public class lc_13_roman_to_int {
    public static void main(String[] args) {
        String s = "III";
        System.out.println(new Solution_13().romanToInt(s));
    }
}
