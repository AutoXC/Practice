package no292;

public class Nim {
    public boolean canWinNim(int n) {
        /*
         * 要想获胜，在你的回合中，必须避免石头堆中的石子数为 4 的情况
         */
        n %= 4;
        if(n==0) {return false;}
        else{return true;}
    }
}
