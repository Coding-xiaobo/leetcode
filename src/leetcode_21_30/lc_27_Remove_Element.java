package leetcode_21_30;

class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
public class lc_27_Remove_Element {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(new Solution_27().removeElement(nums, val));
    }
}
