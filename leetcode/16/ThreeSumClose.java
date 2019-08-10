package no16;

import java.util.Arrays;

public class ThreeSumClose {
    public static void main(String[] args) {
        long start = System.nanoTime();
        
        int[] n = {1,1,1,0};
        int t = -100;
        System.out.println(threeSumClosest(n, t));
        
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) {return 0;}
        if(len <= 3) {
            int sum = 0;
            for (int i = 0;i<len;i++) {
                sum += nums[i];
            }
            return sum;
        }
        
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int i = 0;i<len-2;i++) {
            if(i > 0&&nums[i-1]==nums[i]) {continue;}
            int l = i+1;
            int r = len - 1;
            
            while (l < r) {
                int sum = nums[i]+nums[l]+nums[r] - target;
                if (sum == 0) {return sum + target;}
                else if (sum < 0) {
                    l++;
                    ans = Math.abs(ans - target)>Math.abs(sum)? sum + target : ans;
                }
                else if (sum > 0) {
                    r--;
                    ans = Math.abs(ans - target)>Math.abs(sum)? sum + target : ans;
                }
            }
        }
        return ans;
    }
}
