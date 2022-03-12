package bTree.minDepth;

import bTree.TreeNode;
import bTree.utils.GenTree;

import java.util.LinkedList;

/**
 * 111.⼆叉树的最⼩深度
 * 题⽬地址：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 给定⼀个⼆叉树，找出其最⼩深度。
 * 最⼩深度是从根节点到最近叶⼦节点的最短路径上的节点数ᰁ。
 * 说明: 叶⼦节点是指没有⼦节点的节点
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = GenTree.getTree(10000000,10000001);
        long b1 = System.currentTimeMillis();
        System.out.println(solution.minDepth(tree));
        long e1 = System.currentTimeMillis();
        System.out.println(e1-b1);
        long b2 = System.currentTimeMillis();
        System.out.println(solution.minDepth(tree));
        long e2 = System.currentTimeMillis();
        System.out.println(e2-b2);
    }
    // 递归
    public int minDepth(TreeNode node){
        if (node==null)return 0;
        int leftDepth = minDepth(node.left);
        int rightDepth = minDepth(node.right);
        if (node.left!=null&&node.right==null){
            return leftDepth+1;
        }
        if (node.right!=null&&node.left==null){
            return rightDepth+1;
        }
        return Math.min(leftDepth,rightDepth)+1;
    }
    // 层次遍历
    public int minDepth01(TreeNode node){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int minDepth = 0;
        while (!queue.isEmpty()){
            int sc = queue.size();
            minDepth++;
            for (int i = 0; i < sc; i++) {
                TreeNode poll = queue.poll();
                if (poll!=null){
                    if (poll.left==null&&poll.right==null){
                        return minDepth;
                    }
                    if (poll.left!=null)queue.offer(poll.left);
                    if (poll.right!=null)queue.offer(poll.right);
                }
            }
        }
        return minDepth;
    }
}
