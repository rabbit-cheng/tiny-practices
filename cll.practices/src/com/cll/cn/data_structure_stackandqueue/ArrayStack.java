package com.cll.cn.data_structure_stackandqueue;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;
    public ArrayStack(int capacity){
        array=new Array(capacity);
    }
    public ArrayStack(){
        array=new Array();
    }
    @Override
    public int getSize(){
        return array.getSize();
    }
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }
    @Override
    public E  pop(){//从栈顶取出一个原数将其返回
        return array.removeLast();
    }
    @Override
    public E peek(){//查看栈顶元素
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(",");
            }
        }
        res.append("]top");
        return res.toString();
   }
}
