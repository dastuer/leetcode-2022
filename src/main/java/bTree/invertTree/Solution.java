package bTree.invertTree;

import bTree.TreeNode;
import bTree.utils.GenTree;
import bTree.utils.TreeUtils;

import java.util.LinkedList;

/**
 * 226.翻转⼆叉树
 * 题⽬地址：https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转⼀棵⼆叉树
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode tree = GenTree.getTree();
        Solution solution = new Solution();
        TreeNode tree1 = solution.invertTree(tree);
        TreeUtils.levelOrder(tree1);
    }
    public TreeNode invertTree(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            TreeNode tmp = pop.left;
            pop.left = pop.right;
            pop.right = tmp;
            if (pop.right!=null)stack.push(pop.right);
            if (pop.left!=null)stack.push(pop.left);
        }
        return root;
    }
}
