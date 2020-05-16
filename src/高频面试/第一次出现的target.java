package 高频面试;

public class 第一次出现的target {
//    int[] array = {1,2,2,2,3,3,5,6,8}, int target =2

    // 左边界
    public static int searchLeft(int[] arr,int k){
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            int mid = (l+r)>>1;
            if(arr[mid] == k){
                r = mid;
            }else if(arr[mid]>k){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;

    }
    // 右边界
    public static int searchRight(int[] arr,int k){
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            //这里注意是 (l+r+1)>>1
            //向右取整
            int mid = (l+r+1)>>1;
            if(arr[mid] == k){
                l = mid;
            }else if(arr[mid]>k){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;

    }

    private static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int len = nums.length-1;
        if(len == 0){
            return res;
        }
        res[0] = left_bound(nums,target);
        res[1] = right_bound(nums,target);
        return res;
    }
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收缩左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收缩右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }



    public static void main(String[] args) {
        int[] arr = {1,3,3};
        System.out.println(searchLeft(arr,3));
    }
}
