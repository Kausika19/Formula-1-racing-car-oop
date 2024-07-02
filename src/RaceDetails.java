import java.io.Serializable;

public class RaceDetails implements Serializable {
        private Dates datePlayed;
        private Formula1Driver driver1;
        private Formula1Driver driver2;
        private Formula1Driver driver3;
        private Formula1Driver driver4;
        private Formula1Driver driver5;
        private Formula1Driver driver6;
        private Formula1Driver driver7;
        private Formula1Driver driver8;
        private Formula1Driver driver9;
        private Formula1Driver driver10;
        int driver1Points = 25;
        int driver2Points = 18;
        int driver3Points = 15;
        int driver4Points = 12;
        int driver5Points = 10;
        int driver6Points = 8;
        int driver7Points = 6;
        int driver8Points = 4;
        int driver9Points = 2;
        int driver10Points = 1;


        public RaceDetails(Dates datePlayed,Formula1Driver driver1,Formula1Driver driver2,Formula1Driver driver3,Formula1Driver driver4,
                           Formula1Driver driver5,Formula1Driver driver6,Formula1Driver driver7,Formula1Driver driver8,Formula1Driver driver9,
                          Formula1Driver driver10) {
            this.datePlayed = datePlayed;
            this.driver1 = driver1;
            this.driver2 = driver2;
            this.driver3 = driver3;
            this.driver4 = driver4;
            this.driver5 = driver5;
            this.driver6 = driver6;
            this.driver7 = driver7;
            this.driver8 = driver8;
            this.driver9 = driver9;
            this.driver10 = driver10;
        }

        public RaceDetails() {

        }


        public Dates getDatePlayed() {
            return datePlayed;
        }
        public void setDatePlayed(Dates datePlayed) {
            this.datePlayed = datePlayed;
        }


        public Formula1Driver getDriver1() {return driver1;}
        public void setDriver1(Formula1Driver driver1) {
            this.driver1 = driver1;
        }

        public Formula1Driver getDriver2() {return driver2;}
        public void setDriver2(Formula1Driver driver2) {this.driver2 = driver2;}

        public Formula1Driver getDriver3() {return driver3;}
        public void setDriver3(Formula1Driver driver3) {this.driver3 = driver3;}

        public Formula1Driver getDriver4() {return driver4;}
        public void setDriver4(Formula1Driver driver4) {this.driver4 = driver4;}

        public Formula1Driver getDriver5() {return driver5;}
        public void setDriver5(Formula1Driver driver5) {this.driver5 = driver5;}

        public Formula1Driver getDriver6() {return driver6;}
        public void setDriver6(Formula1Driver driver6) {this.driver6 = driver6;}

        public Formula1Driver getDriver7() {return driver7;}
        public void setDriver7(Formula1Driver driver7) {this.driver7 = driver7;}

        public Formula1Driver getDriver8() {return driver8;}
        public void setDriver8(Formula1Driver driver8) {this.driver8 = driver8;}

        public Formula1Driver getDriver9() {return driver9;}
        public void setDriver9(Formula1Driver driver9) {this.driver9 = driver9;}

        public Formula1Driver getDriver10() {return driver10;}
        public void setDriver10(Formula1Driver driver10) {this.driver10 = driver10;}



        public void setDriver1Points(int driver1Points) {this.driver1Points = driver1Points;}
        public int getDriver1Points() {return driver1Points;}

        public void setDriver2Points(int driver2Points) {this.driver2Points = driver2Points;}
        public int getDriver2Points() {return driver2Points;}

        public void setDriver3Points(int driver3Points) {this.driver3Points = driver3Points;}
        public int getDriver3Points() {return driver3Points;}

        public void setDriver4Points(int driver4Points) {this.driver4Points = driver4Points;}
        public int getDriver4Points() {return driver4Points;}

        public void setDriver5Points(int driver5Points) {this.driver5Points = driver5Points;}
        public int getDriver5Points() {return driver5Points;}

        public void setDriver6Points(int driver6Points) {this.driver6Points = driver6Points;}
        public int getDriver6Points() {return driver6Points;}

        public void setDriver7Points(int driver7Points) {this.driver7Points = driver7Points;}
        public int getDriver7Points() {return driver7Points;}

        public void setDriver8Points(int driver8Points) {this.driver8Points = driver8Points;}
        public int getDriver8Points() {return driver8Points;}

        public void setDriver9Points(int driver9Points) {this.driver9Points = driver9Points;}
        public int getDriver9Points() {return driver9Points;}

        public void setDriver10Points(int driver10Points) {this.driver10Points = driver10Points;}
        public int getDriver10Points() {return driver10Points;}

}


