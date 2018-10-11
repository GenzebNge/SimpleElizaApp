package com.eliza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.*;

public class Eliza {

    private String answer;

    HashMap<String, String> hashlist = new HashMap<>();


    //String[] greeting = new array {{"Good Morning "},{"Hey"},{"Good day."}};

    ArrayList<String> comp = new ArrayList<>();
    ArrayList<String> samples = new ArrayList<>();
    ArrayList<String> qualifiers = new ArrayList<>();
    ArrayList<String> his = new ArrayList<>();


    public Eliza() {
        System.out.println(greeting()+ " What is your problem? Enter your response here or Q to quit:");
    }

    public Eliza(String Answer) {
        System.out.println("Enter your response here or Q to quit:");

    }

    public ArrayList<String> getHis() {
        return his;
    }

    public void setHis(ArrayList<String> his) {
        this.his = his;
    }

    // create a constructor with out put of asks the quuesion while object is instantiated

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // create a string method that returns a string

    public String respond(String response ) {

        return response;

        }

    // greeting class
    public String greeting() {
        ArrayList<String> greet = new ArrayList<>(Arrays.asList("Good Morning", "Hey", "Good day.", "Good night.", "Hi","Good day"));
        Random rand = new Random();
        String greeting = greet.get(rand.nextInt(greet.size()));

        return greeting;
    }

    public String replace(String response) {
        hashlist.put("i", "you");
        hashlist.put("me", "you");
        hashlist.put("my", "your");
        hashlist.put("am", "are");
        hashlist.put("you","me");

        //  System.out.println();
        String[] word = response.split(" ");
        String toPrint = "";

        for (String me : word) {
            //  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

            if (hashlist.containsKey(me))
                comp.add(hashlist.get(me));
            else
                comp.add(me);

        }

        for (String line : comp) {
            toPrint += line +" ";
        }
       // System.out.println("the replaced : "+ toPrint);

         return toPrint;
    }


    public String hedgeQualify(String respond){

        samples.add("Please tell me more");
        samples.add(" Many of my patients tell me the same thing");
        samples.add("It is getting late");
        samples.add("maybe we had better quit");

        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to think that");
        qualifiers.add("So, you are concerned that");

        Random rand = new Random();
        String ranQualifier= qualifiers.get(rand.nextInt(qualifiers.size()));
        String ranHedges= samples.get(rand.nextInt(samples.size()));

        String finValue = ranQualifier.concat(" "+respond);

        ArrayList<String> lists = new ArrayList<>();
        lists.add(ranHedges);
        lists.add(finValue);

        String randomWord = lists.get(rand.nextInt(lists.size()));

        return  randomWord;


    }
    /*public ArrayList<String> showHistory(ArrayList<String> histEliza, ArrayList<String> histUser){
        return  histEliza;

    }
*/
}
