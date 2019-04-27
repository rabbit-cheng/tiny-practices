package com.cll.cn.data_structure_stackandqueue;

/**
 * 循环队列
 *
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int size;//队列中有多少个班元素
    private int front,tail;

    public LoopQueue(int capacity){
        data=(E[]) new Object[capacity+1];//循环队列需有意识的浪费掉一个空间
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public boolean isEmpty(){
        return front==tail;
    }
    @Override
    public int getSize(){
        return size;
    }
    //循环队列的出队
    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue elements from the queue!");
        }
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        //防止空间浪费
        if(size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }
    //循环队列的入队
    @Override
    public void enqueue(E e){
        if((tail+1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }


    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        return data[front];
    }
    public void resize(int capacity){
        E[] newData=(E[]) new Object[capacity+1];
        for(int i=0;i<size;i++){
            newData[i] = data[(i+front)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Queue:size=%d,capacity=%d\n",size,data.length));
        res.append("front[");
        for(int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length != tail){
                res.append(",");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
