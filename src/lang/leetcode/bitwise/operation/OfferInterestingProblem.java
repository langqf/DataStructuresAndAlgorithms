package lang.leetcode.bitwise.operation;

/** 连续n个数的和
 * 求 1 2 ... n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class OfferInterestingProblem {
    public static void main(String[] args) {

        System.out.println(sumNums(10));

    }

    public static int sumNums(int n){
        boolean b = n > 0 && (n += sumNums(n-1)) > 0;
        return n;
    }


    // 常规操作
    public static int sumNums1(int n){
        if(n > 0){
            n += sumNums1(n-1);
            return n;
        }else {
            return 0;
        }
    }
}
