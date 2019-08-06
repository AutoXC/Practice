package no6;

public class Ztype {
    
    public static void main(String[] args) {
        String s = "PAHNAPLSIIGYIR";
        int n = 3;
        System.out.println(convert(s, n).equals(convert1(s, n)));
    }
    
    public static String convert1(String s, int numRows) {
        /*
         * 优化解，只考虑第i=range(numRows)行中原字符索引的规律
         * 本质上就两种情况：1.第一行和最后一行，索引间距为2numRows-2
         *              2.中间行，除了case1中的值，还要考虑间距为2(numRows-1-i)的中间值
         */
        if(s.length()==0 || numRows==0) {return "";}
        if(numRows==1 || numRows>s.length()) {return s;}
        
        char[] c = s.toCharArray();
        int len = c.length;
        char[] ans = new char[len];
        int index = 0;
        
        for(int i = 0;i<numRows;i++) {
            if(i==0 || i==numRows-1) {
                int temp = 0;
                int sIndex;
                while((sIndex = i+temp*(2*numRows-2)) < len) {
                    ans[index]=c[sIndex];
                    temp++;
                    index++;
                }
            }else {
                int temp = 0;
                int sIndex1;
                int sIndex2;
                while((sIndex1 = i+temp*(2*numRows-2)) < len) {
                    ans[index]=c[sIndex1];
                    index++;
                    if((sIndex2 = sIndex1+2*(numRows-1-i)) < len) {
                        ans[index]=c[sIndex2];
                        index++;
                    }
                    temp++;
                }
            }
        }
        return new String(ans);
    }
    
    public static String convert(String s, int numRows) {
        /*
         * 暴力解，按照观察规律存入二维数组中，再遍历取出
         */
        if(s.length()==0 || numRows==0) {return "";}
        if(numRows==1 || numRows>s.length()) {return s;}
        
        int index = 0;
        char[] c = s.toCharArray();
        char[][] arr = new char[numRows][(s.length()/numRows+1)*(numRows-1)];
        for(int i = 0;i<(s.length()/numRows+1);i++) {
            for(int j = 0;index<s.length()&&j<2*numRows-2;j++) {
                if (j<numRows) {arr[j][i*(numRows-1)]=c[index];}
                else {arr[2*numRows-2-j][i*(numRows-1)+j-numRows+1]=c[index];}
                index++;
            }
        }
        
        index = 0;
        for (int i = 0;i<arr.length;i++) {
            for(int j = 0;j<arr[0].length;j++) {
                if(arr[i][j]!='\0') {c[index]=arr[i][j];index++;}
            }
        }
        
        return new String(c);
    }
}
