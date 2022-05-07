package topic18;

import java.util.Stack;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 使用栈模拟队列
 */
public class Solution {
}
class MyQueue {
   private Stack<Integer> s1=null;
   private Stack<Integer> s2=null;
    public MyQueue() {
        s1=new Stack();
        s2=new Stack();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
      peek();
      return  s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return  s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
