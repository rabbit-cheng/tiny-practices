package com.cll.cn.data_structure_linkedlist;

/**
 * 链表类
 */
public class LinkedList<E> {
    //内部节点类
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyHead;//链表虚拟头节点
    private int size;//链表的长度

    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    //获取链表中的元素个数
    public int getSize(){
        return size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //在链表的inedx位置（0-based）添加新的元素
    public void add(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("index is illegal!");
        }
        Node pre=dummyHead;
        for(int i=0;i<index;i++){
            pre=pre.next;
        }
//            Node node=new Node(e);
//            node.next=pre.next;
//            pre.next=node;
        pre.next=new Node(e, pre.next);
        size++;
    }
    //在链表头添加新的元素
    public void addFirst(E e){
        add(0,e);
    }
    //在链表的末尾添加一个新的元素
    public void addLast(E e){
        add(size,e);
    }
    //获得链表第index位置（0-based）的元素
    public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index is illegal!");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<size;i++){
            cur=cur.next;
        }
        return cur.e;
    }
    //获取链表的第一个元素
    public E getFirst(){
        return get(0);
    }
    //获取链表最后一个元素
    public E getLast(){
        return get(size-1);
    }
    //修改链表中的第index位置的元素值为e
    public void set(int index,E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index is illegal!");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }
    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //删除链表index位置（0-based）的元素并返回
    public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index is illegal1");
        }
        Node pre=dummyHead;
        for(int i=0;i<index;i++){
            pre=pre.next;
        }
        Node cur=pre.next;
        pre.next=cur.next;
        cur.next=null;
//        pre.next=pre.next.next;
//        pre.next=null;
        size--;

        return cur.e;
    }
    //删除链表中的第一个元素并返回
    public E removeFirst(){
       return  remove(0);
    }
    //删除链表的最后一个元素
    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        Node cur=dummyHead.next;
        while(cur != null){
            res.append(cur+"-->");
            cur=cur.next;
        }
//        for(Node cur=dummyHead; cur != null;cur=cur.next){
//            res.append(cur+"-->");
//        }
        res.append("null");

        return res.toString();
    }
}
