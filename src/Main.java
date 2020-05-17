

public class Main {
    //测试分支
   public int strToInt(String str){
       char[] ch = str.toCharArray();
       // 去空格
       int index = 0;
       while (index<ch.length&&ch[index] == ' '){
           index++;
       }
       // 符号判断
       int flag = 1;
       if(ch[index] == '-'){
           flag = -1;
           index++;
       }else  if(ch[index] == '+'){
           index++;
       }else if(!Character.isDigit(ch[index])){
           return 0;
       }
       int res = 0;
       while (index<ch.length&&Character.isDigit(ch[index])){
           int digit = ch[index]-'0';
           // 溢出判断
           if(res>(Integer.MAX_VALUE-digit)/10){
               return flag == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
           }
           res = res*10+digit;
           index++;
       }
       return flag == 1?res:-res;

   }



   //大数相加
    public String bigNum(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int idx1 = ch1.length-1;
        int idx2 = ch2.length-1;
        // 进位
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        while (idx1>=0&&idx2>=0){
            int sum = ch1[idx1]-'0'+ch2[idx2]-'0';
            sum = carry?sum+1:sum;
            carry = sum>=10?true:false;
            sb.append((char)(sum%10+'0'));
            idx1--;
            idx2--;
        }
        //处理多余的数
        while (carry||idx1>=0||idx2>=0){
            if(idx1>=0){
                int sum = ch1[idx1]-'0'+ (carry?1:0);
                // 判断进位
                carry = sum>=10?true:false;
                sb.append((char)(sum%10+'0'));
                idx1--;
            }else if(idx2>=0){
                int sum = ch1[idx2]-'0'+ (carry?1:0);
                // 判断进位
                carry = sum>=10?true:false;
                sb.append((char)(sum%10+'0'));
                idx2--;
            }else {
                sb.append('1');
                carry = false;
            }
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.strToInt("  -123"));
    }
}