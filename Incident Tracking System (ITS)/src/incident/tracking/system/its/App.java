
package incident.tracking.system.its;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
//import jdk.internal.util.xml.impl.Input;

public class App {

    private static long serialVersionUID;
    private static File personsFile;
    private static ArrayList<String> mainMenu;
    private static ArrayList<Person> persons = new ArrayList<>();
    private static Person person1, person2, person3;

    private static Customer currentCustomer;
    private static Specialist currentSpecialist;
    private static Manager currentManager;
    private static String userName, password;

    private static boolean NOT_LOGIN_YET = true;

    public App() {
    }

    public static void main(String[] args) {
        savePersons();
        loadPersons();
        appStart();
    }

    public static void appStart() {
        int menuChoose = 0;
        mainMenu = new ArrayList<>();
        mainMenu.add("(1) User Login");
        mainMenu.add("(2) New Customer");
        mainMenu.add("(3) Exit");

        while (NOT_LOGIN_YET) {
            for (String msg : mainMenu) {
                System.out.println(msg);
            }
            Scanner scan = new Scanner(System.in);
            try {
                menuChoose = scan.nextInt();

            } catch (Exception e) {
                // System.out.println("Please choose from menu..");
            }

            if (menuChoose == 1) {
                Scanner in1 = new Scanner(System.in);
                System.out.print("UserName : ");
                userName = in1.nextLine();
                Scanner in2 = new Scanner(System.in);
                System.out.print("Password : ");
                password = in2.nextLine();

                if (doAction(new Person(userName, password), 1)) {
                    NOT_LOGIN_YET = false;

                } else {
                    System.out.println("Wronge login data try again..");
                }
            } else if (menuChoose == 2) {
                System.out.println("Enter Your Info to make account.");
                Scanner inName = new Scanner(System.in);
                System.out.print("UserName : ");
                userName = inName.nextLine();
                System.out.print("Password : ");
                Scanner inpassword = new Scanner(System.in);
                password = inpassword.nextLine();
                Person newPerson = new Person(userName, password, new UserAccount(userName, password), "Customer");
                addPerson(newPerson);

                if (doAction(new Person(userName, password), 2)) {
                    System.out.println("Account Created Success.. Welcome with you");
                    NOT_LOGIN_YET = false;

                } else {
                    System.out.println("Wronge enter valid data..");
                }

            } else if (menuChoose == 3) {
                System.out.println("Thanks forusing our system.");
                System.exit(0);
            } else {
                System.out.println("Please choose from menu..");
            }

        }
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public static void addPerson(Person person) {
        persons.add(person);

    }

    public static void savePersons() {
        person1 = new Person("ahmed", "1234", UserAccount.creatUser("abdallah", "1234"), "Customer");
        person2 = new Person("special", "1234", UserAccount.creatUser("special", "1234"), "Specialist");
        person3 = new Person("admin", "admin", UserAccount.creatUser("admin", "admin"), "Manager");

        Customer customer1 = new Customer("Ismalia", person1.getName(), person1.getName(), person1.getUserAccount());
        Specialist specialist1 = new Specialist(person2.getName(), person2.getName(), person2.getUserAccount());
        Manager manager1 = new Manager(person3.getName(), person3.getEmail(), person1.getUserAccount(), new Date());
    }

    public static void loadPersons() {

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

    }

    public Person getPerson(String name) {
        for (Person p : persons) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public static ArrayList<String> getMenu(Person person) {
        ArrayList<String> customerMenu = new ArrayList();
        ArrayList<String> specialistMenu = new ArrayList();
        ArrayList<String> managerMenu = new ArrayList();
        ArrayList<String> error = new ArrayList();

        //create customer menu..
        customerMenu.add("=============================");
        customerMenu.add("(1) Create a ticket");
        customerMenu.add("(2) Compose a message");
        customerMenu.add("(3) Reply to a message");
        customerMenu.add("(4) Display tickets");
        customerMenu.add("(5) Display a ticket's status");
        customerMenu.add("(6) Rate a specialist");
        customerMenu.add("(7) Logout");
        customerMenu.add("=============================");

        //create specialist menu..
        specialistMenu.add("=============================");
        specialistMenu.add("(1) Display new tickets");
        specialistMenu.add("(2) Update ticket status");
        specialistMenu.add("(3) Reply to a message");
        specialistMenu.add("(4) Display tickets");
        specialistMenu.add("(5) Display a ticket's status");
        specialistMenu.add("(6) Close a ticket");
        specialistMenu.add("(7) Logout");
        specialistMenu.add("=============================");

        //create manger menu..
        managerMenu.add("=============================");
        managerMenu.add("(1) Display new tickets");
        managerMenu.add("(2) Display open tickets");
        managerMenu.add("(3) Assign a ticket to specialist");
        managerMenu.add("(4) Reply to a message");
        managerMenu.add("(5) Display tickets");
        managerMenu.add("(6) Display a ticket's status");
        managerMenu.add("(7) Display highly rated specialists");
        managerMenu.add("(8) Logout");
        managerMenu.add("=============================");

        if (person.getPersonType().equals("Customer")) {
            return customerMenu;
        } else if (person.getPersonType().equals("Manager")) {
            return managerMenu;
        } else if (person.getPersonType().equals("Specialist")) {
            return specialistMenu;
        } else {
            return error;
        }
    }

    public static void displayMenu(ArrayList<String> menu, String type) {

        while (true) {
            for (String msg : menu) {
                System.out.println(msg);
            }

            if (type.equals("Customer")) {
                int input = 0;
                Scanner sc = new Scanner(System.in);
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    //System.out.println("Please enter correct choose");
                }
                switch (input) {
                    case 1:
                        //create ticket
                        System.out.println("Enter your info..");
                        Scanner s = new Scanner(System.in);
                        System.out.println("Your adress : ");
                        String address = s.nextLine();
                        System.out.println("Your email : ");
                        String email = s.nextLine();

                        currentCustomer.creatTicket();
                        System.out.println("Ticket created success..");
                        break;
                    case 2:
                        System.out.println("Enter Ticket info..");
                        Scanner ss = new Scanner(System.in);
                        System.out.println("Ticket Description : ");
                        String description = ss.nextLine();
                        Ticket t = new Ticket(description, currentCustomer);
                        currentCustomer.createMessage(t);
                        System.out.println("Enter massege for ticket : ");
                        String msg = ss.nextLine();
                        currentCustomer.createMessage(t);
                        System.out.println("Massege Created..");
                        break;
                    case 3:
                        System.out.println("Not implemnted yet");
                        break;
                    case 4:
                        currentCustomer.displayTickets();
                        break;
                    case 5:
                        Scanner sss = new Scanner(System.in);
                        System.out.println("Enter ticket id : ");
                        int ticketId = sss.nextInt();
                        Ticket tckt = currentCustomer.findTicket(ticketId);
                        if (tckt != null) {
                            System.out.println("Ticket Status : " + tckt.getStatus());
                        } else {
                            System.out.println("Ticket not found");
                        }
                        break;
                    case 6:
                        System.out.println("Not implemented yet..");
                        break;
                    case 7:
                        System.out.println("Logout Succesfully..");
                        appStart();
                        break;
                    default:
                        System.out.println("Enter correct choose");
                        break;
                }

            } else if (type.equals("Specialist")) {
                int input = 0;
                Scanner sc = new Scanner(System.in);
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    //System.out.println("Please enter correct choose");
                }
                //specialist functions in phase 2 with saving in file..
                switch (input) {
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println("LogOut Succesfully..");
                        appStart();
                        break;
                    default:
                        System.out.println("Enter correct choose");
                        break;
                }

            } else if (type.equals("Manager")) {
                int input = 0;
                Scanner sc = new Scanner(System.in);
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    //System.out.println("Please enter correct choose");
                }
                //Manager functions in phase 2 with saving in file..
                switch (input) {
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        System.out.println("LogOut Succesfully..");
                        appStart();
                        break;
                    default:
                        System.out.println("Enter correct choose");
                        break;
                }

            }

        }
    }

    public static boolean doAction(Person person, int action) {
        if (action == 1) {
            for (Person p : persons) {
                if (person.getName().equalsIgnoreCase(p.getName()) && person.getPassowrd().equalsIgnoreCase(p.getPassowrd())) {
                    if (p.getPersonType().equals("Customer")) {
                        currentCustomer = new Customer("defult location", p.getName(), p.getName() + "@ITS.com", p.getUserAccount());
                        displayMenu(getMenu(p), p.getPersonType());
                        return true;
                    } else if (p.getPersonType().equals("Specialist")) {
                        currentSpecialist = new Specialist(p.getName(), p.getName() + "@ITS.com", p.getUserAccount());
                        displayMenu(getMenu(p), p.getPersonType());
                        return true;
                    } else if (p.getPersonType().equals("Manager")) {
                        currentManager = new Manager(p.getName(), p.getName() + "@ITS.com", p.getUserAccount(), new Date());
                        displayMenu(getMenu(p), p.getPersonType());
                        return true;
                    }
                }
            }
            return false;

        } else if (action == 2) {
            for (Person p : persons) {
                if (person.getName().equalsIgnoreCase(p.getName()) && person.getPassowrd().equalsIgnoreCase(p.getPassowrd())) {
                    currentCustomer = new Customer("defult location", p.getName(), p.getName() + "@ITS.com", p.getUserAccount());
                    displayMenu(getMenu(p), p.getPersonType());
                    return true;
                }
            }
        }

        return false;
    }
}
