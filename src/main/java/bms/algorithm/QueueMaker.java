package bms.algorithm;

public class QueueMaker {

    class MyQueue {

        int ptr = 0;
        int[] values;

        public MyQueue() {
            this.ptr = 0;
            this.values = new int[10];
        }

        public void push(int x) {
            this.values[ptr] = x;
            this.ptr++;
        }

        public int pop() {
            int result = this.values[ptr--];
            this.values[ptr] = 0;
            return result;
        }

        public int peek() {
            return this.values[ptr--];
        }

        public boolean empty() {
            for (int i = 0; i < this.values.length; i++) {
                if (this.values[i] > 0)
                    return false;
            }
            return true;
        }
    }

}
