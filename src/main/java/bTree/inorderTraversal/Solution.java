package bTree.inorderTraversal;

import bTree.RandomBTreeGenerator;
import bTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = RandomBTreeGenerator.getTree();
        System.out.println(solution.inorderTraversal(tree));
        System.out.println(solution.inorderTraversal01(tree));
    }
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = root;
//        stack.push(root);
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;  // 左
            }else {
                TreeNode pop = stack.pop();
                res.add(pop.val);   // 中
                if (pop.right!=null){
                    cur = pop.right; // 右
                }
            }
        }
        return res;
    }
    // 就是要处理的节点放⼊栈之后，紧接着放⼊⼀个空指针作为标记
    // 空节点标记法
    public List<Integer> inorderTraversal01(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.peek();
            if (top!=null){
                TreeNode pop = stack.pop();
                if (pop.right!=null)stack.push(pop.right);// 右
                stack.push(pop);                          // 中
                stack.push(null);
                if (pop.left!=null)stack.push(pop.left);  // 左
            }else {
                stack.pop();
                if (!stack.isEmpty()){
                    TreeNode pop = stack.pop();
                    res.add(pop.val);
                }

            }
        }
        return res;

    }
}
