package 剑指;

import java.util.*;

public class MinStack {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0){
            return false;
        }
        int len = postorder.length-1;
        int root = postorder[len];
        int index = 0;
        int i =0;
        for (; i < len; i++) {
            if(postorder[i]>root){
                break;
            }
        }
        index = i;
        for (; index < len; index++) {
            if(postorder[i]<root){
                return false;
            }
        }
        boolean l = true,r = true;
        if(i>0){
            l = verifyPostorder(Arrays.copyOfRange(postorder,0,i));
        }
        if(index<len){
            r = verifyPostorder(Arrays.copyOfRange(postorder,i,len));
        }
        return l&&r;
    }
    public char firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character,Boolean> map = new HashMap<>();
        for (Character c :
                ch) {
            map.put(c,!map.containsKey(c));
        }
        for (Character c:ch) {
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }
    public int search(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        while (i<=j){
            int mid = (i+j)>>1;
            if(nums[mid]<=target){
                i = mid+1;
            }else {
                j = mid -1;
            }
        }
        int right = i;
         i = 0;
         j = nums.length-1;
         while (i<=j){
             int mid = (i+j)>>1;
             if(nums[mid]<target){
                 i = mid+1;
             }else {
                 j = mid -1;
             }
         }
         int left = j;

         return right - left -1;

    }
    public int missingNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = nums.length-1;
        while (i<=j){
            int mid = (i+j)>>1;
            if(nums[mid] == mid){
                i = mid+1;
            }else{
                j = mid;
            }
        }
        return i;
    }
}
