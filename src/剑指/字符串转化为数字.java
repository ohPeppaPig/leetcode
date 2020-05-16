package 剑指;

public class 字符串转化为数字 {
    public String reverseWords(String s) {
        char[] ch = s.trim().toCharArray();
        int i = 0;
        int j = ch.length-1;
        reverse(ch,i,j);
        i = 0;
        j = 0;
        while(j<=ch.length){
            if(j == ch.length||ch[j]==' '){
                reverse(ch,i,j-1);
                i = j + 1;
            }
            j++;
        }
        return new String(ch);


    }
    private void reverse(char[] ch,int i,int j){
        while(i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }

    // 将一个字符串转化为数字
    private static int strToint(String str){
        if(str == null){
            return 0;
        }
        int flag = 1;
        int res = 0;

        char[] ch = str.toCharArray();

        int i = 0;
        while (ch[i]==' '){
            i++;
        }
        if(ch[i] == '-'){
            flag = -1;
        }
        if(ch[i] == '+'||ch[i]=='-'){
            i++;
        }
        while (i<ch.length&&digit(ch[i])){
            int temp = ch[i]-'0';
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&temp>7)){
                return flag>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10+temp;
            i++;
        }
        return flag>0?res:res*(-1);

    }

    private static boolean digit(char ch) {

        if(ch>='0'&&ch<='9'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
