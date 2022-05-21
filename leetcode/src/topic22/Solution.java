package topic22;

import org.w3c.dom.Node;

/**
 * @author 屈燃希
 * @version 1.0
 * @project  设计循环队列
 */
public class Solution {
    public static void main(String[] args) {
        MyCircularQueue2 circularQueue = new MyCircularQueue2(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4
    }

}
//牺牲一个存储空间来完成循环队列
class MyCircularQueue {
    int capacity=0;
    int[] stack;
    int front=0;
    int rear=0;
    public MyCircularQueue(int k) {
        stack =new int[k+1];
        capacity=k+1;
    }

    public boolean enQueue(int value) {
        if (!isFull()){

            stack[rear]=value;
            rear=(rear+1)%capacity;
            return true;
        }else {
            return false;
        }

    }

    public boolean deQueue() {

        if (!isEmpty()){

            System.out.println(stack[front]);
            front=(front+1)%capacity;

            return true;
        }
        return false;
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }

        return stack[front];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        if (rear == 0) {
            return stack[capacity-1];
        }
        return stack[rear-1];
    }

    public boolean isEmpty() {
        return  front==rear;
    }

    public boolean isFull() {
        return  (rear+1)%capacity==front;
    }
}
//双指针完成循环队列
class MyCircularQueue1 {

    int[] stack;
    int head=-1;
    int tail=-1;
    int size =0;
    public MyCircularQueue1(int k) {
        stack =new int[k];
        size=k;
    }

    public boolean enQueue(int value) {
        if (isEmpty()){
            head=0;
        }
        if (isFull()){
            return false;
        }
        tail = (tail+1)%size;
        stack[tail]=value;
        return true;

    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        if (head == tail){
            head =-1;
            tail = -1;
        }
        else {
            head = (head+1)%size;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()){
            head = -1;
            return head;
        }

        return stack[head];
    }

    public int Rear() {
        if (isEmpty()){
            tail = -1;
            return tail;
        }
        return stack[tail];

    }

    public boolean isEmpty() {
        return head==-1;
    }

    public boolean isFull() {
        return (tail+1)%size==head;
    }
}

class Node1{
    public   int value;
    public Node1 next;

    public Node1(int value) {
        this.value = value;
        next = null;
    }
}
//链队列来完成循环队列
class MyCircularQueue2{
    public Node1 head;
    public Node1 tail;
    private  int size=0;
    private  int count=0;

    public MyCircularQueue2(int size) {
        this.size = size;
    }
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        Node1 newNode = new Node1(value);
        if (isEmpty()){
            head=tail = newNode;
        }else {
            tail.next=newNode;
            tail = newNode;
            tail.next=head;
        }
        this.count+=1;
        return true;


    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        this.head=head.next;
        this.count-=1;
        return true;
    }

    public int Front() {
        if (isEmpty()){
        return  -1;
        }

        return head.value;
    }

    public int Rear() {
        if (isEmpty()){

            return -1;
        }
        return  tail.value;

    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==size;
    }
}


