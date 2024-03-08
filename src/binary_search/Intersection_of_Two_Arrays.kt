package binary_search

import java.util.*
import kotlin.collections.HashSet

class Intersection_of_Two_Arrays {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val result: MutableSet<Int> = HashSet()
        Arrays.sort(nums2)
        for (n1 in nums1) {
            val i2 = Arrays.binarySearch(nums2, n1)
            if (i2 >= 0)
                result.add(n1)
        }
        return result.toIntArray()
    }

    fun intersectinUsingTwoPointer(nums1: IntArray, nums2: IntArray): IntArray {
        val result: MutableSet<Int> = HashSet()
        Arrays.sort(nums1)
        Arrays.sort(nums2)

        var p1 = 0
        var p2 = 0

        while (p1 < nums1.size && p2 < nums2.size) {
            if (nums1[p1] > nums2[p2]) ++p2
            else if (nums1[p1] < nums2[p2]) ++p1
            else {
                result.add(nums1[p1])
                ++p1
                ++p2
            }
        }
        return result.stream().mapToInt(Int::toInt).toArray()
    }
}