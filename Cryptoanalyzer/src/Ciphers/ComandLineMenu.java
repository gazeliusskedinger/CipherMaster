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
        String key = "";
        String input;
        Cipher cip;
        Tools to;
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
                    key = sc.nextLine();
                    System.out.println(cip.encrypt(fh.readFile("Plaintext.txt"),key));
                    break;
                case "2":
                    cip = new Rot(Alph);
                    key = sc.nextLine();
                    System.out.println(cip.encrypt(fh.readFile("Ciphertext.txt"),key));
                    break;
                case "3":
                    cip = new Rot(Alph);
                    System.out.println(cip.brute(fh.readFile("Ciphertext.txt")));
                    break;
                case "4":
                    cip = new Rot(Alph);
                    System.out.println(((Rot) cip).reverseEncrypt(fh.readFile("Plaintext.txt"),key));
                    break;
                case "5":
                    cip = new Rot(Alph);
                    System.out.println(((Rot) cip).reverseDecrypt(fh.readFile("Plaintext.txt"),key));
                    break;
                case "6":
                    cip = new Rot(Alph);
                    System.out.println(((Rot) cip).reverseBrute(fh.readFile("Ciphertext.txt")));
                    break;
                case "7":
                    to = new Tools(Alph);
                    to.freqAnalysis("Ciphertext.txt");
                    break;
                case "8":
                    to = new Tools(Alph);
                    to.bigrams("Ciphertext.txt");
                    break;
                case "9":
                    to = new Tools(Alph);
                    to.trigrams("Ciphertext.txt");
                    break;
                case "10":
                    to = new Tools(Alph);
                    to.annagrams("Ciphertext.txt");
                    break;
                case "11":
                    to = new Tools(Alph);
                    to.calcKeyLength("Ciphertext.txt");
                    break;
                case "12":

                    break;
                case "13":

                    break;
                case "14":
                    cip = new PigLatin(Alph);
                    System.out.println(cip.encrypt(fh.readFile("Plaintext.txt"),"b"));
                    break;
                case "15":
                    cip = new PigLatin(Alph);
                    System.out.println(cip.decrypt(fh.readFile("Ciphertext.txt"),"b"));
                    break;
                case "16":
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