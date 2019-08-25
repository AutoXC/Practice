package no557;

public class ReverseStringWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
    
    public static String reverseWords(String s) {
        /*
         * 效率高
         */
        String[] arr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<arr.length;i++) {
            StringBuilder word = new StringBuilder(arr[i]);
            word.reverse();
            if(i==0) {ans.append(word);}
            else {ans.append(" ").append(word);}
        }
        return ans.toString();
    }
    
    public static String reverseWords0(String s) {
        String[] arr = s.split(" ");
        String ans = "";
        for(int i = 0;i<arr.length;i++) {
            StringBuilder word = new StringBuilder(arr[i]);
            word.reverse();
            arr[i] = word.toString();
            if(i==0) {ans += arr[i];}
            else {ans += " " + arr[i];}
        }
        return ans;
    }
}
