package 高频面试;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// class PrintABCUsingLock {
//    private int times;
//    private int state;
//    private Lock lock = new ReentrantLock();
//
//    public PrintABCUsingLock(int times) {
//        this.times = times;
//    }
//
//    public static void main(String[] args) {
//        PrintABCUsingLock printABC = new PrintABCUsingLock(10);
//        new Thread(printABC::printA).start();
//        new Thread(printABC::printB).start();
//        new Thread(printABC::printC).start();
//    }
//
//    public void printA() {
//        print("A", 0);
//    }
//
//    public void printB() {
//        print("B", 1);
//    }
//
//    public void printC() {
//        print("C", 2);
//    }
//
//    private void print(String name, int targetState) {
//        for (int i = 0; i < times;) {
//            lock.lock();
//            if (state % 3 == targetState) {
//                state++;
//                i++;
//                System.out.print(name);
//            }
//            lock.unlock();
//        }
//    }
//}



public class 多线程顺序打印 {
    private static int num = 0;
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        fixedThreadPool.submit(new Task("A",0));
        fixedThreadPool.submit(new Task("B",1));
        fixedThreadPool.submit(new Task("C",2));
        fixedThreadPool.shutdown();

//        Thread a = new Thread(new Task("A",0));
//        Thread b = new Thread(new Task("B",1));
//        Thread c = new Thread(new Task("C",2));
//        a.start();
//        b.start();
//        c.start();
    }


    static class Task implements Runnable{
    private String name;
    private int id;

    public Task(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {
        int i = 0;
        while(i<10){
            synchronized (Task.class){
                if(num%3 == id){
                    System.out.println(name);
                    num++;
                }else {
                    continue;
                }
            }
            i++;
        }

    }
}

}
