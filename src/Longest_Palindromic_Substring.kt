class Longest_Palindromic_Substring {
    var left = 0
    var maxLen = 0
    fun longestPalindrome(s: String): String {
        val len = s.length
        if (len == 1) return s

        for (i in 0..len - 1) {
            extendPalindrome(s, i, i + 1)
        }

    }
    fun extendPalindrome(s: String, l: Int, r: Int){
        var left = l
        var right = r

        while(left >= 0 && r < s.length){
            if(s[left]!=s[right])
                break
            --left
            ++right

            if(maxLen < right - left - 1){
                left = l +1
                maxLen = r-
            }
        }
    }
}