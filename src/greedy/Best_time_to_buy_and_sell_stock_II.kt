package greedy

class Best_time_to_buy_and_sell_stock_II {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 0..<prices.size - 1) {
            if (prices[i + 1] > prices[i])
                result += prices[i + 1] - prices[i]
        }
        return result
    }
}