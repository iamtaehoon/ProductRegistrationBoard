package hello.itemservice.domain;

import lombok.Getter;

@Getter
public class ProductUpdateForm {
    private String productName;
    private int productPrice;
    private int productCount;

    //생성자 방식임. 근데 생성 메서드랑 머가 다른거임?
    public ProductUpdateForm(String productName, int productPrice, int productCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
    }
}
