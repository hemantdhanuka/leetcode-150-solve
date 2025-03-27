import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q0215A {
    public static void main(String[] args) {
        Q0215A obj = new Q0215A();
        System.out.println(obj.findKthLargest(new int[]{7,3,2,3,1,5,10, 8}, 3));
    }

    // Approach-2
    // O(n)
    public int findKthLargest(int[] nums, int k) {
        int l=0;
        int r=nums.length-1;
        k=nums.length - k + 1;
        int kthElement = 0;
        while(true){
            int mid = quickSort(l,r, nums);

            if(mid == k-1){
                kthElement = nums[mid];
                break;
            }
           else if(mid < k-1){
                l= mid+1;
            }else{
                r= mid-1;
            }
        }

        return kthElement;
    }



    // it will return position of pivot element
//    public int quickSort(int l, int r, int nums[]){
//        int mid = (l + r) / 2;
//        int midElement = nums[mid];
//
//        int elementLessThanMid = 0;
//
//        for(int i=l;i<=r;i++){
//            if(nums[i] < midElement){
//                elementLessThanMid ++;
//            }
//
//        }
//
//        int newMidPosition = l + elementLessThanMid;
//
//        // do quick sort
//        // swap mid and newMidPosition values
//        this.swap(mid, newMidPosition, nums);
//
//        while(l<newMidPosition){
//            if(nums[l] >= nums[newMidPosition]){
//                while(true){
//                    if(nums[r] < nums[newMidPosition]){
//                        break;
//                    }else{
//                        r--;
//                    }
//                }
//
//                // swap
//                this.swap(l, r, nums);
//                r--;
//                l++;
//            }else{
//                l++;
//            }
//        }
//
//        return newMidPosition;
//    }


    // approach 2
    public int quickSort(int l, int r, int nums[]){
        int pivotIndex = l;

        int j = l+1;

        while(j<=r){
            if(nums[j] < nums[pivotIndex]){
                swap(j, pivotIndex, nums);
                swap(pivotIndex+1, j, nums);
                pivotIndex++;
                j++;
            }else{
                j++;
            }
        }

        return pivotIndex;
    }
    public void swap(int i, int j, int array[]){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
