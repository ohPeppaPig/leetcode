package 高频面试;

import java.util.*;

public class 最大数 {
    public String largestNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int n:nums) {
            numList.add(n);
        }
        Collections.sort(numList, new NumComparator());

        StringBuilder sb = new StringBuilder();
        for (int n :
                numList) {
            sb.append(n);
        }
        String res = sb.toString();
        // 最后需要考虑一下数组元素都为0的情况
        return res.charAt(0) == '0' ? "0" : res;
    }

    class NumComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer n1, Integer n2) {
            String str1 = String.valueOf(n1);
            String str2 = String.valueOf(n2);
            // 长度相等，判断值大小即可
            if(str1.length()==str2.length()) {
                if(n1<n2){
                    return 1;
                }
                else if (n1>n2) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
            int idx=0;
            // 两种形式组合，分别判断各位大小
            String s1 = str1+str2;
            String s2 = str2+str1;
            while(idx < s1.length() || idx < s2.length()) {
                char c1 = s1.charAt(idx);
                char c2 = s2.charAt(idx);
                if(c1 < c2) {
                    return 1;
                } else if(c1 > c2) {
                    return -1;
                } else {
                    idx++;
                }
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        最大数 a = new 最大数();
        System.out.println(a.largestNumber(arr));
    }






}
