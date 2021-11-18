package DiceGame;

import java.util.Random;

public class Die {

    // Här skapas en tärning med ett random värde beroende på antal sidor

    private int sideValue;
    private int nrOfSides;
    private static Random randomize = new Random();

    public Die(int nrOfSides) {
        this.nrOfSides = nrOfSides;
    }

    public void roll() {
        sideValue = randomize.nextInt(nrOfSides) +1; // random metoden beror på hur många sidor tärningen har
    }

    public int getSideValue() { // Med denna metod kan vi hämta sid-värdet på en tärning
        return sideValue;
    }

    public int getNrOfSides() {
        return nrOfSides;
    }
}
