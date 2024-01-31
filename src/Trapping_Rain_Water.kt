import kotlin.math.max

class Trapping_Rain_Water {
    fun trap(height: IntArray): Int {
        val len = height.size
        var left = 0
        var right = len - 1
        var leftMax = height[left]
        var rightMax = height[right]
        var answer = 0

        while (left < right) {
            leftMax = max(height[left], leftMax)
            rightMax = max(height[right], rightMax)

            if (leftMax < rightMax) {
                answer += leftMax - height[left]
                ++left
            }else{
                answer += rightMax - height[right]
                --right
            }
        }
        return answer
    }
}