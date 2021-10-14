package hello.itemservice.domain;

import lombok.Getter;

@Getter
public class ProductRegistForm {
    private String productName;
    private int productPrice;
    private int productCount;

    public ProductRegistForm(String productName, int productPrice, int productCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
    }

}
