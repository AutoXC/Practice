package no10;

public class Match {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "aab*a*";
        System.out.println(isMatch(s,p));
        
    }
    /**
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *，其中 '.' 匹配任意单个字符
     *                                                    '*' 匹配零个或多个前面的那一个元素
     */
    
    public static boolean isMatch(String s, String p) {
        if(p.length()==0&&s.length()!=0) return false;
        if(p.length()==0&&s.length()==0) return true;
        
        int ip = 0;
        String ms = "";
        while(ip<p.length()){
            if(ip+1<p.length()){
                if(p.charAt(ip+1)=='*'){
                    if(p.charAt(ip)=='.'){
                        ms += "[a-z]*";
                        ip += 2;
                    }else{
                        ms += "["+p.substring(ip,ip+1)+"]*";
                        ip += 2;
                    }
                }else{
                    if(p.charAt(ip)=='.'){
                        ms += "[a-z]";
                        ip++;
                    }else{
                        ms += "["+p.substring(ip,ip+1)+"]";
                        ip++;
                    }
                }
            }else{
                if(p.charAt(ip)=='.'){
                    ms += "[a-z]";
                    ip++;
                }else{
                    ms += "["+p.substring(ip,ip+1)+"]";
                    ip++;
                }
            }
        }
//        System.out.println(p+","+ms);
        return s.matches(ms);
    }
    
    public boolean isMatch0(String text, String pattern) {
        /* 
         * 回溯法
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/zheng-ze-biao-da-shi
         * -pi-pei-by-leetcode/ 来源：力扣（LeetCode）
         */
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    
    public boolean isMatch(String text, String pattern) {
        /*
         * 自下而上 ，动态规划
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/zheng-ze-biao-da
         * -shi-pi-pei-by-leetcode/ 来源：力扣（LeetCode）
         */
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

}
