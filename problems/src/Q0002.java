public class Q0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode root = null;
        ListNode curr = null;

        while(l1 !=null || l2!=null){
            int v1 = 0;
            if(l1!= null){
                v1 = l1.val;
                l1 = l1.next;
            }

            int v2 =0;
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }

            int sum = v1+v2+carry;
            int nodeVal = sum%10;
            carry = sum/10;

            if(curr == null){
                root = new ListNode(nodeVal);
                curr = root;
            }else{
                curr.next = new ListNode(nodeVal);
                curr = curr.next;
            }

        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}



