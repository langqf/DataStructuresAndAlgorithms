package lang.sort;

import java.util.Arrays;

// 初级排序，冒泡，选择，插入，时间复杂度一般为O(n²)
//TODO 比较三种排序的稳定性，最好时间复杂度，最差时间复杂度，平均时间复杂度，是否原地排序?
public class ElementarySorts {
    public static void main(String[] args) {
        int size = 10;
        int[] numsRandom = new int[size];
        for (int i = 0; i < size; i++) {
            numsRandom[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(numsRandom));
        insectionSort(numsRandom);
        System.out.println(Arrays.toString(numsRandom));
    }

    // 冒泡排序 两两比较并交换，每轮比较出最小值
    public static void bubbleSort(int[] nums){
        int length= nums.length;
        for (int n = 0; n < length; n++) {
            for (int i = 0; i < nums.length - length - 1; i++) {
                if(nums[i] > nums[i+1]){
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        /* 老师的
        int length = nums.length;
        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j < length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }*/
    }
    // 选择排序 已排序序列+未排序序列，每次从排序序列中选出一个最小的和当前位置交换
    public static void selectionSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int pos = i;
            // 找到未排序序列中最小元素位置
            for (int j = i + 1; j < len; j++) {
                if(nums[j] < nums[pos]){
                    pos = j;
                }
            }
            // 当前位置元素不是未排序序列中最小元素就交换
            if(pos != i){
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
            }
        }
    }
    // 插入排序 在已排序序列中找到要插入的位置
    public static void insectionSort(int[] nums){
        /*int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int insertionNum = nums[j];
            while(j > 0 && insertionNum < nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = insertionNum;
        }*/
        // 老师写法
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int insertionNum = nums[i];
            // 查找位置，将所有比自身大的所有元素向后移
            while(j >= 0 && insertionNum < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            // j+1为最终要插入的位置
            nums[j + 1] = insertionNum;
        }
    }
}
