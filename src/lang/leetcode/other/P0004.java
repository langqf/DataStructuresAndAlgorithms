package lang.leetcode.other;

import java.util.Arrays;

/** 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 */
public class P0004 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,4,4}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{-1,3}));
        System.out.println(findMedianSortedArrays(new int[]{2,2,2}, new int[]{2,2,2,2}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2,3,4}));
        System.out.println(findMedianSortedArrays(new int[]{2,3}, new int[]{12,13,32,35,36,37,38,39}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5,6,7}));
    }
    //TODO 代码写的太乱了，需要整理一下，将查找第k小的数作为一个方法

    // 根据中位数定义，该题目的目标可以简单理解为 找两个数组中第 k=(m+n+1)/2 小的数
    // 如果是m+n是奇数 答案就是第k小的数，否则就是第k小和第k+1小的两个数的平均数
    // 如何找第k小的数呢？ 利用二分法，每次都删除较小值所在数组中前(k-1)/2个元素
    // 时间复杂度为 O(log (m+n))
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length,l = m + n;
        if(m == 0){
            if(l%2 != 0){
                return nums2[l / 2];
            }else{
                return (nums2[l/2] + nums2[l/2 - 1]) * 1.0/2;
            }
        }
        if(n == 0){
            if(l%2 != 0){
                return nums1[l / 2];
            }else{
                return (nums1[l/2] + nums1[l/2 - 1]) * 1.0/2;
            }
        }
        int k = (l+1)/2; // 找到第k小的元素
        int i = 0,j = 0;
        while(k > 1){
            if(i == m){
               return l%2 != 0 ? nums2[j+k-1] : (nums2[j+k-1] + nums2[j+k])*1.0/2;
            }
            if(j == n){
                return l%2 != 0 ? nums1[i+k-1] : (nums1[i+k-1] + nums1[i+k])*1.0/2;
            }
            int num = k / 2; // 要删除元素个数
            int a = num <= nums1.length ? nums1[i + num - 1] : nums1[m - 1];
            int b = num <= nums2.length ? nums2[j + num - 1] : nums2[n - 1];
            if (a <= b) {
                k = num <= nums1.length ? k - num : k - (m - i);
                i = num <= nums1.length ? i + num : m;
            } else {
                k = num <= nums2.length ? k - num : k - (n - j);
                j = num <= nums2.length ? j + num : n;
            }
        }
        if(i == m){
            return l%2 != 0 ? nums2[j] : (nums2[j] + nums2[j+1])*1.0/2;
        }
        if(j == n){
            return l%2 != 0 ? nums1[i] : (nums1[i] + nums1[i+1])*1.0/2;
        }
        if(l%2 != 0){
            return Math.min(nums1[i], nums2[j]);
        }else{
            int p;
            if(i != m -1 && j != n -1){
                p =  nums1[i] < nums2[j] ?
                        nums1[i] + Math.min(nums1[i+1], nums2[j]) :
                        nums2[j] + Math.min(nums2[j+1], nums1[i]);
            }else if(i == m -1 && j == n -1){
                p = nums1[i] + nums2[j];
            }else if(i == m -1){
                p = nums2[j+1] > nums1[i] ?
                        nums1[i] + nums2[j]:
                        nums2[j] + nums2[j+1];
            }else {
                p = nums1[i+1] > nums2[j] ?
                        nums1[i] + nums2[j]:
                        nums1[i] + nums1[i+1];
            }
            return p * 1.0/2;
        }
    }

    // 先试试简单的方法 时间复杂度(m+n)lg(m+n)  题目要求时间复杂度为 O(log (m+n))
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m + n;
        int[] arr = new int[l];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }
        for (int i = m; i < l; i++) {
            arr[i] = nums2[i - m];
        }
        Arrays.sort(arr);
        if(l%2 != 0){
            return arr[l / 2];
        }else{
            return (arr[l/2] + arr[l/2 - 1]) * 1.0/2;
        }
    }
}
