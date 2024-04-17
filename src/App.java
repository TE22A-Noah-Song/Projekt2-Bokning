import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int[] platser = new int[20];
        visaMeny(platser);
    }

   
    public static void visaMeny(int[] platser) {
        Scanner t = new Scanner(System.in);

        while (true) {
            System.out.println("Välkommen till Noahs bussresa! Välj mellan 1-4:\n 1. Boka plats\n 2. Hitta bokning\n 3. Avboka bokning\n 4. Avsluta");

            int val = t.nextInt();
            switch (val) {
                case 1:
                    BokaPlats(platser);
                    break;
                case 2:
                    HittaBokning(platser);
                    break;
                case 3:
                    AvbokaBokning(platser);
                    break;
                case 4:
                    System.out.println("Tack för besöket!");
                    return;
                default:
                    System.out.println("Felaktigt val. Vänligen välj mellan 1-4.");
                    
            }
        }
    }

    public static void BokaPlats(int[] platser) {
        //bokningslogik här
        Scanner t = new Scanner(System.in);
        System.out.print("Ange personnummer med ÅÅÅÅMMDD för att boka plats:");
        int personnummer=t.nextInt();
       
        //Printar ut alla säten där 0=ledig
        for (int index = 0; index < platser.length; index++) {
        System.out.print(platser[index]+" ");
        }
        System.out.print(" Vilket säte vill du boka från 1-20?:");
        int säte=t.nextInt();

        if (säte >= 1 && säte <= platser.length && platser[säte - 1] == 0) {
            platser[säte - 1] = personnummer; // Boka platsen med personnumret
            System.out.println("Plats " + säte + " har bokats för personnummer: " + personnummer);
                try {
                    Thread.sleep(2000);    
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            
        } else {
            System.out.println("Ogiltigt eller upptaget säte. Försök igen.");
        }
        int pris=0;
        System.out.print("Ange ålder i siffror:");
        int ålder=t.nextInt();
        if (ålder<18) {
             pris=150;
        }
        else if (ålder>=18) {
             pris=300;
        }
        else{
            System.out.println("Felaktig inmatning! Ange ålder i siffror.");
        }
        System.out.println(pris);
        
    }

    public static void HittaBokning(int[] platser) {
        //logik för att hitta en bokning härz
        Scanner t = new Scanner(System.in);
        System.out.println("Hittade bokning!");
    }

    public static void AvbokaBokning(int[] platser) {
        //logik för att avboka en bokning här
        Scanner t = new Scanner(System.in);
        System.out.println("Bokning avbokad!");
    }
}
