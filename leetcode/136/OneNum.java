package no136;

import java.util.HashSet;

public class OneNum {
    public static void main(String[] args) {
        int[] n = {2,2,1};
        System.out.println(singleNumber0(n));
    }
    
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1;i<nums.length;i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
    
    public static int singleNumber0(int[] nums) {
        HashSet<Integer> s = new HashSet<Integer>();
        int numsSum = 0;
        int setSum = 0;
        for(int n : nums) {
            s.add(n);
            numsSum += n;
        }
        for(int n : s) {
            setSum += n;
        }
        return 2*setSum-numsSum;
    }
}
