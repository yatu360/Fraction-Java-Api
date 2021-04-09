import java.util.*;

import fraction.Fraction;
import fraction.FractionImpl;

public class Main {



    public static void questionOne(){
        Random rand = new Random();
        int n = rand.nextInt(10);
        int k = rand.nextInt(25);
        FractionImpl pizza = new FractionImpl(n);
        FractionImpl people = new FractionImpl(k);
        String answer = pizza.divide(people).toString();

        System.out.println("A group consisting of "+k+" mates, go into a pizzaria together and each order "+k
                            +" pizza(s), but they receive "+n+" pizza(s) instead, how much will each get? (Give your" +
                                "answer in the lowest form as a/b)");

        Scanner user = new Scanner(System.in);
        String userAnswer = user.nextLine();

        if (answer.equals(userAnswer)){
            System.out.println("Correct Answer");
        }
        else{
            System.out.println("Incorrect Answer, the correct answer is: "+answer);
        }
    }


    public static void questionTwo(){
        Random rand = new Random();
        int m = rand.nextInt(25);
        int n = rand.nextInt(25);
        int k = rand.nextInt(25);
        int l = rand.nextInt(25);
        FractionImpl Martha = new FractionImpl(m, n);
        FractionImpl Lisa = new FractionImpl(k, l);
        String answer = Martha.add(Lisa).toString();

        System.out.println("Two sisters, Martha & Lisa just got given their pocket money allowance. Martha received "
                +Martha.toString()+" pound(s) and Lisa received "+Lisa.toString()+" pound(s) ,how much did the sisters received in total?" +
                " Give your answer in the lowest form with a/b format");

        Scanner user = new Scanner(System.in);
        String userAnswer = user.nextLine();

        if (answer.equals(userAnswer)){
            System.out.println("Correct Answer");
        }
        else{
            System.out.println("Incorrect Answer, the correct answer is: "+answer);
        }
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int i = user.nextInt();
        if (i==1){
            questionOne();
        }else if (i==2){
            questionTwo();
        }


    }

}
