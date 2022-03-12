package bTree.symmetricTree;

import bTree.TreeNode;

import java.util.LinkedList;

/**
 * 101. 对称⼆叉树
 * 题⽬地址：https://leetcode-cn.com/problems/symmetric-tree/
 * 给定⼀个⼆叉树，检查它是否是镜像对称的。
 */
public class Solution {
    public static void main(String[] args) {

    }
    // 递归法
    public boolean  isSymmetric(TreeNode root){
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }else if (left==null||right==null){
            return false;
        }else if (left.val != right.val){
            return false;
        }
        return compare(left.left,right.right)&&compare(left.right,right.left);
    }
    // 使用队列
    public boolean isSymmetric01(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.push(root.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if ((node1==null^node2==null)||
                    (node1!=null&&node1.val!=node2.val)){
                return false;
            }
            if (node1!=null){
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
        }
        return true;
    }
}
