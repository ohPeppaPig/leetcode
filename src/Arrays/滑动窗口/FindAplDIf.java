package Arrays.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：

 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。
 示例 1:

 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]

 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 */
public class FindAplDIf {
    /**
     * 滑动固定窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

            List<Integer> res = new ArrayList<>();
            // 边界条件要注意
            if(s.length()<=0 || s.length()<p.length()){
                return res;

            }
            int[] ss = new int[26];
            int[] pp = new int[26];

            int l = 0,r = -1;
            char[] p1 = p.toCharArray();
            char[] s1 = s.toCharArray();
            //初始化
            for(int i = 0;i<p1.length;i++){
                pp[p1[i] - 'a' ]++;
                ss[s1[++r] - 'a']++;
            }
            if(Arrays.equals(pp,ss)){
                res.add(l);
            }
            // 固定滑动窗口
            while (r+1<s.length()){
                ss[s1[++r] - 'a']++;
                ss[s1[l++] - 'a']--;
                if(Arrays.equals(pp,ss)){
                    res.add(l);
                }
            }
            return res;
        }

    /**
     * 蛮力法
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if (slen < plen)
            return list;
        for(int i=0;i<=slen-plen;i++) {
            int[] num = new int[26];
            for(int j=0;j<plen;j++) {
                num[s.charAt(i+j)-'a']++;
                num[p.charAt(j)-'a']--;
            }
            boolean flag = true;
            for(int j=0;j<num.length;j++) {
                if(num[j]!=0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(i);
            }


        }
        return list;
    }
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {1,2};
        System.out.println(Arrays.equals(a,b));
    }
}
