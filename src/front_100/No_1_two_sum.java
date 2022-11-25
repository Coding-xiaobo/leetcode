package front_100;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
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
