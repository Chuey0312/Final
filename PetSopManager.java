import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PetSopManager {

    private static PetShop space = new PetShop(50);
    ///////////////////////////

    private static void printMenu() {
        System.out.println("\nPet Shop Options\n\n" +
                "a: add Pet manually\n" +
                "b: remove a pet\n" +
                "c: See the pets we have\n" +
                "d: count the pets we have\n" +
                "e: write pets to a file\n" +
                "f: Scan files\n" +
                "?: menu\n" +
                "q: quit\n\n");
    }

    ///////////////////////////
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char command;
        printMenu();
        do {
            System.out.println("Enter a command or type '?'");
            command = input.nextLine().toLowerCase().charAt(0);

            switch (command) {
                case 'a':
                    System.out.println("Enter the Name, found or surrendered, and age on 3 separate lines.");
                    String Name = input.nextLine();
                    String FS = input.nextLine();
                    int age = Integer.parseInt(input.nextLine());


                    System.out.println("Dog (1) or Cat (2)?");
                    int CoD = Integer.parseInt(input.nextLine());

                    Pet a;
                    if (CoD == 1) {
                        System.out.println("Enter type of Dog: ");
                        String tod = input.nextLine();
                        a = new Dog(Name, FS, age,tod );
                    } else {
                        System.out.println("Enter type of cat:  ");
                        String toc = input.nextLine();
                        a = new Cat(Name, FS, age, toc);
                    }
                    if (space.add(a)) {
                        System.out.println("Pet added!");
                    } else {
                        System.out.println("No more space");
                    }

                    break;

                case 'b':
                    System.out.println("Please enter the PID");

                    break;

                case 'c':
                    System.out.println(space.toString());
                    break;

                case 'd':
                    System.out.println("There are" + " " + space.getCount() + "" + "pets here");
                    break;
                case 'e':
                    System.out.println("Enter file name");
                    String filename = input.nextLine();
                    int numPetsWritten = 0;
                    try {
                        numPetsWritten = space.writePets(filename);
                    } catch (FileNotFoundException blah) {
                        blah.printStackTrace();
                    }

                    System.out.println(numPetsWritten);
                    break;
                case 'f':
                    System.out.println("Please enter file name for import");
                    filename = input.nextLine();
                    int numPetsRead = 0;
                    try {
                        numPetsRead = readPets(filename);
                    } catch (FileNotFoundException fne) {
                        System.out.println(numPetsRead + "Pets imported from file");
                    }

                    break;
                case '?':
                    printMenu();
                    break;


                case 'q':
                    System.out.println("Thank you, good bye");
                    break;
                default:
                    System.out.println("Try again");
            }

        } while (command != 'q');
    }

    ///////////////////////////
    public static Pet parsePet(String petText) throws PetFormatException {
        String[] tepee = petText.split("\t");
        if (tepee.length != 6)
            throw new PetFormatException("Nope thats wrong");
        if (tepee[0].equals("DOG")) return new Dog(tepee);
        if (tepee[0].equals("CAT")) return new Cat(tepee);
        else throw new PetFormatException("Line must start with CAT or DOG");
    }

    ///////////////////////////
    public static int readPets(String filename) throws FileNotFoundException {
        int count = 0;
        Scanner filescan = new Scanner(new File(filename));

        while (filescan.hasNext()) {
            String currentLine = filescan.nextLine();
            try {
                space.add(parsePet(currentLine));
                count++;
            } catch (PetFormatException PFE) {
                System.out.println("something went wrong");

            }
        }
        filescan.close();
        return count;
    }
}



