import java.util.ArrayDeque;
import java.util.HashSet;

public class LRU{
    private int cacheSize;
    private ArrayDeque<Integer> queue = new ArrayDeque<>();
    private HashSet<Integer> hashSet = new HashSet<>();

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    /**
     * 判断缓存队列是否满
     * @return
     */
   private boolean isFull(){
        return cacheSize == queue.size();
   }

    /**
     * 进队列
     * @param pageNum
     */
   private void enqueue(int pageNum){
       if(isFull()){
           hashSet.remove(queue.getLast());
           queue.pollLast();
       }
       queue.addFirst(pageNum);
       hashSet.add(pageNum);
   }

    /**
     * 访问页面
     * @param pageNum
     */
   public void accessPage(int pageNum){
       //不包含页面，直接入队
       if(!hashSet.contains(pageNum)){
           enqueue(pageNum);
           //包含该页面，刷新
       }else if(pageNum!=queue.getFirst()){
           queue.remove(pageNum);
           queue.addFirst(pageNum);
       }
   }

    /**
     * 打印页面
     */
   public void printQueue(){
       while (!queue.isEmpty()){
           System.out.println(queue.pop()+"");
       }
   }

}



