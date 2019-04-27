package com.cll.cn.data_structure_stackandqueue;
import java.util.Stack;
/**
 * 括号匹配--使用java原有的api完成
 *
 * 假设括号里面只有[],(),{}三种
 * 思路：遇见左括号将左括号入栈
 *         遇见右括号比较栈顶元素与右括号是否匹配，不匹配返回false;
 *         最后返回栈是否为空
 */
public class Leedcode {
        public static boolean isVaild(String s){
            Stack<Character> stack=new Stack<>();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c=='[' || c=='(' || c=='{'){
                    stack.push(c);
                }else{
                    if(stack.isEmpty())  return false;
                    char topChar=stack.pop();
                    if(c=='(' && c!=')')  return false;
                    if(c=='[' && c!=']')  return false;
                    if(c=='{' && c!='}')  return false;
                }
            }
            return stack.isEmpty();
        }

        public static void main(String[] args) {
            System.out.println(isVaild("([{])"));
        }
}
