package queue;

// Java program for linked-list implementation of queue

// A linked list (LL) node to store a queue entry
class QNode {
    int key;
    QNode next;

    // constructor to create a new linked list node
    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

// A class to represent a queue
//The queue, front stores the front node of LL and rear stores ths
//last node of LL
class QueueLL {
    QNode front, rear;

    public QueueLL() {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    void enqueue(int key) {

        // Create a new LL node
        QNode temp = new QNode(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    QNode dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null)
            return null;

        // Store previous front and move front one node ahead
        QNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
        return temp;
    }

    void printQueue()    {

        QNode temp = front;
        System.out.println("printing Q...");
        while(temp!=null) {
            System.out.println(temp.key);
            temp = temp.next;
        }
        System.out.println("printing Q finished");
    }
}

public class QueueUsingLL {

    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enqueue(10);
        q.enqueue(20);
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.printQueue();
        System.out.println("Dequeued item is " + q.dequeue().key);
        q.printQueue();
    }
}
