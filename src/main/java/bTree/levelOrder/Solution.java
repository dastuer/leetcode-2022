package bTree.levelOrder;

import bTree.utils.GenTree;
import bTree.TreeNode;

import java.util.*;

/**
 * 102.⼆叉树的层序遍历题⽬地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给你⼀个⼆叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
 *
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = GenTree.getTree();
        System.out.println(solution.levelOrder(tree));
        System.out.println(solution.levelOrderBottom(tree));
    }
    List<List<Integer>> levelOrder(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int qs = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < qs; i++) {
                TreeNode poll = queue.poll();
                integers.add(poll.val);
                if (poll.left!=null)queue.offer(poll.left);
                if (poll.right!=null)queue.offer(poll.right);
            }
            result.add(integers);
        }
        return result;
    }
    // 107.⼆叉树的层次遍历 II
    // 题⽬链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
    //给定⼀个⼆叉树，返回其节点值⾃底向上的层次遍历。 （即按从叶⼦节点所在层到根节点所在的层，逐
    //层从左向右遍历）
    List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> levelOrder = levelOrder(root);
        Collections.reverse(levelOrder);
        return levelOrder;

    }
}
