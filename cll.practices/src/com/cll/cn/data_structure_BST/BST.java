package com.cll.cn.data_structure_BST;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
/**
 * 二分搜索树
 * 继承comparable接口使每个节点的值具有可比较性
 */
public class BST<E extends Comparable<E>>{
    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root=null;
        size=0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //二分搜索树元素添加（递归实现）
    public void add(E e){
        root=add(root,e);
    }
    //向以node为根的二分搜索树插入元素e--递归算法
    //返回插入新节点后二叉搜索树的根
    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }
    //关于二分搜索树的查询
    public boolean contains(E e){
        return contains(root,e);
    }
    //看以node根的二分搜索树中是否包含元素e
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的遍历——前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //前序遍历以node为根的二分搜索树
    private void preOrder(Node node){
        if(node==null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null){//让右边的节点先入（满足栈的后入先出规则）
                stack.add(cur.right);
            }
            if(cur.left!=null){
                stack.add(cur.left);
            }
        }
    }

    //二分搜索树的层序遍历
    public void sorted(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur=queue.remove();
            System.out.println(cur.e);

            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }

    }
    //二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //遍历以node为根节点的二分搜索树
    private void  inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二叉搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    //遍历以node为根的二叉搜索树
    private void postOrder(Node node){
        if(node==null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //找到最小值
    public E mixmun(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return mixmun(root).e;
    }
    //找到以node为根节点的左子树
    public Node mixmun(Node node){
        if(node.left==null){
            return node;
        }
        return mixmun(node.left);
    }

    //找到最大值
     public E maxmun(){
        if(size==0){
            throw new IllegalArgumentException("BST is empy!");
        }
        return maxmun(root).e;
     }
     //找到以node为根节点的右子树
    public Node maxmun(Node node){
        if(node.right==null){
            return node;
        }
        return maxmun(node.right);
    }

    //删除二分搜索树的最小值并返回
    public E removeMin(){
        E res=mixmun();
        removeMin(root);
        return res;
    }
    //删除以node为根节点的左子树
    //返回删除节点后新的二分搜索树的根
    public Node removeMin(Node node){
        if(node.left==null){
            Node rightnode=node.right;
            node.right=null;
            size--;
            return rightnode;
        }
        node.left=removeMin(node.left);
        return node;
    }
    //删除二分搜索树中的最大值并返回最大值
    public E removeMax(){
        E res=maxmun();
        removeMax(root);
        return res;
    }
    //删除以node为根的最大值
    //返回删除节点后新的二分搜索树的根
    public Node removeMax(Node node){
        if(node.right==null){
            Node leftnode=node.left;
            node.right=null;
            size--;
            return node.left;
        }
        node.right=removeMax(node.right);
        return node;
    }

    //从二分搜索树中删除值为e的节点
    public void remove(E e){
        root = remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的节点
    //返回删除后新的二分搜索树的根节点
    public Node remove(Node node,E e){
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left= remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else{//e.compareTo(node.e)==0
            //待删除节点左子树为空的情况
            if(node.left==null){
                Node rightnode=node.right;
                node.right=null;
                size--;
                return rightnode;
            }
            //待删除节点右子树为空的情况
            if(node.right==null){
                Node leftnode=node.left;
                node.right=null;
                size--;
                return leftnode;
            }
            //待删除节点左右都不为空
            //找到比待删除节点大的最小节点，即就是右子树的最小节点
            //用这个节点顶替待删除节点的位置
             Node successor=mixmun(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;

            node.left=node.right=null;
            return successor;

        }

    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateStringBST(root,0,res);
        return res.toString();
    }
    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateStringBST(Node node,int depth,StringBuilder res){
        if(node==null){
            res.append(genenateDepthString(depth)+"null\n");
            return;
        }
        res.append(genenateDepthString(depth)+node.e+"\n");
        generateStringBST(node.left,depth+1,res);
        generateStringBST(node.right,depth+1,res);
    }
    private String genenateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }
}
