package api;

class CharToAsciiCodeExample {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
         String text2 = scanner.nextLine();
         scanner.close();*/
        String text = "aaa";
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            sum += text.charAt(i);
        }
        System.out.println("ASCII sum: " + sum);
    }
}

