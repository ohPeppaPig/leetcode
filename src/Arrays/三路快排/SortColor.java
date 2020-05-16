package Arrays.三路快排;

public class SortColor {
    public void sortColors1(int[] nums) {

        int[] count = {0, 0, 0};    // 存放0, 1, 2三个元素的频率
        for(int i = 0 ; i < nums.length ; i ++){
            assert nums[i] >= 0 && nums[i] <= 2;
            count[nums[i]] ++;
        }

        int index = 0;
        for(int i = 0 ; i < count[0] ; i ++)
            nums[index++] = 0;
        for(int i = 0 ; i < count[1] ; i ++)
            nums[index++] = 1;
        for(int i = 0 ; i < count[2] ; i ++)
            nums[index++] = 2;

        // 小练习: 自学编写计数排序算法
    }

    /***
     * 三路快排
     * @param nums
     */
    public void sortColors2(int[] nums) {

        int zero = -1;          // [0...zero] == 0
        int two = nums.length;  // [two...n-1] == 2
        for(int i = 0 ; i < two ; ){
            if(nums[i] == 1)
                i ++;
            else if (nums[i] == 2)
                swap(nums, i, --two);
            else{ // nums[i] == 0
                assert nums[i] == 0;
                swap(nums, ++zero, i++);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }

    //作业：88 215

    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int i = 0;
        // 此处 i 移动
        while(i<=high){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 0){
                swap(nums,i,low);
                // 前面的元素都是排序好的
                low++;i++;
            }else{
                swap(nums,i,high);
                high--;
            }
        }
    }


}
