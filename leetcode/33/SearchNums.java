package no33;

import java.util.Arrays;

public class SearchNums {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] n = {4,5,6,0,2,3};
        int t = 8;
        System.out.println(search(n,t));
        
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
    
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int ans = -1;
        if(len==0) {return -1;}
        else if(len==1) {return nums[0]==target?0:-1;}
        
        boolean flag = false;//数组是否旋转标识
        if(nums[0]>nums[len-1]) {flag = true;}
        
        //用二分法找出最大数的索引mid（假设为无重复一次旋转有序数组）
        int mid = ms(nums,0,len-1);
//        System.out.println("mid"+mid+flag);
        
        if(!flag) {ans = bs(nums,target);}
        else if(target<nums[0]) {//旋转，且向右边查找
            if(target<nums[mid+1]||target>nums[len-1]) {return -1;}//判断target是否超界
            ans = mid+1+bs(Arrays.copyOfRange(nums, mid+1, len),target);
        }else if(target>nums[len-1]) {//旋转，且向左边查找
            if(target<nums[0]||target>nums[mid]) {return -1;}
            ans = bs(Arrays.copyOfRange(nums, 0, mid+1),target);
        }
        //结果检查
        if(ans == -1) {return -1;}//防止越界错误
        else {return nums[ans]==target?ans:-1;}//二分法查找中间结果可能为-1但ans并不为-1
    }
    
    public static int ms(int[] nums,int s,int e) {
        /*
         * 二分法找出最大数的索引mid（假设为无重复且有一次旋转有序数组）
         * 注意输入参数是闭区间[s,e]
         */
        if(s==e) {return s;}
        if(nums[s]<nums[e]) {return e;}//说明此区间内为有序，最大数索引为e
        //此区间包含旋转，且s<e
        int mid = (s+e)/2;//分治 
        if(nums[s]>nums[mid]) {
            return ms(nums,s,mid);
        }else if(nums[mid+1]>nums[e]) {//此处mid+1<=e，
            return ms(nums,mid+1,e);
        }
        
        return mid;
    }
    
    public static int bs(int[] nums,int target) {
        /*
         * 二分查找法，输出目标对应索引
         * 输入必须为有序数组
         */
        int len = nums.length;
        int ans = -1;
        if(len==0) {return -1;}
        else if(len==1) {return nums[0]==target?0:-1;}
        if(target<nums[0]||target>nums[len-1]) {return -1;}//越界检查
        
        int mid = len/2;//分治
        
        if(target<nums[mid]) {
            ans = bs(Arrays.copyOfRange(nums, 0, mid),target);
        }else if (target>nums[mid]) {
            ans = mid + 1 + bs(Arrays.copyOfRange(nums, mid+1, len),target);
        }else if (target==nums[mid]){ans = mid;}
        //结果检查
        if(ans == -1) {return -1;}//防止递归中越界错误
        else {return nums[ans]==target?ans:-1;}
    }
}
