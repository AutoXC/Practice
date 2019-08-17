package no121;

public class MaxProfit {
    public static void main(String[] args) {
        int[] n = {7,1,5,3,6,4};
        System.out.println(maxProfit(n));
    }
    
    public static int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int lr = 0;
        int min = prices[0];
        for(int n : prices) {
            lr = n-min>lr?n-min:lr;
            if(n<min) min = n;
        }
        if(lr<0) return 0;
        return lr;
    }
    
    public static int maxProfit0(int[] prices) {
        int len = prices.length;
        int lr = 0;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if(prices[j]-prices[i]>lr){
                    lr=prices[j]-prices[i];
                }
            }
        }
        if(lr<0) return 0;
        return lr;
    }
}
