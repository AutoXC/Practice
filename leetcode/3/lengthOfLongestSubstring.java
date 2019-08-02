import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    /*
     * 注意：
     *      1.设置断点必须保持递增，断点必须为重复元素后一位的索引值，断点前的值不再访问
     *      2.利用map添加字符数组中元素，考虑元素已存在和元素不存在时两种技术情况
     *      3.计数值count保持递增
     *      4.不管是否存在，字符数组中每个值都要做put操作
     *      5.最后考虑极端情况，即整个数组都不重复
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int count = 1;
        int cut = 0;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int temp;
            if (!m.containsKey(arr[i])) {
                temp = i - cut + 1;
            } else {
                // 保持cut断点是递增的
                cut = (m.get(arr[i]) + 1) > cut ? (m.get(arr[i]) + 1) : cut;
                // 保证cut断点前的值不再访问
                temp = i - cut + 1;
            }
            count = temp > count ? temp : count;
            m.put(arr[i], i);
        }
        if (m.size() == arr.length) {
            count = arr.length;
        }
        return count;
    }
}
