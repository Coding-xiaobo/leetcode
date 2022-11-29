package leetcode_11_20;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 双指针算法把n^3优化成n^2 j和k一共是n
         */
        //双指针做法一定要有序，所以要先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            //去重
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1, k = nums.length - 1; j < k; j++) {
                //去重
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                //nums[i] + nums[j] + nums[k - 1] >= 0 不断试探 在nums[i] + nums[j] + nums[k - 1] < 0停下来
                //然后nums[i] + nums[j] + nums[k]就有机会等于0了
                while(j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= 0) k--;
                if(nums[i] + nums[j] + nums[k] == 0) res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
        }
        return res;
    }
}
public class lc_15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new Solution_15().threeSum(nums);
        for(List<Integer> list: res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
