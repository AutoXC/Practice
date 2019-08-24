package no238;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int left = 1;
        int right = 1;
        for(int i=0;i<nums.length;i++){
            ans[i] *= left;
            left *= nums[i];
            
            ans[nums.length-i-1] *= right;
            right *= nums[nums.length-i-1];
        }
        return ans;
    }
}
