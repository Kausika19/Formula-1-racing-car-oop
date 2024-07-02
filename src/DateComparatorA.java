import java.util.Comparator;


public class DateComparatorA implements Comparator<Dates> {

    @Override
    public int compare(Dates date1, Dates date2) {

        int result = 0;

        if (date1.getYear() > date2.getYear())
            return 1;
        else if (date1.getYear() < date2.getYear())
            return -1;
        else if (date1.getYear() == date2.getYear()) {
            if (date1.getMonth() > date2.getMonth())
                return 1;
            else if (date1.getMonth() < date2.getMonth())
                return -1;
            else if (date1.getMonth() == date2.getMonth()) {
                if (date1.getDay() > date2.getDay())
                    result = 1;
                else if (date1.getDay() < date2.getDay())
                    result = -1;
                else if (date1.getDay() == date2.getDay())
                    result = 0;
            }
        } else result = 0;

        return result;
    }
}

