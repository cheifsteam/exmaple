package topic21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 队列实现栈
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
   Queue<Integer> queue1;
   Queue<Integer> queue2; //一个队列同时作为另一个队列临时变量始终为空
   public  MyStack()
   {
        queue1=new LinkedList();
        queue2=new LinkedList();
   }
   public void push(int x)
   {
      queue2.offer(x);
      while (!queue1.isEmpty())
      {
          queue2.offer(queue1.poll());
      }
      Queue temp=queue2;
      queue2=queue1;
      queue1=temp;
   }
   public int top()
   {
       return (int) queue1.peek();
   }
   public int pop(){
       return (int) queue1.poll();
   }
   public boolean empty(){
       return queue1.isEmpty();
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
