
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            if(a!=b){
                System.out.println(b+1);
            }else{
                System.out.println(b);
            }
        }
    }
    
}

/*
* For each prisoner, the number of Red Hats is only two possible. 
* One is assuming that they are white hats. 
* For that prisoner, the number of Red Hats is what the prisoners now see. 
* One is to assume that they are Red Hats. 
* The number of Red Hats is the number of Red Hats seen by prisoners +1
*
* Each prisoner will only go to the warden if he knows he will not die.
*
* Type 1 : 10 people have 1 Red Riding Hood.
* The Red Hat person knows that there is at least one Red Riding Hood.
* He sees that everyone else is white, so only he is Red Hat.
*
* Type 2 : 10 individuals have 2 Red Riding Hoods.
* The first person wearing a red hat saw a red hat, 
* and the second person wearing a red hat also saw a red hat,
* and all persons wearing white hats see 2 Red Hats.
* For first and second person wearing red hats, there are up to 2 red riding hoods.
* For other people wearing white hats, there are up to 3 red riding hoods.
* The next day, first and second person wearing red hats saw no one left. 
* First person wearing red hats was not sure if he was a Red Hat. 
* Second person wearing red hats was not sure if he was a Red Hat.
* At this time, other people wearing white hats were not sure if they were red hat,
* but First person wearing red hats knows that 
* Second person wearing red hats still sees at least one Red Hat.
* It must be him, because other people are a white hat.
* Second person wearing red hats thinks so too.
* On the third day, the people wearing white hats saw wearing Red Hat persons gone,
* so they knew they were wearing white hat and they gone.
*
* Type 3 : 10 people have 3 Red Riding Hoods.
* First, second, third persons wearing red hat saw two Red Riding Hoods.
* No one left the next day.
* At this time, First person assumed that he wear white hats, and 
* it should be tomorrow that both of wearing red hat persons would have left. 
* However, on the third day, second and thrid person wearing red hat did not go.
* The representative said there was at least one Red Riding Hood. 
* It must be me because first person saw other people are white hats. 
* So on the third day, All of wearing red hat persons are gone.
* On the fourth day, people wearing white hats knew that they are white hats,
* and they gone.
*
* Finally, when the number of all persons and number of persons wearing red hat 
* is the same, the number of days required will be the same as 
* the number of days of one less number of persons wearing red hat.
*
* Ex 10 people 9 Red hats, same as 10 people 10 Red hats, 
* because on the ninth day, everyone did not go, 
* there are nine Red Riding Hoods, a white hat on the tenth day, 
* or no tenth day, everyone is Red Hat, everyone walks together
*/
