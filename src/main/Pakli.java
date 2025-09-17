package main;

import main.Lap;

public class Pakli {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLACK = "\u001B[30m";
    
    private Lap[] lapok = new Lap[21];
    
    public Pakli(){
        feltolt();
    }
    
    private void feltolt(){
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        int k = 0;
        for (int i = 0; i < szinek.length; i++) {
            for (int j = 0; j < ertekek.length && k < this.lapok.length; j++) {
                if (szinek[i].equals("P")){
                    this.lapok[k++] = new Lap(RED + szinek[i] + "_" + ertekek[j] + RESET);  
                } else if(szinek[i].equals("Z")){
                    this.lapok[k++] = new Lap(GREEN + szinek[i] + "_" + ertekek[j] + RESET);
                } else if(szinek[i].equals("T")){
                    this.lapok[k++] = new Lap(YELLOW + szinek[i] + "_" + ertekek[j] + RESET);
                } else{
                    this.lapok[k++] = new Lap(BLACK + szinek[i] + "_" + ertekek[j] + RESET);    
                }
            }
        }        
    }
    
    public void kirak(){
        for (int i = 0; i < this.lapok.length; i++) {
            System.out.printf("%-17s".formatted(this.lapok[i].getLeiras()));
            if((i+1) % 3 == 0){
                System.out.println("");
            }
        }
    }
    
    public void kever(int oszlop){
        Lap[] temp_pakli = new Lap[21];
        
        switch(oszlop){
            case 1:
                for (int i = 1; i <= 7; i++) {
                    temp_pakli[i-1]  = this.lapok[(20-(i-1)*3)-1];
                    temp_pakli[i+6]  = this.lapok[(19-(i-1)*3)-1];
                    temp_pakli[i+13] = this.lapok[(21-(i-1)*3)-1];
                }
                break;
            case 2:
                for (int i = 1; i <= 7; i++) {
                    temp_pakli[i-1]  = this.lapok[(19-(i-1)*3)-1];
                    temp_pakli[i+6]  = this.lapok[(20-(i-1)*3)-1];
                    temp_pakli[i+13] = this.lapok[(21-(i-1)*3)-1];
                }
                break;
            case 3:
                for (int i = 1; i <= 7; i++) {
                    temp_pakli[i-1]  = this.lapok[(19-(i-1)*3)-1];
                    temp_pakli[i+6]  = this.lapok[(21-(i-1)*3)-1];
                    temp_pakli[i+13] = this.lapok[(20-(i-1)*3)-1];
                }
                break;
        }
        this.lapok = temp_pakli;      
    }
    
    private void ezVolt(){
        System.out.println("");
    }
}
