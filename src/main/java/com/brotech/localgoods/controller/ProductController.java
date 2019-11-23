package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.enums.UnitType;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.form.CreateProductForm;
import com.brotech.localgoods.model.Picture;
import com.brotech.localgoods.model.PriceInterval;
import com.brotech.localgoods.model.Product;
import com.brotech.localgoods.repository.CategoryRepository;
import com.brotech.localgoods.repository.PictureRepository;
import com.brotech.localgoods.repository.PriceIntervalRepository;
import com.brotech.localgoods.repository.ProductRepository;
import com.brotech.localgoods.service.CategoryService;
import com.brotech.localgoods.service.impl.DefaultProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.brotech.localgoods.constants.Views.ERROR_PAGE;
import static com.brotech.localgoods.constants.Views.PRODUCT_DETAILS_PAGE;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final String UPLOADS_DIR = "/uploads/";
    private static final String CATEGORIES_GROUPED = "categories_grouped";
    private static final String PRODUCT_UNITS = "product_units";
    private static final String CREATE_PRODUCT_FORM = "CreateProductForm";
    private static final String PRODUCT_DETAILS = "productDetails";
    private static final String PRODUCTS = "productList";
    private static final String IS_LIST = "isList";
    private static final String ADD_TO_CART_FORM = "addToCartForm";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DefaultProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private PriceIntervalRepository priceIntervalRepository;

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute(CATEGORIES_GROUPED, categoryService.getAllCategoriesAndSubCategories());
        model.addAttribute(PRODUCT_UNITS, UnitType.values());
        model.addAttribute(CREATE_PRODUCT_FORM, new CreateProductForm());
        return Views.ADD_PRODUCT_PAGE;
    }

    @PostMapping("/add")
    public String createProduct(@ModelAttribute(CREATE_PRODUCT_FORM) CreateProductForm form, @RequestParam("files") MultipartFile[] files) {
        List<String> productImagesPath = new ArrayList<>(files.length);

        final String pathToUploadsDir = request.getServletContext().getRealPath(UPLOADS_DIR);
        if (!new File(pathToUploadsDir).exists()) {
            new File(pathToUploadsDir).mkdir();
        }

        try {
            for (MultipartFile file : files) {
                String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                final String filePath = pathToUploadsDir + UUID.randomUUID() + fileExtension;
                productImagesPath.add(filePath);
                file.transferTo(new File(filePath));
            }
        } catch (Exception e) {
            return ERROR_PAGE;
        }

        Product product = new Product();
        product.setName(form.getTitle());
        product.setDescription(form.getDescription());
        product.setUnitType(form.getUnitType());
        for (PriceInterval priceInterval : form.getPriceIntervals()) {
            priceInterval.setProduct(product);
        }
        product.setPriceIntervals(form.getPriceIntervals());
        product.setCategory(categoryRepository.findById(form.getCategoryId()).orElse(null));
        product.setStock(form.getStock());
        productRepository.save(product);

        if (!CollectionUtils.isEmpty(form.getPriceIntervals())) {
            for (PriceInterval priceInterval :
                    form.getPriceIntervals()) {
                priceInterval.setProduct(product);
                priceIntervalRepository.save(priceInterval);
            }
        }

        if (!CollectionUtils.isEmpty(productImagesPath)) {
            for (String imagePath : productImagesPath) {
                Picture productPicture = new Picture();
                productPicture.setPath(imagePath);
                productPicture.setProduct(product);
                pictureRepository.save(productPicture);
            }
        }
        return "/" + Views.PRODUCTS_PAGE;
    }

    @GetMapping("/list")
    public String getProducts(Model model) {
        model.addAttribute(PRODUCTS, productService.getProducts());
        model.addAttribute(IS_LIST, Boolean.TRUE);
        return Views.PRODUCTS_PAGE;
    }

    @GetMapping("/grid")
    public String getProductsGrid(Model model) {
        model.addAttribute(PRODUCTS, productService.getProducts());
        model.addAttribute(IS_LIST, Boolean.FALSE);
        return Views.PRODUCTS_PAGE;
    }

    @GetMapping("/details/{productId}")
    public String getProdut(@PathVariable("productId") String productId, Model model) {
        try {
            model.addAttribute(PRODUCT_DETAILS, productService.getProductDetails(Long.parseLong(productId)));
            model.addAttribute(ADD_TO_CART_FORM, new AddToCartForm());
            return PRODUCT_DETAILS_PAGE;
        } catch (Exception e) {
            return ERROR_PAGE;
        }
    }
}
