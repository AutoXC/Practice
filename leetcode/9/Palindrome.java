package no9;

import java.util.ArrayList;

public class Palindrome {
    
    public static void main(String[] args) {
        int x = 12;      
        System.out.println(isPalindrome(x));
    }
    
    public static boolean isPalindrome(int x) {
        /**
         * 最快
         */
        if (x<0) return false;
        if (x==0) return true;
        String s = Integer.toString(x);
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s);
        sb2.reverse();

        return sb1.toString().equals(sb2.toString());
    }
    
    public static boolean isPalindrome0(int x) {
        /**
         * 普通字符串方式
         */
        if (x<0) return false;
        if (x==0) return true;
        char[] arr = Integer.toString(x).toCharArray();
        for(int i = 0, j = arr.length-1;i<j;i++,j--) {
            if(arr[i]!=arr[j]) return false;
        }
        return true;
    }
    
    public static boolean isPalindrome1(int x) {
        /**
         * 数值计算方式
         */
        if (x<0) return false;
        if (x==0) return true;
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for (int next = x; next>0; next /= 10) {arr.add(next%10);}

        for(int i = 0, j = arr.size()-1;i<j;i++,j--) {
            int temp1 = arr.get(i);
            int temp2 = arr.get(j);
            if(temp1!=temp2) return false;
        }
        return true;
    }
}
