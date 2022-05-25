import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class MazeMaster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeMaster
{
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       Scanner sc = new Scanner(System.in);
       System.out.println("Welcome to ... and who might you be ?");
       String name = sc.nextLine();
       System.out.println("Hey "+name);
       System.out.println("i'm- well never mind who I am, as you can tell were trapped down here");
       System.out.println("with some sort of creatures, and we will have to work togeather to escape");
       //DirectionchosenA is there to allow the direction option to be repeated if an invalid option is chosen
       int directionChosenA = -1;
       //DirectionchosenA is the firsts junction, it is into the first method for as it is the first junction
       while (directionChosenA == -1)
       {
           System.out.println("Lets get going, which direction should we travel?");
           //Direction Options 
           System.out.println("1. East");
           System.out.println("2. West");
           int a = input.nextInt();
           //If the user chooses to go West it will run the code below where it will look if the user completes or fails the challenge
           if(a == 2)
           {
                 System.out.println("Traveling West...");
               boolean pathBReturn = pathB();
               //Runs if user Wins
               if (pathBReturn)
               {
    
                   System.out.println("Congrats! Honestly... Im suprise you even got it, good on you I guess");
                   System.out.println("I got some bad news though... this is a dead end so you're kinda going to have to go back");
                   System.out.println("Cya!");
                   System.out.println("Well that was a waste of time... I guess we have to go East instead");
                    
                   
               }
                //Runs if user fails        
               else if (!pathBReturn) 
               {
                   directionChosenA = -1;
               }
           }
           //Runs if user chooses to go east
           else if (a == 1)
           {
                 System.out.println("Traveling East...");
               boolean pathDReturn = pathD();
               //Runs if user wins
               if (pathDReturn)
               {
    
                   directionChosenA = 0;
                   junctionD();
               }
               //runs if user fails
               else if (!pathDReturn) 
               {
                   directionChosenA = -1;
               }
           }
    }
}
//This runs if the user makes it past the library (Path D)
    public static void junctionD()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\"Your smarter than I thougt. Lets keep along this path and get out of here\"");
        System.out.println("\"Which direction should we go?\"");
        System.out.println("1.North");
        System.out.println("2.East");
        int b = input.nextInt();
        //This runs if the user chooses to go north   
         if (b==1)
        {
            System.out.println("Traveling North...");
            boolean pathJReturn = pathJ();
            //This runs if the user completes pathJ
            if(pathJReturn)
            {
                junctionJ();
            }
            //This runs if thte user fails pathJ
            else if(!pathJReturn)
            {
                System.out.println("\"Honestly that was a very tough question, sorry about that\"");
                junctionD();
            }
        }
        //This runs if the user chooses too go east
        else if(b==2)
        {
            System.out.println("Traveling East...");
            boolean pathIReturn = pathI();
            //Runs if user Completes pathI
            if(pathIReturn) 
            {
                System.out.println("\"Wow! You actually got it right, I think my parents might let me watch anime again\"");
                junctionI();
            }
            //Runs if user fails PathI
            else if (!pathIReturn)
            {
                System.out.println("\"THANKS! I failed my exam go back to wherever you came from!\"");
                junctionD();
            }
        }
        //Runs if user types a number other than 1 or 2
        else
        {
            System.out.println("Please type a valid number...");
           junctionD(); 
        }
    }
    //Runs if the user completes the previous challenge 
    public static void junctionJ()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\"Well I guess we only have one direction to go...\"");
        System.out.println("1.East");
        int j = input.nextInt();
        //Runs if the user chooses to travel east
        if (j == 1)
        {
            System.out.println("Traveling East...");
            boolean pathKReturn = pathK();
            //Runs if user coompletes the challenge
            if(pathKReturn)
            {
                finish();
            }
            //Runs if user fails the challenge
            else if(!pathKReturn)
            {
                System.out.println("\"You are not my friend...\"");
                junctionJ();
            }     
        }
        //Runs if user types anything  but 1
        else
        {
           System.out.println("\"We only have one direction, lets just go\"");
           junctionJ(); 
        }
    }
    //Runs when uesr completes the previous challenge
    public static void junctionI()
    {
        Scanner input = new Scanner(System.in);
    
        System.out.println("\"Well I guess we only have one direction to go...\"");
        System.out.println("1.North");
        int j = input.nextInt();
        
        //Runs if the user travels north
        if (j == 1)
        {
            System.out.println("Traveling North...");
            boolean pathKReturn = pathK();
            //Runs if the user completes the challenge
            if(pathKReturn)
            {
                finish();
            }
            //Runs if the user fails the challenge
            else if(!pathKReturn)
            {
                System.out.println("\"You are not my friend...\"");
                junctionJ();
            }     
        }
        
        //Runs if user doesn't type 1
        else
        {
           System.out.println("You can only go one direction, go that direction...");
           junctionI(); 
        }
    }
    //First challenge for the user
    public static boolean pathB()
    { 
        Scanner input = new Scanner(System.in);
        System.out.println("You walk along a musty crooked path");
        System.out.println("As you continue forth you spot a young boy playing D&D in his cave");
        System.out.println("He spots you and shouts \"Ahh! a traveler I see? To get past my cave you must first play some D&D!\"");
        System.out.println("\"If you'd like to pass you must first roll a 15 or aboove!!\" /Manical laughter/");
        System.out.println("Type \"Roll\" to roll a d20");
        String rollDice = input.nextLine();
        //Runs when user types roll
        if (rollDice.equals ("Roll"))
        {
            //Randomizes the number
            int random_int = (int)Math.floor(Math.random()*(20-1+1)+1);
           
            System.out.println("You rolled a " +random_int);
            
            //If user rolls 15 or above they complete the challennge
            if(random_int >= 15)
            {
                return true;
            }   
            //If they dont then they go back to the previous junction
            else
            {
                System.out.println("Hahahahahhahhahahhahahh! YOU HAVE NO LUCK ON YOUR SIDE FOOL! HAVE FUN BEING STUCK HERE FOREVER!");
                return false;
            }
        }
        //Runs if user doesn't type Roll
        else
        {
           System.out.println("I SAID TYPE Roll! YOU CAN'T PASS!"); 
           return false;
        }
    }
    
    //Next challenge for the user runs if they choose east
    public static boolean pathD()
    {  
        Scanner input = new Scanner(System.in);
        System.out.println("As you continue east, you come across a large extravigant lirbrary, with a large paralecent fountain in the front");
        System.out.println("You continue into the library as your greeted by Hadeed, a small dwarf with a passion for knowledge");
        System.out.println("\"Ahh, welcome to my library! The names Hadeed, is there anything in particular your looking for?\"");
        System.out.println("\"We're just trying to leave this horrid place, may we pass through your library?\"");
        System.out.println("A large grin grows upon the dwarves face... \"If you'd like to get passed. You must first riddle me this\"");
        System.out.println("\"Just too be nice i'll even give you three guesses\"");
        boolean correctOrWrong = true;
        //This allows the user 3 guesses
        for(int i = 1; i < 4; i++)
        { 
           
            
             System.out.println("\"I have rivers but no water,\"");
            System.out.println("\"I have forest but no trees,\"");
            System.out.println("\"I have cities but no buildings\"");
            System.out.println("\"What am I?\"");
            String riddleHadeed = input.nextLine();
            
            //All  the code below is to see if user has used all their guesses and see if user gets the answer right
             if (i == 1) 
            {
                if (riddleHadeed.equals ("Map"))
                {
                    System.out.println("\"Ahh, a fellow scholar is see, you may continue forth past my library\"");
                    return true;
                }
                else
                {
                    System.out.println("\"no, that was a terrible guess you have two more tries\""); 
                    correctOrWrong = false;
                }
            }
            if (i == 2) 
            {
                if (riddleHadeed.equals ("Map"))
                {
                    System.out.println("\"Ahh, a fellow scholar is see, you may continue forth past my library\"");
                    return true;
                }
                else
                {
                    System.out.println("\"no, that was a terrible you have one more try!\""); 
                    correctOrWrong = false;
                }
            }
            if(i==3)
            {
                if (riddleHadeed.equals ("Map"))
                {
                    System.out.println("\"Ahh, a fellow scholar is see, you may continue forth past my library\"");
                    return true;
                }
                else
                {
                    System.out.println("\"no, that was a terrible you're out of guesses!\""); 
                    correctOrWrong = false;
                }
            }
        }
        return correctOrWrong;
    }
    //Next is an Arithmetic challenge
    public static boolean pathI()
    {  Scanner input = new Scanner(System.in);
       System.out.println("As you walk east, you begin seeing an abundance of numbers layed across the wall");
       System.out.println("You begin sinking into the ground as a strange man walks up to you");
       System.out.println("\"Howdy! The names Hersheysc14, you lookin to get out of that there hole?\"");
       System.out.println("\"If ya do want to you're going to have to solve this equation for me, I need it to pass my exam\"");
       //Randomizes x
       int x = (int)(Math.random() * 5);
       
       System.out.println("What's x^3 + 5*x - 7 if x = "+x);
       int answer = (x*x*x + 5*x);
       int answerSecond = answer - 7;
       int userAnswer = input.nextInt();
       //If the user answers the question right it returns true
       if (userAnswer == answerSecond)
       {
           return true;
       }
       //Returns false
       else
       {
           return false;
       }
       
    }
    //Next challenge if user chooses east once again
    public static boolean pathJ()
    {  
        Scanner input = new Scanner(System.in);
        System.out.println("You continue east in search of the exit");
        System.out.println("You walk up to a small tent blocking your path");
        System.out.println("As you look into the tent an small boy jumps out!");
        System.out.println("\"WELCOME NEWCOMER! What are you doing here?\"");
        System.out.println("\"IF YOU'D LIKE TO PASS YOU MUST FIRST DO ME A FAVOUR\"");
        System.out.println("Spell the word Cookie");
        String spellWord = input.nextLine();
        //runs if user can spell
        if(spellWord.equals ("Cookie"))
        {
           System.out.println("HOW DID YOU KNOW HOW TO SPELL THAT????"); 
           return true; 
        }
        //If user gets it wrong then its dissapointed
        else 
        {
            System.out.println("Yeah that was a hard one, good try");
            return false;
        }
               
    }
    
    //Final challenge for the user 
    public static boolean pathK()
    {  
        Scanner input = new Scanner(System.in);
        System.out.println("As you continue east along your path you noitce a bright light but suddenly");
        System.out.println("THE Mrs. Baconator jumps infront of you in full drag");
        System.out.println("He/Them Shouts with an earpearsing voice\" IF YOU'D LIKE TO PASS TO THE EXIT\"");
        System.out.println("\"YOU MUST FIRST SOLVE A VERY IMPORTANT QUESTION\"");
        System.out.println("\"WHO IS THE BEST PERSON!\"");
        System.out.println("1.Taylor Bybee");
        System.out.println("2.ericdoa");
        System.out.println("3.Bob Tabor");
        System.out.println("4.Baen");
        
        int bestPerson = input.nextInt();
        //If they guess correct it returns true and the final  method runs
        if (bestPerson == 4)
        {
            System.out.println("\"Very smart indeed, with a mind like that I think i'll call you a friend\"");
            return true;
        }
        //If they get it wrong it doesn't run
        else
        {
            return false;
        }
    }
    //Final part for the user to end the story off
    public static void finish()
    {
        System.out.println("You continue forward to the light,");
        
        System.out.println("You walk into the light and you wake up with your friends around you");
        System.out.println("You tell them about how they were all in your dream");
        System.out.println("Kyle the troll, Hadeed the Dwarf, Harshil the unmath, David the dragqueen and Griffin the illiterate");
    }
    
}

    



                                                                           

