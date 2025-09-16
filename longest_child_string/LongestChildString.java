package longest_child_string;

import java.util.HashSet;
import java.util.Set;

// 找出字符串中最长的无重复子串
public class LongestChildString {
    public static void main(String[] args) {
        String str = "abcabcdefcaabb";
        System.out.println(longestChildString(str));
        System.out.println("max lenght is: " + maxLength(str));

        int[] array = {1,2,3,1,2,3,4,5,6,3,1,1,2,2};
        System.out.println(longestChildArray(array));
    }

    public static int longestChildArray(int[] arr) {
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        while (right < arr.length) {
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(arr[left]);
                left++;
            }

        }
        return maxLength;
    }

    public static String longestChildString(String str) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        String tempString = "";
        String longestChildString = "";

        while (right < str.length()) {
            if (right == left && right < str.length()-1) {
                right++;
            }
            tempString = str.substring(left, right);
            if (tempString.length() > maxLength) {
                maxLength = tempString.length();
                longestChildString = tempString;
            }

            if (tempString.contains(String.valueOf(str.charAt(right)))) {
                left++;
                continue;
            }

            
            right++;
        }
        return longestChildString;
    }

    // 另外一种方式获取最长无重复子串的长度
    public static int maxLength(String str) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (right < str.length()) {
            char currentChar = str.charAt(right);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
