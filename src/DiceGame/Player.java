package DiceGame;

import java.util.ArrayList;

public class Player {

    private String name;
    private int points = 0;
    private ArrayList<Die> diceList = new ArrayList<>();

    int counter;
    int sides;

    public Player(String name, ArrayList<Die> diceList) {
        this.name = name;
        this.diceList = new ArrayList<>(diceList);
    }

    public void rollDice() {

        for (int counter = 0; counter < diceList.size(); counter++); { // loopar antal tärningar
            diceList.get(counter).roll();   // räknar antal tärningar med randomvärde
        }
    }

    public int getDieValue() {

        addDie(sides); // Adderar en tärning
        int sum = 0;
        for (int i = 0; i < diceList.size(); i++) {
            sum += diceList.get(i).getSideValue(); // Adderar och sumerar ett resultat av alla tärningar
        }
        return sum;
    }

    public void increaseScore(Player player) { // Ökar en spelares poäng
    player.points++;
    }

    public void addDie(int sides) {  //Skapar en ny tärning med sidor och lägger till i spelarens tärningslista
        Player.this.sides = sides;

        Die addDice = new Die(this.sides);
        sides = addDice.getNrOfSides();

        diceList.add(new Die(sides));
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() { // För att hämta resultat i slutet av spelet
        return
                "" + '\n' +
                "[* Spelare: " + getName() + '\n' +
                "[* Poäng: " + getPoints() + '\n' +
                "*************";
    }
}
