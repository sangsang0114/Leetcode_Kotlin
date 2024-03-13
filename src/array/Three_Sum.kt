package array

import java.util.*

class Three_Sum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val len = nums.size
        val answer = mutableListOf<List<Int>>()

        for (idx in 0..len) {
            val base = idx
            val baseNum = nums[idx]

            var left = 0
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[left] + nums[right]
                if (sum < -base) {
                    ++left
                } else if (sum > -base) {
                    --right
                } else {
                    answer.add(mutableListOf(nums[left], nums[right], base))
                }
            }
        }
        return answer.toSet().toList()
    }

    fun otherSolution(nums: IntArray): List<List<Int>> {
        var left: Int
        var right: Int
        var sum: Int
        val results: MutableList<List<Int>> = mutableListOf()
        Arrays.sort(nums)

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            left = i + 1
            right = nums.size - 1
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right]
                if (sum < 0)
                    ++left
                else if (sum > 0)
                    --right
                else {
                    results.add(listOf(nums[i], nums[left], nums[right]))

                    while (left < right && nums[left] == nums[left + 1]){
                        ++left
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        --right
                    }
                    ++left
                    --right
                }
            }
        }
        return results
    }
}