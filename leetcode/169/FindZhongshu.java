package no169;

import java.util.Arrays;
import java.util.HashMap;

public class FindZhongshu {
    public static void main(String[] args) {
        
    }
    
    public int majorityElement1(int[] nums) {
        /*
         * 投票算法
         *      如果我们把众数记为 +1 ，把其他数记为 -1 
         *      将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多
         */
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            //通过忽略掉前面的数字，忽略掉了同样多数目的众数和非众数
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    
    public int majorityElement0(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int ans = nums[0];
        for(int i = 0;i<nums.length;i++) {
            int n = nums[i];
            if(!map.containsKey(n)) {
                map.put(n, 1);
            }else {
                map.put(n, map.get(n)+1);
            }
            if(map.get(n)>maxCount) {
                maxCount = map.get(n);
                ans = n;
            }
        }
        return ans;
    }
}

