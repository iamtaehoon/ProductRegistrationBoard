package hello.itemservice.repository;

import hello.itemservice.domain.Product;
import hello.itemservice.domain.ProductRegistForm;
import hello.itemservice.domain.ProductUpdateForm;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryProductRepository implements ProductRepository{
    private static Map<Long, Product> store = new HashMap<>();
    private Long productId = 0L; //음...

    //이거 필요한가? 없을거같은데
    public Map<Long,Product> getStore() {
        return store;
    }

    @Override
    public Long save(ProductRegistForm productRegistForm) {
        //검증 따로 안하겠음.
        Product product = new Product(++productId,productRegistForm);

        store.put(product.getProductId(), product);

        return product.getProductId();
    }

    @Override
    public Product findProduct(Long productId) {
        return store.get(productId);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        for (Long productId : store.keySet()) {
            Product product = store.get(productId);
            products.add(product);
        }

        return products;
    }

    //Boolean타입? 혹은 id값?
    @Override
    public void delete(Long memberId) {
        store.remove(memberId);
    }

    @Override
    public Product updateProduct(Long productId, ProductUpdateForm productUpdateForm) {
        Product product = store.get(productId);
        Product updateProduct = product.updateProduct(productUpdateForm);

        return updateProduct;
    }
}
