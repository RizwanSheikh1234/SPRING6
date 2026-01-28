import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.configs.RootConfig;
import com.model.Product;
import com.service.ProductService;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(RootConfig.class);

        Product product = (Product)ctx.getBean("product");
        product.setId(101);
        product.setTitle("ABCD");
        product.setCategory("Elec");
        product.setPdate(LocalDate.of(1999, 8, 22));

        ProductService service =
                ctx.getBean(ProductService.class);

        service.deleteProduct(product.getId());
//        service.getProducts().stream().forEach(p->{System.out.println(p);});
    }
}
