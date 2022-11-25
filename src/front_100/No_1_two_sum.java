package front_100;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 哈希表查询的时间复杂度为O(1) 遍历的时间复杂度为O(n) 总时间复杂度为O(n)
         * 总体思路为：和为target，遍历到nums[i]时，如果target-nums[i]已经存在与哈希表中，那就说明已经找到了
         * 学习哈希表 containsKey()方法 get方法 put方法
         * put方法是直接传入key和value
         * 创建数组的方法 new int[]{}
         */
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if(hash.containsKey(find)) {
                return new int[]{hash.get(find), i};
            } else {
                hash.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
public class No_1_two_sum {
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = {2, 7, 10, 9};
        int target = 11;
        int[] res = s.twoSum(nums, target);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
