package sort.insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 3, 5, 6, 7, 12, 34, 56 };

        int[] result = insertionSort(nums);

        System.out.println(Arrays.toString(result));
    }

    // 依次遍历数组，取出最新遍历的数字，插入到合适的位置
    public static int[] insertionSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j+1]; j--) {
                swap(nums, j, j+1);
            }

        }

        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
