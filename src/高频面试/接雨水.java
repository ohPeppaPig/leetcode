package 高频面试;

import java.util.Stack;

public class 接雨水 {

    public int trap1(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
    public int trap(int[] height) {
        if(height == null){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty()&&height[stack.peek()]<height[i]){
                int pop = stack.pop();
                if(stack.empty()){
                    break;
                }
                //长：（i，peek()中的最小值  -  pop）
                //宽：（i-peek-1）
                res += (i-stack.peek()-1)*(Math.min(height[i],height[stack.peek()])-height[pop]);
            }
            stack.push(i);
        }
        return res;
    }
}
