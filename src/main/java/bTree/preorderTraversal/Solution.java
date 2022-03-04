package bTree.preorderTraversal;

import bTree.RandomBTreeGenerator;
import bTree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        bTree.inorderTraversal.Solution solution = new bTree.inorderTraversal.Solution();
        TreeNode tree = RandomBTreeGenerator.getTree();
        System.out.println(solution.inorderTraversal(tree));
    }
    public List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right!=null){
                stack.push(pop.right);
            }
            if (pop.left!=null){
                stack.push(pop.left);
            }
        }
        return result;
    }
}
