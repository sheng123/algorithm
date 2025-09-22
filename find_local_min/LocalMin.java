package find_local_min;

// 找到一个局部最小的数据，给定一个数组，任意两个相邻的数字都不相等

// 同理也可以找到局部最大数据
public class LocalMin {
    public static void main(String[] args) {
        // 局部最小的定义
        // 1.如果0位置的数据，小于1位置的数据，则认为0是局部最小
        // 2.如果length-1位置的数据，小于length-2位置的数据，则认为length-1位置的数据是局部最小
        // 3.如果是中间位置的数据mid，mid 小于 mid-1 并且小于 mid + 1，则认为 mid 是局部最小
        int[] nums = { 3, 2, 1, 3, 5, 6, 7, 12, 34, 56 };

        int result = findLocalMin(nums);

        System.out.println(result);
    }

    // 1.判断数组最左边和最右边的数据是不是局部最小（left=0, right=length-1）
    // 2.做 while 循环（left<right）
    // 3.取中间的数据，mid= left + （right-left）/2 检查 arr[mid]是否是局部最小（即是否同时小于 arr[mid-1]和
    // arr[mid+1]），如果是则返回 mid。
    // 4.如果 arr[mid] > arr[mid-1]，说明左侧存在“下降”趋势，局部最小值很可能在左边，令 right = mid - 1。
    // 5.否则，如果 arr[mid] > arr[mid+1]，说明右侧存在“上升”趋势，局部最小值很可能在右边，令 left = mid + 1。
    public static int findLocalMin(int[] array) {
        int len = array.length - 1;
        if (array[0] < array[1]) {
            return array[0];
        }

        if (array[len] < array[len - 1]) {
            return array[len];
        }

        int left = 1;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[mid + 1] && array[mid] < array[mid - 1]) {
                return array[mid];
            } else if (array[mid] > array[mid - 1]) {
                right = mid - 1;
            } else if (array[mid] > array[mid + 1]) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
