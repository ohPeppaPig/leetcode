package Arrays.对撞指针;

/***
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true

 */
public class reverse {
    public boolean isNumAndWord(char a){
        return (a >= '0' && a <= '9') || (a >= 'a' && a <= 'z');
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left<right){
            while(left<right&&!isNumAndWord(chars[left])){
                left++;
            }
            while(left<right&&!isNumAndWord(chars[right])){
                right--;
            }
            if(chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

}
