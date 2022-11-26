package leetcode_1_10;

import java.util.ArrayList;
import java.util.List;

class solution_6 {
    public String convert(String s, int numRows) {
        /**
         * lc 6 Z字形变化
         * 主要就是找规律
         * 特别要学习的是这个flag的使用 自己用取余数弄了好久没搞出来
         * StringBuilder的append方法
         */
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder row : rows) ans.append(row);
        return ans.toString();
    }
}
public class No_6_Zigzag_Conversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(new solution_6().convert(s, numRows));
    }
}
