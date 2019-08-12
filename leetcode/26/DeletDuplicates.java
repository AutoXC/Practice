package no26;

import java.util.Arrays;

public class DeletDuplicates {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] n = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(n));
        
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
    
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len<2) {return len;}
        
        int index = 0;
        for(int i = 1; i<len; i++) {
            if(nums[i]==nums[index]) {continue;}
            else {nums[++index]=nums[i];}
        }

//        for(int i=0;i<len;i++) {System.out.print(nums[i]+",");}
//        System.out.println();
        return index+1;
    }
}
