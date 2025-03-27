import java.util.*;

public class Q0373 {

    public static void main(String[] args) {
        Q0373 obj = new Q0373();

        System.out.println(obj.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 3 ));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // minHeap based on sum
        Queue<Pair> queue = new PriorityQueue<>();

        for(int i=0; i< nums1.length;i++){
            queue.add(new Pair(i,0, nums1[i]+nums2[0]));
        }

        List<List<Integer>> ansList = new ArrayList<>();

        while(k>0){
            Pair pair = queue.poll();
            ansList.add(Arrays.asList(nums1[pair.i], nums2[pair.j]));

            if(pair.j + 1 < nums2.length){
                queue.add(new Pair(pair.i, pair.j +1, nums1[pair.i]+ nums2[pair.j + 1]));
            }

            k--;
        }

        return  ansList;
    }

    class Pair implements Comparable<Pair> {
        int i;
        int j;

        int sum;

        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.sum != o.sum){
                return this.sum - o.sum;
            }else{
                return this.i - o.i;
            }
        }
    }

}
