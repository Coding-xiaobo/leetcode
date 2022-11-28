package leetcode_11_20;

class Solution_11 {
    public int maxArea(int[] height) {
        /**
         * 木桶容量由短板决定
         * 移动长板的话, 水面高度不可能再上升, 而宽度变小了, 所以只有通过移动短板, 才有可能使水位上升
         * 脑筋急转弯题目 记住思路即可
         */
        int res = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            //移动短板
            if (height[i] > height[j]) j--;
            else i++;
        }
        return res;
    }
}
public class lc_11_Container_With_Most_Water {
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution_11().maxArea(height));
    }
}
