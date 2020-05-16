package Arrays.三路快排;

import java.util.PriorityQueue;
import java.util.Random;

public class FindKth {
    /**
     * patition 平均复杂度O（Nlogn）
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int targetIndex = len - k;
        int low = 0, high = len - 1;
        while (true) {
            int i = partition(nums, low, high);
            if (i == targetIndex) {
                return nums[i];
            } else if (i < targetIndex) {
                low = i+1;
            } else {
                high = i-1;
            }
        }

    }

    /**
     * 分区函数，将 arr[high] 作为 pivot 分区点
     * i、j 两个指针，i 作为标记“已处理区间”和“未处理区间”的分界点，也即 i 左边的（low~i-1）都是“已处理区”。
     * j 指针遍历数组，当 arr[j] 小于 pivot 时，就把 arr[j] 放到“已处理区间”的尾部，也即是 arr[i] 所在位置
     * 因此 swap(arr, i, j) 然后 i 指针后移，i++
     * 直到 j 遍历到数组末尾 arr[high]，将 arr[i] 和 arr[high]（pivot点） 进行交换，返回下标 i，就是分区点的下标。
     */
    //当数组为有序时  效率较低

    private int partition(int[] arr, int low, int high) {
        if (high > low) {
            //在下标 low 和 high 之间随机选择，然后和下标 high 元素进行交换
            int random = low + new Random().nextInt(high - low);
            swap(arr, high, random);
        }

        int i = low;
        int pivot = arr[high];
        // i 始终指向大于pivot的值 ，j移动，小的话，交换
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 堆排序
     * 时间复杂度 : O(Nlogk)。
       空间复杂度 : O(k)，用于存储堆元素。
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int n : nums){
            minHeap.add(n);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }


    /***
     * 手动建堆
     */
    public int findKthLargest2(int[] nums, int k) {
        //前K个元素原地建小顶堆
        buildHeap(nums, k);
        //遍历剩下元素，比堆顶小，跳过；比堆顶大，交换后重新堆化
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < nums[0]) continue;
            swap(nums, i, 0);
            heapify(nums, k, 0);
        }
        //K个元素的小顶堆的堆顶即是第K大元素
        return nums[0];
    }

    /**
     * 建堆函数
     * 从倒数第一个非叶子节点开始堆化，倒数第一个非叶子节点下标为 K/2-1
     */
    public void buildHeap(int[] a, int k) {
        for (int i = k/2 - 1; i >= 0; i--) {
            heapify(a, k, i);
        }
    }

    /**
     * 堆化函数
     * 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
     */
    public void heapify(int[] a, int k, int i) {
        //临时变量 minPos 用于存储最小值的下标，先假设父节点最小
        int minPos = i;
        while (true) {
            //和左子节点比较
            if (i*2+1 < k && a[i*2+1] < a[i]) minPos = i*2+1;
            //和右子节点比较
            if (i*2+2 < k && a[i*2+2] < a[minPos]) minPos = i*2+2;
            //如果minPos没有发生变化，说明父节点已经是最小了，直接跳出
            if (minPos == i) break;
            //否则交换
            swap(a, i, minPos);
            //父节点下标进行更新，继续堆化
            i = minPos;
        }
    }

//    public void swap1(int[] a, int n, int m) {
//        int tmp = a[n];
//        a[n] = a[m];
//        a[m] = tmp;
//    }


}
