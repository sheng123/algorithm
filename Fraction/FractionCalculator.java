package Fraction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionCalculator {

    public static String calculateExpression(String expression) {
        // 1. 使用正则表达式匹配所有分数部分（包括符号）
        List<String> fractionStrings = new ArrayList<>();
        Pattern pattern = Pattern.compile("([+-]?\\d+)/(\\d+)"); // 匹配如 "+1/2", "-1/3", "1/4"
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            fractionStrings.add(matcher.group(0)); // 将匹配到的分数字符串加入列表
        }

        // 2. 处理表达式以整数开始的情况（例如 "1+1/3" 中的 "1"）
        // 此部分代码较复杂，可根据实际输入格式的复杂性进行扩展。
        // 一个简单的假设：表达式已为标准分数加减形式，如 "-1/2+1/3"

        // 3. 将字符串转换为 Fraction 对象并进行连续运算
        Fraction result = new Fraction(0, 1); // 初始化为 0/1
        for (String fracStr : fractionStrings) {
            // 简单分割解析，假设字符串格式为 "分子/分母"
            String[] parts = fracStr.split("/");
            int num = Integer.parseInt(parts[0]);
            int den = Integer.parseInt(parts[1]);
            Fraction currentFraction = new Fraction(num, den);
            result = result.add(currentFraction); // 持续相加
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String expr1 = "-1/2+1/2";
        String expr2 = "-1/2+1/2+1/3";
        String expr3 = "1/3-1/2";

        System.out.println(calculateExpression(expr1)); // 输出 "0/1"
        System.out.println(calculateExpression(expr2)); // 输出 "1/3"
        System.out.println(calculateExpression(expr3)); // 输出 "-1/6"
    }
}