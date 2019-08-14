package no59;


public class LuoxuanJuzhen2 {
    public static void main(String[] args) {
        int n = 1;
        for(int[] nums:generateMatrix(n)) {
            for(int i:nums) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
    
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0, j =0;
        int loop = 0;
        int count = 1;
        while(count<=n*n) {
            if(count==n*n&&n%2==1) {
                ans[(n-1)/2][(n-1)/2]=count;
                break;
            }

            if(loop%4==0) {
                while(j<n-1-loop/4) {
                    ans[i][j++]=count;
                    count++;
                }
                loop++;
            }else if(loop%4==1) {
                while(i<n-1-loop/4) {
                    ans[i++][j]=count;
                    count++;
                }
                loop++;
            }else if(loop%4==2) {
                while(j>loop/4) {
                    ans[i][j--]=count;
                    count++;
                }
                loop++;
            }else {
                //注意一个循环完了后 控制惯性
                while(i>loop/4) {
                    ans[i][j]=count;
                    if(i==1 + loop/4) {
                        count++;
                        j++;
                        break;
                    }else {
                        i--;
                    }
                    count++;
                }
                loop++;
            }
        }
        
        return ans;
    }
}
