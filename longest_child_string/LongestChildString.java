package longest_child_string;

// 找出字符串中最长的无重复子串
public class LongestChildString {
    public static void main(String[] args) {
        String str = "abcabcdefcaabb";
        System.out.println(longestChildString(str));
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
}
