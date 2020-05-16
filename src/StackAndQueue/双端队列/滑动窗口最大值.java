package StackAndQueue.双端队列;

import java.util.LinkedList;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null||nums.length<2){
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            // 最大值是否过期
            if(i-k>=queue.peek()){
                queue.poll();
            }
            if(i-k+1>=0){
                res[i-k+1] = nums[queue.peek()];
            }
        }
        return res;
    }
}
