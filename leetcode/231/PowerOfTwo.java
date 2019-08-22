package no231;

public class PowerOfTwo {
    
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        if(n==1) return true;
        if(n%2==1) return false;
        int next = n/2;
        return isPowerOfTwo(next);
    }
    
    public boolean isPowerOfTwo0(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
