package no62;

public class UnequePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(99, 99));
    }
    
    public static int uniquePaths(int m, int n) {
        int[][] ans = new int[m+1][n+1];
        for(int i = 1;i<m+1;i++) {ans[i][1]=1;}
        for(int i = 1;i<n+1;i++) {ans[1][i]=1;}
        for(int i = 2;i<m+1;i++) {
            for(int j = 2;j<n+1;j++) {
                ans[i][j] = ans[i][j-1] + ans[i-1][j];
            }
        }
        return ans[m][n];
    }
}
