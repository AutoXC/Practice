package no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        /*
         * 作者：guanpengchn
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/hua-jie-suan-fa-
         * 15-san-shu-zhi-he-by-guanpengchn/
         * 双指针
         */        
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }        
        return ans;
    }
    
    public static List<List<Integer>> threeSum0(int[] nums) {
        /*
         * 先固定遍历的第一个数，取反作为后面两个数的和，结合leetcode题1做法 
         * 或在遍历前先对数组排序，然后遍历中可优化结构
         * 缺点：用了太多内置函数，大大降低了效率
         */
        int len = nums.length;

        Set<List<Integer>> ansCheak = new HashSet<List<Integer>>();

        if (len < 3) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums[len-1]<0) return new ArrayList<List<Integer>>();
        
        for (int i = 0; i < len && nums[i] < 1; i++) {
            int sum = -nums[i];
            if (i > 0 && nums[i] == nums[i-1]) continue; 
            HashSet<Integer> tempSet = new HashSet<Integer>();
            for (int j = i + 1; j < len; j++) {
                if (!tempSet.contains(sum - nums[j])) {
                    tempSet.add(nums[j]);
                } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(sum - nums[j]);
                    temp.add(nums[j]);
//                    Collections.sort(temp);
                    ansCheak.add(temp);

                    if (temp.get(0) == 0 && temp.get(1) == 0) {
                        break;
                    }
                }
            }
        }

        return new ArrayList<List<Integer>>(ansCheak);
    }
}
