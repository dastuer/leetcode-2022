package bTree;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = RandomBTreeGenerator.getTree();
        System.out.println(Arrays.toString(solution.averageOfLevels(tree)));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算树每层的平均值
     * @param root TreeNode类 根节点
     * @return double浮点型一维数组
     */
    double[] sums = new double[1000];
    int[] nodeCount = new int[1000];
    int levelCount = 0;
    public double[] averageOfLevels (TreeNode root) {
        if (root!=null){
            dfs(root,levelCount);
        }
        double[] result = new double[levelCount+1];
        for(int i=0;i<=levelCount;i++){
            result[i] = sums[i]/nodeCount[i];
        }
        return result;
        // write code here
    }
    public void dfs(TreeNode root,int k){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            nodeCount[k]++;
            sums[k]+=root.val;
            levelCount = Math.max(levelCount,k);
        }else{
            sums[k]+=root.val;
            nodeCount[k]++;
            if(root.left!=null){
                dfs(root.left,k+1);
            }
            if(root.right!=null){
                dfs(root.right,k+1);
            }
        }
    }
}
class Solution2{
    public String shuffle (String s, int[] indices) {
        int sl = s.length();
        char[] chars = new char[sl];
        for (int i = 0; i < sl; i++) {
            chars[i] = s.charAt(indices[i]);
        }
        return new String(chars);
    }
}
