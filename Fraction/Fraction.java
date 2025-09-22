package Fraction;

public class Fraction {
    private int numerator;   // 分子
    private int denominator; // 分母

    // 构造函数，自动约分
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("分母不能为零");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // 构造时即化简
    }

    // 分数加法
    public Fraction add(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        return new Fraction(newNumerator, commonDenominator);
    }

    // 分数减法
    public Fraction subtract(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        return new Fraction(newNumerator, commonDenominator);
    }

    // 约分方法：使用欧几里得算法求最大公约数（GCD）
    private void reduce() {
        int gcd = calculateGcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        // 保证分母始终为正
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // 计算最大公约数（GCD）
    private int calculateGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
