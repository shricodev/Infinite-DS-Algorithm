package DataSructures.Stackzz;

import java.util.ArrayList;
import java.util.List;

class Stackzzz {
    List<Integer> st = new ArrayList<>();
    int pointer = -1;

    boolean isEmpty() {
        return st.size() == 0; // or return pointer == -1;
    }

    int top() {
        return st.get(pointer);
    }

    boolean pop() {
        if (st.isEmpty()) return false;
        st.remove(pointer);
        pointer--;
        return true;
    }

    void push(int n) {
        st.add(n);
        pointer++;
    }

    int size() {
        return st.size();
    }
}


public class StackImplementation {

    public static void main(String[] args) {
        Stackzzz st = new Stackzzz();
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.isEmpty());
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        st.pop();
        System.out.println(st.size());
    }
    

}
