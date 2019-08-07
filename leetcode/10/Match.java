package no10;

public class Match {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "ab*a*c*a";
        System.out.println(isMatch(s,p));
        //无法解决解决s=aaa;p=aab*a*之类问题，当考虑.*嵌入时也未解决
    }
    /**
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *，其中 '.' 匹配任意单个字符
     *                                                    '*' 匹配零个或多个前面的那一个元素
     */
    public static boolean isMatch(String s, String p) {
        if(p.length()==0&&s.length()!=0) return false;
        if(p.length()==0&&s.length()==0) return true;

        if(p.length()!=0&&s.length()==0) {
            int ip = p.length() - 1;
            if(p.charAt(ip)=='.'||('a'<=p.charAt(ip)&&p.charAt(ip)<='z')) return false;
            else return true;
        }
        
        int is = s.length() - 1;
        int ip = p.length() - 1;
        boolean ans = false;
        while(is>=0&&ip>=0) {
            if('a'<=p.charAt(ip)&&p.charAt(ip)<='z') {
                if(s.charAt(is)==p.charAt(ip)) {ans = true;}
                else {return false;}
            }
            else if(p.charAt(ip)=='.') {ans = true;}
            else {
                if(p.charAt(--ip)=='.') {return true;}
                else {
                    if(s.charAt(is)!=p.charAt(ip)) {
                        ans = true;
                        ip--;
                        continue;
                    }else {
                        while(0<=is&&s.charAt(is)==p.charAt(ip)) {
                            is--;
                        }
                        ans = true;
                        ip--;
                        continue;
                    }
                }
            }
            is--;
            ip--;
        }
        //考虑is和ip值
        if(is<ip) {
            while(0<=ip && p.charAt(ip)=='*') {
                ip -= 2;
            }
            if(ip>=0) return false;
        }
        if(is>ip) return false;
        return true;
    }
}
