package lang.leetcode.other;

import java.util.Arrays;

/** 灯泡开关
 * 初始时有 n 个灯泡处于关闭状态。
 * 第一轮，你将会打开所有灯泡。
 * 第二轮，你将会每两个灯泡关闭第二个。
 * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。
 * 第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * 找出并返回 n 轮后有多少个亮着的灯泡。

 * 示例 1：
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * 你应该返回 1，因为只有一个灯泡还亮着。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：1
 *
 * 示例 4：
 * 输入：n = 2
 * 输出：1
 *
 * 0 <= n <= 10^9
 *
 */
public class P0319 {

    public static void main(String[] args) {
        System.out.println(bulbSwitch(20));
        System.out.println((int)Math.sqrt(4.0));
    }

    // 直接平方根向下取整
    public static int bulbSwitch(int n) {
        /*int i = 0;
        while(i * i <= n){
            i++;
        }
        return i -1;*/
        return (int) Math.sqrt(n + 0.5);// 防止出现溢出，比如1表示成了0.999999
    }

    /** s[n] 表示n轮后第n个灯泡是否亮 1是 0否
     *  s[n] 的值取决于n约数的数量count，count是奇数还是偶数？ s[n] = (count/2 == 0 ? 0 : 1)
     *  f[n] 表示n轮后亮着的灯泡的总数
     *  f[n] = f[n-1] + s[n]
     *  时间复杂度 n√n
     *  考虑哪些数的约数数量是奇数呢？哪些数的约数数量是偶数呢？
     *  正常情况下，约数都是成对出现的，比如 i*j = n 其中i<= √n j >= √n
     *  出现奇数的情况，是n刚好能开平方的时候，所以
     *  n能开算术平方时 f[n] = f[n-1] + 1 否则 f[n] = f[n-1]
     *  m * m = n 时  n能开算术平方根
     */
    public static int bulbSwitch2(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        int m = 1;
        for (int i = 1; i <= n; i++) {
            if(i < m * m){
                f[i] = f[i-1];
            }else{
                f[i] = f[i-1] + 1;
                m++;
            }
        }
        /*int i = 1;
        while(i <= n){
            if(i < m * m){
                f[i] = f[i-1];
            }else{
                f[i] = f[i-1] + 1;
                m++;
            }
            i++;
        }*/
        System.out.println(Arrays.toString(f));
        return f[n];
    }

    /** s[n] 表示n轮后第n个灯泡是否亮 1是 0否
     *  s[n] 的值取决于n约数的数量count，count是奇数还是偶数？ s[n] = (count/2 == 0 ? 0 : 1)
     *  f[n] 表示n轮后亮着的灯泡的总数
     *  f[n] = f[n-1] + s[n]
     *  时间复杂度 n√n
     *  考虑哪些数的约数数量是奇数呢？哪些数的约数数量是偶数呢？
     *  正常情况下，约数都是成对出现的，比如 i*j = n 其中i<= √n j >= √n
     *  出现奇数的情况，是n刚好能开平方的时候，所以
     *  n能开算术平方时 f[n] = f[n-1] + 1 否则 f[n] = f[n-1]
     */
    public static int bulbSwitch1(int n) {
        int[] s = new int[n+1];
        int[] f = new int[n+1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = (getCount1(i) % 2) == 0 ? 0 : 1;
            f[i] = f[i-1] + s[i];
        }
        System.out.println(Arrays.toString(f));
        return f[n];
    }

    public static int getCount1(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if(n%i == 0){
                if(i * i == n){
                    count += 1;
                }else{
                    count += 2;
                }
            }
        }
        return count;
    }
}
