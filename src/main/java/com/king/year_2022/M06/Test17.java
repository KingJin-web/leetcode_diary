
import java.util.*;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test17
 * @date: 2022��06��17�� 21:12
 * @description: ${}
 */
public class Test17 {
    public void duplicateZeros(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        for (int j : arr) {
            if (j == 0) dq.add(0);
            dq.add(j);
        }
        for (int i = 0 ; i < n ; i++){
            arr[i] = dq.pollFirst();
        }
    }

    public static void main(String[] args) {
//        Map<String, String> aa = new HashMap<>();
//        aa.put("���","Hello World");
//        System.out.println(aa);
        String H = "Hello World! ������磡";
        byte[] bytes = H.getBytes();
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));
//        Map<String, String>[] a = new HashMap[6];
//        for (int i = 0;i<a.length;++i){
//            a[i] = new HashMap<>();
//            a[i].put("1","2");
//            a[i].put("2","2");
//            a[i].put("3","2");
//            a[i].put("���","Hello World");
//        }
//        System.out.println(Arrays.toString(a));

    }
}