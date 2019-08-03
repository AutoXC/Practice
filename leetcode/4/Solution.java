package no4;

class Solution {
    public static void main(String[] args) {
        int[] nums1 = {3,4};
        int[] nums2 = {1,2};
        double i = findMedianSortedArrays(nums1, nums2);
        System.out.println(i);
    }
    
    public static double findMedianSortedArrays(int[] A, int[] B) {
        /*
         * 正解，时间复杂度为log（m + n）
         * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution
         * /xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
         */
        int m = A.length;
        int n = B.length;
        
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    
    public static double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        /*
         * 一般解法，并不符合题意
         */
        int i = 0;
        int j = 0;
        int[] all = new int[nums1.length+nums2.length];
        while (i+j<nums1.length+nums2.length) {
            if((j==nums2.length)||(i<nums1.length&&nums1[i]<nums2[j])) {
                all[i+j]=nums1[i];
                i++;
            }else {
                all[i+j]=nums2[j];
                j++;
            }
        }
        if(all.length%2==1) {return (double) all[all.length/2];}
        else {return (all[all.length/2]+all[all.length/2-1])/2.0;}
    }
    
    
}
