package binary_search

import java.util.*

class Two_Sum_II_input_sorted {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in numbers.indices) {
            val expected = target - numbers[i]
            val idx = Arrays.binarySearch(numbers, i + 1, numbers.size, expected)
            if (idx >= 0) return intArrayOf(i + 1, idx + 1)
        }
        return intArrayOf()
    }

    fun twoSumUsingTwoPointer(numbers: IntArray, target: Int): IntArray? {
        var left = 0
        var right = numbers.size - 1
        while (left != right) {
            val sum = numbers[left] + numbers[right]
            if (sum < target) ++left
            else if (sum > target) --right
            else return intArrayOf(left + 1, right + 1)
        }
        return null
    }
}