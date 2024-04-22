import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int[] platser = new int[20];
        int totalPris = 0; // Variabel för att hålla reda på det totala priset
        visaMeny(platser, totalPris);
    }

    public static void visaMeny(int[] platser, int totalPris) {
        Scanner t = new Scanner(System.in);

        while (true) {
            System.out.println("Välkommen till Noahs bussresa! Välj mellan 1-4:\n 1. Boka plats\n 2. Hitta bokning\n 3. Avboka bokning\n 4. Avsluta");

            int val = t.nextInt();
            switch (val) {
                case 1:
                    totalPris += BokaPlats(platser);
                    break;
                case 2:
                    HittaBokning(platser);
                    break;
                case 3:
                    AvbokaBokning(platser);
                    break;
                case 4:
                    System.out.println("Det totala priset för bokningarna är: " + totalPris+"kr");
                    System.out.println("Tack för besöket!");
                    return;
                default:
                    System.out.println("Felaktigt val. Vänligen välj mellan 1-4.");
            }
        }
    }

    public static int BokaPlats(int[] platser) {
        Scanner t = new Scanner(System.in);
        System.out.print("Ange personnummer med ÅÅÅÅMMDD för att boka plats:");
        int personnummer = t.nextInt();

        // Printar ut alla säten där 0=ledig
        for (int index = 0; index < platser.length; index++) {
            System.out.print(platser[index] + " ");
        }

        int säte;
        while (true) {
            System.out.print(" Vilket säte vill du boka från 1-20?:");
            säte = t.nextInt();

            if (säte >= 1 && säte <= platser.length && platser[säte - 1] == 0) {
                platser[säte - 1] = personnummer; // Boka platsen med personnumret
                System.out.println("Plats " + säte + " har bokats för personnummer: " + personnummer);

                int pris = 0;
                System.out.print("Ange ålder i siffror: ");
                int ålder = t.nextInt();

                if (ålder < 18) {
                    pris = 150;
                } else if (ålder >= 18) {
                    pris = 300;
                } else {
                    System.out.println("Felaktig inmatning! Ange ålder i siffror.");
                }
                System.out.println("Pris: " + pris);

                return pris; // Returnera priset för den aktuella bokningen
            } else {
                System.out.println("Ogiltigt eller upptaget säte. Försök igen.");
            }
        }
    }

    public static void HittaBokning(int[] platser) {
        //logik för att hitta en bokning här
        Scanner t = new Scanner(System.in);
        System.out.print("Ange personnummer för att hitta bokning:");
        int personnummer = t.nextInt();
        boolean BokningHittad = false; //Bokningen är inte hittat föränns persnr finns i listan
    
        for (int i = 0; i < platser.length; i++) {
            if (platser[i] == personnummer) {
                System.out.println("Personen med personnummer " + personnummer + " är bokad på plats " + (i + 1));
                BokningHittad = true;
                break;
            }
        }
    
       
        
    }

    public static void AvbokaBokning(int[] platser) {
        //logik för att avboka en bokning här
        Scanner t = new Scanner(System.in);
        System.out.println("Bokning avbokad!");
    }
}
