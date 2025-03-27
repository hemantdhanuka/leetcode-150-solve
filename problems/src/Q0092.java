import java.util.List;

public class Q0092 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }


        ListNode previous = null;
        ListNode current = head;

        ListNode lthNode = null;
        ListNode lthPreviousNode = null;
        ListNode rthNode = null;
        ListNode rthNextNode = null;


        int count = 1;
        while (count < left) {
            previous = current;
            current = current.next;
            count++;
        }

        lthNode = current;
        lthPreviousNode = previous;

        //move l+1 th node.
        previous = current;
        current = current.next;
        count++;

        while(count <= right){
            ListNode next = current.next;
            current.next = previous;

            previous = current;
            current = next;
            count++;
        }

        rthNode = previous;
        rthNextNode = current;

        if(lthPreviousNode == null){
            head = rthNode;
            lthNode.next = rthNextNode;
        }else{
            lthPreviousNode.next = rthNode;
            lthNode.next = rthNextNode;
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
