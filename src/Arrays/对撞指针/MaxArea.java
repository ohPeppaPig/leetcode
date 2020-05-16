package Arrays.对撞指针;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。

 */
public class MaxArea {
    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    /***
     * 碰撞指针，舍弃短板
     * @param height
     * @return
     */
    public int maxArea1(int[] height){
        int maxarea = 0;
        int i = 0;
        int j = height.length-1;
        while (i<j){
            maxarea = Math.max(maxarea,Math.min(height[i], height[j]) * (j - i));
            if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return maxarea;
    }

}
