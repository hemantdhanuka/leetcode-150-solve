import java.util.List;

public class Q0061 {

    public static void main(String[] args) {

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode rotateRight(ListNode head, int k) {
        int n = this.getTotalNodes(head);

        // if no nodes.
        if(n==0){
            return head;
        }

        k = k % n;

        // no shifts
        if(k==0){
            return head;
        }

        // find lastNode
        int lastNodePosition = n - k;
        int count = 1;
        ListNode curr = head; //
        while(count != lastNodePosition){
            curr = curr.next;
            count++;
        }
        ListNode lastNode = curr;


        ListNode newRootNode = lastNode.next;
        lastNode.next = null;

        ListNode currLastNode = this.getLastNode(newRootNode);
        currLastNode.next = head;

        return newRootNode;
    }

    private int getTotalNodes(ListNode head){
        if(head == null){
            return 0;
        }

        int total = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            total++;
        }
        return total;
    }

    private ListNode getLastNode(ListNode head){
        while(head.next != null){
            head = head.next;
        }

        return head;
    }
}
