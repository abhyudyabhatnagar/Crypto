import java.util.Scanner;
public class Crypto {

    public static String normalizeText(String nm){
        nm = nm.replaceAll(" ","");
        nm = nm.toUpperCase();
        nm = nm.replaceAll("[^a-zA-Z ]", "");
        return nm;
    }


    public static String obify(String obf) {
        String str2 = "";
        int l = obf.length();
        for (int i = 0; i < l; i++) {
            if(Character.toString(obf.charAt(i)).matches("[AEIOUY]")){
                str2 = str2 + obf.charAt(i) + "OB";
            }else{
                str2 = str2 + obf.charAt(i);
            }
        }
        return str2;
    }

    private static String Shiftalphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String ceasarify(String cc,String cc1){
        String result = "";
        int j = 0;

        for(int i =0; i<cc.length();i++){

            j = (int) cc.charAt(i) - (int) 'A';
            result = result + cc1.charAt(j);
        }
        return result;
    }

    public static String groupify(String gp,int n ){

        String result = "";
        int equi = gp.length()%n;
        if(equi != 0){
            while(equi != 0){
                gp = gp + "x";
                equi = gp.length()%n;
            }
        }
        int l = gp.length();

        for(int j =1; j<=l;j++){
            if(j%n == 0){
                result = result + gp.charAt(j-1) + " ";
            }else{
                result = result + gp.charAt(j-1);
            }
        }
        return result;
    }

    public static String encryptString(String str,int shift,int gpNo){

        String result = obify(normalizeText(str));
        result = ceasarify(result,Shiftalphabet(shift));
        result = groupify(result,gpNo);
        return result;
        }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter String to encrypt :- ");
        String str = input.nextLine();
        System.out.print("Enter shift value :- ");
        int shift = input.nextInt();
        System.out.println("Enter the number of groups :- ");
        int gpNo = input.nextInt();

        String encStr = encryptString(str,shift,gpNo);
        System.out.println(encStr);

    }

}
