
package tvseriesmain;

import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a single Series
class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    
        // Constructor for SeriesModel
    public SeriesModel(String id, String name, String age, String episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisodes = episodes;
    }
}

public class TVseriesMenu {
      // Stores all series objects in memory
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

     // Main loop to start the application
    public void run() {
        while (true) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("*****************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String input = sc.nextLine();

            if (input.equals("1")) {
                showMenu();
            } else {
                System.out.println("Exiting application...");
                break;
            }
        }
    }

       // Prints the menu options and handles user selection
    public void showMenu() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction.");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application.");

        System.out.print("\nEnter your choice: ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                captureSeries();
                break;
            case "2":
                searchSeries();
                break;
            case "3":
                updateSeries();
                break;
            case "4":
                deleteSeries();
                break;
            case "5":
                printSeriesReport();
                break;
            case "6":
                exitSeriesApplication();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu...");
        }
    }

    // Captures a new series and saves it into the list
    public void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("*****************************");

        System.out.print("Enter the series id: ");
        String id = sc.nextLine();

        System.out.print("Enter the series name: ");
        String name = sc.nextLine();

          // Validate age input using helper method
        String age = getValidSeriesAge();

        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = sc.nextLine();

         // Create a new series object and add to list
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);

        System.out.println("Series processed successfully!!!");
        backToMenuOrExit();
    }

     // Ensures the user enters a valid age restriction between 2 and 18
    public String getValidSeriesAge() {
        while (true) {
            System.out.print("Enter the series age restriction: ");
            String ageInput = sc.nextLine();

            if (!isNumeric(ageInput)) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.println("Please re-enter the series age >>");
                continue;
            }

            int age = Integer.parseInt(ageInput);
            if (age < 2 || age > 18) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.println("Please re-enter the series age >>");
                continue;
            }
            return ageInput;
        }
    }

    
      // Utility method to check if a string is numeric
    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

     // Allows user to search for a series by ID
    public void searchSeries() {
        System.out.print("\nEnter the series id to search: ");
        String searchId = sc.nextLine();

        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(searchId)) {
                System.out.println("------------------------------------");
                System.out.println("SERIES ID: " + series.SeriesId);
                System.out.println("SERIES NAME: " + series.SeriesName);
                System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
                System.out.println("------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("------------------------------------");
            System.out.println("Series with Series Id: " + searchId + " was not found!");
            System.out.println("------------------------------------");
        }

        backToMenuOrExit();
    }

    // Updates details of an existing series
    public void updateSeries() {
        System.out.print("\nEnter the series id to update: ");
        String updateId = sc.nextLine();

        SeriesModel seriesToUpdate = null;
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(updateId)) {
                seriesToUpdate = series;
                break;
            }
        }

        if (seriesToUpdate == null) {
            System.out.println("Series with Series Id: " + updateId + " was not found!");
            backToMenuOrExit();
            return;
        }

         // Collect new details
        System.out.print("Enter the series name: ");
        String newName = sc.nextLine();

        String newAge = getValidSeriesAge();

        System.out.print("Enter the number of episodes: ");
        String newEpisodes = sc.nextLine();

         // Apply updates
        seriesToUpdate.SeriesName = newName;
        seriesToUpdate.SeriesAge = newAge;
        seriesToUpdate.SeriesNumberOfEpisodes = newEpisodes;

        System.out.println("Series updated successfully!!!");
        backToMenuOrExit();
    }

    // Deletes a series by ID after confirmation
    public void deleteSeries() {
        System.out.print("\nEnter the series id to delete: ");
        String deleteId = sc.nextLine();

        SeriesModel seriesToDelete = null;
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(deleteId)) {
                seriesToDelete = series;
                break;
            }
        }

        if (seriesToDelete == null) {
            System.out.println("Series with Series Id: " + deleteId + " was not found!");
            backToMenuOrExit();
            return;
        }

        System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete: ");
        String confirmation = sc.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            seriesList.remove(seriesToDelete);
            System.out.println("------------------------------------");
            System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
            System.out.println("------------------------------------");
        } else {
            System.out.println("Deletion cancelled.");
        }

        backToMenuOrExit();
    }

     // Prints all series currently in the system
    public void printSeriesReport() {
        System.out.println("\nSERIES REPORT - 2025");
        System.out.println("*****************************");

        if (seriesList.isEmpty()) {
            System.out.println("No series data available.");
        } else {
            int counter = 1;
            for (SeriesModel series : seriesList) {
                System.out.println("Series " + counter);
                System.out.println("------------------------------------");
                System.out.println("SERIES ID: " + series.SeriesId);
                System.out.println("SERIES NAME: " + series.SeriesName);
                System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
                System.out.println("NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
                System.out.println("------------------------------------");
                counter++;
            }
        }
        backToMenuOrExit();
    }

     // Exits the program completely
    public void exitSeriesApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }

    // After each action, gives the user a choice to return to menu or exit
    public void backToMenuOrExit() {
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String input = sc.nextLine();

        if (input.equals("1")) {
            showMenu();
        } else {
            exitSeriesApplication();
        }
    }
}
