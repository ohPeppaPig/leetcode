package Greedy;

/**
 * 定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

 */
public class 跳跃游戏 {

    // 我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置

    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        int achieve = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<=achieve){
                achieve = Math.max(achieve,nums[i]+i);
            }
            if(achieve>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
