package Arrays.三路快排;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，
 * 使 num1 成为一个有序数组。
 */
public class mergeSortedNum {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        m = m-1;
        n = n-1;
        while(m>=0&&n>=0){
            //从后往前 每次将两个数组中较大的数放在最后
            nums1[p--] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }
        //如果nums2中还有值时
        while(n>=0){
            //最后将nums2中剩余的值放入
            nums1[p--]=nums2[n--];
        }
    }
}
