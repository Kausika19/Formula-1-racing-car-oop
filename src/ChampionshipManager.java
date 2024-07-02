import java.io.IOException;

public interface ChampionshipManager {
    void addDriver(String driverName, String location, String teamName);
    void deleteDriver(String driverName);
    void changeDriver(String teamName);
    void displayStatistics(String driverName);
    void displayTable();
    void addRace(Dates datePlayed,Formula1Driver driver1,Formula1Driver driver2,Formula1Driver driver3,Formula1Driver driver4,
                 Formula1Driver driver5,Formula1Driver driver6,Formula1Driver driver7,Formula1Driver driver8,
                 Formula1Driver driver9,Formula1Driver driver10);
    void save() throws IOException;
    void load();
}
