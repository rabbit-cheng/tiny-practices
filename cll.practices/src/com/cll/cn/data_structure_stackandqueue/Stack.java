package com.cll.cn.data_structure_stackandqueue;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
