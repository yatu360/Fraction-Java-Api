import java.util.*;


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

        System.out.print("Enter Answer: ");
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
        System.out.print("Enter Answer: ");


        Scanner user = new Scanner(System.in);
        String userAnswer = user.nextLine();

        if (answer.equals(userAnswer)){
            System.out.println("Correct Answer");
        }
        else{
            System.out.println("Incorrect Answer, the correct answer is: "+answer);
        }
    }


    public static void questionThree(){
        Random rand = new Random();
        int m = rand.nextInt(25);
        int r = rand.nextInt(25);
        String text;

        FractionImpl Marco = new FractionImpl(m, 100);
        FractionImpl Robert = new FractionImpl(r, 100);
        int answer = Marco.compareTo(Robert);

        System.out.println("Two brothers, Marco and Robert are to inherit a vast estate from their parents, Marco is due to" +
                "receive "+Marco.toString()+" as a percentage fraction of the estate and Robert is due to receive "+
                Robert.toString()+" as a percentage fraction of the estate, who is the favourite child? (Marco, Robert or Both)");

        System.out.print("Enter Answer: ");
        Scanner user = new Scanner(System.in);
        String userAnswer = user.nextLine().toLowerCase(Locale.ROOT).trim();

        if (answer>0 && userAnswer.equals("marco")){
            System.out.println("Correct Answer");
        }else if (answer<0 && userAnswer.equals("robert")){
            System.out.println("Correct Answer");
        }
        else if (answer==0 && userAnswer.equals("both")){
            System.out.println("Correct Answer");
        }
        else{
            if(answer>0) text = "Marco";
            else if (answer<0) text = "Robert";
            else text="Both";
            System.out.println("Incorrect answer, the correct answer is: "+text);
        }

    }


    public static void main(String[] args) {
        System.out.println("Enter values between 1-3 to play fraction question time or 0 to exit program");
        Scanner user = new Scanner(System.in);
        int i = user.nextInt();
        while (i!=0) {
            if (i==1) questionOne();
            else if (i==2) questionTwo();
            else if (i==3) questionThree();
            System.out.println("Please enter values between 1-3 for questions or 0 to exit");
            i = user.nextInt();
        }


    }

}
