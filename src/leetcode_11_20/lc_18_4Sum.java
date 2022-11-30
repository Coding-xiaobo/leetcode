package leetcode_11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                for(int k = j + 1, l = nums.length - 1; k < l; k++) {
                    if(k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while(k < l - 1 && nums[i] + nums[j] + nums[k] + nums[k - 1] >= target) l--;
                    if(nums[i] + nums[j] + nums[k] + nums[l] == target) ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                }
            }
        }
        return ans;
    }
}
public class lc_18_4Sum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> ans = new Solution_18().fourSum(nums, target);
        for(List<Integer> list : ans) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
