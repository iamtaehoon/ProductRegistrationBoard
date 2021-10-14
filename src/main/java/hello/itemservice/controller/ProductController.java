package hello.itemservice.controller;

import hello.itemservice.domain.Product;
import hello.itemservice.domain.ProductRegistForm;
import hello.itemservice.domain.ProductUpdateForm;
import hello.itemservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired //오토와이어드 생략가능이지. 생성자 1개니까.
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

        productRepository.save(new ProductRegistForm("itemA",10000,10));
        productRepository.save(new ProductRegistForm("itemB",12000,30));
        productRepository.save(new ProductRegistForm("itemC",20000,12));
        productRepository.save(new ProductRegistForm("itemD",15000,21));
    }

    @GetMapping("/product")
    public String productListForm(Model model){

        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product";
    }

    @GetMapping("/product/register")
    public String productRegister(Model model) {
        //productRegistForm 생성자 저상태로는 여기서 못만듬. 아 이래서 생성메서드를 쓰는건가?
        return "product/registerForm";
    }

    @GetMapping("/product/info")
    public String productInfo(@RequestParam Long id, Model model) {
        Product product = productRepository.findProduct(id);
        model.addAttribute("product", product);
        System.out.println("product.getProductId() = " + product.getProductId());
        System.out.println("product.getProductName() = " + product.getProductName());
        return "product/infoForm";
    }

    @GetMapping("/product/modify")
    public String productModify(@RequestParam Long id, Model model) {
        Product product = productRepository.findProduct(id);
        model.addAttribute("product", product);
        System.out.println("modify: product.getProductId() = " + product.getProductId());
        System.out.println("modify: product.getProductName() = " + product.getProductName());
        return "product/modifyForm";
    }

    @PostMapping("/product/modify")
    public String postProductModify(@RequestParam Long id, @ModelAttribute ProductUpdateForm productUpdateForm) {
        Product product = productRepository.findProduct(id);
//        System.out.println("product.getProductName() = " + product.getProductName());
        product.updateProduct(productUpdateForm);
        return "redirect:/product/info?id="+id;
    }

    @PostMapping("/product/save")
    public String postProductSave(@ModelAttribute ProductRegistForm productRegistForm) {
        productRepository.save(productRegistForm);

        return "redirect:/product";
    }


}
