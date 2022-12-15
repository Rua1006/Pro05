package com.shop.myapp.controller;

import com.shop.myapp.dto.ProductDTO;
import com.shop.myapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("detail")
    public String getProduct(@RequestParam("prono") int prono, Model model) throws Exception{
        ProductDTO dto = productService.getProduct(prono);
        model.addAttribute("dto", dto);
        return "/product/productDetail";
    }

    @GetMapping("category")
    public String productCateList(@RequestParam("cateno") int cateno, Model model) throws Exception{
        List<ProductDTO> productcateList = productService.productCateList(cateno);
        model.addAttribute("productcateList", productcateList );
        return "/product/productcateList";
    }

    @GetMapping("delete")
    public String productDelte(HttpServletRequest request, Model model) throws Exception{
        int prono = Integer.parseInt(request.getParameter("prono"));
        productService.productDelete(prono);
        return "redirect:list";
    }
}
