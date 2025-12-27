package lang.search;

import lang.sort.EfficientComparisonSorts;

import java.util.Arrays;

// 二分查找
public class MyBinarySearch {
    public static void main(String[] args) {
        int size = 11;
        int[] numsRandom = new int[size];
        for (int i = 0; i < size - 1; i++) {
            numsRandom[i] = (int)(Math.random() * 100);
        }
        numsRandom[size-1] = 45;
        EfficientComparisonSorts.quickSort(numsRandom, 0, numsRandom.length - 1);
        System.out.println(Arrays.toString(numsRandom));
        int i = binarySearch(numsRandom,  0, numsRandom.length - 1, 45);
        System.out.println(i);
    }

    public static int binarySearch(int[]  nums, int start, int end, int target){
        int mid =  start + (end - start)/2;
        while(start <= end){
            if(target > nums[mid]){
                return binarySearch(nums, mid + 1, end, target);
            }else if(target < nums[mid]){
                return binarySearch(nums, start, mid - 1, target);
            }else{
                return mid;
            }
        }
        return -1;
    }
}
