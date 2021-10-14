package hello.itemservice.repository;

import hello.itemservice.domain.Product;
import hello.itemservice.domain.ProductRegistForm;
import hello.itemservice.domain.ProductUpdateForm;

import java.util.List;

public interface ProductRepository {

    //상품 저장.
    public Long save(ProductRegistForm productRegistForm);

    //상품 조회
    public Product findProduct(Long productId);

    //상품 전체 조회
    public List<Product> findAll();

    //상품 삭제
    public void delete(Long memberId);

    //상품 수정
    public Product updateProduct(Long productId, ProductUpdateForm productUpdateForm);
}
