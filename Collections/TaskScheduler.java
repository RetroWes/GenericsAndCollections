import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;

// Define a Task class to hold details about a task, including its priority and name.
class Task{
    private int priority;
    private String name;

    // Constructor to initialize a Task object with a priority and a name.
    Task(int priority, String name){
        this.priority = priority;
        this.name = name;
    }

    public String getName() {return name;}
    public int getPriority() {return priority;}
    public void setPriority(int priority) {this.priority = priority;}
}

// Class to manage tasks using a priority queue.
class TaskScheduler {
    // Method to update the priority of a task identified by 'name' in the given priority queue.
    public static void updatePriority(PriorityQueue<Task> queue, String name, int newPriority){
        // Create a temporary list from the priority queue to iterate over and modify tasks.
        ArrayList<Task> list = new ArrayList<>(queue);
        // Clear the original queue so it can be repopulated with updated tasks.
        queue.clear();

        // Iterate through the list of tasks.
        for(Task task : list){
            // If the current task's name matches the given name, update its priority.
            if(task.getName().equals(name)) {task.setPriority(newPriority);}
            // Add the task back into the priority queue (with updated priority if applicable).
            queue.add(task);
        }
    }

    // Private helper method to print out the names of tasks in the queue in priority order.
    private static void printQueue(PriorityQueue<Task> queue) {
        // Create a copy of the queue to avoid modifying the original queue.
        PriorityQueue<Task> copy = new PriorityQueue<>(queue.comparator());
        copy.addAll(queue);

        // Poll (remove) each task from the copy of the queue and print its name until the queue is empty.
        while (!copy.isEmpty()) {System.out.printf(" \"%s\"", copy.poll().getName());}
        System.out.println(); // Move to a new line after printing all task names.
    }

    // Main method to run some example operations on the TaskScheduler.
    public static void main(String[] args){
        // Create a comparator for the Task objects based on their priority.
        Comparator<Task> comparator = (task1, task2) -> task1.getPriority() - task2.getPriority();
        // Initialize the priority queue with the custom comparator to organize tasks by priority.
        PriorityQueue<Task> queue = new PriorityQueue<>(comparator);

        // Add some tasks to the queue with various priorities.
        queue.add(new Task(5, "Task A"));
        queue.add(new Task(1, "Task B"));
        queue.add(new Task(13, "Task C"));
        
        // Print the initial queue state.
        System.out.print("Initial Queue:");
        printQueue(queue);

        // Update the priority of "Task A" to 0, making it the highest priority task.
        updatePriority(queue, "Task A", 0);

        // Print the queue state after updating the priority of "Task A".
        System.out.print("Updated Queue:");
        printQueue(queue);
    }
}