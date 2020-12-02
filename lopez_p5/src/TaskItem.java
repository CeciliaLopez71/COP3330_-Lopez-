

public class TaskItem {

    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private boolean isComplete;
    private String title;
    private String description;
    private String date;
    
    public TaskItem()
    {
        this.title = "";
        this.description = "";
        this.date = "";
        this.isComplete = false;
    }
    
    public TaskItem(String _title, String _description, String _date)
    {
        editImpl(_title, _description, _date);
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public void setDate(String _date) {
        this.date = _date;
    }

    public String getDate() {
        return this.date;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesription() {
        return this.description;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void setMarked(boolean _isComplete) {
        this.isComplete = _isComplete;
    }

    //YYYY-MM-DD
    public static boolean isValidDate(String date) {
        String[] dateSplit = date.split("-");

        if (dateSplit.length != 3
                || dateSplit[0].length() != 4
                || dateSplit[1].length() != 2
                || dateSplit[2].length() != 2) {
            return false;
        }

        try {
            int year = Integer.valueOf(dateSplit[0]);

            if (year < 0) {
                return false;
            }

            boolean isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);

            int month = Integer.valueOf(dateSplit[1]);

            if (month < 1 || month > 12) {
                return false;
            }

            int day = Integer.valueOf(dateSplit[2]);

            int daysInMonth = DAYS_IN_MONTH[month - 1];

            if (isLeapYear && month == 2) {
                daysInMonth = daysInMonth + 1;
            }

            if (day < 1 || day > daysInMonth) {
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }  
    
    static boolean isValidTitle(String title) {
        return title.length() > 0;
    }

    static boolean isValidDescription(String description) {
        return true;
    }
    
    public void edit(String _title, String _description, String _date) {
        editImpl(_title, _description, _date);
    }
        
    private void editImpl(String _title, String _description, String _date) {
        
        if (!isValidTitle(_title))
        {
            throw new IllegalArgumentException("Invalid Title!");
        }
        
        if (!isValidDescription(_description))
        {
            throw new IllegalArgumentException("Invalid Description!");
        }
        
        if (!isValidDate(_date))
        {
            throw new IllegalArgumentException("Invalid Date!");
        }

        this.title = _title;
        this.description = _description;
        this.date = _date;
        this.isComplete = false;
    }
}
