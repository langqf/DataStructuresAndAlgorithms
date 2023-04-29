package lang.leetcode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/** 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 *
 */
public class Offer40 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3,2,1}, 2)));
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0,1,2,1}, 1)));
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4)));
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{40,0,0,2,0,5}, 0)));
    }

    // 方法二 参考源码 PriorityQueue（默认是最小堆）建一个最大堆 或者 TODO 自建堆
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] arrK = new int[k];
        if(k == 0){
            return arrK;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(heap.peek() > arr[i]){
                heap.poll();
                heap.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            arrK[i] = heap.poll();
        }
        return arrK;
    }
    // 方法一、先排序
    public static int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] arrK = new int[k];
        for (int i = 0; i < k; i++) {
            arrK[i] = arr[i];
        }
        return arrK;
    }

}
