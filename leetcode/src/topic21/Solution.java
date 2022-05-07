package topic21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
           myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
        MyStack myStack1 = new MyStack();
           myStack1.push(1);
        myStack1.push(2);
        System.out.println(myStack1.top()); // 返回 2
        System.out.println(myStack1.pop()); // 返回 2
        System.out.println(myStack1.empty()); // 返回 False

    }
}
class MyStack {
    Queue<Integer> q1,q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        Queue<Integer> temp=q2;
        q2=q1;
        q1=temp;
    }

    public int pop() {

      return   q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
    
}
class MyStack1 {
    Queue<Integer> q1;
    public MyStack1() {
        q1=new LinkedList<>();
       
    }

    public void push(int x) {
        int n =q1.size();
        q1.add(x);
        for (int i = 0; i <n ; i++) {
            q1.add(q1.poll());
        }
    }

    public int pop() {

      return   q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
    
}
