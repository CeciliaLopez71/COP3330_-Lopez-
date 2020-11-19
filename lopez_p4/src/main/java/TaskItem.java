package main.java;

import java.io.Serializable;

public class TaskItem implements Serializable {

    private static final long serialVersionUID = 1L; //this is commonvalue

    private String title;
    private String description;
    private String dueDate;
    private boolean isCompleted;

    public TaskItem(String title, String description, String dueDate, boolean isCompleted) throws Exception {
        super();

        if (this.validateString(title)) {
            this.title = title;
        } else {
            throw new Exception();
        }

        if (this.validateString(description)) {
            this.description = description;
        } else {
            throw new Exception();
        }

        if (this.isValidDate(dueDate)) {

            this.dueDate = dueDate;
        } else {
            throw new Exception();
        }
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {

        if (this.validateString(title)) {
            this.title = title;
        }else {
            throw new Exception();
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception {

        if (this.validateString(description)) {
            this.description = description;
        }else {
            throw new Exception();
        }

    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) throws Exception {

        if (this.isValidDate(dueDate)) {

            this.dueDate = dueDate;
        }else {
            throw new Exception();
        }

    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "TaskItem [title=" + title + ", description=" + description + ", dueDate=" + dueDate + ", isCompleted="
                + isCompleted + "]";
    }

    public boolean validateString(String input) {

        if (input == null || input.length() == 0) {
            return false;
        }
        return true;
    }

    public boolean isValidDate(String dueDate) {

        if (dueDate == null) {
            return false;
        } else if (dueDate.length() != 10) {
            return false;
        } else {
            String[] dateComponents = dueDate.split("-");

            if (dateComponents.length < 3) {
                return false;
            } else if (dateComponents[0].length() < 4 || dateComponents[1].length() < 2
                    || dateComponents[2].length() < 2)

                return false;
        }
        return true;
    }

}
