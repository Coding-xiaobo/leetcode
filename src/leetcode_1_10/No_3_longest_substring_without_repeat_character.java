package leetcode_1_10;

import java.util.HashMap;
import java.util.Map;

class Solution_3 {
    /**
     * lc 3 最长无重复字串
     * 滑动窗口算法：ij双指针构成滑动窗口 j在前 i在后 ij之间所有的字母用哈希表存
     * 如果重复了，那重复元素一定是j指向的元素，那就往前移动i，直到j指向的元素个数为1，现在窗口中就没有重复的了
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            // 用char类型存，用charAt方法取
            char ch = s.charAt(j);
            // 如果哈希表中没有，先设置为1
            if(!hashmap.containsKey(ch)) hashmap.put(ch, 1);
            else hashmap.put(ch, hashmap.get(ch) + 1);
            while(hashmap.get(ch) > 1) {
                hashmap.put(s.charAt(i), hashmap.get(s.charAt(i)) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
public class No_3_longest_substring_without_repeat_character {
    public static void main(String[] args) {
        Solution_3 s3 = new Solution_3();
        String s = "abcabcbb";
        int res = s3.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
