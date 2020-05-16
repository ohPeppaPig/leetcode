package 高频面试;


/**
 * T(n) = aT(n/b) + f(n)
 * 其中a为每次递归会分成几个需要计算的下一层，(n/b)为下一层计算的元素个数，f(n)为本层的计算复杂度
   由于是折半查找，所以有：a=1、b=2（平均）、f(n)=n(每次的遍历比较交换)

 T(n) = T(n/2) +n
 =  T(n/4) + n/2 +n
 ……
 = T(1) + 2 + …… + n/2 +n    // T(1)≈1 等比数列求和
 = （1 - n * 2)/(1 - 2)
 = 2n - 1


 */

public class 寻找数组中位数 {

    public static int findMid(int[] num){
        if(num.length == 0){
            return 0;
        }
//        return patition(num,0,num.length-1);
        return Find(num,0,num.length-1);

    }
    public static double getMid(int[] num){
        if(num.length == 0){
            return -1;
        }
        if(num.length%2 == 0){
            return (getByTwo(num,(num.length-1)/2)+getByTwo(num,(num.length)/2))/2;
        }else {
            return getByTwo(num,(num.length-1)/2);
        }
    }

    private static double getByTwo(int[] num,int stop){
        int start = 0;
        int end = num.length-1;
        int p = 0;
        while(start<=end){
            p = patition(num,start,end);
            if(p == stop){
                return num[p];
            }else if(p < stop){
                start = p+1;
            }else {
                end = p-1;
            }
        }
        return -1;
    }

    private static int Find(int[] num, int i, int j) {

        int p = patition(num,i,j);
        if(p == (num.length-1)/2){
            return num[p];
        }else if(p < (num.length-1)/2){
            return Find(num,p+1,j);
        }else {
            return Find(num,i,p-1);
        }
    }


    private static int patition(int[] num, int i, int j) {
        int p = num[i];
        while (i<j){
            while (i<j&&num[j]>=p){
                j--;
            }
            num[i] = num[j];
            while (i<j&&num[i]<p){
                i++;
            }
            num[j] = num[i];

        }
        num[i] = p;

        // 定位
        return i;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(getMid(arr));
    }
}
