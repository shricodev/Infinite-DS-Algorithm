package LeetcodeDaily;

import java.util.Stack;

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if (!output.empty()) {
            return output.pop();
        } 

        while (!input.empty()) {
            output.push(input.pop());
        } 
        return output.pop();
    }
    
    public int peek() {
        if (!output.empty()) {
            return output.peek();
        }

        while (!input.empty()) {
            output.push(input.pop());
        }
        return output.peek();
    }
    
    public boolean empty() {
        return output.size() == 0 && input.size() == 0;
    }
}