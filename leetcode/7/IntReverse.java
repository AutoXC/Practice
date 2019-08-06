package no7;

public class IntReverse {

    public static void main(String[] args) {
        int x = -1999999999;
        int ans = reverse(x);
        System.out.println(ans);
    }

    public static int reverse(int x) {
        char[] c = Integer.toString(x).toCharArray();
        int len = c.length;
        if (x < 0) {
            for (int i = 1, j = len - 1; i < j; i++, j--) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }
        } else {
            for (int i = 0, j = len - 1; i < j; i++, j--) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }
        }
        try {
            return Integer.parseInt(new String(c));
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            return 0;
        }
    }
}
