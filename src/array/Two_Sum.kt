package array

private class Two_Sum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val m : MutableMap<Int, Int> = mutableMapOf()

        for((i, num) in nums.withIndex()){
            if(m.containsKey(target-num)){
                return intArrayOf(m[target-num]!!, i)
            }
            m[num] = i
        }
        return intArrayOf()
    }
}