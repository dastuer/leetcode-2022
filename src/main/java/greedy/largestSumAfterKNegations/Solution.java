package greedy.largestSumAfterKNegations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
    public int largestSumAfterKNegations(int[] nums,int k){
        nums = Arrays.stream(nums).boxed().
                sorted(Comparator.comparingInt(Math::abs)).
                mapToInt(Integer::intValue).
                toArray();
        for (int i = nums.length-1; i >=0; i--) {
            if (k==0)break;
            int val = nums[i];
            if (val<0){
                nums[i] = -val;
                k--;
            }
            if (i==0&&k>0){
                val = k%2==1?-val:val;
                nums[i] = val;
            }
        }
        return IntStream.of(nums).sum();
    }
}
