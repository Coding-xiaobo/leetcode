package leetcode_21_30;

class Solution_28 {
    public int strStr(String s, String p) {
        if(p.isEmpty()) return 0;
        int n = p.length(), m = s.length();
        //字符串的下标从1开始计算
        p = " " + p;
        s = " " + s;
        //初始化next数组
        int[] ne = new int[n + 1];
        //计算next数组（）在模式串上进行即可
        for(int i = 2, j = 0; i <= n; i++) {
            while(j > 0 && p.charAt(i) != p.charAt(j + 1)) {
                j = ne[j];
            }
            if(p.charAt(i) == p.charAt(j + 1)) j++;
            ne[i] = j;
        }
        //匹配
        for(int i = 1, j = 0; i <= m; i++) {
            while(j > 0 && s.charAt(i) != p.charAt(j + 1)) {
                j = ne[j];
            }
            if(s.charAt(i) == p.charAt(j + 1)) j++;
            if(j == n) return i - j;
        }
        return -1;
    }
}
public class lc_28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static void main(String[] args) {
        String p = "sad";
        String s = "sadbutsad";
        System.out.println(new Solution_28().strStr(p, s));
    }
}
