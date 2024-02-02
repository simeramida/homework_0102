import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        DBtodo db = new DBtodo();


    System.out.println("Your To do List");
    System.out.println("Please enter your name: ");
       Scanner in = new Scanner(System.in);
       String name = in.next();
       System.out.println("Hello "+name);

       String choice = null;
       Scanner input = new Scanner(System.in);

       do {
           //Display the Menu
           System.out.println("Please choose an option");
           System.out.println("0. Exit");
           System.out.println("1. List all ");
           System.out.println("2. Add a task ");
           System.out.println("3. Remove a task ");
           System.out.println("4. Update ");

           choice = input.nextLine();

           switch(choice) {

            case "1":
            System.out.println("List all ");
            ResultSet result = db.select_all();
            while (result.next()){
                System.out.println("id: " + result.getInt("id"));
                System.out.println("item: " +result.getString("item"));
                System.out.println("hours: " +result.getInt("hours"));
                System.out.println("status: " +result.getString("status"));
            }
            break;


            case "2":
            System.out.println("Add a task ");
            String item = input.nextLine();
            int hours = input.nextInt();
            db.add(item,hours);
            break;

            case "3":
            System.out.println("Remove a task ");
            int id = input.nextInt();
            db.delete(id);
            break;

            case "4":
            System.out.println("Update ");
            String item1 = input.nextLine();
            int hours1 = input.nextInt();input.nextLine();
            String status = input.nextLine();
            int id1 = input.nextInt();
            db.update(item1, hours1, status, id1);
            break;


            }
        } while (!choice.equals("0"));



    }
}