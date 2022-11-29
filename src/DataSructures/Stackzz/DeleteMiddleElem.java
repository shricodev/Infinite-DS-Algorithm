package DataSructures.Stackzz;

import java.util.Stack;

public class DeleteMiddleElem {
    
    public void deleteMid(Stack<Integer>s, int sizeOfStack){
        // code here
        if (sizeOfStack <= 0) return;
        int mid = sizeOfStack / 2;
        s.remove(mid);
    } 
}
