import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BOI boi = new BOI("12345","Raj",AccountType.SAVINGS);
        boi.deposit(2000);
        System.out.println(boi.getDetails());

    }
}