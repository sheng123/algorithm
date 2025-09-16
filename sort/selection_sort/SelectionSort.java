package sort.selection_sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 3, 5, 6, 7, 12, 34, 56 };

        int[] result = selectionSort(nums);

        System.out.println(Arrays.toString(result));
    }

    public static int[] selectionSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[j] < nums[minIndex] ? j : minIndex;
            }

            swap(nums, i, minIndex);
        }

        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}