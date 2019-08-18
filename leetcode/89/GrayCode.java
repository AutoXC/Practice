package no89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(1>>0);
    }
    
    public List<Integer> grayCode(int n) {
        /*
         * 二进制数转格雷码
         * 最高位保留，其余按如下异或
         * G(n) = B(n+1) XOR B(n)
         */
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res; 
    }
    
    public List<Integer> grayCode1(int n) {
        /*
         * 镜像法
         */
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
    
    public static List<Integer> grayCode0(int n) {
        char[] c = new char[n];
        Arrays.fill(c, '0');
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> ansSet = new ArrayList<Integer>();
        ansSet.add(0);
        
        backtrack(c,ansSet,ans);
        return ans;
    }
    
    public static void backtrack(char[] c,ArrayList<Integer> ansSet,ArrayList<Integer> ans) {
        if(ansSet.size()==(int) Math.pow(2, c.length)) {
            ans.addAll(ansSet);
        }
        
        for(int i = c.length-1;i>-1;i--) {
            c[i] = c[i]=='0'?'1':'0';
            int num = Integer.parseInt(new String(c), 2);
            if(ansSet.contains(num)) {break;}
            ansSet.add(num);
            backtrack(c,ansSet,ans);
            c[i] = c[i]=='0'?'1':'0';
        }
    }
}
