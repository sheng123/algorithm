package sort.merge_sort.small_sum;


// 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
// 相当于，每一个数右边比当前数大的数累加起来
// 例如：[1,3,4,2,5] 1左边比1小的数，没有；3左边比3小的数，1；4左边比4小的数，1、3；2左边比2小的数，1；5左边比5小的数，1、3、4、2；
// 所以小和为 1+1+3+1+1+3+4+2=16

// 也可以转化理解，1右边比1大的数有4个，4个1；3右边比3大的数有两个，2个3；4右边比4大的数有1个，1个4；2右边比2大的数有1个，1个2；4*1+2*3+1*4+1*2=16

// 分解可以使用归并排序，在排序的过程中，每次计算右边比当前大的数，进行累加
public class SmallSum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 5 };

        int result = smallSum(nums, 0, nums.length - 1);

        System.out.println(result);
    }

    public static int smallSum(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return smallSum(nums, left, mid) + smallSum(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    public static int merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int result = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
                help[i] = nums[p1];
                result += nums[p1] * (right - p2 + 1);
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

        return result;
    }
}
