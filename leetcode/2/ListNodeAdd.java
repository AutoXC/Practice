import java.util.ArrayList;

public class ListNodeAdd {
    public static void main(String[] args) {
        ListNode l11 =new ListNode(9);
        
        
        ListNode l21 =new ListNode(1);
        ListNode l22 =new ListNode(9);
//        ListNode l23 =new ListNode(9);
//        ListNode l24 =new ListNode(9);
//        ListNode l25 =new ListNode(9);
//        ListNode l26 =new ListNode(9);
//        ListNode l27 =new ListNode(9);
//        ListNode l28 =new ListNode(9);
//        ListNode l29 =new ListNode(9);
//        ListNode l210 =new ListNode(9);
        l21.next = l22;
//        l22.next = l23;
//        l23.next = l24;
//        l24.next = l25;
//        l25.next = l26;
//        l26.next = l27;
//        l27.next = l28;
//        l28.next = l29;
//        l29.next = l210;
        
        ListNode ans;
        ans = addTwoNumbers(l11, l21);
        System.out.println(ans.val+""+ans.next.val+""+ans.next.next.val);
    }
    /*
     * 注意的问题
     * 1.如果将链表中表示的数转成基本数据类型，可能超过基本数据类型能表示的最大值
     * 2.使用列表直接进行位对位加法，考虑位数是否对等（先假设对等写一个，再添加条件语句改其他情况），
     *                          考虑进位问题（特别是位数相等时的进位）
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList arr1 = new ArrayList();
        ArrayList arr2 = new ArrayList();
//        long num1 = 0;
//        long num2 = 0;
        //将数取出放入列表
        while (l1!=null){
            arr1.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            arr2.add(l2.val);
            l2 = l2.next;
        }
        System.out.println(arr1+"\r\n"+arr2);
        
//        for(int i=0;i<arr1.size();i++){
//            int temp1 =(int) arr1.get(i);
//            num1 += temp1*Math.pow(10,i);
//        }
//        for(int i=0;i<arr2.size();i++){
//            int temp2 =(int) arr2.get(i);
//            num2 += temp2*Math.pow(10,i);
//        }
//        System.out.println(num1+","+num2);
//        
//        long sum = num1 + num2;
        
        ArrayList<ListNode> arrSum = new ArrayList<ListNode>();
        boolean flag = false; //按位加法，进位标识
        //遍历两个数的每一位，不论是否对齐
        for(int i = 0;i<arr1.size()||i<arr2.size();i++) {
            //当索引i对应位都有数时
            if (i<arr1.size()&&i<arr2.size()) {
                int num1 = (int) arr1.get(i);
                int num2 = (int) arr2.get(i);
                int temp = flag ? (num1 + num2 + 1):(num1 + num2);
                //是否进位
                if (temp<10) {
                    arrSum.add(new ListNode(temp));
                    flag = false;
                }else {
                    //确认进位，考虑是否同时到达两数的最高位，暗含两数是否对齐
                    arrSum.add(new ListNode(temp%10));
                    flag = true;
                    if((i==arr1.size()-1)&&(i==arr2.size()-1)) {
                        arrSum.add(new ListNode(temp/10));
                    }
                }
            //i++后，索引i对应位有一组数无值时
            }else if (arr1.size()<arr2.size()) {
                int num2 = (int) arr2.get(i);
                int temp = flag ? (num2 + 1):(num2);
                if (temp<10) {
                    arrSum.add(new ListNode(temp));
                    flag = false;
                }else {
                    //进位确认，是否到达最高位
                    if (i != arr2.size()-1) {
                        arrSum.add(new ListNode(temp%10));
                        flag = true;
                    }else {
                        arrSum.add(new ListNode(temp%10));
                        arrSum.add(new ListNode(temp/10));
                    }
                    
                }
            }else {
                int num1 = (int) arr1.get(i);
                int temp = flag ? (num1 + 1):(num1);
                if (temp<10) {
                    arrSum.add(new ListNode(temp));
                    flag = false;
                }else {
                    if (i != arr1.size()-1) {
                        arrSum.add(new ListNode(temp%10));
                        flag = true;
                    }else {
                        arrSum.add(new ListNode(temp%10));
                        arrSum.add(new ListNode(temp/10));
                    }
                }
            }
            
        }
        
//        if (sum==0){
//            arrSum.add(new ListNode((int) sum));
//        }
//        while(sum!=0){
//            arrSum.add(new ListNode((int) (sum%10)));
//            sum = sum / 10;
//        }
        //为链表添加指向
        for(int i=0;i<arrSum.size()-1;i++){
            arrSum.get(i).next = arrSum.get(i+1);
        }
        
        return arrSum.get(0);
    }
}
