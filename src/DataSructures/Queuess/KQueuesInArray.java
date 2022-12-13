package DataSructures.Queuess;

class KQueues {
    int n;
    int k;
    int arr[];
    int front[];
    int rear[];
    int next[];
    int freeSpot = 0;

    // initialization
    public KQueues(int n, int k) {
        this.n = n;
        this.k = k;
        // front and rear is of size k.
        front = rear = new int[k];
        arr = new int[n];
        next = new int[n];

        // initializing all the values in nfront, rear with -1;
        for (int i = 0; i < k; i++) {
            front[i] = rear[i] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    public int push(int val, int q) {
        if (freeSpot == -1)
            return -1;

        int index = freeSpot;
        freeSpot = next[index];
        // means we are pushing the element for the first time in the given queue.
        // 0 based indexing.
        if (front[q - 1] == -1) {
            front[q - 1] = index;
        } else {
            // link the old element to the new element.
            next[rear[q - 1]] = index;
        }
        // since we are putting a value so adding -1.
        next[index]  = -1;
        rear[q - 1] = index;
        arr[index] = val;
        return val;
    }

    public int poll(int q) {
        // the size == 0 is not needed.
        if (front[q - 1] == -1)
            return -1;

        int index = front[q - 1];
        // now the another element of the q is denoted by the next of the index.
        front[q - 1] = next[index];
        next[index] = freeSpot;
        // we can utilize the free spot of the removed element.
        freeSpot = index;
        return arr[index];
    }
}