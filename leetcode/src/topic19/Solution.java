package topic19;

import java.util.LinkedList;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 剑指 Offer 09. 用两个栈实现队列
 * LinkedList 底层是双向链表
 */
public class Solution {
}
class CQueue {
    private LinkedList<Integer> s1,s2;
    public CQueue() {
        s1=new LinkedList<>();
        s2 =new LinkedList<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()){
            if (s1.isEmpty()){
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek()==null?-1:s2.pop();
        }else {
            return s2.peek()==null?-1:s2.pop();
        }
    }
}