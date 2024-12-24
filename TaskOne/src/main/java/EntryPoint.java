import java.util.List;

public class EntryPoint {
    public static void main(String[] args) {
        BracketsGenerator generator = new BracketsGenerator();
        int num = generator.getPair();

        List<String> result = generator.generateBracketsList();

        System.out.println("Number of brackets: " + result.size());
        System.out.println("Generated bracket expressions: ");
        result.forEach(System.out::println);
    }
}
