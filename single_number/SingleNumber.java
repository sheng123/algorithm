package single_number;


// 给定一个数组，该数组中只有两个数字出现过奇数次（a，b），其他数字出现的次数都是偶数次，要求找到这两个数字
// 例如 [1,1,2,3,4,4,5,5,6,6]
public class SingleNumber {
    public static void main(String[] args) {
        // 这题可以使用异或运算来解决
        // 1. 所有数字都进行一次异或运算，得到两个只出现一次的数字的异或值 a^b
        // 2. 提取该值最右边的1，rightOne
        // 3. 两个只出现一次的数字，rightOne 的位置一定一个是0，一个是1
        // 4. 数组中 rightOne 位置为0 或者为1的进行一次异或，得到的值一定是 a 或者 b
        // 5. 然后把第一次异或的值跟第二次异或的值再进行一次异或，得到的值一定是 b 或者 a
        int[] array = {1,1,2,3,4,4,5,5,6,6};

        int[] result = singleNumber(array);

        System.out.println(result[0] + " " + result[1]);
        
    }

    public static int[] singleNumber(int[] array) {
        int xor = 0;
        for(int cur : array) {
            xor ^= cur;
        } 

        int rightOne = xor&(~xor + 1);
        int oneItem = 0;

        for(int cur : array) {
            if ((cur & rightOne) == 0) {
                oneItem ^= cur;
            }
        }

        int[] result = {oneItem, oneItem^xor};
        return result;
    }
}
