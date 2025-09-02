package main

import "fmt"

// 计算数组中连续出现的数字的个数
func main() {
	array := []int{1, 1, 1, 1, 2, 2, 5, 5, 6, 7, 3, 3, 4, 5, 7, 7, 8, 8, 9, 10}
	consecutiveNumbers := findConsecutiveNumbers(array)
	fmt.Println(consecutiveNumbers)
}

func findConsecutiveNumbers(array []int) []int {
	consecutiveNumbers := []int{}

	currentNumber := array[0]
	currentCount := 0

	for _, number := range array {
		if currentNumber == number {
			currentCount++
		} else {
			consecutiveNumbers = append(consecutiveNumbers, currentCount)
			currentNumber = number
			currentCount = 1
		}
	}

	consecutiveNumbers = append(consecutiveNumbers, currentCount)
	return consecutiveNumbers
}
