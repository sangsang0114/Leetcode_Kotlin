import kotlin.math.min

class Array_Partition {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var sum = 0
        for (i in 1..nums.size - 1 step 2) {
            sum += min(nums[i],nums[i-1])
        }
        return sum
    }
}