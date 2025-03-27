public class Q0172 {
    public static void main(String[] args) {
        Q0172 obj = new Q0172();

        System.out.println(obj.trailingZeroes(20));
    }


    public int trailingZeroes(int n) {
        // assumming jitni 5 ke factor millenge that is our answer.

        int factor = 3125;
        int countOf5 = 5;
        int answer = 0;
        int lastDivider = 0;
        while(factor >= 5 ){
            int divider = n / factor;
            answer += countOf5*(divider-lastDivider);
            lastDivider = divider;
            factor = factor / 5;
            countOf5--;
        }

        return answer;
    }
}
