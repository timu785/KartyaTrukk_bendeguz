package nezet;

import java.util.Scanner;
import modell.Pakli;

public class KartyaTrukk {
    static Scanner sc = new Scanner(System.in);
    private Pakli egyPakli;
    
    public KartyaTrukk(){
        this.egyPakli = new Pakli();
        egyPakli.kirak();
        egyPakli.kever(beker());
        egyPakli.kirak();
        egyPakli.kever(beker());
        egyPakli.kirak();
        egyPakli.kever(beker());
        egyPakli.kirak();
    }
    
    public int beker(){
        boolean jo;
        int oszlop;
        do {
            System.out.println("\nMelyik oszlop? (1-3)\n");
            oszlop = sc.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);
        return oszlop;   
    }
    
}
