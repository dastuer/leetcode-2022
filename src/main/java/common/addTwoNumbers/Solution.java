package common.addTwoNumbers;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(){

    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode reHead = new ListNode(0);
        ListNode reL = reHead;
        int carry = 0;
        while (l1!=null||l2!=null||carry!=0){
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;
            int sum = (val1+val2+carry);
            int reVal = sum%10;
            carry = sum/10;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            reL.next = new ListNode(reVal);
            reL = reL.next;
        }
        return reHead.next;
    }
}
