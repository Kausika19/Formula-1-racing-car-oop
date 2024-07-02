import java.io.Serializable;
import java.util.Objects;

public class Driver implements Serializable {

    private String driverName;
    private String location;
    private String teamName;

    public Driver(String driverName, String location, String teamName) {
        this.driverName = driverName;
        this.location = location;
        this.teamName = teamName;
    }

    public Driver() {
    }

    @Override
    public String toString() {
        return "SportClub{" +
                "driverName='" + driverName + '\'' +
                ", location='" + location + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(driverName, driver.driverName) &&
                Objects.equals(location, driver.location) &&
                Objects.equals(teamName, driver.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, location, teamName);
    }

    public String getDriverName(){ return  driverName;}
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLocation(){ return  location;}
    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeamName(){ return  teamName;}
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }



}

