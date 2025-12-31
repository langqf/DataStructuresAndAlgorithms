package lang.kv;

import java.util.*;

// HashMap的遍历
public class HashMapTraversal {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");map.put(2, "two");map.put(3, "three");map.put(4, "four");
        map.put(5, "five");map.put(6, "six");map.put(7, "seven");map.put(8, "eight");
        map.put(9, "nine");map.put(10, "ten");
        System.out.println("===========lambda表达 分割线===========");
        // lambda表达 map.forEach((k, v) -> {})  现代推荐写法。代码简洁，底层基于entrySet，性能与它相当
        map.forEach((k, v) -> {
            System.out.println("k:" + k + " v:" + v);
        });
        System.out.println("===========map.entrySet() 分割线===========");

        // 经典高效写法 性能稳定 for (Map.Entry<K, V> entry : map.entrySet())
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println("k:" + entry.getKey() + " v:" + entry.getValue());
        }
        System.out.println("===========iterator 分割线===========");
        // map.entrySet().iterator 与for-each entrySet性能等价 但能在遍历时安全地使用iterator.remove()删除元素
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("k:" + entry.getKey() + " v:" + entry.getValue());
        }
        System.out.println("===========map.keySet(),map.values()  分割线===========");
        // map.keySet(), map.values() 只需要k或只需要v时使用
        for (Integer k: map.keySet()) {
            System.out.println("k:" + k );
        }
        for (String v: map.values()) {
            System.out.println("v:" + v );
        }
        System.out.println("===========Stream API分割线===========");
        // 单线程下有一定开销，需要进行复杂操作（如过滤、转换，映射等复杂链式操作）才考虑使用 Stream API
        map.entrySet().stream().forEach((entry) -> {
            System.out.println("k:" + entry.getKey() + " v:" + entry.getValue());
        });
        System.out.println("===========Parallel Stream API分割线===========");
        // 并行遍历，仅在数据量极大且可并行化处理的任务中有优势，通常有额外开销
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println("k:" + entry.getKey() + " v:" + entry.getValue());
        });

    }
}
