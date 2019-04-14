package com.cll.cn.leedcode;
import java.util.Scanner;
/**
 * 判断链表是否有环
 */
class Node{
    public Node next=null;
    public char data;

    public Node(char data){
        this.data=data;
    }
}

public class LinkedHasCircle {
    public static Node head=null;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        char[] ch=str.toCharArray();

        for(int i=0;i<ch.length;i+=2){
            addNode(ch[i]);
        }
        System.out.println(isLoop(head));
    }

    public static void addNode(char node){
        if(head==null){
            head=new Node(node);
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(node);
    }

    public static boolean isLoop(Node head){
        Node fast=head;
        Node slow=head;
        if(fast==null){
            return false;
        }

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return !(fast.next==null || fast==null);
    }
}
