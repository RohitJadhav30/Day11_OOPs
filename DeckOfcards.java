//program4

import java.util.Random;

public class DeckOfcards {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "Queen", "King", "Ace"};
    private static final int TOATAL_CARDS = SUITS.length * RANKS.length;
    private static final int CARDS_PER_PLAYER = 9;
    private static final int TOTAL_PLAYERS = 4;

    private static String[] initializeDeck(){
        String[] deck = new String[TOATAL_CARDS];
        int index = 0 ;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    private static void shuffle(String[] deck){
        Random random = new Random();
        for(int i = 0; i < deck.length; i++){
            int randomIndex = random.nextInt(deck.length);
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    private static String[][] distributeCards(String[] deck){
        String[][] playersCards = new String[TOTAL_PLAYERS][CARDS_PER_PLAYER];
        int cardIndex = 0;
        for(int i = 0; i < TOTAL_PLAYERS; i++){
            for(int j = 0; j < CARDS_PER_PLAYER; j++){
                playersCards[i][j] = deck[cardIndex++];
            }
        }
        return playersCards;
    }

    private static void printCards(String[][] playersCards){
        for(int i = 0; i < playersCards.length; i++){
            System.out.println("Player " + (i + 1) + " cards: ");
            for(int j = 0; j < playersCards[i].length; j++){
                System.out.println(playersCards[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] deck = initializeDeck();
        shuffle(deck);
        String[][] playersCards = distributeCards(deck);
        printCards(playersCards);
    }
}
