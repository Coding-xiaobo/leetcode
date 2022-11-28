package leetcode_1_10;

class Solution_5 {
    public String longestPalindrome(String s) {
        /**
         * lc 5 最长回文字串
         * 中心扩散法 分奇数偶数情况
         * substring方法是截取的坐标，注意第二个参数的含义
         */
        int n = s.length();
        String res = "";
        for(int i = 0; i < n; i++) {
            //奇数情况
            int l = i - 1, r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            // l 和 r都是多走了一位，要回到原来的位置上
            if(res.length() < r - l - 1) res = s.substring(l + 1, r + 1 - 1); //左闭右开
            //偶数情况
            l = i; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if(res.length() < r - l - 1) res = s.substring(l + 1, r);
        }
        return res;
    }
}
public class No_5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "babad";
        String res = new Solution_5().longestPalindrome(s);
        System.out.println(res);
    }
}
