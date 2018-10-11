package com.eliza;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        // input the users response
        Scanner input = new Scanner(System.in);
        Eliza eliz = new Eliza();
        String response = input.nextLine();
        eliz.setAnswer(response);
        ArrayList<String> histUser = new ArrayList<>();
        ArrayList<String> histEliza = new ArrayList<>();
        ArrayList<String> hist = new ArrayList<>();

        histUser.add(eliz.getAnswer());

        if (!(response.equalsIgnoreCase("q") || response.equalsIgnoreCase("I am feeling great"))) {
            String response1 = eliz.replace(response);
            // then qualifier and appending method here
            System.out.println(eliz.hedgeQualify(response1));
            hist.add(eliz.hedgeQualify(response1));
            //  System.out.println();
            String response2;

            do {
                Eliza eliz2 = new Eliza("");
                response2 = input.nextLine();
                eliz2.setAnswer(response2);
                hist.add(eliz2.getAnswer());
                String replace = eliz2.replace(response2);
                // System.out.println("replaced word :"+ replace);

                System.out.println(eliz2.hedgeQualify(replace));
                hist.add(eliz2.hedgeQualify(replace));
                // System.out.println(eliz2.getHis());
                //  System.out.println(replace);
            } while (!response2.equalsIgnoreCase("q") && !response2.equalsIgnoreCase("I am feeling great"));

        } else {
            System.out.println("Thank you for playing !");
        }

        // System.out.println("the size of the inputs : "+ hist.size());
        System.out.println("do you wanna see the history of user " + hist);
        System.out.println("do you wanna see the history of eliza " + histEliza);


        System.out.println("do you wanna see the history");
        String seeHis = input.nextLine();

        if(seeHis.equalsIgnoreCase("yes")) {

            for (String word: hist) {
                System.out.println(word);
            }
        }


    }
}


