public class Q0042 {

    public static void main(String[] args) {
        Q0042 obj = new Q0042();
        int trappedRain = obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(trappedRain);
    }

//    public int trap(int[] height) {
//        int leftMax[] = new int[height.length];
//        int rightMax[] = new int[height.length];
//
//        int max = -1;
//        for(int i=0;i<leftMax.length;i++){
//            max = Math.max(max, height[i]);
//            leftMax[i] = max;
//        }
//
//         max = -1;
//        for(int i=rightMax.length-1;i>=0;i--){
//            max = Math.max(max, height[i]);
//            rightMax[i] = max;
//        }
//
//        int trappedRain = 0;
//        for(int i=0;i<height.length;i++){
//            int min = Math.min(leftMax[i], rightMax[i]);
//            trappedRain = trappedRain + min - height[i] ;
//        }
//
//        return trappedRain;
//
//    }


    // Approach 2
    // 2 pointers
    public int trap(int[] height) {
        int maxLeft = -1;
        int maxRight = -1;

        int left = 0;
        int right = height.length-1;
        int trappedWater = 0;
        while(left<=right) {
            if(maxLeft < maxRight) {

                int possibleHeight = Math.min(maxLeft, maxRight);
                if(height[left] < possibleHeight){
                    trappedWater += possibleHeight - height[left];
                }

                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            }
            else{

                int possibleHeight = Math.min(maxLeft, maxRight);
                if(height[right] < possibleHeight){
                    trappedWater += possibleHeight - height[right];
                }

                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }

        return trappedWater;
    }

}
