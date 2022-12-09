package DataSructures.Queuess;

import java.util.Queue;
import java.util.Stack;

class GfG{
    //Function to reverse the queue.
    // we can solve the qn using the same approach of reversing the stack.
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        // using another appraoch to solve the qn.
        Stack<Integer> st = new Stack<>();

        while (q.size() != 0) {
            int num = q.poll();
            st.add(num);
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        return q;
    }
}
