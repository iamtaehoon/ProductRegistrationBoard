package hello.itemservice.domain;

import lombok.Getter;

@Getter
public class Product {
    private Long productId;
    private String productName;
    private int productPrice;
    private int productCount;

    public Product(Long productId, ProductRegistForm productRegistForm) {
        this.productId = productId;
        this.productName = productRegistForm.getProductName();
        this.productPrice = productRegistForm.getProductPrice();
        this.productCount = productRegistForm.getProductCount();
    }

    public Product updateProduct(ProductUpdateForm productUpdateForm) {
        this.productName = productUpdateForm.getProductName();
        this.productPrice = productUpdateForm.getProductPrice();
        this.productCount = productUpdateForm.getProductCount();

        return this;
    }
}
