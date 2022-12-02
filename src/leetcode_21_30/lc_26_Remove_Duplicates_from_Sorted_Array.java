package leetcode_21_30;

class Solution_26 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }
}
public class lc_26_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new Solution_26().removeDuplicates(nums));
    }
}
