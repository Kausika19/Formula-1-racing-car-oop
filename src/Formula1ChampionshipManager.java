import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;

public class Formula1ChampionshipManager implements ChampionshipManager {

    ArrayList<Formula1Driver> driverArrayList = new ArrayList<>();
    ArrayList<RaceDetails> raceArrayList = new ArrayList<>();

    public ArrayList<Formula1Driver> getDriverArrayList() {
        return driverArrayList;
    }

    public void setDriverArrayList(ArrayList<Formula1Driver> driverArrayList) {
        this.driverArrayList = driverArrayList;
    }

    public ArrayList<RaceDetails> getRaceArrayList() {
        return raceArrayList;
    }

    public void setRaceArrayList(ArrayList<RaceDetails> raceArrayList) {
        this.raceArrayList = raceArrayList;
    }


    //Add driver to the list.
    @Override
    public void addDriver(String driverName, String location, String teamName) {

        int a = 0;
        int driverArrayListLength = driverArrayList.size();
        for (int i = 0; i < driverArrayListLength; i++) {
            if (driverArrayList.get(i).getTeamName().contains(teamName)) {
                a = 1;
            } else if (!(driverArrayList.get(i).getTeamName().contains(teamName))) {
                a = 0;
            }
        }
        if (a == 0) {
            Formula1Driver formula1Driver = new Formula1Driver(driverName, location, teamName);
            driverArrayList.add(formula1Driver);
            System.out.println("Driver added successfully !");
        } else if (a == 1) {
            System.out.println("Driver cannot be added! Entered team already has a driver !");
        }
    }


    //Delete an existing driver
    @Override
    public void deleteDriver(String driverName) {
        for (Formula1Driver driver : driverArrayList) {
            if (driver.getDriverName().equals(driverName)) {
                driverArrayList.remove(driver);
                System.out.println("The driver " + driverName + " has been removed successfully!");
                return;
            }
        }
        System.out.println(driverName + " driver is not found!");
    }


    //Changing the driver in an existing team. Assumption: points belong to the teams.
    @Override
    public void changeDriver(String teamName) {

        boolean ans = false;
        for (Formula1Driver driver : driverArrayList) {
            if (teamName.equals(driver.getTeamName())) {
                System.out.print("Please enter the new driver name to change : ");
                Scanner dn = new Scanner(System.in);
                String newDriverName = dn.nextLine();
                driver.setDriverName(newDriverName);
                ans = true;
                System.out.println(newDriverName + " has been changed to team " + teamName + "!");
            }
        }
        if (ans == false)
            System.out.println("Entered team does not exist!");
    }

    //Displaying statistics for a driver entered by the user.
    @Override
    public void displayStatistics(String driverName) {

        for (Formula1Driver drive : driverArrayList) {
            if (drive.getDriverName().equals(driverName)) {
                System.out.println(" Driver Name        : " + drive.getDriverName());
                System.out.println(" Team Name          : " + drive.getTeamName());
                System.out.println(" Driver Location    : " + drive.getLocation());
                System.out.println(" First Position     : " + drive.getFirstPosition());
                System.out.println(" Second Position    : " + drive.getSecondPosition());
                System.out.println(" Third Position     : " + drive.getThirdPosition());
                System.out.println(" Total Races Played : " + drive.getNoOfRaces());
                System.out.println(" Total Points       : " + drive.getNoOfPoints());
                return;
            }
        }
        System.out.println("Entered driver is not in the list!");
    }


