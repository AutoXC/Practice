package no54;

import java.util.ArrayList;
import java.util.List;

public class LuoxuanJuzhen {
    public static void main(String[] args) {
        int[][] a = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(spiralOrder(a));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int m = matrix.length;
        if(m==0) return ans;
        int n = matrix[0].length;
        if (n==0) return ans;
        
        int i = 0, j =0;
        int loop = 0;
        int count = 0;
        while(count<m*n) {
            if(count==m*n-1&&n==m&&n%2==1) {
                ans.add(matrix[(n-1)/2][(m-1)/2]);
                break;
            }

            if(loop%4==0) {
                while(count<m*n&&j<n-1-loop/4) {
                    ans.add(matrix[i][j++]);
                    count++;
                }
                loop++;
            }else if(loop%4==1) {
                while(count<m*n&&i<m-1-loop/4) {
                    ans.add(matrix[i++][j]);
                    count++;
                }
                loop++;
            }else if(loop%4==2) {
                while(count<m*n&&j>loop/4) {
                    ans.add(matrix[i][j--]);
                    count++;
                }
                loop++;
            }else {
                //注意一个循环完了后 控制惯性
                while(count<m*n&&i>loop/4) {
                    ans.add(matrix[i][j]);
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
