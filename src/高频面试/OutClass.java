package 高频面试;
// 内部类与静态内部类

/**
 * 非静态内部类依赖于外部类的实例，而静态内部类不需要。
 *
 * 静态内部类不能访问外部类的非静态的变量和方法。
 */
public class OutClass {
    static void a(){
        System.out.println("静态方法");
    }
    void b(){
        System.out.println("非静态方法");
    }

    class innerClass{}

    static class staticinnerClass{}

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        innerClass innerClass = outClass.new innerClass();
        staticinnerClass staticinnerClass = new staticinnerClass();
    }


}
