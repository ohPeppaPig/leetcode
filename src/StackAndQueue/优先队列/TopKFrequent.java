package StackAndQueue.优先队列;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 */
public class TopKFrequent {
    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        if(k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        // 统计每个元素出现的频率
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i ++)
            if(freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);

        if(k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        // 扫描freq,维护当前出现频率最高的k个元素
        // 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new PairComparator());
//        priorityQueue<Integer,Integer>pq = new priorityQueue()
        for(Integer num: freq.keySet()){
            int numFreq = freq.get(num);
            if(pq.size() == k){
                if(numFreq > pq.peek().getKey()){
                    pq.poll();
                    pq.add(new Pair(numFreq, num));
                }
            }
            else
                pq.add(new Pair(numFreq, num));
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!pq.isEmpty())
            res.add(pq.poll().getValue());

        return res;
    }


    /**
     * k = 1 时问题很简单，线性时间内就可以解决。只需要用哈希表维护元素出现频率，每一步更新最高频元素即可。

     当 k > 1 就需要一个能够根据出现频率快速获取元素的数据结构，这就是优先队列。
     复杂度分析

     时间复杂度：O(N\log(k))O(Nlog(k))。Counter 方法的复杂度是 O(N)O(N)，建堆和输出的复杂度是 O(N \log(k))O(Nlog(k))。因此总复杂度为 O(N + N \log(k)) = O(N \log(k))O(N+Nlog(k))=O(Nlog(k))。
     空间复杂度：O(N)O(N)，存储哈希表的开销。
     注释

     根据复杂度分析，方法对于小 k 的情况是很优的。但是如果 k 值很大，我们可以将算法改成删除频率最低的若干个元素。

     * @param nums
     * @param k
     * @return
     */
        public List<Integer> topKFrequent1(int[] nums, int k) {
            // build hash map : character and how often it appears
            HashMap<Integer, Integer> count = new HashMap();
            for (int n: nums) {
                count.put(n, count.getOrDefault(n, 0) + 1);
            }

            // init HeapSort 'the less frequent element first'
            PriorityQueue<Integer> heap =
                    new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

            // keep k top frequent elements in the HeapSort
            for (int n: count.keySet()) {
                heap.add(n);
                if (heap.size() > k)
                    heap.poll();
            }

            // build output list
            List<Integer> top_k = new LinkedList();
            while (!heap.isEmpty())
                top_k.add(heap.poll());
            Collections.reverse(top_k);
            return top_k;
        }





}
