package com.cll.cn.data_structure_linkedlist;

/**
 * 直接采用尾指针的方式实现 链表队列
 */
public class LinkedListQueue<E> implements Queue<E>{

        //内部节点类
        private class Node {
            public E e;
            public Node next;

            public Node(E e, Node next) {
                this.e = e;
                this.next = next;
            }

            public Node(E e) {
                this(e, null);
            }

            public Node() {
                this(null, null);
            }

            @Override
            public String toString() {
                return e.toString();
            }
        }

    private Node head;//头结点
    private Node tail;//尾节点
    private int size;//链表中存储的元素

    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }
    @Override
    public int getSize(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public void enqueue(E e){//入队操作，将链表的尾部当做队列的首部入队
        if(tail==null){
            tail=new Node(e);
            head=tail;
        }else{
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }
    @Override
    public E dequeue(){//出队操作，将链表的头部当做队列的尾部添加
        if(isEmpty())  throw new IllegalArgumentException("queue is empty");
        Node cur=head;
        head=head.next;
        cur.next=null;
        if(tail==null){
            head=null;
        }
        size--;
        return cur.e;
    }
    @Override
    public E getFront(){
        if(isEmpty())  throw new IllegalArgumentException("queue is empty");
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue:tail:");
        Node cur=head;
        while(cur != null){
            res.append(cur+"-->");
            cur=cur.next;
        }
        res.append("null:head");
       return res.toString();
    }

    public static void main(String[] args) {

            LinkedListQueue<Integer> queue=new LinkedListQueue<>();
            for(int i=0;i<10;i++){
                queue.enqueue(i);
                System.out.println(queue);
                if(i%3==2){
                    queue.dequeue();
                    System.out.println(queue);
                }
            }

    }
}
