package lang.leetcode.search;

/** 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例 1：
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 *
 * 示例 2：
 * 输入：n = 1, bad = 1
 * 输出：1
 *
 * 提示：
 *
 * 1 <= bad <= n <= 2^31 - 1
 */
public class P0278 {

    public static void main(String[] args) {
//        System.out.println(firstBadVersion(1));// 5 4
        System.out.println(firstBadVersion1(2126753390));// 2126753390 1702766719
    }

    public static int firstBadVersion1(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            if(!isBadVersion(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version) {
        if(version >= 1702766719){
            return true;
        }
        return false;
    }

}