    //Display all drivers' statistics in a table
    @Override
    public void displayTable() {

        Collections.sort(driverArrayList, new ComparatorD());

        System.out.println("                                                           Premier League Table");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%8s %8s %10s %8s %15s %8s %8s %8s %8s %8s %8s %8s %8s %8s %8s %8s", "DRIVER", "|", "LOCATION", "|", "TEAM", "|", "POINTS", "|", "1ST POSITIONS", "|", "2ND POSITIONS", "|", "3RD POSITIONS", "|", "RACES", "|");
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Formula1Driver driver : driverArrayList) {
            System.out.printf("%8s %8s %10s %8s %15s %8s %8s %8s %8s %13s %11s %10s %10s %11s %10s %7s",
                    driver.getDriverName(), "|", driver.getLocation(), "|", driver.getTeamName(), "|", driver.getNoOfPoints(), "|", driver.getFirstPosition(), "|", driver.getSecondPosition(), "|", driver.getThirdPosition(), "|", driver.getNoOfRaces(), "|" + "\n");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    //Add a race. User must enter 10 drivers names correctly as in the list!
    @Override
    public void addRace(Dates datePlayed, Formula1Driver driver1, Formula1Driver driver2, Formula1Driver driver3, Formula1Driver driver4,
                        Formula1Driver driver5, Formula1Driver driver6, Formula1Driver driver7, Formula1Driver driver8,
                        Formula1Driver driver9, Formula1Driver driver10) {


        RaceDetails raceDetails = new RaceDetails(datePlayed, driver1, driver2, driver3, driver4, driver5, driver6, driver7, driver8, driver9, driver10);
        raceArrayList.add(raceDetails);
        updatePoints(raceDetails);

        System.out.println("----Added race details----");
        System.out.println(" ");
        System.out.println("Race Date: " + datePlayed);
        System.out.println(" ");
        System.out.println("1st Place: " + driver1);
        System.out.println("2nd Place: " + driver2);
        System.out.println("3rd Place: " + driver3);
        System.out.println("4th Place: " + driver4);
        System.out.println("5th Place: " + driver5);
        System.out.println("6th Place: " + driver6);
        System.out.println("7th Place: " + driver7);
        System.out.println("8th Place: " + driver8);
        System.out.println("9th Place: " + driver9);
        System.out.println("10th Place: " + driver10);

    }


    //Update the points of the drivers.
    private void updatePoints(RaceDetails raceDetails) {

        raceDetails.getDriver1().setNoOfRaces(raceDetails.getDriver1().getNoOfRaces() + 1);
        raceDetails.getDriver2().setNoOfRaces(raceDetails.getDriver2().getNoOfRaces() + 1);
        raceDetails.getDriver3().setNoOfRaces(raceDetails.getDriver3().getNoOfRaces() + 1);
        raceDetails.getDriver4().setNoOfRaces(raceDetails.getDriver4().getNoOfRaces() + 1);
        raceDetails.getDriver5().setNoOfRaces(raceDetails.getDriver5().getNoOfRaces() + 1);
        raceDetails.getDriver6().setNoOfRaces(raceDetails.getDriver6().getNoOfRaces() + 1);
        raceDetails.getDriver7().setNoOfRaces(raceDetails.getDriver7().getNoOfRaces() + 1);
        raceDetails.getDriver8().setNoOfRaces(raceDetails.getDriver8().getNoOfRaces() + 1);
        raceDetails.getDriver9().setNoOfRaces(raceDetails.getDriver9().getNoOfRaces() + 1);
        raceDetails.getDriver10().setNoOfRaces(raceDetails.getDriver10().getNoOfRaces() + 1);


        raceDetails.getDriver1().setNoOfPoints(raceDetails.getDriver1().getNoOfPoints() + raceDetails.getDriver1Points());
        raceDetails.getDriver2().setNoOfPoints(raceDetails.getDriver2().getNoOfPoints() + raceDetails.getDriver2Points());
        raceDetails.getDriver3().setNoOfPoints(raceDetails.getDriver3().getNoOfPoints() + raceDetails.getDriver3Points());
        raceDetails.getDriver4().setNoOfPoints(raceDetails.getDriver4().getNoOfPoints() + raceDetails.getDriver4Points());
        raceDetails.getDriver5().setNoOfPoints(raceDetails.getDriver5().getNoOfPoints() + raceDetails.getDriver5Points());
        raceDetails.getDriver6().setNoOfPoints(raceDetails.getDriver6().getNoOfPoints() + raceDetails.getDriver6Points());
        raceDetails.getDriver7().setNoOfPoints(raceDetails.getDriver7().getNoOfPoints() + raceDetails.getDriver7Points());
        raceDetails.getDriver8().setNoOfPoints(raceDetails.getDriver8().getNoOfPoints() + raceDetails.getDriver8Points());
        raceDetails.getDriver9().setNoOfPoints(raceDetails.getDriver9().getNoOfPoints() + raceDetails.getDriver9Points());
        raceDetails.getDriver10().setNoOfPoints(raceDetails.getDriver10().getNoOfPoints() + raceDetails.getDriver10Points());


        raceDetails.getDriver1().setFirstPosition(raceDetails.getDriver1().getFirstPosition() + 1);
        raceDetails.getDriver2().setSecondPosition(raceDetails.getDriver2().getSecondPosition() + 1);
        raceDetails.getDriver3().setThirdPosition(raceDetails.getDriver3().getThirdPosition() + 1);
    }


    //Save the details entered by the user.
    @Override
    public void save() throws IOException {

        FileOutputStream driverOutputStream = new FileOutputStream("DriverFile.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(driverOutputStream);
        outputStream.writeObject(driverArrayList);
        outputStream.close();
        driverOutputStream.close();

        FileOutputStream RaceOutput = new FileOutputStream("RaceDetailsFile.ser");
        ObjectOutputStream output = new ObjectOutputStream(RaceOutput);
        output.writeObject(raceArrayList);
        output.close();
        RaceOutput.close();

    }


    //Load the saved file. File will load each time when it runs.
    @Override
    public void load() {

        try {
            FileInputStream driverInputStream = new FileInputStream("DriverFile.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(driverInputStream);
            Object d = objectInputStream.readObject();

            driverArrayList = (ArrayList<Formula1Driver>) d;

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream RaceOutput = new FileInputStream("RaceDetailsFile.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(RaceOutput);
            Object r = objectInputStream.readObject();
            raceArrayList = (ArrayList<RaceDetails>) r;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    public void gui() {

        JFrame frame = new JFrame("GUI");
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(2, 4));
        panel.setVisible(true);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(600, 500);
        panel.setBackground(Color.GRAY);


        JLabel l = new JLabel("      ----OPTIONS---- ");
        JButton b1 = new JButton("TABLE 1");               //creating instance of JButton for 1st table(drivers and their statistics in descending order).
        JButton b2 = new JButton("TABLE 2");               //creating instance of JButton for 2nd table(drivers and their statistics in ascending order).
        JButton b3 = new JButton("TABLE 3");               //creating JButton for 3rd table(drivers and their statistics in descending order according to the number of 1st position).
        JButton b4 = new JButton("Generate Race");           //Generating races and giving positions randomly for drivers.
        JButton b5 = new JButton("Winning Probability");
        JButton b6 = new JButton("Races Dates");               //Races sorted in ascending order of the played date.
        JButton b7 = new JButton("Search Race");               //Searching for the participated race dates and the positions of a certain driver.

        panel.add(l);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);


        ActionListener a1 = new ActionListener() {
            public void actionPerformed(ActionEvent e1) {

                Collections.sort(driverArrayList, new ComparatorD());

                eventMethod();

            }
        };
        b1.addActionListener(a1);

        ActionListener a2 = new ActionListener() {
            public void actionPerformed(ActionEvent e2) {

                Collections.sort(driverArrayList, new ComparatorA());
                eventMethod();
            }
        };

        b2.addActionListener(a2);

        ActionListener a3 = new ActionListener() {
            public void actionPerformed(ActionEvent e3) {
                Collections.sort(driverArrayList, new ComparatorP());
                eventMethod();
            }
        };

        b3.addActionListener(a3);

        ActionListener a4 = new ActionListener() {
            public void actionPerformed(ActionEvent e4) {

                JFrame frame = new JFrame("Race");
                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout(0, 1));
                frame.add(panel);
                frame.setVisible(true);
                frame.setSize(300, 400);

                //DAY
                Random randomD = new Random();
                int lowD = 1;
                int highD = 28;
                int day = randomD.nextInt(highD - lowD) + lowD;

                //MONTH
                Random randomM = new Random();
                int lowM = 1;
                int highM = 12;
                int month = randomM.nextInt(highM - lowM) + lowM;

                //YEAR
                Random randomY = new Random();
                int lowY = 2012;
                int highY = 2021;
                int year = randomY.nextInt(highY - lowY) + lowY;

                Dates datePlayed = new Dates(day, month, year);

                JLabel l = new JLabel("  Race date (DD/MM/YYYY) = " + datePlayed);
                panel.add(l);
                JLabel a = new JLabel(" ");

                //Array for storing drivers name according to their positions(temporary)
                Formula1Driver[] nameList = new Formula1Driver[10];

                int n = driverArrayList.size();
                //ArrayList for generating random values.
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 1; i < (n + 1); i++) {
                    list.add(i);
                }

                Collections.shuffle(list);

                //Assumption: Only 10 drivers can participate in a race
                int r = 0;
                for (Formula1Driver driver : driverArrayList) {

                    int racePosition = list.get(r);
                    r++;
                    switch (racePosition) {
                        case 1:
                            driver.setFirstPosition(driver.getFirstPosition() + 1);
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 25);

                            String dn1 = driver.getDriverName();

                            Formula1Driver driver1 = null;
                            for (Formula1Driver drivers1 : getDriverArrayList()) {
                                if (drivers1.getDriverName().equals(dn1))
                                    driver1 = drivers1;
                                nameList[0] = driver1;
                            }

                            JLabel d1 = new JLabel("   1st Position  :  " + driver.getDriverName());
                            panel.add(d1);
                            panel.add(a);
                            break;
                        case 2:
                            driver.setSecondPosition(driver.getSecondPosition() + 1);
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 18);

                            String dn2 = driver.getDriverName();

                            Formula1Driver driver2 = null;
                            for (Formula1Driver drivers2 : getDriverArrayList()) {
                                if (drivers2.getDriverName().equals(dn2))
                                    driver2 = drivers2;
                                nameList[1] = driver2;
                            }

                            JLabel d2 = new JLabel("   2nd Position :  " + driver.getDriverName());
                            panel.add(d2);
                            panel.add(a);
                            break;
                        case 3:
                            driver.setThirdPosition(driver.getThirdPosition() + 1);
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 15);

                            String dn3 = driver.getDriverName();

                            Formula1Driver driver3 = null;
                            for (Formula1Driver drivers3 : getDriverArrayList()) {
                                if (drivers3.getDriverName().equals(dn3))
                                    driver3 = drivers3;
                                nameList[2] = driver3;
                            }

                            JLabel d3 = new JLabel("   3rd Position  :  " + driver.getDriverName());
                            panel.add(d3);
                            break;
                        case 4:
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 12);

                            String dn4 = driver.getDriverName();

                            Formula1Driver driver4 = null;
                            for (Formula1Driver drivers4 : getDriverArrayList()) {
                                if (drivers4.getDriverName().equals(dn4))
                                    driver4 = drivers4;
                                nameList[3] = driver4;
                            }

                            JLabel d4 = new JLabel("   4th Position  :  " + driver.getDriverName());
                            panel.add(d4);
                            panel.add(a);
                            break;
                        case 5:
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 10);

                            String dn5 = driver.getDriverName();

                            Formula1Driver driver5 = null;
                            for (Formula1Driver drivers5 : getDriverArrayList()) {
                                if (drivers5.getDriverName().equals(dn5))
                                    driver5 = drivers5;
                                nameList[4] = driver5;
                            }

                            JLabel d5 = new JLabel("   5th Position  :  " + driver.getDriverName());
                            panel.add(d5);
                            panel.add(a);
                            break;
                        case 6:
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 8);

                            String dn6 = driver.getDriverName();

                            Formula1Driver driver6 = null;
                            for (Formula1Driver drivers6 : getDriverArrayList()) {
                                if (drivers6.getDriverName().equals(dn6))
                                    driver6 = drivers6;
                                nameList[5] = driver6;
                            }

                            JLabel d6 = new JLabel("   6th Position  :  " + driver.getDriverName());
                            panel.add(d6);
                            panel.add(a);
                            break;
                        case 7:
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 6);

