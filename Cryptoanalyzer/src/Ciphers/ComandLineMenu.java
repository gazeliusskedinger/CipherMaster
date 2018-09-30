package Ciphers;

import java.util.Scanner;

public class ComandLineMenu {

    private FileHandeler fh = new FileHandeler();
    private char[] Alph;

    public ComandLineMenu(String[] args){
        Charset cs = new Charset(args[0]);
        this.Alph = cs.getSet();
    }


    public void menu(){
        boolean scClose = false;
        String input;
        Cipher cip;
        Scanner sc = new Scanner(System.in);
        String menuGuide = fh.readFile("Menu_guide");
        System.out.println(fh.readFile("intro_title.dat"));
        do {

            System.out.print(menuGuide);
            input = sc.nextLine();

            switch (input){
                case "0":
                    System.out.println("Exiting!");
                    break;
                case "1":
                    cip = new Rot(Alph);
                    System.out.println(cip.encrypt(fh.readFile("Plaintext.txt"),"4"));
                    break;
                case "2":
                    cip = new Rot(Alph);
                    System.out.println(cip.encrypt(fh.readFile("Plaintext.txt"),"4"));
                    break;
                case "4":
                    System.out.println("Do A Third Thing.");
                    break;
                case "5":
                    System.out.println("Do A Third Thing.");
                    break;
                case "6":
                    System.out.println("Do A Third Thing.");
                    break;
                case "7":
                    System.out.println("Do A Third Thing.");
                    break;
                case "8":
                    System.out.println("Do A Third Thing.");
                    break;
                default:
                    System.out.println("Wrong Input\nTry Again!");
            }

        }while(!input.equals("0") );
        sc.close();
    }


    private boolean ArgValidatorChecker(String[] args){
        return true;
    }

    private String help(){
        return fh.readFile("help.txt");
    }



}