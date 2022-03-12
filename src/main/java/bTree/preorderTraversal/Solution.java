package bTree.preorderTraversal;

import bTree.utils.GenTree;
import bTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = GenTree.getTree();
        System.out.println(solution.preorderTraversal(tree));
        System.out.println(solution.preorderTraversal01(tree));
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
    public List<Integer> preorderTraversal01(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop!=null){
                if (pop.right!=null)stack.push(pop.right); // 右
                if (pop.left!=null)stack.push(pop.left); //  左
                stack.push(pop); // 中
                stack.push(null);
            }else {
                if (!stack.isEmpty()){
                    TreeNode pop1 = stack.pop();
                    result.add(pop1.val);
                }
            }
        }
        return result;
    }
}
