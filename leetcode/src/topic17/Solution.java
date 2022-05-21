package topic17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int leetcode = solution.firstUniqChar1("aabb");
        System.out.println(leetcode);
    }
    public  int firstUniqChar(String s) {
        Map<Character,Integer> hashMap= new HashMap<>();
        Queue<Pair> queue=new LinkedList<>();

        for (int i = 0; i <s.length() ; i++) {
            char c= s.charAt(i);
            if (!hashMap.containsKey(c)){
                hashMap.put(c,i);
                queue.add(new Pair(i,c));
            }else {
                hashMap.put(c, -1);
                while (!queue.isEmpty()&& hashMap.get(queue.peek().aChar)==-1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }
    public  int firstUniqChar1(String s) {
        Map<Character,Integer> hashMap= new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char c= s.charAt(i);
            hashMap.put(c,hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i <s.length() ; i++) {
            if (hashMap.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

}
class Pair {
    int pos;
    char aChar;

    public Pair(int pos, char aChar) {
        this.pos = pos;
        this.aChar = aChar;
    }
}
