package 高频面试;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

 示例 1:

 输入:
 "tree"

 输出:
 "eert"

 解释:
 'e'出现两次，'r'和't'都只出现一次。
 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class 按频率排序 {

    public String frequencySort1(String s) {

        //统计词频
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character num : s.toCharArray()) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        //定义大顶堆
        PriorityQueue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        //入大顶堆
        for (Character key : map.keySet()) {
            pq.add(key);
        }
        //组装字符串
        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            Character remove = pq.remove();
            Integer count = map.get(remove);
            while (count > 0) {
                builder.append(remove);
                count--;
            }
        }

        return builder.toString();
    }

    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for(char c :ch){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        // 定义大顶堆（优先队列）
        PriorityQueue<Character> queue = new PriorityQueue<>((v1,v2)->(map.get(v2)-map.get(v1)));
        for (char key :
                map.keySet()) {
            queue.add(key);
        }
        // 组装字符串
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Character remove = queue.remove();
            int count = map.get(remove);
            for (int i = 0; i < count; i++) {
                sb.append(remove);
            }
        }
        return sb.toString();
    }
}
