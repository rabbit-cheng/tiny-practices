package com.cll.cn.data_structure_stackandqueue;

public class Main {
//    public static void main(String[] args){
//        ArrayStack<Integer> stack=new ArrayStack();
//        for(int i=0;i<5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//        stack.pop();
//        System.out.println(stack);
//    }
    public static void main(String[] args){
        LoopQueue<Integer> queue=new LoopQueue<>();
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
