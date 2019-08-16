package no78;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        HashSet<List<Integer>> out = new HashSet();
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums) {
            nums_lst.add(num);
        }
        out.add(new ArrayList<Integer>());
        for(int n = 1;n<nums.length+1;n++) {
            backtrack(n,nums_lst,out,0);
        }
        
        output.addAll(out);
        return output;
    }
    
    public static void backtrack(int n,ArrayList<Integer> nums,HashSet<List<Integer>> out,int index) {
        if(index == n) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0;i<n;i++) {temp.add(nums.get(i));}
//            Collections.sort(temp);
            out.add(temp);
        }
        for(int i = index;i<nums.size();i++) {
            Collections.swap(nums, index, i);
            // use next integers to complete the permutations
            //开始探索
            backtrack(n, nums, out, index + 1);
            // backtrack 回溯，将遍历到的值放回原处，开始下一次遍历
//            Collections.swap(nums, index, i);
        }
    }
}
