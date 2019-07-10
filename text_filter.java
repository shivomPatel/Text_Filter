import java.util.Scanner;
/**
 * Project 1 - Text Filter
 *
 * The program gives the user the choice
 * to filter, replace, or censor a passage of
 * text that they input. The program continues
 * for as long as the user responds to the program
 * with "Yes".
 *
 * @author Shivom Patel, lab sec 813
 *
 * @version September 26, 2018
 *
 */
public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print hello message
        System.out.println("Welcome to TextFilter!");

        // Value to keep track of if the user wants to keep filtering text
        boolean keepFiltering = true;

        do {
            // Print options for the user to select
            System.out.println("Please select one of the following filtering options:");
            System.out.println("1. Filter Word\n" +
                    "2. Find-And-Replace\n" +
                    "3. Censor Information");


            // Save their choice
            int choice = 0;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                choice = 0;
                scanner.nextLine();
            }

            if (choice == 1 ) {

                // PART 1 - Censoring Words

                System.out.println();
                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered:");

                passage = scanner.nextLine();

                String word;  // The word to be censored from the text phrase
                System.out.println("Please enter the word you would like to censor:");

                word = scanner.nextLine();
                System.out.println("Uncensored:");
                System.out.println(passage);
                passage = passage + " ";


                String xCharacters = "";

                for (int i = 0; i < word.length(); i++) {
                    xCharacters += "X";
                }


                if (passage.contains(" " + word + " ")) {
                    passage = passage.replace(" " + word + " ", " " + xCharacters + " ");

                }
                if (passage.contains(word + "?")) {
                    passage = passage.replace(word + "?", xCharacters + "?");

                }
                if (passage.contains(word + ".")) {
                    passage = passage.replace(word + ".", xCharacters + ".");

                }
                if (passage.contains(word + "!")) {
                    passage = passage.replace(word + "!", xCharacters + "!");

                }


                if (passage.contains(" " + word + "\n")) {
                    passage = passage.replace(" " + word + "\n", " " + xCharacters + "\n");

                }

                if (passage.contains(word + ",")) {
                    passage = passage.replace(word + ",", xCharacters + ",");

                }

                if (passage.contains(word + " ") && passage.charAt(0) == word.charAt(0)) {
                    passage = passage.replace(word + " ", xCharacters + " ");

                }


                System.out.println("Censored:");
                //System.out.println(passage.trim() + punct);
                System.out.println(passage.trim());


            } else if (choice == 2) {

                // PART 2 - Replacing Words


                String passage = "";  // The text to be filtered
                System.out.println();
                System.out.println("Please enter the passage you would like filtered:");


                passage = scanner.nextLine();


                String replace;  // The word to be filtered from the text phrase
                System.out.println("Please enter the word you would like to replace:");


                replace = scanner.nextLine();


                String insert;  // The word to be inserted in the text phrase
                System.out.println("Please enter word you would like to insert:");


                insert = scanner.nextLine();

                System.out.println("Uncensored:");
                System.out.println(passage);


                if (passage.contains(replace)) {
                    passage = passage.replace(replace, insert);
                    //passage.substring(0, word.indexOf(word.charAt(1))) + word + passage.substring(word.length());
                }


                System.out.println("Censored:");
                System.out.println(passage);



            } else if (choice == 3) {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // PART 3 - Censoring Personal Information

                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */

                String passage = "";  // String for holding text to be filtered
                System.out.println();
                System.out.println("Please enter the phrase you would like to censor information from:");

                while (true) {

                    String temp = scanner.nextLine(); // Obtain a line from the user

                    if (!passage.isEmpty() && temp.isEmpty()) {
                        break;
                    } else if (passage.isEmpty() && temp.isEmpty()) {
                        continue;
                    }

                    // Add the contents of temp into the phrase
                    passage += temp;


                    // Append a newline character to each line for parsing
                    // This will separate each line the user enters
                    // To understand how input is formatted in Part 3, please refer to the handout.
                    passage += '\n';
                }

                // Print the uncensored passage
                System.out.println("Uncensored: ");
                System.out.println(passage);


                String[] passageArrayOption3 = passage.split("\n");

                /*for(int i = 0; i < passageArrayOption3.length; i++){
                    System.out.println(passageArrayOption3[i]);
                }*/

                String nameStarCharacter = "";
                String nameStarCharacterLast = "";

                String emailFirstStars = "";
                String emailLastStars = "";

                String phoneNumberStars = "***-***";
                String phoneNumber = "";

                for (int i = 0; i < passageArrayOption3.length; i++) {
                    if (passageArrayOption3[i].contains("Name:")) {
                        //System.out.println(passageArrayOption3[i].substring(0, passageArrayOption3[i].indexOf(" ")));

                        for (int u = 0; u < passageArrayOption3[i].substring(passageArrayOption3[i].indexOf(" ") + 2,
                                passageArrayOption3[i].lastIndexOf(" ")).length(); u++) {
                            nameStarCharacter = nameStarCharacter + "*";
                        }

                        passageArrayOption3[i] = passageArrayOption3[i].replace(passageArrayOption3[i].substring(
                                passageArrayOption3[i].indexOf(" ") + 2,
                                passageArrayOption3[i].lastIndexOf(" ")), nameStarCharacter);

                        nameStarCharacter = "";
                        passage = passageArrayOption3[i];

                        for (int u = 0; u < passageArrayOption3[i].substring(
                                passageArrayOption3[i].lastIndexOf(" ") + 1,
                                passageArrayOption3[i].length()).length() - 1; u++) {
                            nameStarCharacterLast = nameStarCharacterLast + "*";
                        }

                        passageArrayOption3[i] = passageArrayOption3[i].replace(passageArrayOption3[i].substring(
                                passageArrayOption3[i].lastIndexOf(" ") + 1,
                                passageArrayOption3[i].length() - 1), nameStarCharacterLast);

                        nameStarCharacterLast = "";
                        passage = String.join("\n", passageArrayOption3);

                    }

                    if (passageArrayOption3[i].contains("Email:")) {
                        //System.out.println(passageArrayOption3[i].substring(0, passageArrayOption3[i].indexOf(" ")));

                        for (int u = 0; u < passageArrayOption3[i].substring(passageArrayOption3[i].indexOf(" ") + 2,
                                passageArrayOption3[i].indexOf("@")).length(); u++) {
                            emailFirstStars += "*";
                        }
                        passageArrayOption3[i] = passageArrayOption3[i].replace(passageArrayOption3[i].substring(
                                passageArrayOption3[i].indexOf(" ") + 2,
                                passageArrayOption3[i].indexOf("@")), emailFirstStars);

                        emailFirstStars = "";

                        for (int m = 0; m < passageArrayOption3[i].substring(passageArrayOption3[i].indexOf("@") + 2,
                                passageArrayOption3[i].indexOf(".")).length(); m++) {
                            emailLastStars += "*";
                        }

                        passageArrayOption3[i] = passageArrayOption3[i].replace(passageArrayOption3[i].substring(
                                passageArrayOption3[i].indexOf("@") + 2,
                                passageArrayOption3[i].indexOf(".")), emailLastStars);

                        String emailHolder = passageArrayOption3[i].substring(passageArrayOption3[i].indexOf(":"));
                        //System.out.println(emailHolder);
                        //System.out.println(passageArrayOption3[i]);

                        passageArrayOption3[i] = "Email" + emailHolder.replace(
                                emailHolder.substring(emailHolder.indexOf("@") + 2,
                                        emailHolder.indexOf(".")), emailLastStars);
                        //System.out.println(passageArrayOption3[i]);

                        passage = String.join("\n", passageArrayOption3);
                        emailLastStars = "";

                    }

                    if (passageArrayOption3[i].contains("Phone:")) {
                        //System.out.println(passageArrayOption3[i].substring(0, passageArrayOption3[i].indexOf(" ")));

                        passageArrayOption3[i] = passageArrayOption3[i].replace(passageArrayOption3[i].substring(
                                passageArrayOption3[i].indexOf(" ") + 1,
                                passageArrayOption3[i].lastIndexOf("-")), phoneNumberStars);


                        passage = String.join("\n", passageArrayOption3);
                    }
                }

                // Print the censored passage

                System.out.println("Censored:");
                System.out.println(passage);
                System.out.println();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            } else {

                // They entered a number that was not 1, 2 or 3
                System.out.println("The option you chose was invalid!");

            }

            System.out.println("Would you like to keep filtering? Yes/No");
            String decision = scanner.next();

            if (decision.equals("Yes") || decision.equals("yes")) {
                keepFiltering = true;
            } else {
                keepFiltering = false;
            }

        } while (keepFiltering);
        System.out.println("Thank you for using TextFilter!");
        // Shivom patel is awesome

    }
}
