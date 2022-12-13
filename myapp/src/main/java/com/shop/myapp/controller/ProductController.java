package com.shop.myapp.controller;

import com.shop.myapp.dto.ProductDTO;
import com.shop.myapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public String getProductList(Model model) throws Exception{
        List<ProductDTO> productList = productService.productList();
        model.addAttribute("productList", productList);
        return "/product/productList";
    }

}
