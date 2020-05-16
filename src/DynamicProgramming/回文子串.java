package DynamicProgramming;

public class 回文子串 {
    int count = 0;
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            maxLen(ch,i,i);
            maxLen(ch,i,i+1);

        }
        return count;

    }

    private void maxLen(char[] ch, int i, int j) {

        while (i>=0&&j<=ch.length-1&&ch[i]==ch[j]){
            count++;
            i--;
            j++;
        }

    }

}
