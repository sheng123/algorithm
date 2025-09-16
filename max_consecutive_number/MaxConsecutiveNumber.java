package max_consecutive_number;

// 有一个数组，最多可以修改K个数字，出现最大的连续相同数字的个数

// 可以使用滑动窗口来解决这个问题
// 1.相同的数字是题目中的目标数字，target number
// 2.设置两个指针，left 和 right
// 3.遍历数组，right 指针不断右移，如果不是 target number，那么 countNonTarget 累加1
// 4.判断 countNonTarget 是否大于 k，如果大于 k 的话，就移动 left 指针，然后判断 left 位置是否为 target number，不是的话就 countNonTarget 减1
// 5.maxLegth = right - left + 1
public class MaxConsecutiveNumber {
    public static void main(String[] args) {
        int[] array = {1,1,1,0,0,0,0,1,1};

        int result = maxConsecutiveNumber(array, 3, 1);
        System.out.println(result);

    }

    public static int maxConsecutiveNumber(int[] array, int k, int targetNumber) {
        int left = 0;
        int maxLegth = 0;
        int countNonTarget = 0;

        for (int right = 0; right < array.length; right++) {
            if (array[right] != targetNumber) {
                countNonTarget++;
            }

            while (countNonTarget > k) {
                if (array[left] != targetNumber) {
                    countNonTarget--;
                }
                left++;
            }

            maxLegth = Math.max(maxLegth, right - left + 1);
        }

        return maxLegth;
    }
}