                            String dn7 = driver.getDriverName();

                            Formula1Driver driver7 = null;
                            for (Formula1Driver drivers7 : getDriverArrayList()) {
                                if (drivers7.getDriverName().equals(dn7))
                                    driver7 = drivers7;
                                nameList[6] = driver7;
                            }

                            JLabel d7 = new JLabel("   7th Position  :  " + driver.getDriverName());
                            panel.add(d7);
                            panel.add(a);
                            break;
                        case 8:
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 4);

                            String dn8 = driver.getDriverName();

                            Formula1Driver driver8 = null;
                            for (Formula1Driver drivers8 : getDriverArrayList()) {
                                if (drivers8.getDriverName().equals(dn8))
                                    driver8 = drivers8;
                                nameList[7] = driver8;
                            }

                            JLabel d8 = new JLabel("   8th Position  :  " + driver.getDriverName());
                            panel.add(d8);
                            panel.add(a);
                            break;
                        case 9:
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 2);

                            String dn9 = driver.getDriverName();

                            Formula1Driver driver9 = null;
                            for (Formula1Driver drivers9 : getDriverArrayList()) {
                                if (drivers9.getDriverName().equals(dn9))
                                    driver9 = drivers9;
                                nameList[8] = driver9;
                            }

                            JLabel d9 = new JLabel("   9th Position  :  " + driver.getDriverName());
                            panel.add(d9);
                            panel.add(a);
                            break;
                        case 10:
                            driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                            driver.setNoOfPoints(driver.getNoOfPoints() + 1);

                            String dn10 = driver.getDriverName();

                            Formula1Driver driver10 = null;
                            for (Formula1Driver drivers10 : getDriverArrayList()) {
                                if (drivers10.getDriverName().equals(dn10))
                                    driver10 = drivers10;
                                nameList[9] = driver10;
                            }

                            JLabel d10 = new JLabel("   10th Position:  " + driver.getDriverName());
                            panel.add(d10);
                            panel.add(a);
                            break;
                        default:
                            break;
                    }
                }

                RaceDetails raceDetails = new RaceDetails(datePlayed, nameList[0], nameList[1], nameList[2], nameList[3], nameList[4], nameList[5], nameList[6], nameList[7], nameList[8], nameList[9]);
                raceArrayList.add(raceDetails);
            }
        };
        b4.addActionListener(a4);

        ActionListener a5 = new ActionListener() {
            public void actionPerformed(ActionEvent e5) {
                JFrame frame = new JFrame("Winning Probability");
                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout(0, 1));
                frame.add(panel);
                frame.setVisible(true);
                frame.setSize(500, 600);


                //DAY
                Random randomD = new Random();
                int lowD = 1;
                int highD = 28;
                int day = randomD.nextInt(highD - lowD) + lowD;

                //MONTH
                Random randomM = new Random();
                int lowM = 1;
                int highM = 12;
                int month = randomM.nextInt(highM - lowM) + lowM;

                //YEAR
                Random randomY = new Random();
                int lowY = 2012;
                int highY = 2021;
                int year = randomY.nextInt(highY - lowY) + lowY;

                Dates datePlayed = new Dates(day, month, year);

                JLabel l = new JLabel("  Race date (DD/MM/YYYY) = " + datePlayed);
                panel.add(l);
                JLabel a = new JLabel("******************************************");
                JLabel b = new JLabel("  --Starting Position--  ");
                panel.add(a);
                panel.add(b);

                Formula1Driver[] startNameList = new Formula1Driver[10];

                int num = driverArrayList.size();

                ArrayList<Integer> startPositionList = new ArrayList<Integer>();
                for (int i = 1; i < (num + 1); i++) {
                    startPositionList.add(i);
                }
                Collections.shuffle(startPositionList);

                int s = 0;
                for (Formula1Driver driver : driverArrayList) {
                    int startPosition = startPositionList.get(s);
                    s++;
                    switch (startPosition) {
                        case 1:
                            String dn1 = driver.getDriverName();

                            Formula1Driver driver1 = null;
                            for (Formula1Driver drivers1 : getDriverArrayList()) {
                                if (drivers1.getDriverName().equals(dn1))
                                    driver1 = drivers1;
                                startNameList[0] = driver1;
                            }
                            JLabel d1 = new JLabel("   1st Starting Position  :  " + driver.getDriverName());
                            panel.add(d1);
                            break;

                        case 2:
                            String dn2 = driver.getDriverName();

                            Formula1Driver driver2 = null;
                            for (Formula1Driver drivers2 : getDriverArrayList()) {
                                if (drivers2.getDriverName().equals(dn2))
                                    driver2 = drivers2;
                                startNameList[1] = driver2;
                            }
                            JLabel d2 = new JLabel("   2nd Starting Position :  " + driver.getDriverName());
                            panel.add(d2);
                            break;
                        case 3:
                            String dn3 = driver.getDriverName();

                            Formula1Driver driver3 = null;
                            for (Formula1Driver drivers3 : getDriverArrayList()) {
                                if (drivers3.getDriverName().equals(dn3))
                                    driver3 = drivers3;
                                startNameList[2] = driver3;
                            }
                            JLabel d3 = new JLabel("   3rd Starting Position  :  " + driver.getDriverName());
                            panel.add(d3);
                            break;
                        case 4:
                            String dn4 = driver.getDriverName();

                            Formula1Driver driver4 = null;
                            for (Formula1Driver drivers4 : getDriverArrayList()) {
                                if (drivers4.getDriverName().equals(dn4))
                                    driver4 = drivers4;
                                startNameList[3] = driver4;
                            }
                            JLabel d4 = new JLabel("   4th Starting Position  :  " + driver.getDriverName());
                            panel.add(d4);
                            break;
                        case 5:
                            String dn5 = driver.getDriverName();

                            Formula1Driver driver5 = null;
                            for (Formula1Driver drivers5 : getDriverArrayList()) {
                                if (drivers5.getDriverName().equals(dn5))
                                    driver5 = drivers5;
                                startNameList[4] = driver5;
                            }
                            JLabel d5 = new JLabel("   5th Starting Position  :  " + driver.getDriverName());
                            panel.add(d5);
                            break;
                        case 6:
                            String dn6 = driver.getDriverName();

                            Formula1Driver driver6 = null;
                            for (Formula1Driver drivers6 : getDriverArrayList()) {
                                if (drivers6.getDriverName().equals(dn6))
                                    driver6 = drivers6;
                                startNameList[5] = driver6;
                            }
                            JLabel d6 = new JLabel("   6th Starting Position  :  " + driver.getDriverName());
                            panel.add(d6);
                            break;
                        case 7:
                            String dn7 = driver.getDriverName();

                            Formula1Driver driver7 = null;
                            for (Formula1Driver drivers7 : getDriverArrayList()) {
                                if (drivers7.getDriverName().equals(dn7))
                                    driver7 = drivers7;
                                startNameList[6] = driver7;
                            }
                            JLabel d7 = new JLabel("   7th Starting Position  :  " + driver.getDriverName());
                            panel.add(d7);
                            break;
                        case 8:
                            String dn8 = driver.getDriverName();

                            Formula1Driver driver8 = null;
                            for (Formula1Driver drivers8 : getDriverArrayList()) {
                                if (drivers8.getDriverName().equals(dn8))
                                    driver8 = drivers8;
                                startNameList[7] = driver8;
                            }
                            JLabel d8 = new JLabel("   8th Starting Position  :  " + driver.getDriverName());
                            panel.add(d8);
                            break;
                        case 9:
                            String dn9 = driver.getDriverName();

                            Formula1Driver driver9 = null;
                            for (Formula1Driver drivers9 : getDriverArrayList()) {
                                if (drivers9.getDriverName().equals(dn9))
                                    driver9 = drivers9;
                                startNameList[8] = driver9;
                            }
                            JLabel d9 = new JLabel("   9th Starting Position  :  " + driver.getDriverName());
                            panel.add(d9);
                            break;
                        case 10:
                            String dn10 = driver.getDriverName();

                            Formula1Driver driver10 = null;
                            for (Formula1Driver drivers10 : getDriverArrayList()) {
                                if (drivers10.getDriverName().equals(dn10))
                                    driver10 = drivers10;
                                startNameList[9] = driver10;
                            }
                            JLabel d10 = new JLabel("   10th Starting Position:  " + driver.getDriverName());
                            panel.add(d10);
                            break;
                        default:
                            break;
                    }
                }

                panel.add(a);

                JLabel b1 = new JLabel("  --Drivers' Position--  ");
                panel.add(b1);

                //Array to store drivers name according to their positions(temporary)
                Formula1Driver[] nameList = new Formula1Driver[10];

                    int n = driverArrayList.size();
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for (int i = 1; i < (n + 1); i++) {
                        list.add(i);
                    }

                    Collections.shuffle(list);

                    //Assumption: Only 10 drivers can participate in a race
                    int r = 0;
                    for (Formula1Driver driver : driverArrayList) {

                        int racePosition = list.get(r);
                        r++;
                        switch (racePosition) {
                                case 1:

                                  //  if(startPosition==1) {}
                                    driver.setFirstPosition(driver.getFirstPosition() + 1);
                                    driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                    driver.setNoOfPoints(driver.getNoOfPoints() + 25);

                                    String dn1 = driver.getDriverName();

                                    Formula1Driver driver1 = null;
                                    for (Formula1Driver drivers1 : getDriverArrayList()) {
                                        if (drivers1.getDriverName().equals(dn1))
                                            driver1 = drivers1;
                                        nameList[0] = driver1;
                                    }

                                    JLabel d1 = new JLabel("   1st Position  :  " + driver.getDriverName());
                                    panel.add(d1);
                                    break;
                            case 2:
                                driver.setSecondPosition(driver.getSecondPosition() + 1);
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 18);

                                String dn2 = driver.getDriverName();

                                Formula1Driver driver2 = null;
                                for (Formula1Driver drivers2 : getDriverArrayList()) {
                                    if (drivers2.getDriverName().equals(dn2))
                                        driver2 = drivers2;
                                    nameList[1] = driver2;
                                }

                                JLabel d2 = new JLabel("   2nd Position :  " + driver.getDriverName());
                                panel.add(d2);
                                break;
                            case 3:
                                driver.setThirdPosition(driver.getThirdPosition() + 1);
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 15);

                                String dn3 = driver.getDriverName();

                                Formula1Driver driver3 = null;
                                for (Formula1Driver drivers3 : getDriverArrayList()) {
                                    if (drivers3.getDriverName().equals(dn3))
                                        driver3 = drivers3;
                                    nameList[2] = driver3;
                                }

                                JLabel d3 = new JLabel("   3rd Position  :  " + driver.getDriverName());
                                panel.add(d3);
                                break;
                            case 4:
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 12);

                                String dn4 = driver.getDriverName();

                                Formula1Driver driver4 = null;
                                for (Formula1Driver drivers4 : getDriverArrayList()) {
                                    if (drivers4.getDriverName().equals(dn4))
                                        driver4 = drivers4;
                                    nameList[3] = driver4;
                                }

                                JLabel d4 = new JLabel("   4th Position  :  " + driver.getDriverName());
                                panel.add(d4);
                                break;
                            case 5:
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 10);

                                String dn5 = driver.getDriverName();

                                Formula1Driver driver5 = null;
                                for (Formula1Driver drivers5 : getDriverArrayList()) {
                                    if (drivers5.getDriverName().equals(dn5))
                                        driver5 = drivers5;
                                    nameList[4] = driver5;
                                }

                                JLabel d5 = new JLabel("   5th Position  :  " + driver.getDriverName());
                                panel.add(d5);
                                break;
                            case 6:
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 8);

                                String dn6 = driver.getDriverName();

                                Formula1Driver driver6 = null;
                                for (Formula1Driver drivers6 : getDriverArrayList()) {
                                    if (drivers6.getDriverName().equals(dn6))
                                        driver6 = drivers6;
                                    nameList[5] = driver6;
                                }

                                JLabel d6 = new JLabel("   6th Position  :  " + driver.getDriverName());
                                panel.add(d6);
                                break;
                            case 7:
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 6);

                                String dn7 = driver.getDriverName();

                                Formula1Driver driver7 = null;
                                for (Formula1Driver drivers7 : getDriverArrayList()) {
                                    if (drivers7.getDriverName().equals(dn7))
                                        driver7 = drivers7;
                                    nameList[6] = driver7;
                                }

                                JLabel d7 = new JLabel("   7th Position  :  " + driver.getDriverName());
                                panel.add(d7);
                                break;
                            case 8:
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 4);

                                String dn8 = driver.getDriverName();

                                Formula1Driver driver8 = null;
                                for (Formula1Driver drivers8 : getDriverArrayList()) {
                                    if (drivers8.getDriverName().equals(dn8))
                                        driver8 = drivers8;
                                    nameList[7] = driver8;
                                }

                                JLabel d8 = new JLabel("   8th Position  :  " + driver.getDriverName());
                                panel.add(d8);
                                break;
                            case 9:
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 2);

                                String dn9 = driver.getDriverName();

                                Formula1Driver driver9 = null;
                                for (Formula1Driver drivers9 : getDriverArrayList()) {
                                    if (drivers9.getDriverName().equals(dn9))
                                        driver9 = drivers9;
                                    nameList[8] = driver9;
                                }

                                JLabel d9 = new JLabel("   9th Position  :  " + driver.getDriverName());
                                panel.add(d9);
                                break;
                            case 10:
                                driver.setNoOfRaces(driver.getNoOfRaces() + 1);
                                driver.setNoOfPoints(driver.getNoOfPoints() + 1);

                                String dn10 = driver.getDriverName();

                                Formula1Driver driver10 = null;
                                for (Formula1Driver drivers10 : getDriverArrayList()) {
                                    if (drivers10.getDriverName().equals(dn10))
                                        driver10 = drivers10;
                                    nameList[9] = driver10;
                                }

                                JLabel d10 = new JLabel("   10th Position:  " + driver.getDriverName());
                                panel.add(d10);
                                break;
                            default:
                                break;
                            }

                        }
                RaceDetails raceDetails = new RaceDetails(datePlayed, nameList[0], nameList[1], nameList[2], nameList[3], nameList[4], nameList[5], nameList[6], nameList[7], nameList[8], nameList[9]);
                raceArrayList.add(raceDetails);
                }

            };

        b5.addActionListener(a5);


        ActionListener a6 = new ActionListener() {
            public void actionPerformed(ActionEvent e6) {
                JFrame frame = new JFrame("Sorted Race Dates");
                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout());
                frame.add(panel);
                frame.setVisible(true);
                frame.setSize(400, 500);


                ArrayList<Dates> datesList = new ArrayList<Dates>();

                for (RaceDetails race : raceArrayList) {
                    Dates date = race.getDatePlayed();
                    datesList.add(date);
                }

                Collections.sort(datesList, new DateComparatorA());


                DefaultTableModel tableModel = new DefaultTableModel(1, 0);
                JTable table = new JTable(tableModel);
                table.setFont (table.getFont ().deriveFont (18.0f));
                table.setRowHeight(20);

                panel.add(table);
                tableModel.addColumn("Dates", new String[]{"                          RACE DATES"});

                for (int i = 0; i < datesList.size(); i++) {
                    Dates d = datesList.get(i);

                    Object[] data = {"    " + d};
                    tableModel.addRow(data);
                }
            }
        };

        b6.addActionListener(a6);


        ActionListener a7 = new ActionListener() {
            public void actionPerformed(ActionEvent e7) {

                JFrame frame = new JFrame("Race");
                JPanel panel = new JPanel();

                panel.setLayout(new FlowLayout());
                frame.add(panel);
                frame.setVisible(true);
                frame.setSize(800, 300);

                JLabel l1 = new JLabel("Driver Name: ");
                JTextField t1 = new JTextField(20);

                panel.add(l1);
                panel.add(t1);

                String name = t1.getText();
                JButton b = new JButton("Search for Race Details");
                panel.add(b);

                ActionListener a = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Race Details");
                        JPanel panel = new JPanel();

                        panel.setLayout(new GridLayout(20, 3));
                        frame.add(panel);
                        frame.setVisible(true);
                        frame.setSize(800, 800);

                        JLabel l = new JLabel("                                               " +
                                "  -----------------------------------Race Details-----------------------------------");
                        panel.add(l);

                        for (Formula1Driver driver : driverArrayList) {
                            if (driver.getDriverName().equals(t1.getText())) {
                                JLabel t = new JLabel("                       Driver Name:    " + driver.getDriverName() + "         Team Name:   " + driver.getTeamName() + "         Location:    " + driver.getLocation());
                                panel.add(t);
                                for (RaceDetails race : raceArrayList) {

                                    if (race.getDriver1().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver1() + "'s position:    1st Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver2().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver2() + "'s position:    2nd Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver3().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver3() + "'s position:    3rd Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver4().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver4() + "'s position:    4th Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver5().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver5() + "'s position:    5th Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver6().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver6() + "'s position:    6th Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver7().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver7() + "'s position:    7th Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver8().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver8() + "'s position:    8th Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver9().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver9() + "'s position:    9th Place  ");
                                        panel.add(l2);
                                    } else if (race.getDriver10().toString().equals(t1.getText())) {
                                        JLabel l2 = new JLabel("  Race Date:  " + race.getDatePlayed() + "       Driver " + race.getDriver10() + "'s position:    10th Place  ");
                                        panel.add(l2);
                                    }
                                }
                            }
                        }
                    }
                };
                b.addActionListener(a);
            }
        };
        b7.addActionListener(a7);
    }

    public void eventMethod() {
        JFrame frame = new JFrame("TABLE ");
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());
        panel.setVisible(true);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(800, 300);

        JLabel l1 = new JLabel("Formula 1 Championship Drivers & Statistics");
        panel.add(l1);

        //Creating JTable
        String col[] = {"Name", "Team", "Location", "Points", "1st position", "2nd position", "3rd position", "No of Race"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        JTable table = new JTable(tableModel);

        panel.add(table);
        tableModel.addRow(col);

        //Load arraylist data into the JTable
        for (int i = 0; i < driverArrayList.size(); i++) {

            String driverName = driverArrayList.get(i).getDriverName();
            String teamName = driverArrayList.get(i).getTeamName();
            String location = driverArrayList.get(i).getLocation();
            int points = driverArrayList.get(i).getNoOfPoints();
            int first = driverArrayList.get(i).getFirstPosition();
            int second = driverArrayList.get(i).getSecondPosition();
            int third = driverArrayList.get(i).getThirdPosition();
            int noOfRace = driverArrayList.get(i).getNoOfRaces();

            Object[] data = {driverName, teamName, location, points, first, second,
                    third, noOfRace};

            tableModel.addRow(data);

        }

        table.getColumnModel().getColumn(1).setPreferredWidth(90);


    }
    }

