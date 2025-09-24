package sort.heap_sort;

import java.util.Arrays;

// 堆结构其实就是一个完全二叉树
// 某一个位置 i 的数据，它的左孩子对应的位置为 2*i+1，右孩子对应的位置为 2*i+2，父亲的位置为 (i-1)/2
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 7, 1, 9, 6 };

        // 先把数组构建称为大顶堆
        for(int i = 0; i< arr.length-1; i++) {
            heapInsert(arr, i);
        }

        System.out.println("heapInsert: " + Arrays.toString(arr));

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

        System.out.println("heapSort: " + Arrays.toString(arr));
    }

    // 每插入一个数据，跟自己的父亲进行比较，如果大的话，就进行交换
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1; // 左孩子的下标
        while (left < heapSize) { // 下方还有孩子的时候，继续进行遍历
            // 比较两个孩子，把大的那个下标交给 largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            // 比较父亲和大的孩子，把大的下标交给 largest
            largest = arr[largest] > arr[index] ? largest : index;

            // 如果当前值是最大值，那么就跳出，结束这次遍历
            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
