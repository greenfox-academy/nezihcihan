
import java.util.Scanner;

public class PartyIndicator {
    // Write a program that asks for two numbers
// Thw first number represents the number of girls that comes to a party, the
// second the boys
// It should print: The party is exellent!
// If the the number of girls and boys are equal and there are more people coming than 20
//
// It should print: Quite cool party!
// It there are more than 20 people coming but the girl - boy ratio is not 1-1
//
// It should print: Average party...
// If there are less people coming than 20
//
// It should print: Sausage party
// If no girls are coming, regardless the count of the people
    public static void main(String[] args) {
        System.out.println("Enter a number of boys and girls came to the party respectively!\n");
        Scanner input = new Scanner(System.in);
        int boys = input.nextInt();
        int girls = input.nextInt();
        if(girls == 0){
            System.out.println("Sousage party...");
        }
        else if (((boys + girls) > 20) && (boys == girls) )
            System.out.println("The party is excellent!");

        else if((boys + girls > 20) && (boys != girls)){
            System.out.println("Quite cool party");
        }
        else if((boys + girls) < 20){
            System.out.println("Average party...");
        }


}
}
