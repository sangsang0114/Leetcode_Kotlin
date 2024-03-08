package binary_search

class Search_in_Rotated_Sorted_Array {
    fun search(nums: IntArray, target: Int): Int {
        //이진 검색을 이용해 피봇이 될 최솟값을 찾는 과정
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] > nums[right] -> left = mid + 1
                else -> right = mid
            }
        }
        val pivot = left

        //이진 검색을 이용해 target 값을 찾는 과정
        left = 0
        right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            val midPivot = (mid + pivot) % nums.size

            when {
                nums[midPivot] < target -> left = mid + 1
                nums[midPivot] > target -> right = mid - 1
                else -> return midPivot
            }
        }
        return -1
    }
}

