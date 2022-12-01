package leetcode_21_30;

import java.util.ArrayList;
import java.util.List;

class Solution_22 {
    static List<String> ans = new ArrayList<>();
    void dfs(int n, int lc, int rc, String seq) {
        /**
         * 左括号只要有，就可以一直填
         * 右括号有，并且任意前缀中左括号的数量大于右括号的数量，就可以填右括号
         * 通法：
         *      （1）任意前缀 左括号的数量大于等于右括号的数量
         *      （2）左右括号的数量相等
         */
        if(lc == n && rc == n) ans.add(seq);
        else {
            if(lc < n) dfs(n, lc + 1, rc, seq + '(');
            if(rc < n && lc > rc) dfs(n, lc, rc + 1, seq + ')');
        }
    }
    public List<String> generateParenthesis(int n) {
        ans.clear();
        dfs(n, 0, 0, "");
        return ans;
    }
}
public class lc_22_Generate_Parentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new Solution_22().generateParenthesis(n);
        for(String s : ans) {
            System.out.print(s + " ");
        }
    }
}
