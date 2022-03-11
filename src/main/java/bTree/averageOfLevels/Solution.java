package bTree.averageOfLevels;

import bTree.RandomBTreeGenerator;
import bTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.averageOfLevels(RandomBTreeGenerator.getTree())));
    }
    // 层次优先遍历
    public List<Double> averageOfLevels01(TreeNode root){
        ArrayList<Double> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            double total = 0;
            int oldSize = queue.size();
            for (int i = 0; i < oldSize; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null)
                    queue.offer(poll.left);
                if (poll.right!=null)
                    queue.offer(poll.right);
                total+= poll.val;
            }
            result.add(total/ oldSize);
        }
        return result;
    }
    // 深度优先遍历
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
