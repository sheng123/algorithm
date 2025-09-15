package binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 1, 3, 6, 7, 9, 10, 14, 15 };
        int index = binarySearch(array, 14);
        System.out.println(index);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
