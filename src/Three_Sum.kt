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
}