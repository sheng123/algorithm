package longest_child_string;

import java.util.HashSet;
import java.util.Set;

// 找出字符串中最长的无重复子串
public class LongestChildString {
    public static void main(String[] args) {
        String str = "abcabcdefcaabb";
        System.out.println(longestChildString(str));
        System.out.println("max lenght is: " + maxLength(str));
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
