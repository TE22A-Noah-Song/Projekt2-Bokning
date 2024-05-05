import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] platser = new int[20];
        int totalPris = 0; // Variabel för att hålla reda på det totala priset
        visaMeny(platser, totalPris);
    }

    public static void visaMeny(int[] platser, int totalPris) {
        Scanner t = new Scanner(System.in);

        while (true) {
            System.out.println("Välkommen till Noahs bussresa! Välj mellan 1-5:\n 1. Boka plats\n 2. Hitta bokning\n 3. Avboka bokning\n 4. Visa vinst \n 5. Avsluta");

            int val = t.nextInt();
            switch (val) {
                case 1:
                    bokaPlats(platser);
                    break;
                case 2:
                    hittaBokning(platser);
                    break;
                case 3:
                    totalPris -= avbokaBokning(platser);
                    System.out.println("Platsen har avbokats. Det totala priset har justerats till: " + totalPris + "kr");
                    break;
                case 4:
                    totalPris = visa_vinst(platser); // Beräkna vinsten baserat på bokade platser
                    System.out.println("Det totala priset för bokningarna är: " + totalPris + "kr");
                    break;
                case 5:
                    System.out.println("Tack för besöket!");
                    return;

                default:
                    System.out.println("Felaktigt val. Vänligen välj mellan 1-5.");
            }
        }
    }

    public static void bokaPlats(int[] platser) {
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
                return;
            } 
            else {
                System.out.println("Ogiltigt eller upptaget säte. Försök igen.");
            }
        }
    }

    public static void hittaBokning(int[] platser) {
        //logik för att hitta en bokning här
        Scanner t = new Scanner(System.in);
        System.out.print("Ange personnummer för att hitta bokning:");
        int personnummer = t.nextInt();
        boolean bokningHittad = false; //Bokningen är inte hittad föränns persnr finns i listan

        for (int i = 0; i < platser.length; i++) {
            if (platser[i] == personnummer) {
                System.out.println("Personen med personnummer " + personnummer + " är bokad på plats " + (i + 1));
                bokningHittad = true;
                break;
            }
        }

        //Om bokningen är falskt (inte hittad)
        if (!bokningHittad) {
            System.out.println("Ingen bokning hittades för personnummer " + personnummer);
        }
    }

    public static int avbokaBokning(int[] platser) {
        //logik för att avboka en bokning här
        Scanner t = new Scanner(System.in);
        System.out.print("Ange personnummer för att avboka bokning:");
        int personnummer = t.nextInt();
        boolean bokningHittad = false; // Variabel för att hålla reda på om bokningen hittades
        int vinst = 0;

        for (int i = 0; i < platser.length; i++) {
            if (platser[i] == personnummer) { // Om personnumret matchar en bokning
                int ålder = 2024 - (personnummer / 10000); // Beräkna ålder baserat på personnumret
                if (ålder > 17) {
                    vinst = 300; 
                } else {
                    vinst = 150;
                }
                platser[i] = 0; // Markera platsen som ledig genom att tilldela 0
                System.out.println("Bokningen för personnummer " + personnummer + " har avbokats från plats " + (i + 1));
                bokningHittad = true;
                break; // Avsluta sökningen när bokningen har avbokats
            }
        }

        if (!bokningHittad) { // Om ingen bokning hittades för det angivna personnumret
            System.out.println("Ingen bokning hittades för personnummer " + personnummer);
        }
        return vinst;
    }
    
    
    public static int visa_vinst(int[] platser) {
        int totalVinst = 0;
        for (int i = 0; i < platser.length; i++) {
            if (platser[i] != 0) {
                int personnummer = platser[i];
                int ålder = 2024 - (personnummer / 10000); // Beräkna ålder baserat på personnumret
                if (ålder > 17) {
                    totalVinst += 300; 
                } else {
                    totalVinst += 150;
                }
            }    
        }
        return totalVinst;
    }  
}
