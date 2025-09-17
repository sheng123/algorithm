package valid_brackets;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 */

 // 这个题目看起来是左右括号是成对出现的，不会 ({)}，如果这样的话，感觉使用三个栈会比较好处理
public class BracketsValid {
    public static void main(String[] args) {
        String  str = "({[)})";
        boolean b = validBrackets(str);

        System.out.println(b);
    }

    public static boolean validBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char temp = stack.pop();
                if (c == '}' && temp != '{') {
                    return false;
                } else if (c == ')' && temp != '(') {
                    return false;
                } else if (c == ']' && temp != '[') {
                    return false;
                } 
            }
        }
        return stack.empty() ?  true: false;
    }
}
