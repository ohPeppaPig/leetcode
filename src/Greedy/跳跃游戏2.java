package Greedy;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 示例:

 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

 */
public class 跳跃游戏2 {
    public int jump(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // end 作为边界
        int end = 0;
        // 到达的最远
        int achieve = 0;
        // 步数
        int count = 0;
        // 防止刚好跳到末尾，count++
        for (int i = 0; i < nums.length-1; i++) {
            // 更新最大的边界
            achieve = Math.max(achieve,nums[i]+i);
            if(i == end){
                end = achieve;
                count++;
            }
        }
        return count;
    }
}
