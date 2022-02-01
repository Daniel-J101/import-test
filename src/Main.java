import models.Movie;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try {
            loadMovies("Movies.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("MOVIES LOADED\n\n");
            System.out.println(store);
            manageMovies();
        }


//        System.out.println(movie);

    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return \n\td) exit");
            String answer = scanner.nextLine();

            if(!(answer.equals("a") || answer.equals("b") || answer.equals("c")))
                break;

            System.out.println("Please enter the name of the movie ");
            String name = scanner.nextLine();
            if(name.isEmpty()) {
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }

            switch(answer) {
                case "a":
                    if(!store.getMovie(name).isAvailable()) {
                        System.out.println("\n\n\n\nThe movie is not available for purchasing. Please try again\n");
                        continue;
                    }
                    store.action(name, "sell");
                    break;
                case "b":
                    if(!store.getMovie(name).isAvailable()) {
                        System.out.println("\n\n\n\nThe movie is not available for renting. Please try again\n");
                        continue;
                    }
                    store.action(name, "rent");
                    break;
                case "c":
                    store.action(name, "return");
                    break;
                default:
                    System.out.println("Something went wrong.");
            }

            System.out.println("\n\nUPDATED MOVIES\n\n");
            System.out.println(store);
        }

        scanner.close();
    }


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */
    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);

        while(scanner.hasNextLine()) {
            String info = scanner.nextLine();
            String[] piece = info.split("--");
            Movie temp = new Movie(piece[0], piece[1], Double.parseDouble(piece[2]));
            store.addMovie(temp);
        }

        scanner.close();
    }

}