package lang.kv;

public class HashMapAnalyze {
    public static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(tableSizeFor(1));
        System.out.println(tableSizeFor(5));
        System.out.println(tableSizeFor(6));
        System.out.println(tableSizeFor(7));
        System.out.println(tableSizeFor(8));
        System.out.println(tableSizeFor(9));

    }
    // 计算数组大小，保持数组大小为2的n次幂
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
