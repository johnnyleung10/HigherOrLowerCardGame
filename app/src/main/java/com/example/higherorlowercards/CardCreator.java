package com.example.higherorlowercards;

public class CardCreator {
    public static String cardMaker() {
        String[] suits = {"diamonds", "clubs", "hearts", "spades"};

        int cardNum = (int) (Math.random()*13)+1;
        String cardSuit = suits[(int) (Math.random()*3)+0];

        return(cardNum +" " +cardSuit);
    }

    public static int cardNum(String card) {
        String[] cardSplit = card.split(" ", 2);
        return(Integer.parseInt(cardSplit[0]));
    }

    public static String cardSuit(String card) {
        String[] cardSplit = card.split(" ", 2);
        return(cardSplit[1]);
    }

    public static boolean isLarger(String cardA, String cardB) {
        if (cardA.equals(CardComparison.isCardLarger(cardA, cardB)))
            return true;
        else
            return false;
    }

    public static boolean isSmaller(String cardA, String cardB) {
        if (cardA.equals(CardComparison.isCardLarger(cardA, cardB)))
            return false;
        else
            return true;
    }


}
