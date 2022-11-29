package leetcode_11_20;

import java.util.ArrayList;
import java.util.List;

class Solution_17 {
    static List<String> res = new ArrayList<>();
    //每个数字到字母的映射
    static String[] str = {
        "", "", "abc", "def",
        "ghi", "jkl","mno",
        "pqrs","tuv","wxyz"
    };
    static void dfs(String digits, int u, String path) {
        //说明已经全部遍历完了，不能继续遍历了
        if(u == digits.length()) res.add(path);
        else {
            //取出第几位
            String curr = str[digits.charAt(u) - '0'];
            //遍历当前这一位可以取那些字符
            for(char c : curr.toCharArray()) {
                dfs(digits, u + 1, path + c);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        //这里记得清理res数组，因为这里res数组是全局变量，LeetCode每次测试用例都不会清空，所以需要自己清理
        res.clear();
        dfs(digits, 0, "");
        return res;
    }
}
public class lc_17_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        String s = "23";
        List<String> strs = new Solution_17().letterCombinations(s);
        for(String str: strs) {
            System.out.print(str + " ");
        }
    }
}
