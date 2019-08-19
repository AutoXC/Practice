class Solution {
    public int maxProfit(int[] prices) {
        /*
        * 峰谷法，一次遍历
        */
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    
    public int maxProfit0(int[] prices) {
        /*
        * 暴力解法，递归
        */
        int len = prices.length;
        
        if(len<2) return 0;
        int min = prices[0];
        int p1 = 0;
        int ans = 0;
        for(int i = 1;i<len;i++) {
            p1 = prices[i]-min>p1?prices[i]-min:p1;
            if(prices[i]<min) {min=prices[i];}
            int p2 = 0;
            for(int j = i+1;j<len;j++) {
                int temp = maxProfit(Arrays.copyOfRange(prices, j, len));
                p2 = temp>p2?temp:p2;
            }
            ans = p1+p2>ans?p1+p2:ans;
        }
        return ans;
    }
}