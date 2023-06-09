/* This class inherits from `Date` class and include time in addition to date */
public class DateTime extends Date {
    int day;
    int month;
    int year;

    int minute;
    int hour;

    /**
     * @param d   day
     * @param m   month
     * @param y   year
     * @param min minute
     * @param h   hour
     */
    public DateTime(int y, int m, int d, int h, int min) {
        super(y, m, d);  // call the constructor of the superclass
        this.minute = min;
        this.hour = h;

        // Input validation
        if (this.minute < 0 || this.minute > 59) {
            this.minute = 0;
        }

        if (this.hour < 0 || this.hour > 23) {
            this.hour = 0;
        }
    }

    public void setDay(int day){this.day = day;}
    public void setMonth(int month){this.month = month;}
    public void setYear(int year){this.year = year;}

    public void setMinute(int minute) {
        if (this.minute < 0 || this.minute > 59) {
            this.minute = 0;
        }else{
            this.minute = minute;
        }
    }

    public void setHour(int hour) {
        if (this.hour < 0 || this.hour > 23) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }

    /**
     * @return a date string in the format DD/MM/YYYY HH:MM
     */
    @Override
    public String toString() {
        String hourString, minuteString;

        // add a leading zero if the hour or minute is less than 10
        if (this.hour < 10) {
            hourString = "0" + this.hour;
        } else {
            hourString = "" + this.hour;
        }
        if (this.minute < 10) {
            minuteString = "0" + this.minute;
        } else {
            minuteString = "" + this.minute;
        }

        return super.toString() + " " + hourString + ":" + minuteString;
    }

    /**
     * @param o object to compare with
     * @return true if the object is a DateTime and has the same day, month, year, hour and minute
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof DateTime) {
            return (this.hashCode() == o.hashCode());
        } else {
            return false;
        }
    }

    /**
     * @return hashcode of the date
     */
    @Override
    public int hashCode() {
        int minutesInHour = 60;
        int hoursInDay = 24;

        // The hashcode of a DateTime is the hashcode of the Date plus the hashcode of the time
        int code = this.minute + this.hour*minutesInHour + Math.abs(super.hashCode())*hoursInDay*minutesInHour;

        if (year < 0) {  // if the year is negative, make the hashcode negative
            return -code;
        } else {
            return code;
        }
    }
}
