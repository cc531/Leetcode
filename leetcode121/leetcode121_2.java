class Solution {
    public int maxProfit(int[] prices) {
        int low_buy = prices[0];
        int max_profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];

            // greedy
            int profit_today = sell - low_buy;

            max_profit = Math.max(max_profit, profit_today);

            low_buy = Math.min(low_buy, prices[i]);
        }

        return max_profit;
    }
}

// Runtime: 2 ms, faster than 57.66% of Java online submissions for Best Time to
// Buy and Sell Stock.
// Memory Usage: 53.1 MB, less than 19.48% of Java online submissions for Best
// Time to Buy and Sell Stock.
// time complexity: O(n)
// space complexity: O(1)