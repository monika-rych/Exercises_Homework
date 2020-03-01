package api;


import java.util.Scanner;

class CharToAsciiCodeExample {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
         String text2 = scanner.nextLine();
         scanner.close();*/
        String text = "aaa";
        int sum = 0;


        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int asciiValue = ch;
            sum = sum + asciiValue;
        }
        System.out.println("ASCII sum: " + sum);
    }
}

