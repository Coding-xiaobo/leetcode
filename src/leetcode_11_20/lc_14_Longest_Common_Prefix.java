package leetcode_11_20;

class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        /**
         * 两重循环即可 第一重枚举第几个字符 第二重循环枚举所有的字符串
         */
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) return sb.toString();

        //第一重循环遍历字符数
        for(int i = 0; ; i++) {
            if(i >= strs[0].length()) return sb.toString();
            char c = strs[0].charAt(i);
            //第二重循环遍历所有的字符串
            for(String str: strs) {
                if(str.length() <= i || str.charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }
    }
}
public class lc_14_Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Solution_14().longestCommonPrefix(strs));
    }
}
