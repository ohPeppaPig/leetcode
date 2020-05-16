package sort;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {1,4,7,5,2};
//        quickSort(arr,0,arr.length-1);
//        for (int i :
//                arr) {
//            System.out.print(i);
//        }
        quickSortInternal3(arr,0,arr.length-1);
        for (int i :
                arr) {
            System.out.print(i);
        }

    }
    public static void quickSort(int[] arr,int i,int j){
        if(i<j){
          int pivot = patition(arr,i,j);
            quickSort(arr,0,pivot-1);
            quickSort(arr,pivot+1,j);
        }
    }

    private static int patition(int[] arr, int i, int j) {
        int pivot = arr[i];
        while(i<j){
            while (i<j&&arr[j]>=pivot){
                j--;
            }
            arr[i] = arr[j];
            while (i<j&&arr[i]<pivot){
                i++;
            }
            arr[j] = arr[i];

        }
        arr[i] = pivot;
        return i;

    }
    private static void quickSortInternal3(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        // 随机选取待排序数组中的任意⼀一个元素
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, randomIndex);
        int v = arr[l];
        // arr[l+1...lt] < v
        int lt = l;
        // arr[lt+1...i-1] == v
        int i = l + 1;// arr[gt...r] > v
//        int gt = r + 1;
        int gt = r + 1;
        while (i < gt) {
            if (arr[i] < v) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        // 循环⾛走完只需要将l位置的元素与lt交换即为分区点
        swap(arr, l, lt);
        quickSortInternal3(arr, l, lt - 1);
        quickSortInternal3(arr, gt, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
