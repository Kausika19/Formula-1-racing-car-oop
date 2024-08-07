import java.io.Serializable;
import java.util.Objects;

public class Dates implements Serializable {
    private int day;
    private int month;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dates)) return false;
        Dates dates = (Dates) o;
        return day == dates.day &&
                month == dates.month &&
                year == dates.year;
    }

    public Dates() {
    }

    public Dates(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }



    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
