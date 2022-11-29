package leetcode_11_20;

import java.util.Arrays;
import java.util.Map;

class Solution_16 {
    public int threeSumClosest(int[] nums, int target) {
        /**
         * 排序还是要先排序，但是不用考虑重复的情况了，因为要求的是最接近的和，而不是具体的数组
         * 这里二重循环里面两种移动的方式，为了更接近，大了就减小，小了就增加
         * 但是一定要注意等于的情况，等于就直接返回了
         */
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) < Math.abs(res - target)) {
                    res = sum;
                }
                if(sum > target) k--;
                else if(sum < target) j++;
                //一定要考虑sum == target的情况
                else return target;
            }
        }
        return res;
    }
}
public class lc_16__3Sum_Closest {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 2};
        int target = 3;
        System.out.println(new Solution_16().threeSumClosest(arr, target));
    }
}
