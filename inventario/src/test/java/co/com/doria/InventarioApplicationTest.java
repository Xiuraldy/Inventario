package co.com.doria;

        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InventarioApplicationTest {

    @Autowired
    private SpreadsheetClient spreadsheetClient;

    @Value("${google.spreadSheets.apiKey}")
    private String apiKey;

    @Test
    void readTest() {
        var products = spreadsheetClient.products(apiKey);

        System.out.println("-----------------");
        System.out.println("Range: " + products.getRange());

        products.getValues()
                .stream()
                .filter(product -> product.length == 1)
                .forEach(product -> {
                    System.out.println("Title: " + product[0]);
                });
        System.out.println("----------------");
    }
}
