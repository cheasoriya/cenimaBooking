    package BookingMovies;

    import java.util.Arrays;
    import java.util.Scanner;


    public class Movies {
        private  static  String [][] cenima;
        private  static  int  codeSeate =1  ;
        private  static  boolean  cenimaSetup = false ;
        private static void setUpHall(){
            int rows = 0,cols = 0;
            System.out.print("Input Set up rows Halls = ");
            rows = new Scanner(System.in).nextInt();
            System.out.print("Input Set up cols Halls = ");
            cols = new Scanner(System.in).nextInt();
            cenima = new String[rows][cols];
            String status = "AV";
            for (int i = 0 ;i < rows; i++){
                for (int j = 0; j < cols; j++){
                    cenima[i][j] = codeSeate +" - "+ status;
                    codeSeate += 1;
                }
            }
            System.out.println("Corrent Hall ");
           for(String [] hall : cenima){
               System.out.println(Arrays.toString(hall));
           }
           cenimaSetup = true;
        }
        private static void booking(){
            if (!cenimaSetup){
                System.out.println("No hall plz setup hall");
            }
            System.out.println("WELCOME TO BOOKING HALL");
            System.out.print(" Please Inter the seat code for booking = ");
            String codeBooking = new Scanner(System.in).nextLine();
            for (int i = 0; i < cenima.length; i++){
                for (int j = 0; j < cenima[i].length; j++){
                    String [] detail  = cenima[i][j].split(" - ");
                    if(detail[0].equals(codeBooking)) {
                        if (detail[1].equals("AV")) {
                            cenima[i][j] = detail[0] + " - BO";
                            System.out.println("Seat [" + codeBooking + "] Booking Success");
                            for (String[] row : cenima) {
                                System.out.println(Arrays.toString(row));
                            }

                        }
                        break;
                    }
                    }
                }
            }
        private  static void cancelBooking(){
            System.out.println("Inter Seat Code to Cancel : ");
            String cancelSeat = new Scanner(System.in).nextLine();
            for (int i = 0; i < cenima.length; i++){
                for (int j = 0; j < cenima[i].length; j++){
                    String [] detailCancelSeat = cenima[i][j].split(" - ");
                    if (detailCancelSeat[0].equals(cancelSeat)){
                        if (detailCancelSeat[1].equals("BO")){
                            cenima[i][j] =detailCancelSeat[0] + " - AV";
                            for (String[] row : cenima){
                                System.out.println(Arrays.toString(row));

                            }
                            System.out.println("You Cancel success");
                        }
                    }
                }
            }
        }
        public static void viewBookingHistory(){
                for (String[] record : cenima){
                    System.out.println(Arrays.toString(record));
                }
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("""
                            1. Set up The hall
                            2. Booking the seat
                            3. Cancel the seat
                            4. Show the history
                            5. Exit
                        """);
                System.out.print("Choose your Option : ");
                int opt = new Scanner(System.in).nextInt();
                switch (opt){
                    case 1 -> setUpHall();
                    case 2 -> booking();
                    case 3 -> cancelBooking();
                    case 4 -> viewBookingHistory();
                    case 5 ->
                    System.exit(
                            0
                    );
                }
            }
        }
    }

