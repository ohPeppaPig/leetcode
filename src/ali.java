import java.util.HashMap;
import java.util.Map;
//
//public class ali {
    //评测题目: 无
//1.给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//    示例 1:
//    输入:"tree"
//    输出:"eert"
//    解释:'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//    示例 2:
//    输入:"cccaaa"
//    输出:"cccaaa"
//    解释:'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//    示例 3:
//    输入:"Aabb "
//    输出:"bbAa"
//    解释:此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。注意'A'和'a'被认为是两种不同的字符。
//
//
//            2.给定一个字符串，请找出不含重复字符的最长子串。
//    示例 1:
//    输入: "abcabcbb"
//    输出: "abc"
//    解释: 无重复字符的最长子串是 "abc"
//    示例 2:
//    输入: "bbbbb"
//    输出: "b"
//    解释: 无重复字符的最长子串是 “b”
//    示例 3:
//    输入: "pwwkew"
//    输出: "wke"
//    解释: 无重复字符的最长子串是 wke

//1.
//    public String sortByfre(String s){
//        Map<Character , Integer> map = new HashMap<>();
//        char[] ch = s.toCharArrays();
//        // 统计字符出现的频率
//        for(int i = 0;i<ch.length;i++){
//            if(!map.contains(ch[i])){
//                map.put(ch[i],1);
//            }else{
//                map.put(ch[i],map.get(ch[i])+1);
//            }
//        }
//        // 按照对应的出现次数，放入字串数组
//        String[] str = new String[map.size()];
//        int i = 0;
//        for(Entry<Character,Integer> entry:map.entrySet){
//            stringBuilder sb = new stringBuilder();
//            for(int j = 0;j<entry.getValue();j++){
//                sb.append(entry.getkey());
//            }
//            str[i] = sb.toString();
//            i++;
//        }
//        // 长度排序
//        for(int j = 0;j<str.length - 1;j++){
//            for(int k = j+1;k<str.length;k++){
//                if(str[j].length()<str[k].length()){
//                    // 交换
//                    string s = str[j];
//                    str[j] = str[k];
//                    str[k] = s;
//
//
//                }
//            }
//        }
//        // 重新组装返回
//        StringBuilder sb = new StringBuilder();
//        for(int j = 0;j<str.length;j++){
//            sb.append(str[j]);
//        }
//        return sb.tostring;
//
//    }
//
//
//
//2
//    public String longestSub(String s){
//
//        int n = s.length(),ans = 0;
//        // 保留元素的下标
//        int[] index = new int[2];
//        Map<Character,Integer> map = new HashMap<>();
//        for(int j = 0,i = 0;j<n;j++){
//            if(map.containsKey(s.charAt(j))){
//                // 更新左边界
//                i = Math.max(map.get(s.charAt(j)),i);
//            }
//            // 更新无重复最大长度
//            if(ans < j-i+1){
//                ans = j - i + 1;
//                // 保留左右下标
//                int[0] = i;
//                int[1] = j;
//            }
//
//        }
//        a = int[0];
//        b = int[1];
//        return s.substring(a,b+1);
//
//    }
//}
