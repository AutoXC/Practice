package no70;

public class ClimbLouti {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbStairs(n));
        System.out.println(Integer.MAX_VALUE);
    }
    
    public static int climbStairs0(int n) {
        if(n==0) return 0;
        else if(n==1) return 1;
        else if(n==2) return 2;
        return climbStairs0(n-1)+climbStairs0(n-2);
        
    }
    
    public static int climbStairs(int n) {
        int[] ans = new int[n+1];
        if(n>0) ans[1]=1;
        if(n>1) ans[2]=2;
        for(int i = 3;i<n+1;i++) {
            ans[i]=ans[i-1]+ans[i-2];
        }
        return ans[n];
    }
    
}
