package no20;

import java.util.LinkedList;

public class ValidKuohao {
    public static void main(String[] args) {
        long start = System.nanoTime();
        
        String s = "((";
        System.out.println(isValid(s));
        
        long end = System.nanoTime();
        System.out.println(end-start);
    }
    
    public static boolean isValid(String s) {
        /*
         * 注意考虑输入s大小的边界值 
         * 注意检查stack的size
         */
        int len = s.length();
        if(len==0) {return true;}
        if(len==1) {return false;}
        
        String l = "({[";
        String r = "]})";
        LinkedList<String> stack = new LinkedList<String>();
        for (int i = len -1;i>=0;i--) {
            String temp = s.substring(i, i+1);
            if(r.contains(temp)) {stack.add(temp);}
            else if(l.contains(temp)) {
                if(stack.size()==0) {return false;}
                String stackOut = stack.getLast();
                if(stackOut.equals("]")) {
                    if(!temp.equals("[")) {return false;}
                    else stack.removeLast();
                }
                else if(stackOut.equals("}")) {
                    if(!temp.equals("{")) {return false;}
                    else stack.removeLast();
                }
                else if(stackOut.equals(")")) {
                    if(!temp.equals("(")) {return false;}
                    else stack.removeLast();
                }
            }
        }

        if(stack.size()==0) {return true;}
        return false;
    }
}
