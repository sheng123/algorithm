package sort.merge_sort;

import java.util.Arrays;

// 归并排序，时间复杂度为 N*logN

// 采用递归的方式来执行，每次执行一半的数据
// merge 阶段使用辅助空间数组，把左边和右边的数据依次copy到辅助数组中，完成以后再把数据copy到原数组中
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 3, 5, 6, 7, 12, 34, 56 };

        mergeSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
                help[i] = nums[p1];
                p1++;
            } else {
                help[i] = nums[p2];
                p2++;
            }

            i++;
        }

        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }

        while (p2 <= right) {
            help[i++] = nums[p2++];
        }

        for (int v : help) {
            nums[left++] = v;
        }

    }
}
