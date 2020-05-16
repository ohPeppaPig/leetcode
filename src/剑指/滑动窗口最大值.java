package 剑指;

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            // 每次加入元素从尾到头判断是否比队列中数大，依次弹出小值，否则添加末尾
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            // 一直到不能移动滑动窗口
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }

    public ArrayList<Integer> maxWindows(int[] arr,int k){
        ArrayList<Integer> res = new ArrayList<>();
        // 双端队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= arr.length - k; i++) {
            // 依次出队
            while (!queue.isEmpty()&&arr[queue.peekLast()]<arr[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            // 判断是否过期
            if(queue.peekFirst() == i-k){
                queue.peekFirst();
            }
            res.add(arr[queue.peekFirst()]);

        }
        return res;

    }
}
