package duke.list;

import java.util.ArrayList;

import duke.exception.DukeException;
import duke.task.Task;

/**
 * Represents a list of tasks in the Duke application.
 * This class manages a list of tasks and provides methods for adding, retrieving,
 * completing, undoing, and deleting tasks.
 */
public class TaskList {

    private ArrayList<Task> taskList;

    /**
     * Constructs a FunnyList with the given list of tasks.
     *
     * @param taskList The initial list of tasks.
    */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Constructs an empty FunnyList.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public int size() {
        return this.taskList.size();
    }

    public Task get(int i) {
        return this.taskList.get(i);
    }

    /**
     * Marks a task at the specified index as completed.
     *
     * @param index The index of the task to complete.
     * @return The completed task.
     * @throws DukeException If the index is out of bounds.
     */
    public Task markTask(int index) throws DukeException {
        if (index < 1 || index > this.taskList.size()) {
            throw new DukeException("Index does not exist");
        }
        return this.taskList.get(index - 1).markTask();
    }

    /**
     * Marks a completed task at the specified index as incomplete.
     *
     * @param index The index of the task to undo.
     * @return The task that was undone.
     * @throws DukeException If the index is out of bounds.
     */
    public Task unmarkTask(int index) throws DukeException {
        if (index < 1 || index > this.taskList.size()) {
            throw new DukeException("Index does not exist");
        }
        return this.taskList.get(index - 1).unmarkTask();
    }

    /**
     * Removes and returns a task from the list at the specified index.
     *
     * @param index The index of the task to delete.
     * @return The task that was deleted.
     * @throws DukeException If the index is out of bounds.
     */
    public Task deleteTask(int index) throws DukeException {
        if (index < 1 || index > this.taskList.size()) {
            throw new DukeException("Index does not exist");
        }
        Task task = this.taskList.get(index - 1);
        this.taskList.remove(index - 1);
        return task;
    }

    public Task rescheduleTask(int index, String deadline) throws DukeException {
        if (index < 1 || index > this.taskList.size()) {
            throw new DukeException("Index does not exist");
        }
        Task task = this.taskList.get(index - 1);
        task.rescheduleTask(deadline);
        return task;
    }
    public void add(Task task) {
        this.taskList.add(task);
    }

    public ArrayList<Task> findTasks(String search) {
        ArrayList<Task> result = new ArrayList<>();
        for (int i = 0; i < this.taskList.size(); i++) {
            Task curr = this.taskList.get(i);
            if (curr.match(search)) {
                result.add(curr);
            }
        }
        return result;
    }

}
