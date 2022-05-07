package topic20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 中缀表达式转后缀表达式
 */
public class Solution{
    public static void main(String[] args) {
        //1、首先创建两个栈，运算符栈S1和储存中间结果栈S2
        Stack<String> S1 = new Stack();
        Stack<String> S2 = new Stack();
        //2、创建一个运算符的Map，映射其优先级
        Map<String,Integer> operator = new HashMap();
        operator.put("+", 1);
        operator.put("-", 1);
        operator.put("*", 2);
        operator.put("/", 2);
        operator.put("(", -1);
        operator.put(")", -2);
        //3、取中缀表达式
        String input = "(6+4)/2*3"; //6, 4, +, 2, /, 3, *
        for(int i=0;i<input.length();i++) {
            String uN = String.valueOf(input.charAt(i));
            //1、当遇到操作数时
            if(!operator.containsKey(uN)) {
                S2.add(uN);
                continue;
            }else if(operator.get(uN)>0){//2、当遇到运算符时
                while(true) {
                    //2.1如果S1为空，或者栈顶元素为"(",则直接将此运算符入符号栈
                    if(S1.isEmpty() || operator.get(S1.peek())==-1) {
                        S1.add(uN);
                        break;
                        //若此运算符比栈顶运算符高（必须是高，相同和低都不行）
                    }else if(operator.get(uN)>operator.get(S1.peek())) {
                        //将此运算符入符号栈
                        S1.add(uN);
                        break;
                    }else {//此运算符比栈顶运算符优先级相等或者低
                        //将S1中的运算符弹出，入中间结果栈
                        S2.add(S1.pop());
                    }
                }
                continue;
            }else { //当遇到括号时
                //如果是左括号
                if(operator.get(uN)==-1) {
                    S1.add(uN);
                    continue;
                }else {//如果是右括号时,则依次弹出S1栈顶的运算符，直到找到左括号为止，然后废弃这对括号
                    while(true) {
                        String temp = S1.pop();
                        if(operator.get(temp)==-1) {
                            break;
                        }else {
                            S2.add(temp);
                        }
                    }
                }
            }
        }
        //将S1中剩余的运算符依次弹出并压入S2
        while(!S1.isEmpty()) {
            S2.add(S1.pop());
        }
        System.out.println(S2);
        //S2逆序计算机容易识别,将S2逆序存入S1
        while(!S2.isEmpty()) {
            S1.add(S2.pop());
        }
        //计算结果栈
        Stack<Integer> S = new Stack();
        while(!S1.isEmpty()) {
            if(operator.containsKey(S1.peek())) {
                String sign = S1.pop();
                int temp1 = S.pop();
                int temp2 = S.pop();
                switch (sign) {
                    case "+":
                        S.add(temp2+temp1);
                        break;
                    case "-":
                        S.add(temp2-temp1);
                        break;
                    case "*":
                        S.add(temp2*temp1);
                        break;
                    case "/":
                        S.add(temp2/temp1);
                        break;
                    default:
                        break;
                }
            }else {
                S.add(Integer.parseInt(S1.pop()));
            }
        }
        System.out.println(S);
    }
}

