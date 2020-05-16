package Arrays.对撞指针;

/***
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1:

 输入: "hello"
 输出: "holle"
 示例 2:

 输入: "leetcode"
 输出: "leotcede"

 */
public class reverseAEIOU {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l=0, r=arr.length-1;
        while(l<r){
            while(l<r && judge(arr[l])) l++;
            while(l<r && judge(arr[r])) r--;

            char tmp = arr[r];
            arr[r--] = arr[l];
            arr[l++] = tmp;
        }
        // String result = String.valueOf(arr);
        String result = new String(arr);
        return result;
    }
    public boolean judge(char c){
        if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u' && c!='A' && c!='E' && c!='I' && c!='O' && c!='U'){
            return true;
        }else{return false;}
    }

}
