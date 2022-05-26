import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Allignment allignment = new Allignment("acactgtgaaaaa", "atgtgaa");
        allignment.semiGlobal(-2);
        allignment.global(-2);
        allignment.local(-2);
        allignment.semiGlobal(-2, -4);
        allignment.global(-2,-4);
        allignment.local(-2, -4);
    }
}
