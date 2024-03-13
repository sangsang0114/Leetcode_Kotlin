package array

class Best_Time_to_Buy_and_Sell_Stock {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = prices[0]

        for (price in prices) {
            minPrice = minPrice.coerceAtMost(price)
            maxProfit = maxProfit.coerceAtLeast(price - minPrice)
        }
        return maxProfit
    }
}