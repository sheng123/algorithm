package sort.bubble_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 3, 5, 6, 7, 12, 34, 56 };

        int[] result = bubbleSort(nums);

        System.out.println(Arrays.toString(result));
    }

    private static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        // 每次遍历，把最大的值像气泡一样，放在最后面的位置
        for (int e = nums.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
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
