
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。

 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？

 */
public class demo {

    static class ListNode<T>{
        T val;

        public ListNode(T val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode next;
    }

    public static  <T> void show(T t) {
        System.out.println(t);

    }
    public static void main(String[] args) {
        show("123");
        show(123);






    }
}
