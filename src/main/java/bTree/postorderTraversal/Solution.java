package bTree.postorderTraversal;

import bTree.RandomBTreeGenerator;
import bTree.node.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        TreeNode tree = RandomBTreeGenerator.getTree();
        Solution solution = new Solution();
        System.out.println(solution.postorderTraversal(tree));
    }
    public List<Integer> postorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.left!=null)stack.push(pop.left);
            if (pop.right!=null)stack.push(pop.right);
        }
        Collections.reverse(result);
        return result;
    }
}
