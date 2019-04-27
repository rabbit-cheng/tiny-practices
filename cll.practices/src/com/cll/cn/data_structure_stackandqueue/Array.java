package com.cll.cn.data_structure_stackandqueue;

/**
 * 基于java提供的数组二次封装属于自己的数组
 * size:数组的有效元素大小
 * capacity：数组的容量即为data.length
 */
public class Array<E>{
    private E[] data;
    private int size;

    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }
    //无参构造函数，默认容量为10
    public Array(){
        this(10);
    }
    //用户获取数组中元素个数
    public int getSize(){
        return size;
    }
    //用户获取数组的容量
    public int getCapacity(){
        return data.length;
    }
    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //向所有元素后添加一个元素
    public void addLast(E e){
        add(size,e);
    }
    //向数组头部添加一个元素
    public void addFirst(E e){
        add(0,e);
    }
    //向数组指定位置添加一个元素
    public void add(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("AddLast failed,Require index>=0 and index<=size！");
        }
        if(size==data.length){
            resize(2*data.length);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }


    //获取指定索引出的值
    public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed,Index is Illegal");
        }
        return data[index];
    }

    public E getLast(){
        return  get(size-1);
    }
    public E getFirst(){
        return get(0);
    }
    //更新指定索引的值
    public void set(int index,E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Set failed,Index is Illegal");
        }
        data[index]=e;
    }
    //查找数组中是否含有元素e
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //查找数组中元素e所在的索引，若不存在返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    //删除指定索引的元素,返回删除的元素
    public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Remove failed,Index is Illegal");
        }
        E ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;//方便其回收

        if(size == data.length/2){
            resize(data.length/2);
        }
        return ret;
    }
    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }
    //如果存在元素e，仅删除一个值为e
    public void removeElement(E e){
        int t=find(e);
        if(t !=-1){
            remove(t);
        }
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }


    //容量满时进行数组扩容
    private void resize(int newCapacity){
            E[] newData=(E[])new Object[newCapacity];
            for(int i=0;i<size;i++){
                newData[i]=data[i];
            }
            data=newData;
    }
}
