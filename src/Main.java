import java.util.*;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//
//        char a = '?';
//        short b = (short) a;
//        System.out.println(b);

//        method(5);
//        System.out.println(method(5));
//        MaoPao();
//        xuanZe();
//        erFen();
            test();




    }

    public static void test01(){

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("123",123);
        hashMap.put("147",147);
        hashMap.put("321",321);
        hashMap.put("258",258);

        Set<String> keySet = hashMap.keySet();
        for (String key :
             keySet) {
            Integer value = hashMap.get(key);
            System.out.println(key + "---" + value);

        }

        System.out.println("----------------------");

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<String,Integer> entry:
        entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();

        }






    }


    public static int method(int num) {
        if (num == 1) {
            return 1;

        } else {
            return method(num - 1) * num;
        }


    }


    public static void MaoPao() {
        int[] is = {66, 98, 65, 14, 6, 7};
        for (int i = 0; i < is.length - 1; i++) {
            for (int j = 0; j < is.length - 1 - i; j++) {
                if (is[j] > is[j + 1]) {
                    int temp = is[j];
                    is[j] = is[j + 1];
                    is[j + 1] = temp;
                }
            }
            System.out.println(is[i]);
        }
        System.out.println(Arrays.toString(is));

    }


    public static void erFen() {
        int[] is = {66, 98, 65, 14, 6, 7};
        int num = 65;
        boolean bool = false;
        int start = 0;
        int end = is.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num > is[mid]) {
                start = mid + 1;
            } else if (num < is[mid]) {
                end = mid - 1;
            } else {
                bool = true;
                break;
            }
        }
        if(bool){
            System.out.println("找到了");
        }else {
            System.out.println("没有找到");
        }

    }

    public static void test(){

        HashSet<String> hashSet = new HashSet<>();

//        for (String str:
//             hashSet) {
//            System.out.println(str);
//        }

        hashSet.add("154");
        hashSet.add("45");
        hashSet.add("54884");
        hashSet.add("445");


        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);

        }


    }









}