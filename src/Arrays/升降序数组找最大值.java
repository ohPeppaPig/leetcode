package Arrays;

public class 升降序数组找最大值 {
    public static int findMax(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr[arr.length-1];
        }
        if(arr[0]>arr[1]){
            return arr[0];
        }
        int i = 1,j = arr.length-1;
        while (i<j){

            int mid = (i+j)>>1;
            if(arr[mid]>=arr[mid-1]&&arr[mid]>arr[mid+1]){
                return arr[mid];
            }
            if(arr[mid]>=arr[mid-1]){
                i = mid;
            }else {
                j = mid-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        System.out.println(findMax(arr));
    }

}
