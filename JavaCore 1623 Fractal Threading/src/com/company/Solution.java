package com.company;

/*

1623 Recursive thread creation
1. Modify the GenerateThread class to become a thread.
2. Create a GenerateThread constructor that should:
2.1. Call the superclass constructor with the String parameter - the number of thread created. Use countCreatedThreads.
2.2. Run the current thread.
2.3. The first thread number must start with 1.
3. Override the toString method, click Alt + Insert -> Override Methods inside GenerateThread. Start typing toString.
3.1. The toString method must return the current thread number and the word "created". Use getName ().
Example: "8 created"
4. While the number of threads created is less than Solution.count, the run method should:
4.1. Create a new thread of type GenerateThread.
4.2. Output to the console created in paragraph 4.1. thread.
5. As a result, 15 rows should be output to the console.

Requirements:
1. The GenerateThread class must be inherited from Thread.
2. The GenerateThread class must have an open constructor with no parameters.
3. The GenerateThread class constructor must increment the countCreatedThreads value and pass it as a string to the superclass constructor.
4. The GenerateThread class constructor must start the thread.
5. The toString method of the GenerateThread class must return the filename and the word "created". Example: "8 created".
6. If the number of threads created is less than Solution.count, the run method must create a new thread of type GenerateThread.
7. If the number of threads created is less than Solution.count, the run method should output the created thread to the console.
8. The output of the program should be consistent with the assignment, showing that all 15 threads have been created.


 */

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
            start();
        }

        @Override
        public void run() {
            if (countCreatedThreads < count) {
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}


