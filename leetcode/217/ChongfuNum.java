package no217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChongfuNum {
    public static void main(String[] args) {
        int[] n = {3,2,23,6,7,23,7,2,4,0,8,3,7,9,3,5,2,0,1,46,1};
        guibing(n, 0, n.length);
        System.out.println(Arrays.toString(n));
    }
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n : nums) {
            if(set.contains(n)) {return true;}
            else {set.add(n);}
        }
        return false;
    }
    
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++) {
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
    
    public void kuaipai(int[] nums,int s,int e) {
        if(nums.length<2||e-s<2) {return;}
        int compare = nums[e-1];
        int index = s;
        for(int i = s;i<e-1;i++) {
            if(nums[i]<=compare) {
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,index,e-1);
        if(index>s+1) {kuaipai(nums,s,index);}
        if(index<e-1) {kuaipai(nums,index+1,e);}
    }
    
    public void swap(int[] nums, int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void guibing(int[] nums, int s,int e) {
        if(nums.length<2||e-s<2) {return;}
        int mid = (s+e)/2;
        guibing(nums,s,mid);
        guibing(nums,mid,e);
        
        merge(nums,s,mid,e);
    }
    
    public static void merge(int[]nums,int s,int mid, int e) {
        int start = s;
        int end1 = mid;
        int end2 = e;
        int[] temp = new int[e-s];
        int index = 0;
        while(s<end1||mid<end2) {
            if(s>=end1||(mid<end2&&nums[mid]<nums[s])) {
                temp[index] = nums[mid];
                index++;
                mid++;
            }else {
                temp[index] = nums[s];
                index++;
                s++;
            }
        }
        for(int i = 0;i<temp.length;i++) {
            nums[start++] = temp[i];
        }
    }
}
