package 高频面试;

import javafx.util.Pair;

import java.util.*;

public class 两数之和 {

    //8,19,-7,92,26,81,99,107

    public static List<List> numBytwo(int[] arr,int sum){

        List<List> res = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(sum-arr[i])&&i<map.get(sum-arr[i])){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(map.get(sum-arr[i]));
                res.add(temp);
                Queue<Integer> queue = new LinkedList<>();

            }
        }
        return res;

    }
    
//    public static List<List> numBytwo1(int[] arr,int sum){
//        List<List> res = new ArrayList<>();
//        TreeMap<Integer,Integer> map = new TreeMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            if(!map.containsKey(arr[i])){
//                map.put(arr[i],1);
//            }else {
//                map.put(arr[i],map.get(arr[i])+1);
//            }
//        }
//        for (int i = 0; i < ; i++) {
//
//        }
//
//
//    }

    public static void main(String[] args) {
        int[] arr = {8,19,-7,92,26,81,99,107};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> a:map.entrySet()){

            if(a.getValue()>1){
                count+=a.getValue();
            }

        }
        System.out.println(numBytwo(arr,100));
    }
}
