package lang.leetcode.other;

/** 镜面反射
 * 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
 * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 *
 * 示例 1：
 * 输入：p = 2, q = 1
 * 输出：2
 * 解释：这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
 *
 * 示例 2：
 * 输入：p = 3, q = 1
 * 输入：1
 *
 * 提示：
 * 1 <= q <= p <= 1000
 *
 */
public class P0858 {
    public static void main(String[] args) {
        System.out.println(mirrorReflection(1,1));
        System.out.println(mirrorReflection(2,1));
        System.out.println(mirrorReflection(3,1));
        System.out.println(mirrorReflection(3,2));
    }

    // 简化问题 光线最终向上走的距离，其实就是 p 和 q 的最小公倍数L
    // L是q的偶数倍，到达西墙2，L是q的奇数倍，到达东墙0或者1 0或者1用count计数分奇偶
    public static int mirrorReflection(int p, int q) {
        int m = p, n = q;
        int r;
        while(n > 0){
            r = m%n;
            m = n;
            n = r;
        }// 循环结束后m是最大公约数
        int k = p/m; // 找到最小的k，使得kq是p的倍数
        int l = q/m; // 找到最小的l，使得lp是q的倍数
        if(k%2 == 0){
            return 2;
        }else if(l%2 == 0){
            return 0;
        }else{
            return 1;
        }
    }
}
