package sliding_window

class Minimum_Window_Substring {
    fun minWindow(s: String, t: String): String {
        val need: MutableMap<Char, Int> = mutableMapOf()

        for (c in t.toCharArray())
            need[c] = need.getOrDefault(c, 0) + 1

        var missingCount = t.length
        var left = 0
        var right = 0
        var start = 0
        var end = 0
        var minLen = Int.MAX_VALUE

        for (c in s.toCharArray()) {
            ++right

            //필요했던 문자열이므로 카운터에서 감소
            if (need.containsKey(c) && need[c]!! > 0)
                --missingCount
            need[c] = need.getOrDefault(c, 0) - 1

            if (missingCount == 0) {
                while (left < right && need[s[left]]!! < 0) {
                    need[s[left]] = need.getOrDefault(s[left], 0) + 1
                    ++left
                }

                if (minLen > right - left + 1) {
                    minLen = right - left + 1
                    start = left
                    end = right
                }

                need[s[left]] = need.getOrDefault(s[left], 0) + 1
                ++missingCount
                ++left
            }
        }
        return s.substring(start, end)
    }
}