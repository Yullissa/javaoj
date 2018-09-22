public class Aug01_best_time_to_buy_and_sell_stock {

    //保存每个最小值点，更新维护该值后面较大值和最小值的差即可
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxprofit = 0;
        int minNum = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minNum) {
                minNum = prices[i];
            } else if (prices[i] > minNum)
                maxprofit = Math.max(prices[i] - minNum, maxprofit);
        }
        return maxprofit;
    }
}
