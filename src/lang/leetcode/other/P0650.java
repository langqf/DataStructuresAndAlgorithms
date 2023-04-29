package lang.leetcode.other;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/** 只有两个键的键盘
 *  最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 *
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1：
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 */
public class P0650 {

    public static void main(String[] args) {
        System.out.println(minSteps(1));
        System.out.println(minSteps(2));
        System.out.println(minSteps(3));
        System.out.println(minSteps(4));
        System.out.println(minSteps(5));
        System.out.println(minSteps(6));
        System.out.println(minSteps(100));
        System.out.println(minSteps(45));
    }

    // 动态规划 很难想到
    public static int minSteps(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if(i%j == 0){
                    f[i] = Math.min(f[i], f[j] + i/j);
                    f[i] = Math.min(f[i], f[i/j] + j);
                }
            }
//            System.out.println("f[" + i + "]=" + f[i]);
        }
        return f[n];
    }

     /**
      * 如果是奇数，不可能存在复制全部（大于一个A）的操作，因为复制全部，粘贴之后得到的是一个偶数
      * 3+3+3 = 9不行吗？ AAAAAAAAA 以上结论错误
      * 为什么9可以复制全部，3、5、7不可以呢？ 是不是因为后者是质数？
      * 3和9是什么关系呢？ 3是9的除本身外最大因数,那是不是在达到3时复制全部最快，操作次数最少呢？
      * 看看100 100 = 2 * 2 * 5 * 5  除本身外最大因数是50  50除本身外最大因数是 25  25的除本身外最大因数是5  5是质数
      * 达到100最快是哪种方案呢？
      * 一、100 = 50 *2  50 = 10*5 10 = 5*2  5 = 5*1
      *  1. 到达5 需要5次
      *  2. 达到10 5+2 = 7
      *  3. 达到50 5+2+1+1+1+1+1 = 12
      *  4. 到达100 12 + 1 + 1 = 14
      * 二、100 = 50 *2  50 = 25*2 25 = 5*5  5 = 5*1
      *  1. 到达5 需要5次
      *  2. 达到25 5+1+1+1+1+1 = 10
      *  3. 达到50 10+1+1 = 12
      *  4. 到达100 12 + 1 + 1 = 14
      *
      *  45 呢  45 = 3 * 3 * 5  15,9,5,3
      *  3 + 1 + 14 = 18 到达3
      *  5 + 1 + 8  = 14 到达5
      *  3 + 1 + 2 + 1 + 4 = 11 达到9
      *  5 + 1 + 2 + 1 + 2 = 11  到达15
      *
      *  77呢  11 * 7
      *  7 + 1 + 10
      *  11 + 1 + 6
      *
      *  非质数：分解质因数 质因数之和
      *  质数：本身
      *  问题转化成 找一个数的质因子，如果是质数，返回本身，否则返回质因子的和
      *
      *
      *
      * */
     public static int minSteps1(int n) {
         int sum = 0;
         for (int i = 2; i <= n; i++) {
             while(n % i == 0){
                 sum += i;
                 n = n/i;
             }
         }
        return sum;
    }
}
