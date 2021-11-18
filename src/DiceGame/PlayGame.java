package DiceGame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PlayGame {

    private static ArrayList<Player> players = new ArrayList<>();
    static int guess;

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("VÄLKOMMEN TILL TÄRNINGSSPELET!");
        System.out.println("");

        takeTurn();
        getWinners(players);
    }

    private static ArrayList<Player> initialize() {

        Scanner input = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>(); // Initierar en lista med spelare
        ArrayList<Die> diceList = new ArrayList<>(); // Initierar en  lista med tärningar

        System.out.println("Hur många spelare vill spela? ");
        int numOfPlayers = input.nextInt();

        System.out.println("Hur många tärningar ska varje spelare ha?");
        int numOfDices = input.nextInt();

        System.out.println("Hur många sidor ska tärningen ha?");
        int numOfSides = input.nextInt();
        System.out.println("****************************");

        for (int i = 0; i < numOfDices; i++) {
            diceList.add(new Die(numOfSides)); // Adderar tärning till tärningslistan
        }

        for (int i = 1; i < numOfPlayers + 1; i++) {
            System.out.println("Spelare " + i + " Skriv in ditt namn: ");
            String names = input.next();
            players.add(new Player(names,diceList));  // Adderar namn och tärningslistan till listan med spelare
        }

        return players;
    }

    private static void takeTurn() {

        Scanner guessValue = new Scanner(System.in);
        int i = 0;
        players = new ArrayList<>(initialize());

        for (int j = 0; j <5; j++) { // 5 omgångar

            for (i=0; i < players.size(); i++) { // loopar genom listan med spelare
                System.out.println();
                System.out.println("****************************");
                System.out.println("Spelare: " + players.get(i).getName()); //skriver ut spelaren namn
                System.out.println("Gissa tärningens värde: ");
                guess = guessValue.nextInt(); // Tar in spelarens gissning
                System.out.println();
                System.out.println("* TÄRNINGARNA KASTAS *");
                System.out.println();
                players.get(i).rollDice(); //Metod som rullar tärninagrna
                System.out.println("Du kastade: " + players.get(i).getDieValue()); // Hämtar värdet på tärningarna
                System.out.println();

                if (guess == players.get(i).getDieValue()) { // Om gissning är rätt
                        System.out.println("Du gissade rätt och får 1 extra poäng!");
                        players.get(i).increaseScore(players.get(i)); // Plusar på spelarens poäng
                        System.out.println(players.get(i).getName() + " har nu: " + players.get(i).getPoints() + " poäng");
                } else if (guess != players.get(i).getDieValue()) { // Om gissning är fel
                    System.out.println("Du gissade fel...");
                    System.out.println(players.get(i).getName() + " har : " + players.get(i).getPoints() + " poäng");
                }
            }


        }
        System.out.println();
        System.out.println("****************************");
        System.out.println("Spelet är slut och vinnaren/vinnarna är...");
        System.out.println();
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {

        ArrayList<Player> winners = new ArrayList(); // Initierar en lista med vinnare

        Player element = Collections.max(players, Comparator.comparingInt(Player::getPoints));
        int maxPoints = element.getPoints();
        int i;

        for (i = 0; i < players.size(); i++) {  // Loopar igenom listan med användare
            if (maxPoints == players.get(i).getPoints()) { // Kollar vilken spelare som har flest poäng
                winners.add(players.get(i)); // Adderar spelare till vinnarlistan
            }
        }

        if (winners.size() != 0) {  // Om listan med vinnare inte är 0
            for (i = 0; i < winners.size(); i++) { // Loopar igenom listan med vinnare och skriver ut
                System.out.println("*" + winners.get(i).getName() + "!*");
            }
        }

        System.out.println();
        System.out.println("**RESULTAT**");
        System.out.println(players.toString()); // Hämtar resultat

        return winners;
    }

}

