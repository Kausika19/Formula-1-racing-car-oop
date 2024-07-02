import java.io.Serializable;
import java.util.Objects;

public class Formula1Driver extends Driver implements Serializable {
    private int firstPosition;               //Number of first position .
    private int secondPosition;             //Number of second position.
    private int thirdPosition;             //Number of third position.
    private int noOfPoints;                //  The number of points that a driver currently has.
    private int noOfRaces;                 //  Number of races the driver participated.

    public Formula1Driver(String driverName, String location, String teamName) {
        super(driverName, location, teamName);
    }

    public Formula1Driver() {}

    @Override
    public String toString() {
        return this.getDriverName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formula1Driver)) return false;
        if (!super.equals(o)) return false;
        Formula1Driver that = (Formula1Driver) o;
        return firstPosition == that.firstPosition &&
               secondPosition == that.secondPosition &&
               thirdPosition == that.thirdPosition &&
               noOfPoints == that.noOfPoints &&
               noOfRaces == that.noOfRaces;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstPosition, secondPosition, thirdPosition, noOfPoints, noOfRaces);
    }

    public Formula1Driver(int firstPosition, int secondPosition, int thirdPosition, int noOfPoints, int noOfRaces) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
        this.noOfPoints = noOfPoints;
        this.noOfRaces = noOfRaces;
    }


    public int getFirstPosition() {
        return firstPosition;
    }
    public void setFirstPosition(int firstPosition) {
        this.firstPosition = firstPosition;
    }

    public int getSecondPosition() {
        return secondPosition;
    }
    public void setSecondPosition(int secondPosition) {
        this.secondPosition = secondPosition;
    }

    public int getThirdPosition() {
        return thirdPosition;
    }
    public void setThirdPosition(int thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }
    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public int getNoOfRaces() {
        return noOfRaces;
    }
    public void setNoOfRaces(int noOfRaces) {
        this.noOfRaces = noOfRaces;
    }


}