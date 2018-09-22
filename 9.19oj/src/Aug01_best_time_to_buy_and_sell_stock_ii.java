public class Aug01_best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            while (i < prices.length && prices[i - 1] > prices[i]) i++;
            int buy = prices[i - 1];
            while (i < prices.length && prices[i - 1] <= prices[i]) i++;
            int sell = prices[i - 1];
            total += sell - buy;
        }
//        System.out.println(total);
        return total;
    }
}
