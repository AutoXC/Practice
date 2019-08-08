package no11;

public class MaxArea {
    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }

    public static int maxArea(int[] height) {
        /* 双指针 */
        int n = height.length;
        int ans = 0;
        for (int i = 0, j = n - 1; i < j;) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j])
                i++;
            else
                j--;
        }
        return ans;
    }

    public static int maxArea0(int[] height) {
        /* 暴力解 */
        int n = height.length;
        int ans = 0;
        int outmax = 0;
        for (int i = 0; i < n - 1; i++) {
            if (height[i] > height[outmax])
                outmax = i;
            if (height[i] < height[outmax])
                continue;
            for (int j = i + 1; j < n; j++) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                ans = temp > ans ? temp : ans;
            }
        }
        return ans;
    }
}
