package Greedy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

 注意：

 你可以假设胃口值为正。
 一个小朋友最多只能拥有一块饼干。

 示例 1:

 输入: [1,2,3], [1,1]

 输出: 1

 解释:
 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 所以你应该输出1。
 */
public class AssignCookies {
        public int findContentChildren ( int[] g, int[] s){

            Arrays.sort(g);
            Arrays.sort(s);

            int gi = g.length - 1, si = s.length - 1;
            int res = 0;
            while (gi >= 0 && si >= 0) {
                if (s[si] >= g[gi]) {
                    res++;
                    si--;
                }
                gi--;
            }

            return res;
        }
    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int i = 0,j = 0;
        int len1 = ss.length;
        int len2 = tt.length;

       while (j<len2&&i<len1){
           if(ss[i] == tt[j]){
               i++;
               j++;
           }else {
               j++;
           }

       }
       return i==len1-1;
    }


}

