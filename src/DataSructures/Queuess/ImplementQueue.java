package DataSructures.Queuess;

class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        if (rear == 100005)
            return;

        arr[rear] = x;
        rear++;

    }

    // Function to pop an element from queue and return that element.
    int pop() {
        // Your code here
        if (front == rear)
            return -1;
        int temp = arr[front];
        arr[front] = -1;
        front++;
        if (front == rear) {
            front = 0;
            rear = 0;
        }
        return temp;
    }
}
