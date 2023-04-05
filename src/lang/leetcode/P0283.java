package lang.leetcode;

/** 移动零 同26,27
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 10(4)
 * -2(31) <= nums[i] <= 2(31) - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class P0283 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,0,0,3,12,0};
        moveZeroes(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println("*****************");
        int[] nums2 = {0,0,3,4,0,4,0,23,3,4,0,0};
        moveZeroes(nums2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
    }

    // 将所有不等于0的元素挑选出来放前面，最后将剩余的数据全部赋值0  这种方式更好理解
    public static void moveZeroes(int[] nums){
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                nums[i++] = nums[j];
            }
            j++;
        }
        while(i < nums.length){
            nums[i++] = 0;
        }
    }

    // i指向数值=0的位置，j不断往前，当j所指位置数值不等于0时，和i位置数据做交换
    public static void moveZeroes1(int[] nums){
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                if(i != j){// i!=j时，交换两个位置元素值
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
            j++;
        }
    }

}
