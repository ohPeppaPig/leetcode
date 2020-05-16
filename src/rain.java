public class rain {
    /**
     *  def trap(self, height: List[int]) -> int:
     n=len(height)
     left,right=0,n-1
     SUM,tmp,high=0,0,1
     while(left<=right):
     while(left<=right and height[left]<high):
     SUM+=height[left]
     left+=1
     while(right>=left and height[right]<high):
     SUM+=height[right]
     right-=1
     high+=1
     tmp+=right-left+1
     return tmp-SUM
     */
    public int trap(int[] height) {
        int len = height.length;
        int left = 0,right = len-1;
        int sum = 0,tep = 0,high = 1;
        while (left<=right){
            while (left<=right&&height[left]<high){
                sum +=height[left];
                left++;
            }
            while(left<=right&&height[right]<high){
                sum+=height[right];
                right--;
            }
            high++;
            tep += right-left+1;
        }
        return tep-sum;
    }
}
