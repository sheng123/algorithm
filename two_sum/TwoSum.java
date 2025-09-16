package two_sum;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = { 1, 3, 6, 7, 9, 10, 14, 15 };

        ArrayList<Pair> result = twoSum(array, 13);

        for (Pair pair : result) {
            System.out.printf("first: %d, secend: %d\n", pair.first, pair.second);
        }
    }

    public static ArrayList<Pair> twoSum(int[] array, int target){
        ArrayList<Pair> temp = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == target) {
                Pair pair = new Pair(left, right);
                temp.add(pair);
                right--;
            } else if (array[left] + array[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return temp;
    }
}
