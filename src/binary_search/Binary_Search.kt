package binary_search

import java.util.*

class Binary_Search {
    fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> left = mid + 1
                nums[mid] > target -> left = mid - 1
                else -> return mid
            }
        }
        return -1
    }

    fun binarySearchUsingMethod(nums: IntArray, target: Int): Int {
        val result = Arrays.binarySearch(nums, target)
        return if (result >= 0) result else -1
    }
}