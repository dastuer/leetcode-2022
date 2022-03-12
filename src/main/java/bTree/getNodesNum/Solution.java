package bTree.getNodesNum;

import bTree.TreeNode;
import bTree.utils.GenTree;

/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = GenTree.getCompleteTree(10000 );
        System.out.println(solution.getNodesNum(tree));
        System.out.println(solution.getNodesNum01(tree));
    }
    // 一般二叉树
    public int getNodesNum(TreeNode root){
        if (root==null)return 0;
        return getNodesNum(root.left)+getNodesNum(root.right)+1;
    }
    // 满二叉树：最后一层从左开始第一个节点到最后一个节点无空隙
    public int getNodesNum01(TreeNode root){
        if (root==null)return 0;
        int leftCount = 0;
        int rightCount = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left!=null){
            leftCount++;
            left = left.left;
        }
        while (right!=null){
            rightCount++;
            right = right.right;
        }
        if (leftCount==rightCount){
            return (2<<leftCount)-1;
        }
        return getNodesNum01(root.left)+getNodesNum01(root.right)+1;
    }
}
