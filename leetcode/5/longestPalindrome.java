package no5;

public class Solution {
    public static void main(String[] args) {
        String s = "asd";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }
    
    public static String longestPalindrome(String s) {
        /*
         * 非动态规划，遍历求解(中心扩展法)
         * 第一层i遍历整个字符串
         * 第二层遍历考虑两种情况，奇数和偶数回文子串；注意临界条件
         * 注意给定字符串s为空和无回文子串的情况
         * 
         * 动态规划
         * 
         * Manacher 算法
         */
        int count = 1;
        char[] arr = s.toCharArray();
        String ans = null;
        
        if (s.length()==0) {return "";}
        
        for (int i = 0; i < s.length(); i++) {
            int j = 1;
            int temp = 1;
            while (i-j>-1 && i+j<s.length()) {
                if(arr[i-j]==arr[i+j]) {
                    temp += 2;
                    if (temp>count) {
                        count = temp;
                        ans = s.substring(i-j, i+j+1);
                    }
                    j++;
                }else {break;}
            }
            
            j = 1;
            temp = 0;
            while(i-j+1>-1 && i+j<s.length()) {
                if(arr[i-j+1]==arr[i+j]) {
                    temp += 2;
                    if (temp>count) {
                        count = temp;
                        ans = s.substring(i-j+1, i+j+1);
                    }
                    j++;
                }else {break;}
            }
        }
        
        if(count == 1) {ans = Character.toString(arr[0]);}
        System.gc();
        return ans;
    }
    
    public String longestPalindrome0(String s) {
        /*
         * 作者：windliang
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-xi-tong-su-de-
         * si-lu-fen-xi-duo-jie-fa-bao-gu/ 来源：力扣（LeetCode）
         * 
         */
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }
}
