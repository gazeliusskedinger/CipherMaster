import java.util.Scanner;

public class ComandLineMenu {
    String[] args;
    public ComandLineMenu(String[] args){
        this.args = args;
    }

    private FileHandeler fh = new FileHandeler();
    //public static void main(String[] args) {
    //    menu();
    //}

    /**
     * Menu
     */

    public void menu(){
        String input;
        String menuGuide = fh.readFile("Menu_guide");
        Scanner sc = new Scanner(System.in);
        System.out.println(fh.readFile("intro_title.dat"));
        do {
            System.out.print(menuGuide);
            input = sc.nextLine();
            switch (input){
                case "0":
                    System.out.println("Exiting!");
                    break;
                case "1":
                    analysisMenu();
                    break;
                case "2":
                    DecryptMenu();
                    break;
                case "3":
                    System.out.println("Do A Third Thing.");
                    break;
                default:
                    System.out.println("Wrong Input\nTry Again!");
            }

        }while(!input.equals("0") );
        sc.close();
    }

    public void analysisMenu(){
        Tools to = new Tools("se");
        String input;
        String menuGuide = fh.readFile("Analysis_Menu");
        Scanner sc = new Scanner(System.in);
        String text = fh.readFile("Ciphertext.txt");
        //System.out.println(fh.readFile("intro_title.dat"));
        do {
            System.out.print(menuGuide);
            input = sc.nextLine();
            switch (input){
                case "0":
                    System.out.println("Going back!.\n\n\n");
                    break;
                case "1":
                    to.freqAnalysis(text);
                    break;
                case "2":
                    to.bigrams(text);
                    break;
                case "3":
                    to.trigrams(text);
                    break;
                case "4":
                    System.out.print("Annagramm : ");
                    String annagram = sc.nextLine();
                    to.annagrams(annagram);
                    break;
                default:
                    System.out.println("Wrong Input\nTry Again!");
            }

        }while(!input.equals("0") );
        //sc.close();
    }

    public void DecryptMenu(){
        Ciphers cp = new Ciphers("se");
        String input;
        String menuGuide = fh.readFile("Decrypt_menu");
        Scanner sc = new Scanner(System.in);
        String text = fh.readFile("Ciphertext.txt");
        //System.out.println(fh.readFile("intro_title.dat"));
        String keyt = "";
        do {
            System.out.print(menuGuide);
            input = sc.nextLine();
            switch (input){
                case "0":
                    System.out.println("Going back!.\n\n\n");
                    break;
                case "1":
                    System.out.print("Key : ");
                    int key = sc.nextInt();
                    cp.makeRot(text,key);
                    break;
                case "2":
                    System.out.print("Key : ");
                    keyt = sc.nextLine();
                    cp.substitutionDeCrypt(text, keyt);
                    break;
                case "3":
                    cp.transpCrypt(text);
                    break;
                case "4":
                    System.out.print("Key : ");
                    keyt = sc.nextLine();
                    cp.xorDecrypt(text, keyt);
                    break;
                default:
                    System.out.println("Wrong Input\nTry Again!");
            }
        }while(!input.equals("0") );
        //sc.close();
    }

    private boolean ArgValidatorChecker(String[] args){
        return true;
    }

    private String help(){
        return fh.readFile("help.txt");
    }



}