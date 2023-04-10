package lang.leetcode.string;

import java.util.Arrays;

/**
 * 大数打印
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 这道题本身很简单，但是却可以作为很多 中等/困难 题目的基础，比如 超级次方，实现pow(x,n) 等等
 * 示例一：
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 示例二：
 *  * 输入: n = 3
 *  * 输出: [1,2,3,.......,998,999]
 *
 *  1<=n
 */
public class Offer017_PrintNumbers {

    public static void main(String[] args) {
        /*int[]  arr = printNumbers3(2);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }*/
        printNumbers(6);
    }
    // 超出long范围呢 比如n = 10 使用字符数组['0','0','0','0','0','0','0','0','0','0']
    // 每次+1 再输出
    public static void printNumbers(int n) {

        char[] arr = new char[n];
        Arrays.fill(arr,'0');
        boolean isBreak = false;
        while(!isBreak){
            boolean forward = false;
            // 最后一位 +1
            for(int i = n -1; i >= 0; i--){
                int val = arr[i] - '0';
                if(forward || i == n-1){
                    val = val + 1;
                }
                if(val >= 10){
                    forward = true;
                    arr[i] = '0';
                }else{
                    forward = false;
                    arr[i] = (char)(val + '0');
                }
                if(!forward){
                    break;
                }
            }
            if(forward){
                isBreak = true;
            }
            // 打印
            boolean ok = false;
            for (int i = 0; i < n; i++) {
                if(ok || arr[i] != '0'){
                    System.out.print(arr[i]);
                    ok = true;
                }
            }
            System.out.println();
        }

    }

    // 超出long范围呢 比如n = 10
    public static void printNumbers0(int n) {
        //声明字符数组,用来存放一个大数
        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!incrementNumber(number)) {
            saveNumber(number); //存储数值
        }
    }

    public static boolean incrementNumber(char[] number) {
        //循环体退出标识
        boolean isBreak = false;
        //进位标识
        int carryFlag = 0;
        int l = number.length;
        for (int i = l - 1; i >= 0; i--) {
            //取第i位的数字转化位int
            int nSum = number[i] - '0' + carryFlag;
            if (i == l - 1) {
                //最低位加1
                ++nSum;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isBreak = true;
                } else {
                    //进位之后减10，并把进位标识设置为1
                    nSum -= 10;
                    carryFlag = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isBreak;
    }
    public static void saveNumber(char[] number) {
        boolean isBegin0 = true;
        for (char c : number) {
            if (isBegin0 && c != '0') {
                isBegin0 = false;
            }
            if (!isBegin0) {
                // 到这里并没有继续往下实现一个存储数组的版本，是因为原题其实就是要求打印数值。
                // 这道题目在leetcode上被改动成返回int数组的形式，也只是为了测试方便，
                // 本身leetcode并没有提供对应的大数测试样例，也是担心其内存溢出。
                // 总之大家知道本题的考察点所在就可以了。
                System.out.print(c);
            }
        }
        System.out.println();
    }

    // 根据n求出最大的n位数
    // n=1 max=10*0 + 9
    // n=2 max=10*9 + 9
    // n=3 max= 10*(10*9+9)+9
    public static int[] printNumbers3(int n) {
        /*int max = 0;
        for (int i = 0; i < n; i++) {
            max = 10*max + 9;
        }*/
        int max = getMaxByN(n);
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static int getMaxByN(int n){
        if(n == 1){
            return 9;
        }else{
            return 10 * getMaxByN(n-1) + 9;
        }
    }

    // 不使用Math.pow 求出10^n次方
    public static int[] printNumbers2(int n) {
        int max = 1;
        for (int i = 1; i <=n; i++) {
            max *= 10;
        }
        int[] res = new int[max - 1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    // 使用Math.pow 求出10^n次方
    public static int[] printNumbers1(int n) {
        int len = (int) Math.pow(10, n);
        int[] res = new int[len - 1];
        for (int i = 1; i < len; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
