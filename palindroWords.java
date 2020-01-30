public class palindroWords {

    public static void main(String[] args) {
        Reverse("GeeksForGeeks");
        System.out.print("\n");
        System.out.print("Phase is a: "+ CheckPalindro("never odd or even")+ " Palindro");
    }

    //Reverse any word provide
    public static void Reverse(String word){
        int len = word.length();
        for (int i = len - 1; i >= 0; i--) {
            System.out.print(word.charAt(i));
        }
    }
    //compare is the phase is Palindro
    static boolean CheckPalindro(String input){
        input = input.toLowerCase().replaceAll("\\s","");
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - 1 - i)) return false;
        }
        return true;
    }

}