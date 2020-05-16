package Arrays.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubWithoutRepeat {

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 更新左边界 i
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }

    public int lengthOfLongestSubstring2(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;

        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到l == s.size(); r == s.size()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while(l < s.length()){

            if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0)
                freq[s.charAt(++r)] ++;
            else    //r已经到头 || freq[s[r+1]] == 1
                freq[s.charAt(l++)] --;

            res = Math.max(res, r-l+1);
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new LongestSubWithoutRepeat()).lengthOfLongestSubstring1( "abcabcbb" ));
        System.out.println((new LongestSubWithoutRepeat()).lengthOfLongestSubstring1( "bbbbb" ));
        System.out.println((new LongestSubWithoutRepeat()).lengthOfLongestSubstring1( "pwwkew" ));
        System.out.println((new LongestSubWithoutRepeat()).lengthOfLongestSubstring1( "" ));
        System.out.println((new LongestSubWithoutRepeat()).lengthOfLongestSubstring1( "au" ));
    }

    //438  76
}
