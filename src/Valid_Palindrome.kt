import java.util.*

private class Valid_Palindrome {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length-1

        while(left < right){
            when{
                !Character.isLetterOrDigit(s[left]) -> ++left
                !Character.isLetterOrDigit(s[right]) -> --right
                else -> {
                    val l = Character.toLowerCase(s[left])
                    val r = Character.toLowerCase(s[right])
                    if(l != r)
                        return false
                    ++left
                    --right
                }
            }
        }
        return true
    }

    fun otherSolution(s: String): Boolean{
        val regex = "[^A-Za-z0-9]".toRegex()
        val s_filtered = s.replace(regex,"").toLowerCase()
        val s_reversed = StringBuilder(s_filtered).reverse().toString()
        return s_filtered == s_reversed
    }
}