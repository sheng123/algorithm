package sort.quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 5, 3, 4, 5, 2, 6, 9, 6 };

        quickSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            swap(nums, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(nums, l, r);
            quickSort(nums, l, p[0] - 1);
            quickSort(nums, p[1] + 1, r);
        }
    }

    // 1.当前值比 arr[r] 小，和小于区下一个交换，小于区右扩，当前位置加1
    // 2.当前值比 arr[r] 大，和大于区前一个交换，大于区左扩，当前位置不变
    // 3.当前值等于 arr[r]，当前位置加1
    // 4.返回的是等于区的左右边界
    public static int[] partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int less = l - 1;
        int more = r; // more 指向大于区的起始位置
        while (l < more) {
            if (arr[l] < pivot) {
                swap(arr, ++less, l++);
            } else if (arr[l] > pivot) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }

        swap(arr, more, r);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
