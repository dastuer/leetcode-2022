package bTree.utils;

import bTree.TreeNode;

import java.util.*;

public class GenTree {
    public static TreeNode getTree(int from,int to){
        TreeNode[] treeNodes = randomNodes(from,to);
        TreeNode root = treeNodes[0];
        int len = treeNodes.length;
        System.out.println("tree: \n"+Arrays.toString(treeNodes));
        System.out.println();
        for (int i = 0; i <= len/2; i++) {
            TreeNode cur = treeNodes[i];
            if (i*2+1<len){
                cur.left = treeNodes[i*2+1];
            }
            if (i*2+2<len){
                cur.right = treeNodes[i*2+2];
            }
        }
        return root;
    }
    public static TreeNode getTree(){
        return getTree(5,10);
    }
    public static TreeNode getTree(int n){
        return getTree(n,n+1);
    }
    public static TreeNode getCompleteTree(int from,int to){
        TreeNode[] treeNodes = randomNodes(from, to);
        System.out.println("tree: \n"+Arrays.toString(treeNodes));
        LinkedList<TreeNode> queue = new LinkedList<>(Arrays.asList(treeNodes));
        TreeNode tree = queue.poll();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        queue1.add(tree);
        while (!queue1.isEmpty()&&!queue.isEmpty()){
            int sc = queue1.size();
            for (int i = 0; i < sc; i++) {
                TreeNode poll = queue1.poll();
                if (!queue.isEmpty()){
                    poll.left = queue.poll();
                    queue1.offer(poll.left);
                }
                if (!queue.isEmpty()){
                    poll.right = queue.poll();
                    queue1.offer(poll.right);
                }
            }
        }
        return tree;
    }
    public static TreeNode getCompleteTree(int n){
        return getCompleteTree(n,n+1);
    }
    private static TreeNode[] randomNodes(int from,int to){
        Random random = new Random();
        int len = random.nextInt(from, to);
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            nodes.add(new TreeNode(random.nextInt(1,10)));
        }
        return nodes.toArray(new TreeNode[0]);
    }
}
