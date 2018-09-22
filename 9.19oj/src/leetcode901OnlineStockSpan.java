import java.util.HashMap;
import java.util.Stack;

public class leetcode901OnlineStockSpan {
    public leetcode901OnlineStockSpan() {
    }

    Stack<Integer> prices;
    Stack<Integer> weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
}
