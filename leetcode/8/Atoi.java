package no8;

import java.util.ArrayList;

//示例 1:
//
//输入: "42"
//输出: 42
//示例 2:
//
//输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
//示例 3:
//
//输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
//示例 4:
//
//输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。
//示例 5:
//
//输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
//     因此返回 INT_MIN (−231) 。

public class Atoi {

    public static void main(String[] args) {
        String str = "+5345";
        System.out.println(myAtoi(str));
        

    }

    public static int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;

        char first = '\0';
        int index = 0;
        ArrayList<Character> ans= new ArrayList<Character>();
        
        int num = 0;

        if (len == 0)
            return 0;
        // 获得第一个非空字符
        for (int i = 0; i < len; i++) {
            if (arr[i] == ' ') {
                continue;
            }else {
                index = i;
                first=arr[i];
                break;
            }
        }
        
        if(first=='-'||first=='+') {
            if(index+1==len||'9'<arr[index+1]||arr[index+1]<'0') {return 0;}
            else {
                ans.add(first);
                for(int i = index+1;i<len;i++) {
                    if('9'<arr[i]||arr[i]<'0') {break;}
                    ans.add(arr[i]);
                }
            }
        }else if('0'<=first&&first<='9'){
            for(int i = index;i<len;i++) {
                if('9'<arr[i]||arr[i]<'0') {break;}
                ans.add(arr[i]);
            }
        }else {return 0;}
        
        try {
            char[] temp = new char[ans.size()];
            for(int i = 0;i<temp.length;i++) {temp[i]=ans.get(i);}
            num = Integer.parseInt(new String(temp));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            if(ans.get(0)=='-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        return num;
    }
}
