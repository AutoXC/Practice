package no46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NoSameNum {
    public static void main(String[] args) {
        long start = System.nanoTime();

        System.out.println(permute(new int[] {1,2,3}));
        
        long end = System.nanoTime();
        System.out.println(end - start + "ns");
    }

    public static void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        // if all integers are used up
        //当first走到最后说明nums内已经排列完毕
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        //nums中first以前的索引已经排列完毕
        //现在开始搜索此时first能够指向的值（遍历first以后的索引）
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            //将遍历到的值位置转换到first处
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            //开始探索
            backtrack(n, nums, output, first + 1);
            // backtrack 回溯，将遍历到的值放回原处，开始下一次遍历
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

}
