package duke.tasks;

import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Task is a public class that represents the tasks in duke.
 * A task object encapsulates the description of the task, the type of task it is, and whether
 * the task is done
 */
public class Task {
    protected String description;
    protected String type = "";
    protected String subtypes = " ";
    protected boolean isDone;
    protected int duration;
    protected Calendar datetime = Calendar.getInstance();
    protected Calendar end = Calendar.getInstance();
    protected Period recurringDuration;
    protected ArrayList<ToDo> doAfter = new ArrayList();
    private static final String padding = "     ";

    /**
     * This is the constructor of Task object.
     * @param description the description of the task
     */
    public Task(String description) {
        this(description, Period.of(0,0,0));
    }

    public Task(String description, Period recurringDuration) {
        this.description = description;
        this.recurringDuration = recurringDuration;
        this.isDone = false;
    }

    /**
     * This function checks whether the particular task object is done and return the string accordingly.
     * @return <code>[\u2713]</code> if the task is done
     *          <code>[\u2718]</code> if the task is not done
     */
    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]"); //return tick or X symbols
    }

    /**
     * This is a getter for description.
     * @return description of the task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * This is a setter for isDone.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * This is a getter for isDone.
     * @return isDone status of the task
     */
    public boolean getisDone() {
        return this.isDone;
    }

    /**
     * This is a getter for the type.
     * @return type of the task
     */
    public String getType() {
        return this.type;
    }

    /**
     * This is a getter for the subtype.
     * @return subtype of the task
     */
    public String getSubtype() {
        return this.subtypes;
    }

    /**
     * This is a getter for the type.
     * @return type of the task
     */
    public Calendar getDate() {
        return this.datetime;
    }

    public Calendar getEnd() {
        return this.end;
    }

    public void setDoAfter(ArrayList<ToDo> doAfter) {
        this.doAfter = doAfter;
    }

    public ArrayList<ToDo> getDoAfter() {
        return this.doAfter;
    }

    public void setDate(Calendar datetime) {
        this.datetime = datetime;
    }

    public void setRecurringDuration(Period recurringDuration) {
        this.recurringDuration = recurringDuration;
    }

    public Period getRecurringDuration() {
        return this.recurringDuration;
    }

    public boolean isRecurringTask() {
        return !this.recurringDuration.isZero();
    }

    /**
     * This function overrides the toString() function in the object class.
     * @return the status icon and the description of the task
     */
    @Override
    public String toString() {
        return this.getStatusIcon() + " " + this.description;
        //TODO: refactor this by using type also
    }

}