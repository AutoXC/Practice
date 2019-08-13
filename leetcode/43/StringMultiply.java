package no43;

import java.util.ArrayList;

public class StringMultiply {
    public static void main(String[] args) {
        long start = System.nanoTime();
        
        String n1 = "123456789";
        String n2 = "987654321";
        System.out.println(multiply(n1, n2));
        
        long end = System.nanoTime();
        System.out.println(end-start);
    }
    
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")||num1==""||num2=="") {return "0";}
        
        ArrayList<String> s1 = new ArrayList<String>();
        ArrayList<String> s2 = new ArrayList<String>();
        int len1 = num1.length();
        int len2 = num2.length();
        for(int i = len1-1;-1<i;i--) {s1.add(num1.substring(i, i+1));}
        for(int i = len2-1;-1<i;i--) {s2.add(num2.substring(i, i+1));}
        
        ArrayList<String> ans = new ArrayList<String>();
        boolean first = true;
        while(!s2.isEmpty()) {
            boolean isten = false;
            for(int i = 0; i<len1||i<ans.size();i++) {
                if(first) {
                    ans.add(s1.get(i));
                }else {
                    if(i<len1) {
                        int temp1 = Integer.parseInt(ans.get(i));
                        int temp2 = Integer.parseInt(s1.get(i));
                        int sum = isten?(temp1 + temp2 + 1):(temp1 + temp2);
                        if(sum>=10) {
                            isten = true;
                            ans.set(i,Integer.toString(sum%10));
                            if(i==len1-1&&ans.size()==len1) {
                                ans.add("1");
                                isten=false;
                                break;
                            }
                        }else {
                            isten = false;
                            ans.set(i,Integer.toString(sum));
                        }
                    }else {
                        int temp = Integer.parseInt(ans.get(i));
                        
                        int sum = isten?(temp + 1):(temp);
                        if(sum>=10) {
                            isten = true;
                            ans.set(i,Integer.toString(sum%10));
                            if(i==ans.size()-1) {
                                ans.add("1");
                                isten=false;
                                break;
                            }
                        }else {
                            isten = false;
                            ans.set(i,Integer.toString(sum));
                            //break;
                        }
                    }
                    
                }
                
            }
            first = false;
            isnull(s2);
        }
        String s = "";
        for(int i = ans.size()-1;-1<i;i--) {
            s += ans.get(i);
        }
        return s;
    }
    
    public static void isnull(ArrayList<String> s) {
        int len = s.size();
        boolean ifzero = false;
        if(len==1&&s.get(0).equals("1")) {
            s.clear();
        }else if(len==1) {
            int temp = Integer.parseInt(s.get(0)) -1;
            s.set(0, Integer.toString(temp));
        }else if(len>1) {
            int temp = Integer.parseInt(s.get(0));
            if(temp==0) {
                ifzero = true;
                s.set(0, "9");
            }else {s.set(0, Integer.toString(temp-1));}
            
            for(int i = 1; ifzero&&i<len;i++) {
                temp = Integer.parseInt(s.get(i));
                if(i==len-1&&temp==1) {
                    s.remove(i);
                    ifzero = false;
                    break;
                }
                if(temp==0) {
                    ifzero = true;
                    s.set(i, "9");
                }else {
                    s.set(i, Integer.toString(temp-1));
                    ifzero = false;
                }
            }
        }
    }
}
