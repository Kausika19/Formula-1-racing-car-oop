import java.util.Comparator;

public class ComparatorP implements Comparator<Formula1Driver> {

    @Override
    public int compare(Formula1Driver driver1, Formula1Driver driver2) {

        if(driver1.getFirstPosition() > driver2.getFirstPosition())
            return -1;

        else if(driver1.getFirstPosition() < driver2.getFirstPosition())
            return 1;

        else {
            if (driver1.getNoOfPoints() > driver2.getNoOfPoints())
                return -1;

            else if (driver1.getNoOfPoints() < driver2.getNoOfPoints())
                return 1;
            else return 0;
        }
    }

}
