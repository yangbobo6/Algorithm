package array;

/**
 * @Author: yangbo
 * @Date: 2022-05-29-9:19
 * @Description: 买卖股票的最佳时机
 */
public class code121_maxProfit {
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int max = 0;
        
        for(int i=0;i<len;i++){
            for (int j = i+1; j < len-1; j++) {
                int value = prices[j]-prices[i];
                if(max<value){
                    max = value;
                }
            }
        }
        return max;
    }
    
    public int maxProfit(int[] prices){
        if(prices.length<=1){
            return 0;
        }
        //记录 今天之前买入的最小值min，最大获利max
        int min = prices[0],max = 0;
        for (int i:prices
             ) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
