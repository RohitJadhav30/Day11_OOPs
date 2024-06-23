//program5

import java.util.Random;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front;
    private Node rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public String dequeue() {
        if (this.front == null)
            return null;
        String data = this.front.data;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        return data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class Player {
    private String name;
    private Queue cards;

    public Player(String name) {
        this.name = name;
        this.cards = new Queue();
    }

    public void addCard(String card) {
        this.cards.enqueue(card);
    }

    public void sortCards() {
        String[] cardArray = new String[9];
        Node current = cards.front;
        int index = 0;
        while (current != null) {
            cardArray[index++] = current.data;
            current = current.next;
        }
        for (int i = 0; i < cardArray.length - 1; i++) {
            for (int j = i + 1; j < cardArray.length; j++) {
                if (compareCards(cardArray[i], cardArray[j]) > 0) {
                    String temp = cardArray[i];
                    cardArray[i] = cardArray[j];
                    cardArray[j] = temp;
                }
            }
        }
        cards = new Queue();
        for (String card : cardArray) {
            cards.enqueue(card);
        }
    }

    private int compareCards(String card1, String card2) {
        String[] parts1 = card1.split(" ");
        String[] parts2 = card2.split(" ");
        int rank1 = getRankIndex(parts1[0]);
        int rank2 = getRankIndex(parts2[0]);
        return Integer.compare(rank1, rank2);
    }

    private int getRankIndex(String rank) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i].equals(rank)) {
                return i;
            }
        }
        return -1; 
    }

    public void printCards() {
        System.out.println(name + "'s cards:");
        cards.printQueue();
        System.out.println();
    }
}

public class DeckOfCards2 {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int TOTAL_CARDS = SUITS.length * RANKS.length;
    private static final int CARDS_PER_PLAYER = 9;
    private static final int TOTAL_PLAYERS = 4;

    public static void main(String[] args) {
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        Player[] players = distributeCards(deck);
        printPlayers(players);
    }

    private static String[] initializeDeck() {
        String[] deck = new String[TOTAL_CARDS];
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    private static void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = random.nextInt(deck.length);
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    private static Player[] distributeCards(String[] deck) {
        Player[] players = new Player[TOTAL_PLAYERS];
        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        int cardIndex = 0;
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            for (Player player : players) {
                player.addCard(deck[cardIndex++]);
            }
        }
        for (Player player : players) {
            player.sortCards();
        }
        return players;
    }

    private static void printPlayers(Player[] players) {
        for (Player player : players) {
            player.printCards();
        }
    }
}
