package DataSructures.Queuess;

class MyCircularQueue {
    int arr[];
    int front = 0, rear = 0;
    int size = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        // if the size of the queue is 0 then both front and rear should point to the same index so handling this condn.
        if (isEmpty()) {
            front = rear = 0;
            arr[rear] = value;
            size++;
            return true;
        }
        
        rear++;
        size++;
        rear = rear % arr.length;
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        arr[front] = -1;
        front++;
        size++;
        front = front % arr.length;
        return true;
    }
    
    public int Front() {
        return arr[front];
    }
    
    public int Rear() {
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == arr.length;
    }
}

/**
 * CircularQueue
 */
public class CircularQueue {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear(); // return 3
        myCircularQueue.isFull(); // return True
        myCircularQueue.deQueue(); // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear(); // return 4
    }
}
