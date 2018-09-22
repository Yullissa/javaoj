public class Aug01_best_time_to_buy_and_sell_stock_iii {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(-prices[i], buy1);  //第一次买花的钱,//要选出花钱最少的那天买
            sell1 = Math.max(sell1, prices[i] + buy1); //第一次卖赚的钱

            // sell1 记录最高一次交易可赚的钱
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //buy2记录的是什么 ： 记录 到目前为止 买入最低点时可以赚的最多的钱
            sell2 = Math.max(sell2, prices[i] + buy2);
            //sell2 记录到目前为止经过最多两次交易赚的钱
//            System.out.println(sell2);
        }
        return sell2;
    }
}
