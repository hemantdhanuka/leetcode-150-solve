import java.util.HashMap;

public class Q0219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<=nums.length;i++){
            int num = nums[i];

            int lastIndex = map.getOrDefault(num, Integer.MIN_VALUE - 1);

            if(Math.abs(i -lastIndex) <= k){
                return true;
            }

            map.put(num, i);
        }

        return false;

    }

}
