package 高频面试;


/**
 * 饿汉模式
 * 线程安全，无延迟加载
 */
class singleton1{
    private static singleton1 singleton1 = new singleton1();
    private singleton1(){}
    public static singleton1 getInstance(){
        return singleton1;
    }
}

/**
 * 懒汉模式
 * 懒加载
 */
class singleton2{
    private static singleton2 singleton2 = null;
    private singleton2(){}
    public static singleton2 getInstance(){
        if(singleton2 == null){
            return new singleton2();
        }
        return singleton2;
    }
}

/**
 * 双重检测锁
 */
class DCL{
    // 指令重排会造成空指针异常
    private volatile static DCL singleton;
    private DCL(){}
    public static DCL getInstance(){
        if(singleton == null){
            synchronized (DCL.class){
                // 在加一层判空
                if(singleton == null){
                    singleton =new DCL();
                }
            }
        }
        return singleton;
    }

}

/**
 *  静态内部类
 */

class inner{
    private inner(){}
    private static class holder{
        private static inner instance = new inner();
    }
    public static inner getInstance(){
        return holder.instance;
    }
}

public class 手写单例 {


}
