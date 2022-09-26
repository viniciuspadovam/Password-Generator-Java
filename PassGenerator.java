import java.util.Scanner;

public class PassGenerator {
    public static void main(String[] args) {
        clearConsole();

        String password = "";

        Scanner keyboard = new Scanner(System.in);

        System.out.println("============== GERADOR DE SENHAS - JAVA ==============\n");

        // --- GET INPUT ---
        Integer num = 0;
        while (num == 0) {
            try {
                System.out.print("Digite a quantidade de caracteres da sua senha: ");
                num = keyboard.nextInt();
            } catch (Exception e) {
                System.out.print("Ops... Parece que foi inserido um caractere. Precisamos que digite apenas números.\n");
            }
            keyboard.nextLine();
        }
        
        // --- CREATE PASSWORD ---
        String charset = "abcdefghijklmopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#%!";
        for(int i = 0; i < num; i++) {
            password += charset.charAt((int)Math.floor(Math.random() * charset.length()));
        }
        
        setTimeOut(2000);
        System.out.println("\n======================================================\n");
        setTimeOut(1500);
        System.out.printf("Uma senha de %d caracteres está sendo preparada.\n", num);

        setTimeOut(2500);
        System.out.println("Sua senha está quase pronta...");
        setTimeOut(2000);
        System.out.print("\n");
        // --- SHOW PASSWORD ---
        System.out.print(password);
        System.out.println("\n");
        
        keyboard.close();
    }

    public static void setTimeOut(int millisecond) {
        try{
            Thread.sleep(millisecond);
        } catch(Exception e) {}
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
          } catch(Exception e) {
            e.printStackTrace();
        }
    }
}