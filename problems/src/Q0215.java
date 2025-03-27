import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q0215 {
    public static void main(String[] args) {
        Q0215 obj = new Q0215();
        System.out.println(obj.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    // Heap
    // O(nlogk)
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        for(int i=0;i<nums.length;i++){
            int number = nums[i];
            if(i < k){
                minHeap.add(number);
            }
            else {
                int minK = minHeap.peek();
                if(number > minK){
                    minHeap.add(number);
                    minHeap.remove();
                }
            }
        }

        return minHeap.peek();
    }

}
