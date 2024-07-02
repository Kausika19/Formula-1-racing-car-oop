import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {


        Formula1ChampionshipManager FCM = new Formula1ChampionshipManager();
        FCM.load();

        while (true) {
            Main.Menu(FCM);
            break;
        }
    }

    public static void Menu(Formula1ChampionshipManager FCM) throws IOException {

        while (true) {
            System.out.println("");
            System.out.println("------------------------------Main Menu------------------------------");
            System.out.println(" ");
            System.out.println(
                    "Press 1 : To add a new driver\n" +
                            "Press 2 : To delete a driver\n" +
                            "Press 3 : To change the driver\n" +
                            "Press 4 : To display team statistics\n" +
                            "Press 5 : To display Formula1Driver Table\n" +
                            "Press 6 : To add a race  \n" +
                            "Press 7 : To save in a file  \n" +
                            "Press 8 : GUI  \n" +
                            "Press 9 : To quit \n"
            );
            try {

                System.out.print("Enter your choice : ");
                Scanner sc = new Scanner(System.in);
                int userOption = sc.nextInt();

                if (userOption == 1) {

                    Scanner dnameSc = new Scanner(System.in);
                    Scanner locationSc = new Scanner(System.in);
                    Scanner tnameSc = new Scanner(System.in);

                    System.out.println("");

                    System.out.println("Enter the driver name : ");
                    String driverName = dnameSc.nextLine();
                    System.out.println("Enter the driver location : ");
                    String location = locationSc.nextLine();
                    System.out.println("Enter the team name :");
                    String teamName = tnameSc.nextLine();

                    FCM.addDriver(driverName, location, teamName);

                } else if (userOption == 2) {

                    System.out.println("");
                    System.out.print("Please enter the driver name to delete : ");
                    Scanner dn = new Scanner(System.in);
                    String driverName = dn.nextLine();
                    FCM.deleteDriver(driverName);
                    continue;

                } else if (userOption == 3) {

                    System.out.println("");
                    System.out.print("Please enter the TEAM NAME to change the driver : ");
                    Scanner tn = new Scanner(System.in);
                    String teamName = tn.nextLine();
                    FCM.changeDriver(teamName);

                } else if (userOption == 4) {

                    System.out.println("");
                    System.out.println("--------------------------Driver Statistics--------------------------");
                    System.out.println(" ");
                    System.out.print("Please enter the driver name : ");
                    Scanner dn = new Scanner(System.in);
                    String driverName = dn.nextLine();
                    FCM.displayStatistics(driverName);

                } else if (userOption == 5) {
                    System.out.println("");
                    FCM.displayTable();


                } else if (userOption == 6) {
                    Scanner dayScanner = new Scanner(System.in);
                    Scanner scan = new Scanner(System.in);

                    System.out.println("");

                    // Entering Race Played date between the Clubs
                    System.out.println("Enter the race date : ");
                    System.out.print("Day: ");
                    int day = dayScanner.nextInt();
                    System.out.print("Month: ");
                    int month = dayScanner.nextInt();
                    System.out.print("Year: ");
                    int year = dayScanner.nextInt();
                    if(day<1 || day>28 || month<1 || month>12 || year<2012 || year>2021){System.out.println("Entered date is wrong");continue;}
                    Dates datePlayed = new Dates(day, month, year);
                    System.out.println("Race date (DD/MM/YYYY) = " + datePlayed);
                    System.out.println("");

                    System.out.println("----Once you start entering names you have to write 10 drivers names correctly!---- ");

                    boolean wrongAns = true;

                    System.out.println("");
                    System.out.println("Drivers name: \n");
                    for (Formula1Driver driver : FCM.driverArrayList) {
                        System.out.println("- " + driver.getDriverName());
                    }
                    System.out.println("");


                    // Entering name of the 1st winner.
                    System.out.println("Enter the 1st position driver name : ");
                    String p1 = scan.nextLine();
                    for (Formula1Driver drive : FCM.driverArrayList) {
                        if (drive.getDriverName().equals(p1)) {
                            wrongAns = false;
                        }
                    }
                    if (wrongAns == true) {
                        System.out.println("Entered driver is not in the list!");
                        continue;
                    }

                    Formula1Driver driver1 = null;
                    for (Formula1Driver drivers1 : FCM.getDriverArrayList()) {
                        if (drivers1.getDriverName().equals(p1))
                            driver1 = drivers1;
                    }
                        System.out.println(p1 + " scored 25 points!");

                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                            for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1)))
                            System.out.println("- " + drive.getDriverName());
                        }
                       System.out.println("");


                    // Entering name of the 2nd winner.
                        System.out.println("Enter the 2nd position driver name : ");
                        String p2 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if ((drive.getDriverName().equals(p2)) && !(p2.equals(p1))) {

                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {

                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver2 = null;
                        for (Formula1Driver drivers2 : FCM.getDriverArrayList()) {
                            if (drivers2.getDriverName().equals(p2))
                                driver2 = drivers2;
                        }

                        System.out.println(p2 + " scored 18 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 3rd winner.
                        System.out.println("Enter the 3rd position driver name : ");
                        String p3 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p3) && !(p3.equals(p1)) && !(p3.equals(p2))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver3 = null;
                        for (Formula1Driver drivers3 : FCM.getDriverArrayList()) {
                            if (drivers3.getDriverName().equals(p3))
                                driver3 = drivers3;
                        }
                        System.out.println(p3 + " scored 15 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2)|| drive.getDriverName().equals(p3)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 4th winner.
                        System.out.println("Enter the 4th position driver name : ");
                        String p4 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p4) && !(p4.equals(p1)) && !(p4.equals(p2)) && !(p4.equals(p3))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver4 = null;
                        for (Formula1Driver drivers4 : FCM.getDriverArrayList()) {
                            if (drivers4.getDriverName().equals(p4))
                                driver4 = drivers4;
                        }
                        System.out.println(p4 + " scored 12 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2)|| drive.getDriverName().equals(p3)|| drive.getDriverName().equals(p4)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 5th winner.
                        System.out.println("Enter the 5th position driver name : ");
                        String p5 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p5) && !(p5.equals(p1)) && !(p5.equals(p2)) && !(p5.equals(p3)) && !(p5.equals(p4))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver5 = null;
                        for (Formula1Driver drivers5 : FCM.getDriverArrayList()) {
                            if (drivers5.getDriverName().equals(p5))
                                driver5 = drivers5;
                        }
                        System.out.println(p5 + " scored 10 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2)|| drive.getDriverName().equals(p3)|| drive.getDriverName().equals(p4)|| drive.getDriverName().equals(p5)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 6th winner.
                        System.out.println("Enter the 6th position driver name : ");
                        String p6 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p6) && !(p6.equals(p1)) && !(p6.equals(p2)) && !(p6.equals(p3)) && !(p6.equals(p4)) && !(p6.equals(p5))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver6 = null;
                        for (Formula1Driver drivers6 : FCM.getDriverArrayList()) {
                            if (drivers6.getDriverName().equals(p6))
                                driver6 = drivers6;
                        }
                        System.out.println(p6 + " scored 8 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2) || drive.getDriverName().equals(p3) || drive.getDriverName().equals(p4)
                                    || drive.getDriverName().equals(p5)|| drive.getDriverName().equals(p6)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 7th winner.
                        System.out.println("Enter the 7th position driver name : ");
                        String p7 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p7) && !(p7.equals(p1)) && !(p7.equals(p2)) && !(p7.equals(p3)) && !(p7.equals(p4)) && !(p7.equals(p5))
                                    && !(p7.equals(p6))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver7 = null;
                        for (Formula1Driver drivers7 : FCM.getDriverArrayList()) {
                            if (drivers7.getDriverName().equals(p7))
                                driver7 = drivers7;
                        }
                        System.out.println(p7 + " scored 6 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2) || drive.getDriverName().equals(p3) || drive.getDriverName().equals(p4)
                                    || drive.getDriverName().equals(p5) || drive.getDriverName().equals(p6)|| drive.getDriverName().equals(p7)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 8th winner.
                        System.out.println("Enter the 8th position driver name : ");
                        String p8 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p8) && !(p8.equals(p1)) && !(p8.equals(p2)) && !(p8.equals(p3)) && !(p8.equals(p4)) && !(p8.equals(p5))
                                    && !(p8.equals(p6)) && !(p8.equals(p7))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver8 = null;
                        for (Formula1Driver drivers8 : FCM.getDriverArrayList()) {
                            if (drivers8.getDriverName().equals(p8))
                                driver8 = drivers8;
                        }
                        System.out.println(p8 + " scored 4 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2) || drive.getDriverName().equals(p3) || drive.getDriverName().equals(p4)
                                    || drive.getDriverName().equals(p5) || drive.getDriverName().equals(p6) || drive.getDriverName().equals(p7) || drive.getDriverName().equals(p8)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 9th winner.
                        System.out.println("Enter the 9th position driver name : ");
                        String p9 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p9) && !(p9.equals(p1)) && !(p9.equals(p2)) && !(p9.equals(p3)) && !(p9.equals(p4)) && !(p9.equals(p5))
                                    && !(p9.equals(p6)) && !(p9.equals(p7)) && !(p9.equals(p8))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver9 = null;
                        for (Formula1Driver drivers9 : FCM.getDriverArrayList()) {
                            if (drivers9.getDriverName().equals(p9))
                                driver9 = drivers9;
                        }
                        System.out.println(p9 + " scored 2 points!");
                        wrongAns = true;

                        System.out.println("");
                        System.out.println("Drivers name: \n");
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if(!(drive.getDriverName().equals(p1) || drive.getDriverName().equals(p2) || drive.getDriverName().equals(p3) || drive.getDriverName().equals(p4)
                                    || drive.getDriverName().equals(p5) || drive.getDriverName().equals(p6) || drive.getDriverName().equals(p7) || drive.getDriverName().equals(p8) || drive.getDriverName().equals(p9)))
                                System.out.println("- " + drive.getDriverName());
                        }
                        System.out.println("");

                        // Entering name of the 10th winner.
                        System.out.println("Enter the 10 position driver name : ");
                        String p10 = scan.nextLine();
                        for (Formula1Driver drive : FCM.driverArrayList) {
                            if (drive.getDriverName().equals(p10) && !(p10.equals(p1)) && !(p10.equals(p2)) && !(p10.equals(p3)) && !(p10.equals(p4)) && !(p10.equals(p5))
                                    && !(p10.equals(p6)) && !(p10.equals(p7)) && !(p10.equals(p8)) && !(p10.equals(p9))) {
                                wrongAns = false;
                            }
                        }
                        if (wrongAns == true) {
                            System.out.println("Entered driver is not in the list or already entered!");
                            continue;
                        }

                        Formula1Driver driver10 = null;
                        for (Formula1Driver drivers10 : FCM.getDriverArrayList()) {
                            if (drivers10.getDriverName().equals(p10))
                                driver10 = drivers10;
                        }
                        System.out.println(p10 + " scored 1 point!");
                        wrongAns = true;

                        FCM.addRace(datePlayed,driver1,driver2,driver3,driver4,driver5,driver6,driver7,driver8,driver9,driver10);


                } else if (userOption == 7) {
                    System.out.println("");
                    //Saving the program
                    FCM.save();
                    System.out.println("Program is saved!");

                } else if (userOption == 8) {
                    System.out.println("");
                    System.out.println("GUI is Opening...");
                    FCM.gui();

                } else if (userOption == 9) {
                    System.out.println("");
                    System.out.println("Program is exiting....");
                    //Exiting the program
                    System.exit(0);

                } else {
                    System.out.println("");
                    System.out.println("------Invalid Input------");
                    System.out.println("Please enter a Valid Input");
                }
            } catch (InputMismatchException e) {
                System.out.println("------Invalid Input------");
                System.out.println("Please enter a Valid Input");
            }
        }
    }
}