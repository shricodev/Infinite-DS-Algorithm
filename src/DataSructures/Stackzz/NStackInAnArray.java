package DataSructures.Stackzz;

import java.util.Arrays;

class NStack {
    int[] arr;
    int[] top;
    int[] next;
    int freeSpot;
    int n, s;
    // Initialize your data structure.
    // n -> no of stacks
    // s -> size of the array.
    public NStack(int n, int s) {
        // Write your code here.
        arr = new int[s];
        top = new int[n];
        next = new int[s];
        freeSpot = 0;
        this.n = n;
        this.s = s;
        Arrays.fill(top, -1);

        for (int i = 0; i < s - 1; i++) {
            next[i] = i + 1;
        }
        next[s - 1] = -1;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        if (freeSpot == -1) return false;
        // finding the index to push the element.
        int index = freeSpot;
        // now the freeSpot is occupied so change the freeSpot to the next free Space of the index.
        freeSpot = next[index];
        // place the value in the index.
        arr[index] = x;
        // now the next of the index is going to be the top of the prev stack. it points to the value just down it.
        next[index] = top[m - 1];
        // now the top of the stack is changed to the index.
        top[m - 1] = index;

        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // Write your code here.
        // if there is no element in the stack then we cannot pop the element so return -1
        if (top[m - 1] == -1) return -1;
        
        int index = top[m - 1];
        top[m - 1] = next[index];
        next[index] = freeSpot;
        freeSpot = index;

        return arr[index];
    }
}
