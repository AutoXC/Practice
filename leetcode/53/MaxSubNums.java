package no53;


public class MaxSubNums {
    public static void main(String[] args) {
        int[] n = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(n));
    }
    
    public static int maxSubArray(int[] nums) {
        //正数增益，并不需要了解当前值num多大，当sum>0时才对结果有增益，sum<0时取num与ans比较
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;

        /*
         * 作者：guanpengchn
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
         */    
        }
    
    public static int maxSubArray0(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        
        int[][] ans = new int[len][len];
        int max = 0;
        for(int i = 0;i<len;i++) {
            int isum = 0;
            for (int j = i;j<len;j++) {
                isum += nums[j];   //sum of i to j
                if(j==i) {ans[i][j]=nums[i];}
                else {ans[i][j]= isum >ans[i][j-1]? isum : ans[i][j-1];}
            }
            if(i==0) {max = ans[i][len-1];}
            else {max = max<ans[i][len-1]?ans[i][len-1]:max;}
        }
        return max;
    }
}
