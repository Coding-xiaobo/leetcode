package leetcode_11_20;

class Solution_12 {
    public String intToRoman(int num) {
        /**
         * 模拟题 把每一位模拟出来 查表看千位 百位 十位 个位 分别是什么 最后在拼起来
         * 实现的时候有一定的技巧
         * 千位一定是M 几千就是几M
         * 百位时 100 400 500 900是没有规律的
         *      技巧是   只要大于等于900就是CM
         *              只要大于等于500 就是D 然后把500减去 剩下的再去对应
         */
        int[] values = {
                1000,
                900, 500, 400, 100,
                90, 50, 40, 10,
                9, 5, 4, 1
        };
        String[] reps = {
                "M",
                "CM","D","CD","C",
                "XC","L","XL","X",
                "IX","V","IV","I"
        };
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 13; i++) {
            while(num >= values[i]) {
                //大于就减掉 剩下的继续判断
                num -= values[i];
                sb.append(reps[i]);
            }
        }
        return sb.toString();
    }
}
public class lc_12_int_to_roman {
    public static void main(String[] args) {
        int x = 3;
        System.out.println(new Solution_12().intToRoman(x));
    }
}
