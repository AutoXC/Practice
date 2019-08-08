package no14;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] ss = {"dog","dracecar","dcar"};
        System.out.println(longestCommonPrefix(ss));
    }

    public static String longestCommonPrefix(String[] strs) {
        /**
         * 水平扫描
         * 其他方法：分治法，二分查找
         */
        String ans = "";
        if (strs.length==0) return ans;
        else if (strs.length == 1) return strs[0];
        //i表示字符串前i个字符
        for (int i = 1; i<strs[0].length()+1; i++) {
            String temp = strs[0].substring(0,i);
            boolean flag = true;
            //默认至少有2个字符串，从第二个(j=1)开始遍历
            for (int j = 1; j<strs.length;j++) {
                if(!strs[j].startsWith(temp)) {
                    flag = false;
                    return ans;
                }
            }
            if(flag) ans = temp;
            else break;
        }
        
        return ans;
    }
}
