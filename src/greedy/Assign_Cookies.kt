package greedy

import java.util.*

class Assign_Cookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        Arrays.sort(s)
        Arrays.sort(g)

        var child = 0
        var cookie = 0

        while (child < g.size && cookie < s.size) {

            //어린이가 원하는 크기보다 더 큰 쿠키일 때만 다음 어린이로 이동
            if (s[cookie] >= g[child])
                ++child
            ++cookie
        }
        return child
    }
}