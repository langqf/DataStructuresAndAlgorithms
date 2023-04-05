package lang.leetcode;

import java.util.*;

/** 两个数组的交集
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *  示例 1：
 *  输入：nums1 = [1,2,2,1], nums2 = [2,2]
 *  输出：[2,2]
 *  示例 2:
 *  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *  输出：[4,9]
 *  提示：
 *  1 <= nums1.length, nums2.length <= 1000
 *  0 <= nums1[i], nums2[i] <= 1000
 *  进阶：
 *  如果给定的数组已经排好序呢？你将如何优化你的算法？
 *  如果 nums1 的大小比 nums2 小，哪种方法更优？
 *  如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class P0350 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersectionOfTwoArray1 = intersect2(nums1, nums2);
        for (int var :intersectionOfTwoArray1) {
            System.out.print(var + "、");
        }
        System.out.println();
        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        int[]  intersectionOfTwoArray2 = intersect2(nums3, nums4);
        for (int var :intersectionOfTwoArray2) {
            System.out.print(var + "、");
        }
    }

    // 利用map k-v  v表示出现次数  时间复杂度O(BlgA)或者O(AlgB) A，B分别代表数组长度
    public static int[] getIntersectionOfTwoArray(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> resultList= new ArrayList();
        for(int i : nums2){
            if(map.containsKey(i)  && map.get(i) > 0){
                resultList.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] resultArr = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    // 先排序，再比较 在排好序的情况下，时间复杂度是 O(A+B)
    public static int[] intersect(int[] nums1, int[] nums2){
        quickSort(nums1, 0, nums1.length -1);// 1 1 2 2
        quickSort(nums2, 0 , nums2.length -1);// 2 2
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        ArrayList<Integer> resultList= new ArrayList();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                resultList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] resultArr = new int[resultList.size()];
        for(int k = 0; k < resultList.size(); k++) {
            resultArr[k] = resultList.get(k);
        }
        return resultArr;
    }

    // 先排序，再比较 在排好序的情况下，时间复杂度是 O(A+B)
    public static int[] intersect2(int[] nums1, int[] nums2){
        quickSort(nums1, 0, nums1.length -1);// 1 1 2 2
        quickSort(nums2, 0 , nums2.length -1);// 2 2
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        int[] resultArr = new int[k];
        for(int m = 0; m < k; m++) {
            resultArr[m] = nums1[m];
        }
        return resultArr;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 采用循环遍历，不可行
    public static int[] getIntersectionOfTwoArray_Bad(int[] nums1, int[] nums2){
        int[] resultArr;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int size = l1 < l2 ? l1 : l2;
        int[] intersectionArr = new int[size];
        for (int i = 0; i < size; i++) {
            intersectionArr[i] = -1;
        }
        int k = 0;
        for(int i = 0; i < l1; i++){
            for(int j = 0; j < l2; j++){
                if(nums2[j] != -1 && nums1[i] == nums2[j]){
                    intersectionArr[k++] = nums1[i];
                    nums2[j] = -1;
                    break;
                }
            }
        }
        resultArr = new int[k];
        for (int i = 0; i < k; i++) {
            resultArr[i] = intersectionArr[i];
        }
        return resultArr;
    }



}
