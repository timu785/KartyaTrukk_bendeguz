package main;

import java.util.Scanner;

public class main {
    static String[] pakli = new String[21];
    static Scanner sc =new Scanner(System.in);
    
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String BLACK = "\u001B[30m";
    
    public static void main(String[] args) {
        osszeallit();
        kirak();
        kever();
        kirak();
        kever();
        kirak();
        kever();
        kirak();
        
    }

    private static void osszeallit() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        
        int k = 0;
        for (int i = 0; i < szinek.length; i++) {
            for (int j = 0; j < ertekek.length; j++) {
                if(k < pakli.length){
                    if(szinek[i].equals("P")){
                        pakli[k++] = RED + szinek[i] + "_" + ertekek[j] + RESET;  
                    } else if(szinek[i].equals("Z")){
                        pakli[k++] = GREEN + szinek[i] + "_" + ertekek[j] + RESET;
                    } else{
                        pakli[k++] = BLACK + szinek[i] + "_" + ertekek[j] + RESET;    
                    }
                }
            }
        }
    }
    
    private static void kirak(){
        for (int i = 0; i < pakli.length; i++) {
            System.out.printf("%-17s".formatted(pakli[i]));
            if((i+1) % 3 == 0){
                System.out.println("");
            }
        }
    }
    
    private static int beker(){
        boolean jo;
        int oszlop;
        do {
            System.out.println("\nMelyik oszlop? (1-3)\n");
            oszlop = sc.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);
        return oszlop;
    }
    
    private static void kever() {
        String[] temp_pakli = new String[21];
        
        switch(beker()){
            case 1:
                for (int i = 1; i <= 7; i++) {
                    temp_pakli[i-1]    = pakli[(20-(i-1)*3)-1];
                    temp_pakli[i+6]  = pakli[(19-(i-1)*3)-1];
                    temp_pakli[i+13] = pakli[(21-(i-1)*3)-1];
                }
                break;
            case 2:
                for (int i = 1; i <= 7; i++) {
                    temp_pakli[i-1]    = pakli[(19-(i-1)*3)-1];
                    temp_pakli[i+6]  = pakli[(20-(i-1)*3)-1];
                    temp_pakli[i+13] = pakli[(21-(i-1)*3)-1];
                }
                break;
            case 3:
                for (int i = 1; i <= 7; i++) {
                    temp_pakli[i-1]    = pakli[(19-(i-1)*3)-1];
                    temp_pakli[i+6]  = pakli[(21-(i-1)*3)-1];
                    temp_pakli[i+13] = pakli[(20-(i-1)*3)-1];
                }
                break;
        }
        pakli = temp_pakli;
    }
}
