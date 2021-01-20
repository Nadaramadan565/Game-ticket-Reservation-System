
package gameticket_package;
        import java.time.Duration;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.util.*;
        import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class Main {

    /** Static Data Member*/
    public static List <staduim> stad=new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Game> game=new ArrayList<>();
        List<fans> fan=new ArrayList<>();

        Scanner s=new Scanner(System.in);

        staduim s1=new staduim(15, 90, 200, 300, "cairo staduim");
        staduim s2=new staduim(15, 200, 500, 700, "Burg alarab staduim");

        stad.add(s1);
        stad.add(s2);

        /** creating objects of game */
        /**Polymorphism*/
        international international_game1=new international("Real Madrid", "Bercelona", 900, 50, 30, 20,"2020-06-07", s2);//this date prevent cancelation from working because it is over the cancel duration .
        international_game1.Calc_price();
        international international_game2=new international("Chelsea", "oldham", 1400, 50, 30, 20,"2020-05-30", s2);
        international_game2.Calc_price();
        national national_game1=new national("Alahly", "Zamalk", 900, 50, 30, 20,"2020-05-08", s1);
        national_game1.Calc_price();
        national national_game2=new national("ethad", "esmaaily", 1400, 50, 30, 20, "2020-05-09", s1);
        national_game2.Calc_price();
        /** adding them in  array list of game */
        game.add(national_game2);
        game.add(international_game2);
        game.add(national_game1);
        game.add(international_game1);
        /** creating objects of fan*/
        fans fan1=new fans("125", "52");
        fans fan2=new fans("165", "98");
        fans fan3=new fans("100","55");
        fans fan4=new fans("50","005");
        /** adding them in  array list of fan */
        fan.add(fan1);
        fan.add(fan2);
        fan.add(fan3);
        fan.add(fan4);
        /** Adding some Data before the fan add his data   */
        System.out.println("Fan 1 : ");
        fan1.reserve_ticket(game.get(0),1,1);
        System.out.print("In Game "+game.get(0).code+"\n"+"---------------"+"\n");
        System.out.println("Fan 1 : ");
        fan1.reserve_ticket(game.get(1),3,6);
        System.out.print("In Game "+game.get(1).code+"\n"+"---------------"+"\n");
        System.out.println("Fan 2 : ");
        fan2.reserve_ticket(game.get(2),3,1);
        System.out.println("In Game "+game.get(2).code+"\n"+"---------------"+"\n");


        try {

            while (true) {
                System.out.println("Enter 1 to Reserve a Match" + "\n" + "Enter 2 to Upgrade a Match" + "\n" + "Enter 3 to Cancel a Match" + "\n" + "Enter 4 to Check Availability of Seat " + "\n" + "Enter 5 to Make a Bet between two teams " + "\n" + "Enter 6 To show all tickets of specific fan "+"\n" +"Enter 7 To Complain "+"\n" +"Enter 8 To Exit ");
                int choice = s.nextInt();
                boolean con = true;
                if(choice>8)
                {
                    System.out.println("Please Enter Valid choice "+"\n");
                }


                switch (choice) {

                    case 1:
                        while (con) {
                            System.out.println("1- " + game.get(0).code);
                            System.out.println("2- " + game.get(1).code);
                            System.out.println("3- " + game.get(2).code);
                            System.out.println("4- " + game.get(3).code);
                            System.out.println("Enter Game Number that you want to attend  ");
                            int game_num = s.nextInt();


                            System.out.println(fan1.getId()+" "+fan2.getId()+" "+fan3.getId()+" "+fan4.getId());
                            System.out.println("Enter one ID from all of this ");
                            String id=s.next();
                            int number=0;

                            for(int i=0;i<fan.size();i++)
                            {
                                if (fan.get(i).getId().equalsIgnoreCase(id)) {
                                    number=i;
                                    System.out.println("Fan " + (number+1));
                                }
                            }


                            System.out.println("Enter the category number and seat number" + "\n" + "Category Number 1 , 2 , 3 Only : ");
                            int catt = s.nextInt();
                            System.out.println("Seat Number");
                            int seatnumber = s.nextInt();
                            //  System.out.println(fan.get(number).check_availabilty(game.get(0), seatnumber, catt));
                            if( fan.get(number).check_availabilty(game.get(game_num-1), seatnumber, catt))
                            {

                                System.out.println("Before reservation : "+"Sorry Not Avaliable,it's booked");
                            }
                            else
                            {
                                System.out.println("Before reservation : "+"Avaliable");
                            }


                            fan.get(number).reserve_ticket(game.get(game_num-1), catt, seatnumber); /**Checking Reservation */



                            if( fan.get(number).check_availabilty(game.get(game_num-1), seatnumber, catt))
                            {

                                System.out.println("After reservation : "+"Sorry Not Avaliable,it's booked");
                            }
                            else
                            {
                                System.out.println("After reservation : "+"Avaliable");
                            }
                            //System.out.println(fan.get(number).check_availabilty(game.get(0), seatnumber, catt));
                            System.out.println("Y for continue reservation and N to stop");
                            char co = s.next().charAt(0);
                            if (co == 'Y') {//Enter it capital
                                con = true;
                            } else {
                                con = false;
                                break;
                            }

                        }
                        break;
                    case 2:

                        while (con) {

                            System.out.println("1- " + game.get(0).code);
                            System.out.println("2- " + game.get(1).code);
                            System.out.println("3- " + game.get(2).code);
                            System.out.println("4- " + game.get(3).code);
                            System.out.println("Enter Game Number that you want to attend  ");
                            int game_num = s.nextInt();


                            System.out.println(fan1.getId()+" "+fan2.getId()+" "+fan3.getId()+" "+fan4.getId());
                            System.out.println("Enter one ID from all of this ");
                            String id=s.next();
                            int number=0;

                            for(int i=0;i<fan.size();i++)
                            {
                                if (fan.get(i).getId().equalsIgnoreCase(id)) {
                                    number=i;
                                    System.out.println("Fan " + (number+1));
                                }
                            }


                            fan.get(number).showtickets(); /** Show Tickets before upgrading */
                            System.out.println("Which ticket do you want to Upgrade "+" Enter Number of the ticket");
                            int number_ticket=s.nextInt();

                            System.out.println("Enter the category number and seat number that you want to upgrade" + "\n" + "Category Number : ");
                            int catt = s.nextInt();
                            System.out.println("Seat Number");
                            int seatnumber = s.nextInt();


                            fan1.upgrade_ticket(fan.get(number).tic.get(number_ticket-1), catt, seatnumber); /**Checking Upgrading */
                            System.out.println(fan.get(number).check_availabilty(fan.get(number).tic.get(number_ticket-1).g,seatnumber,catt));
                            if(fan.get(number).check_availabilty(fan.get(number).tic.get(number_ticket-1).g,seatnumber,catt))
                            {
                                System.out.println("it's already reserved ");

                            }

                            fan.get(number).showtickets(); /** Show Tickets after upgrading */
                            System.out.println("Y for continue Upgrading and N to stop");
                            char co = s.next().charAt(0);
                            if (co == 'Y') {//Enter it capital
                                con = true;
                            } else {
                                con = false;
                                break;
                            }
                        }
                        break;

                    case 3:
                        while (con) {
                            System.out.println(fan1.getId() + " " + fan2.getId() + " " + fan3.getId() + " " + fan4.getId());
                            System.out.println("Enter one ID from all of this ");
                            String id = s.next();
                            int number = 0;

                            for (int i = 0; i < fan.size(); i++) {
                                if (fan.get(i).getId().equalsIgnoreCase(id)) {
                                    number = i;
                                    System.out.println("Fan " + (number + 1));
                                }
                            }


                            System.out.println("All Tickets Before cancelation");
                            fan.get(number).showtickets(); /** Show Tickets before Cancelation */

                            System.out.println("Which ticket do you want to Cancel " + " Enter Number of the ticket");
                            int number_ticket = s.nextInt();

                            fan.get(number).cancel_ticket(fan.get(number).tic.get(number_ticket - 1));/** Checking Cancelation */
                            System.out.println("All Tickets After cancelation");
                            fan.get(number).showtickets(); /** Show Tickets after Cancelation */
                            System.out.println("Y for continue cancelation and N to stop");
                            char co = s.next().charAt(0);
                            if (co == 'Y') {//Enter it capital
                                con = true;
                            } else {
                                con = false;
                                break;
                            }
                        }
                        break;
                    case 4:
                        while (con) {
                            System.out.println("1- " + game.get(0).code);
                            System.out.println("2- " + game.get(1).code);
                            System.out.println("3- " + game.get(2).code);
                            System.out.println("4- " + game.get(3).code);
                            System.out.println("Enter Game Number that you want to Check Availabilty on it   ");
                            int game_num = s.nextInt();

                            System.out.println(fan1.getId() + " " + fan2.getId() + " " + fan3.getId() + " " + fan4.getId());
                            System.out.println("Enter one ID from all of this ");
                            String id1 = s.next();
                            int number1 = 0;

                            for (int i = 0; i < fan.size(); i++) {
                                if (fan.get(i).getId().equalsIgnoreCase(id1)) {
                                    number1 = i;
                                    System.out.println("Fan " + (number1 + 1));
                                }
                            }

                            System.out.println("Enter the category number and seat number that do you want to check availabilty for it " + "\n" + "Category Number : ");
                            int cat = s.nextInt();
                            System.out.println("Seat Number");
                            int seat_number = s.nextInt();



                            if (fan.get(number1).check_availabilty(game.get(game_num-1), seat_number, cat)) { /**Checking function check availability */
                                System.out.println("Sorry Not Avaliable,it's booked");
                            } else {
                                System.out.println("Avaliable");
                            }
                            System.out.println("Y for continue checking the availabilty and N to stop");
                            char co = s.next().charAt(0);
                            if (co == 'Y') {//Enter it capital
                                con = true;
                            } else {
                                con = false;
                                break;
                            }
                        }
                        break;
                    case 5:
                        while (con) {
                            System.out.println("1- " + game.get(0).code);
                            System.out.println("2- " + game.get(1).code);
                            System.out.println("3- " + game.get(2).code);
                            System.out.println("4- " + game.get(3).code);
                            System.out.println("Enter Game Number that you want to make a bet bteween thier teams  ");
                            int game_num = s.nextInt();
                            System.out.println("What team do you expect to be the winner  " + game.get(game_num - 1).getTeam1() + " or " + game.get(game_num - 1).getTeam2());
                            String chice = s.next();
                            fan1.makebet(game.get(game_num - 1), chice); /**checking making bet for two teams */
                            System.out.println("Y for continue making bet and N to stop");
                            char co = s.next().charAt(0);
                            if (co == 'Y') {
                                con = true;
                            } else {
                                con = false;
                                break;
                            }
                        }
                        break;
                    case 6:
                        while(con) {
                            System.out.println(fan1.getId() + " " + fan2.getId() + " " + fan3.getId() + " " + fan4.getId());
                            System.out.println("Enter one ID from all of this ");
                            String id1 = s.next();
                            int number1 = 0;

                            for (int i = 0; i < fan.size(); i++) {
                                if (fan.get(i).getId().equalsIgnoreCase(id1)) {
                                    number1 = i;
                                    System.out.println("Fan " + (number1 + 1));
                                }
                            }
                            fan.get(number1).showtickets();
                            System.out.println("Y for continue making bet and N to stop");
                            char co = s.next().charAt(0);
                            if (co == 'Y') {//Enter it capital
                                con = true;
                            } else {
                                con = false;
                                break;
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Enter Your Complain ");
                        String comp=s.next();
                        fans.complains(comp);
                        break;

                    case 8:
                        System.exit(0);
                        break;

                }

            }
        }catch( Exception e)
        {
            System.out.println("There is no tickest to cancel or Upgrade");

        }
    }

}
/** interface */
interface show_info
{
    void showtickets();
}
/** Abstract Class */
abstract class Game
{
    /** Final data member */
    final protected String code ;
    staduim stad;
    private String team1 ,team2 ,winner ,type ;
    LocalDate date;
    protected float price1,price2,price3;
    public List<seat>cat1;
    public List<seat>cat2;
    public List<seat>cat3;

    //Getters and setters
    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getCode() {
        return code;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public float getPrice1() {
        return price1;
    }

    public void setPrice1(float price1) {
        this.price1 = price1;
    }

    public float getPrice2() {
        return price2;
    }

    public void setPrice2(float price2) {
        this.price2 = price2;
    }

    public float getPrice3() {
        return price3;
    }

    public void setPrice3(float price3) {
        this.price3 = price3;
    }

    /**abstract function to implement overriden*/
    public abstract void Calc_price ();

    //constructor
    Game(String team1,String team2,int number_of_seats,float price1,float price2,float price3,String date,staduim stad)
    {
        cat1=new ArrayList<>();
        cat2=new ArrayList<>();
        cat3=new ArrayList<>();
        this.team1=team1;
        this.team2=team2;
        this.stad=stad;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        code=team1+" VS "+team2+" "+date;

        try
        {
            this.date= LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        }
        catch(Exception e)
        {
            System.out.println("Enter true format");
        }

        ///Intialization of Array list to make each index refer to object of seat
        for(int i=0;i<stad.getNo_cat1();i++)
        {
            cat1.add(new seat(i+1, 1));

        }
        for(int i=0;i<stad.getNo_cat2();i++)
        {
            cat2.add(new seat(i+1, 2));

        }
        for(int i=0;i<stad.getNo_cat3();i++)
        {
            cat3.add(new seat(i+1, 3));

        }


    }
}
class international extends Game
{


    public international(String team1,String team2,int number_of_seats,float price1,float price2,float price3,String date,staduim stad)
    {

        super(team1, team2,number_of_seats,price1, price2, price3,date,stad);
        this.setType("International");

        int random_int = (int)(Math.random() * (2 - 1 + 1) + 1);
        if(random_int==1)
        {
            setWinner(team1);
        }
        else if(random_int==2)
        {
            setWinner(team2);
        }

    }
    /**Overriden Method*/
    @Override
    public void Calc_price()
    {
        setPrice1(price1*90);
        setPrice2(price2*70);
        setPrice3(price3*50);
    }

}

class national extends Game
{
    public national(String team1,String team2,int number_of_seats,float price1,float price2,float price3,String date,staduim stad)
    {
        super(team1, team2,number_of_seats,price1, price2, price3,date,stad);
        this.setType("National");

        int random_int = (int)(Math.random() * (2 - 1 + 1) + 1);
        if(random_int==1)
        {
            setWinner(team1);
        }
        else if(random_int==2)
        {
            setWinner(team2);
        }

    }
    /**Overriden Method*/
    @Override
    public void Calc_price()
    {
        setPrice1(price1*12);
        setPrice2(price2*10);
        setPrice3(price3*5);
    }

}
/** Class Staduim hold all the information about where the game will be played and number of seats in each staduim  */
class staduim
{
    /** Static Data Member */
    private static int number_of_seats,no_cat1,no_cat2,no_cat3;
    private String location;

    //constructor
    public staduim(int number_of_seats, int no_cat1, int no_cat2, int no_cat3, String location) {
        this.number_of_seats = number_of_seats;
        this.no_cat1 = no_cat1;
        this.no_cat2 = no_cat2;
        this.no_cat3 = no_cat3;
        this.location = location;
    }


    //Setters and Getters
    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public int getNo_cat1() {
        return no_cat1;
    }

    public void setNo_cat1(int no_cat1) {
        this.no_cat1 = no_cat1;
    }

    public int getNo_cat2() {
        return no_cat2;
    }

    public void setNo_cat2(int no_cat2) {
        this.no_cat2 = no_cat2;
    }

    public int getNo_cat3() {
        return no_cat3;
    }

    public void setNo_cat3(int no_cat3) {
        this.no_cat3 = no_cat3;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

/** Class Seat hold all the information of Seat like it's number , Category and whether it's booked or not  */
class seat
{
    private int number ;
    private int cat;
    private boolean booked =false;

    // constructor
    public seat(int number, int category)
    {
        this.number = number;
        this.cat=category;
    }

    //Setters and Getters
    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public boolean isBooked() {
        return booked;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

}

/**Class Ticket hold all information about game like Game Code , Price of each Ticket depended on which category (1,2,3) will be choosed , object of Seat that will be choosed and Game that user decided to attend it  */
class ticket
{

    private String code;
    private float price;
    seat booked_seat;
    Game g;
    //constructor
    public ticket( float price,seat booked_seat, Game g) {
        this.code = g.code;
        this.price = price;
        this.booked_seat = booked_seat;
        this.g = g;

    }

    //Setters and Getters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public seat getBooked_seat() {
        return booked_seat;
    }

    public void setBooked_seat(seat booked_seat) {
        this.booked_seat = booked_seat;
    }
}

/** class exception that inherted from class Exception */
class exception extends Exception
{
    public exception (String m)
    {
        super(m);
    }
}

/**
 * class fan that hold all the data of the fan like ID and password of each fan and it's tickets that he reserve , upgrade and cancel it  */
class fans implements  show_info
{
    private String id;
    private String password;
    private static String complain;

    List<ticket> tic=new ArrayList<>();

    //Getters and Setters


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
    /**Static method*/
    public static String getComplain() {
        return complain;
    }

    public static void setComplain(String complain) {
        fans.complain = complain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // constructor of fan
    public fans(String id, String password) {
        this.id = id;
        this.password = password;

    }

/** Complains function that the admin recieves all the complains from the user */
    /**
     *
     * @param complain variable that i get the complain of user
     */
    /** Static  Method */
    public static void complains(String complain)
    {
        fans.complain=complain;
        System.out.println("We will solve your problem Soon "+"\n");

    }

    /** Show all the tickets for each one fan  */

    @Override
    public final void showtickets()
    {
        for(int i=0;i<tic.size();i++)
        {
            if(tic.get(i).booked_seat.getCat()==1)
            {


                System.out.println("Ticket "+ (i+1) + " \n"+"-------"+"\n"+"Type of ticket : "+ tic.get(i).g.getType() +"\n"+"Ticket Code : "+tic.get(i).getCode()+"\n"+"Seat Category "+ tic.get(i).booked_seat.getCat()+"\n" +"Seat Number " + tic.get(i).getBooked_seat().getNumber()+"\n"+"Price :  "+ tic.get(i).getPrice()+"\n"+"---------------");
            }

            if(tic.get(i).booked_seat.getCat()==2)
            {
                System.out.println("Ticket "+ (i+1) +" \n"+"-------"+"\n"+"Type of ticket : "+ tic.get(i).g.getType() +"\n"+"Ticket Code : "+tic.get(i).getCode()+"\n"+"Seat Category "+ tic.get(i).booked_seat.getCat()+"\n" +"Seat Number " + tic.get(i).getBooked_seat().getNumber()+"\n"+"Price :  "+ tic.get(i).getPrice()+"\n"+"---------------");


            }
            if(tic.get(i).booked_seat.getCat()==3)
            {


                System.out.println("Ticket "+ (i+1)  +" \n"+"-------"+"\n"+ "Type of ticket : "+ tic.get(i).g.getType()+"\n"+"Ticket Code : "+tic.get(i).getCode()+"\n"+"Seat Category "+ tic.get(i).booked_seat.getCat()+"\n" +"Seat Number " + tic.get(i).booked_seat.getNumber()+"\n"+"Price :  "+ tic.get(i).getPrice()+"\n"+"---------------");
            }


        }
        if(tic.size()==0)
        {
            System.out.println("There is no Tickets to show ! ");

        }

    }

    /**
     *
     * @param g object from the game that the fan want to reserve it.
     * @param cat Category number that the user want to reserve in it .
     * @param number Seat number that the user wants to reserve it .
     */
    /** Reservation Function takes game , category and number and reserve them for the user  */
    public void reserve_ticket(Game g , int cat,int number)
    {

        if(cat==1)                                            // checking if Category that he want to reserve equals 1
        {

            seat s=g.cat1.get(getindex(g, number, cat));      // create an object of seat points to the seat in the Category that he want

            if(!check_availabilty(g,number, cat))             // checking if this seat in this category will be available or not
            {

                ticket t=new ticket(g.getPrice1(),s, g);
                tic.add(t);                                   // Adding object of ticket in the array list of ticket of each fan
                s.setBooked(true);                            // Update the value of Availability of seat to not make any one to reserve it again
                s.setNumber(number);
                System.out.println("You reserved a seat in category "+ cat +" and it's number is "+number);

            }
            else
            {
                System.out.println("Already Reserved");       // if the seat is not Available

            }
        }


        else if (cat==2)                                       // checking if Category that he want to reserve equals 2
        {
            seat s=g.cat2.get(getindex(g, number, cat));

            if(!check_availabilty(g,number, cat))
            {
                ticket t=new ticket(g.getPrice2(),s, g);
                tic.add(t);
                s.setBooked(true);

                s.setNumber(number);
                System.out.println("You reserved a seat in category "+ cat +" and it's number is "+number);



            }
            else
            {
                System.out.println("Allready Reserved");

            }
        }
        else if(cat==3)                                        // checking if Category that he want to reserve equals 3
        {
            seat s=g.cat3.get(getindex(g, number, cat));
            s.setNumber(number);
            if(!check_availabilty(g,number, cat))
            {
                ticket t=new ticket(g.getPrice3(),s, g);
                tic.add(t);
                s.setBooked(true);
                s.setNumber(number);
                System.out.println("You reserved a seat in category "+ cat +" and it's number is "+number);


            }
            else
            {
                System.out.println("Allready Reserved");

            }

        }
        else{
            System.out.println("this is unvalid category");       // if User enter category other than 1 , 2 , 3
        }


    }

    /** Upgrading function takes from the user new category and new seat and object from the ticket to upgrade the old category number from the lowest to the highest category only */

    /**
     *
     * @param t     Object from the ticket that holds the old category and seat number that the user want to change it .
     * @param cat   new category that the user wants to change old category to it .
     * @param num   new Seat that the user want to change old Seat to it .
     */
    public void upgrade_ticket(ticket t,int cat ,int num)
    {
        try{
            if(t.booked_seat.getCat()!=1){         //Not allowed to be at category 1 and then updrade your category to lowest degree
                if(cat==2){ // new category that the user want to upgrade it
                    if(t.booked_seat.getCat()==3){ //old category

                        if(!check_availabilty( t.g,num, cat))
                        {
                            t.booked_seat.setBooked(false);  // Set boolean vriable that in the seat with false that it's become available "old seat"
                            t.booked_seat=t.g.cat2.get(num-1); //make object of seat that in the ticket to point to  new seat from the type of category hthat he want to upgrade to it
                            t.booked_seat.setNumber(num);
                            t.booked_seat.setBooked(true);       //Set boolean vriable that in the seat with false that it's become Not available "new seat"
                            System.out.println("Upgraded Successfuly");

                        }
                        else
                        {
                            System.out.println("booked");
                        }

                    }
                    else if(t.booked_seat.getCat()==2)
                    {
                        System.out.println("Sorry No Upgrading can be done because you enter the same category ");


                    }
                    else
                    {
                        throw new Exception();

                    }
                }
                else if(cat==1)
                {
                    if(t.booked_seat.getCat()==3){

                        if(!check_availabilty( t.g,num, cat))
                        {
                            t.booked_seat.setBooked(false);
                            t.booked_seat=t.g.cat1.get(num-1);
                            t.booked_seat.setNumber(num);
                            t.booked_seat.setBooked(true);
                            t.g.cat1.get(num-1).setBooked(true);
                            System.out.println("Upgraded Successfuly"+"\n");
                        }
                        else
                        {
                            System.out.println("booked");

                        }

                    }
                    else if(t.booked_seat.getCat()==2)
                    {

                        if(!check_availabilty( t.g,num, cat))
                        {
                            t.booked_seat.setBooked(false);
                            t.booked_seat=t.g.cat1.get(num-1);
                            t.booked_seat.setNumber(num);
                            t.booked_seat.setBooked(true);
                            System.out.println("Upgraded Successfuly");
                        }
                        else
                        {
                            System.out.println("booked");

                        }

                    }

                    else
                    {
                        System.out.println("Highest category reserved ");

                    }
                }
                else if(cat==3)
                {
                    if(t.booked_seat.getCat()==3)
                    {
                        System.out.println("Sorry No Upgrading can be done because you enter the same category ");
                    }

                }
            }
            else {
                if (cat== 2 ||cat == 3) {
                    throw new Exception();
                }
                else
                {
                    System.out.println("Sorry, Highest category reserved and No Upgrading can be done because you enter the same category"); //if the user reserved in category 1 and he wants to upgrade to 2 or 3
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Not allowed to degrade your category ");
        }

    }

//Overloading

    /**
     *
     * @param tickett that the user want to cancel it
     * @param number Index of ticket that i will removing ticket using it without checking on the date
     */
    public void cancel_ticket(ticket tickett,int number)
    {
        boolean flag=false;
        for(ticket obj:this.tic)
        {
            if(obj.booked_seat.getNumber()==tickett.booked_seat.getNumber())
            {
                flag=true;
            }
        }
        if(flag){
            tickett.booked_seat.setBooked(false);
            tic.remove(tickett.booked_seat.getNumber()-1);

        }
    }

    /** Cancelation Function that take a ticket and remove it from the array lust of tickets   */
    /**
     *
     * @param tickett object from the tikect that the user want to cancel it
     */
    public void cancel_ticket(ticket tickett)
    {
        boolean flag=false;
        for(ticket obj:this.tic) //to make sure that this ticket is already exsist
        {
            if(obj.booked_seat.getNumber()==tickett.booked_seat.getNumber())
            {
                flag=true;
            }
        }
        if(flag)
        {
            LocalDate cancelation_date=LocalDate.parse("2020-05-26", DateTimeFormatter.ISO_LOCAL_DATE);
            Duration diff=Duration.between(tickett.g.date.atStartOfDay() ,cancelation_date.atStartOfDay());//duartion between date of the game and cancelation date
            long diffDays = diff.toDays(); /// turn it into days

            try{

                if(diffDays>3)
                {
                    tickett.booked_seat.setBooked(false);
                    tic.remove(tickett.booked_seat.getNumber()-1);
                    System.out.println("                        You cancel your ticket Sucessfully                       "+"\n");


                }
                else

                {
                    throw new Exception();

                }

            }
            catch(Exception e)
            {
                System.out.println("\n"+"No Cancelation after 3 days"+"\n");
            }

        }

        else
        {
            try
            {
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("No Ticket with this code to cancel");
            }
        }
    }

    /** Function that take Game and the team that the user choose it to be the winner and it detects if user expect true or false */
    /**
     *
     * @param g object from game that user will detect one of it's teams to be the winner
     * @param choice the team that the user will be detect it to be the winner team
     */
    public void makebet(Game g,String choice)
    {

        LocalDate bet_date=LocalDate.parse("2020-06-06", DateTimeFormatter.ISO_LOCAL_DATE);//date that will be compared with the date of game to show if the match has been played or not
        Duration diff=Duration.between(g.date.atStartOfDay() ,bet_date.atStartOfDay());
        long diffDays = diff.toDays();
        try {
            if(diffDays!=-1) {

                if (choice.equalsIgnoreCase(g.getWinner()))
                {
                    System.out.println("Your expectation is true team : " + g.getWinner() + " is the winner ");
                }
                else
                {
                    System.out.println("Sorry ,Your expectation is False team : " + g.getWinner() + " is the winner ");
                }
            }
            else
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            System.out.println("You can't make a bet for match that have been ended ");

        }


    }

/** getindex function it takes game and seat number and category in each game to get index of a complete object  */
    /**
     *
     * @param g game that i give with it number of seat and category to get index of object
     * @param seat_number
     * @param cat refere to category number
     * @return
     */

    public int getindex(Game g,int seat_number,int cat)
    {
        if (cat==1)
        {
            for (int i=0;i<g.cat1.size();i++)
            {
                if(g.cat1.get(i).getNumber()==seat_number )
                {
                    return i;
                }
            }
        }
        else if(cat==2)
        {
            for (int i=0;i<g.cat2.size();i++)
            {
                if(g.cat2.get(i).getNumber()==seat_number )
                {
                    return i;
                }
            }
        }
        else if(cat==3)
        {
            for (int i=0;i<g.cat3.size();i++)
            {
                if(g.cat3.get(i).getNumber()==seat_number )
                {
                    return i;

                }
            }
        }


        return 0 ;
    }

    /** Checking availability that takes game and seat number and category
     * and return boolean variable if this seat didn't reserved yet so it
     * returns false " Not reserved,that tis seat is empty " and when it's reserved it returns true " seat is reserved  " */
    /**
     *
     * @param g game that the user wants to check availability of seat on it
     * @param seat_number seat the user wants to check it
     * @param cat category that the user to check in it
     * @return
     */
    public boolean check_availabilty(Game g,int seat_number,int cat)
    {
        try{
            if (cat==1)
            {
                for (int i=0;i<g.cat1.size();i++)
                {
                    if(g.cat1.get(i).getNumber()==seat_number )
                    {
                        return g.cat1.get(i).isBooked();//returning boolean variable in this category of specific game that user choosed it
                    }

                }
            }
            else if(cat==2)
            {
                for (int i=0;i<g.cat2.size();i++)
                {
                    if(g.cat2.get(i).getNumber()==seat_number )
                    {
                        return g.cat2.get(i).isBooked();
                    }


                }
            }
            else if(cat==3)
            {
                for (int i=0;i<g.cat3.size();i++)
                {
                    if(g.cat3.get(i).getNumber()==seat_number )
                    {
                        return g.cat3.get(i).isBooked();

                    }


                }
            }
            else {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            System.out.println("Enter correct Number");

        }
        return false;
    }
}
