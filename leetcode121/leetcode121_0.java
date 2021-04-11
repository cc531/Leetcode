class Solution {
    public int maxProfit(int[] prices) {

        // new一個minprice 跟 初始化maxprofit
        // 解題概念是找一個最小值, 然後持續用(i-最小值)來找出maxprofit
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        // i開始遍歷
        for (int i = 0; i < prices.length; i++)  

            // 遍歷中, 如果prices[i] < minprice, 就替換成minprice
            if (prices[i] < minprice)
                minprice = prices[i];

            // 需要找到最大maxprofit, 遍歷中若prices[i] - minprice比前一個maxprofit大
            // 就取代maxprofit
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;

        }
    // 走完整個循環後得到maxprofit
    return maxprofit;
}}