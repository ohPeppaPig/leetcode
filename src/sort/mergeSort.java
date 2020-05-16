package sort;

public class mergeSort {

//    public int reversePairs(int[] nums) {
//        //corner case
//        if(nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        return mergeSort(nums, 0, nums.length - 1);
//    }
//
//    private int mergeSort(int[] nums, int left, int right) {
//        if(left == right) {
//            return 0;
//        }
//
//        int mid = left + ((right - left) >> 1);
//
//        return mergeSort(nums, left, mid) +
//                mergeSort(nums, mid + 1, right) +
//                merge(nums, left, mid, right);
//    }
//
//    private int merge(int[] nums, int left, int mid, int right) {
//        int p1 = left, lEnd = mid, p2 = mid + 1, rEnd = right;
//        int ans = 0, i = 0;
//        int[] mergeArray = new int[right - left + 1];
//
//        while(p1 <= lEnd && p2 <= rEnd) {
//            ans += nums[p1] > nums[p2] ? rEnd - p2 + 1 : 0;
//            mergeArray[i++] = nums[p1] > nums[p2] ? nums[p1++] : nums[p2++];
//        }
//        while(p1 <= lEnd) {
//            mergeArray[i++] = nums[p1++];
//        }
//        while(p2 <= rEnd) {
//            mergeArray[i++] = nums[p2++];
//        }
//
//        for(int j = 0; j < mergeArray.length; j++) {
//            nums[left + j] = mergeArray[j];
//        }
//
//        return ans;
//    }

    // 逆序数

    public int reversePairs(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        return mergesort(nums,0,nums.length-1);



    }

    private int mergesort(int[] nums, int i, int j) {
        if(i==j){
            return 0;
        }
        int mid = (i+j)>>1;
        int left = mergesort(nums,i,mid);
        int right = mergesort(nums,mid+1,j);
        return merge(nums,i,mid,j)+left+right;

    }

    private int merge(int[] nums, int i, int mid, int j) {
        int l = i,r = mid+1;
        int[] temp = new int[j-i+1];
        int index = 0;
        int res = 0;
        while(l<=mid&&r<=j){
            if(nums[l]>nums[r]){
                temp[index++] = nums[r++];
                res+=mid-l+1;
            }else {
                temp[index++] = nums[l++];
            }
        }
        while(l<=mid){
            temp[index++] = nums[l++];
        }
        while(r<=j){
            temp[index++] = nums[r++];
        }
        for (int k = 0; k < temp.length; k++) {
            nums[i+k] = temp[k];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] res = {1,3,2,3,1};
        System.out.println(new mergeSort().reversePairs(res));
    }
}
