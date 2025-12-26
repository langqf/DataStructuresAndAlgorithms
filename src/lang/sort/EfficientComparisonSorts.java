package lang.sort;

import java.util.Arrays;

// 高效的比较排序  快速排序，归并排序，堆排序，希尔排序
public class EfficientComparisonSorts {
    public static void main(String[] args){
        int size = 10;
        int[] numsRandom = new int[size];
        for (int i = 0; i < size; i++) {
            numsRandom[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(numsRandom));
        // 临时数组存放每次合并好的有序序列，每次合并完成后将数据复制给原数组
        int[] temp = new int[numsRandom.length];
        mergeSort(numsRandom, 0, numsRandom.length - 1, temp);
        System.out.println(Arrays.toString(numsRandom));
    }

    // 快速排序 选定一个基准元素，将序列分成左右两组，保证所有左组中的元素=<基准元素，所有右组中的元素>基准元素，之后分别对左右两组的序列做相同的处理
    //TODO deepseek提供的方法，先找到基准元素位置
    //TODO 125题 可以用快速排序思想
    public static void quickSort(int[] nums, int start, int end){
        /* 自己的写法
        if(start >=  end) {
            return;
        }
        int pivot = nums[start];
        int i = start, j = end;
        while(i <= j){
            if(nums[i] >= pivot){
                if(nums[j] <= pivot){
                    // =<基准元素的数据需要交换，放入左组
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                }
                j--;
            }else{
                i++;
            }
        }
        quickSort(nums, start, j);
        quickSort(nums, i , end);*/

        // 老师的写法
        if(start >=  end) {
            return;
        }
        int pivot = nums[start];
        int left = start, right = end;
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    // 归并排序
    public static void mergeSort(int[] nums, int start, int end, int[] temp){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums,start, mid, end, temp);
    }

    // 合并
    public static void merge(int[] nums, int start, int mid, int end, int[] temp){
        int left = start;
        int right = mid + 1;
        int index = start;
        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                temp[index++] = nums[left++];
            }else{
                temp[index++] = nums[right++];
            }
        }
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        while(right <= end){
            temp[index++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
