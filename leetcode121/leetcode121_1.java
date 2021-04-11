class Solution {
    public int maxProfit(int[] prices) {
        int max_ans = 0;

        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];

            // sell
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                int profit = sell - buy;

                max_ans = Math.max(max_ans, profit);
            }
        }

        return max_ans;
    }
}

// time complexity:O(n^2)
// space complexity:O(1)