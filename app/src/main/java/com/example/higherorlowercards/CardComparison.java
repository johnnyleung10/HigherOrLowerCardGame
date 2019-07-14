package com.example.higherorlowercards;

public class CardComparison {

    public static String isCardLarger(String cardA, String cardB) {
            String[] suits = {"diamonds", "clubs", "hearts", "spades"};

            //Card A
            String[] cardASplit = cardA.split(" ", 2);
            String cardANum = cardASplit[0];
            String cardASuit = cardASplit[1];
            int cardASuitVal = 0;

            for(int k = 0; k<4; k++) {
                if (suits[k].equals(cardASuit))
                    cardASuitVal = k+1;
            }

            //Card B
            String[] cardBSplit = cardB.split(" ", 2);
            String cardBNum = cardBSplit[0];
            String cardBSuit = cardBSplit[1];
            int cardBSuitVal =0;

            for(int k = 0; k<4; k++) {
                if (suits[k].equals(cardBSuit))
                    cardBSuitVal = k+1;
            }

            //Comparator
            if (Integer.parseInt(cardANum) > Integer.parseInt(cardBNum)) {
                return(cardA);
            }

            else if (Integer.parseInt(cardANum) < Integer.parseInt(cardBNum)) {
                return(cardB);
            }

            else {
                if(cardASuitVal > cardBSuitVal)
                    return(cardA);
                else
                    return(cardB);
            }
    }

}


