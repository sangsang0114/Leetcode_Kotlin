class Product_of_Array_Except_Self {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size) { i -> 1 }
        for(i in nums.indices)
            answer[i] *= nums[i]

        return answer
    }
}