package com.cll.cn.data_structure_linkedlist;

/**
 * 利用链表实现栈
 */
public class LinkedListStack<E> implements Stack<E>{
    private LinkedList<E> list;

    public LinkedListStack(){
        list=new LinkedList<>();
    }
    @Override
    public int getSize(){
        return list.getSize();
    }
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public void push(E e){//入栈（链表头作为栈顶）
        list.addFirst(e);
    }
    @Override
    public E pop(){//出栈（链表头出栈）
        return list.removeFirst();
    }
    @Override
    public E peek(){//查看栈顶元素
        return list.getFirst();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack:");
        res.append(list);

        return res.toString();
    }

    public static void main(String[] args){
        LinkedListStack<Integer> stack=new LinkedListStack();
        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
