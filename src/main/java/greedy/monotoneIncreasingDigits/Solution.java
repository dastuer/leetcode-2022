package greedy.monotoneIncreasingDigits;

/**
 * 738.单调递增的数字
 * 给定⼀个⾮负整数 N，找出⼩于或等于 N 的最⼤的整数，同时这个整数需要满⾜其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满⾜ x <= y 时，我们称这个整数是单调递增的。）
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.monotoneIncreasingDigits(100));
    }
    public int monotoneIncreasingDigits(int num){
        StringBuilder numStr = new StringBuilder(num+"");
        boolean hasDesc = false;
        for (int i = 1; i < numStr.length(); i++) {
            if (hasDesc){
                numStr.replace(i,i+1,"9");
            }
            else if (numStr.charAt(i-1) > numStr.charAt(i)){
                String s = (char)(numStr.charAt(i - 1) - 1) +"";
                numStr.replace(i-1,i, s);
                numStr.replace(i,i+1,"9");
                hasDesc = true;
            }
        }
        return Integer.parseInt(numStr.toString());

//        String numStr = num+"";
//        int[] nums = new int[numStr.length()];
//        for (int i = num,n=nums.length-1; i>0&&n>=0; i/=10,n--) {
//            nums[n] = i % 10;
//        }
//        boolean hasDec = false;
//        int result = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (hasDec){
//                nums[i] = 9;
//            }
//            else if (nums[i] < nums[i-1]){
//                nums[i-1]--;
//                nums[i] = 9;
//                hasDec = true;
//            }
//        }
//        for (int i = nums.length-1,n=1; i >=0; i--,n*=10) {
//            result += nums[i]*n;
//        }
//        return result;
    }
}
