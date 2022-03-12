package bTree.maxDepth;

import bTree.TreeNode;
import bTree.utils.GenTree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = GenTree.getTree();
        System.out.println(solution.maxDepth(tree));
    }
    public int maxDepth(TreeNode root){
        if (root==null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
