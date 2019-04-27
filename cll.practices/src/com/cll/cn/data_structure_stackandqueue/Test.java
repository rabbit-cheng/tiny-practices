package com.cll.cn.data_structure_stackandqueue;
import java.util.Random;
import com.cll.cn.data_structure_linkedlist.LinkedListStack;

/**
 * 测试数组栈和链表栈的时间差
 */
public class Test {
    //测试使用stack运行opCount个push和pop所需要的时间（秒）
    private static double testStack(Stack<Integer> stack,int opCount){
        long startTime=System.nanoTime();

        Random random=new Random();
        for(int i=0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            stack.pop();
        }
        long endTime=System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount=100000;
        ArrayStack<Integer> arrayStack=new ArrayStack<>();
        double time1=testStack(arrayStack,opCount);
        System.out.println("ArrayListTime:"+time1+"s");

        //LinkedListStack<Integer> linkStack=new  LinkedListStack<>();
       // double time2=testStack(linkStack,opCount);
       // System.out.println("LinkedListStack:"+time2+"s");
        //其实这个时间比较复杂，因为linkedList包含许多的new操作
    }
}
