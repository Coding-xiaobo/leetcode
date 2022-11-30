package leetcode_11_20;

import java.util.Stack;

class Solution_20 {
    public boolean isValid(String s) {
        /**
         * 栈的使用
         * 遇到左括号入栈 如果遇到右括号，弹栈和右括号比较是否匹配
         * 最后一定要判断栈是否为空 可能存在剩余左括号的情况
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '(') stack.push(c);
            else {
                if (stack.size() == 0) return false;
                else {
                    char t = stack.pop();
                    if(t == '{' && c == '}' || t == '[' && c == ']' || t == '(' && c == ')') continue;
                    else return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
public class lc_20_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new Solution_20().isValid(s));
    }
}
