package com.smileispoem.mcpserverdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smileispoem.mcpserverdemo.entiy.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);


    @Tool(description = "根据MSC商品名称返回商品信息")
    public String queryProductInfo(String productName) {

        logger.info("商品信息工具被调用了... 产品名 : {}", productName);
        Product productInfo;
        String jsonResult = "";
        switch (productName) {
            case "product1":
                productInfo = new Product("product1", "红");
                break;
            case "product2":
                productInfo = new Product("product2", "黄");
                break;
            case "product3":
                productInfo = new Product("product3", "蓝");
                break;
            default:
                productInfo = new Product("默认商品", "七彩色");
                break;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonResult = objectMapper.writeValueAsString(productInfo);
        } catch (Exception e) {
            jsonResult = "{\"name\":\"未查询到\",\"color\":\"五彩斑斓的黑\"}";
        }
        logger.info("商品信息工具被调用了... 产品名 : {}， 产品信息：{}", productName, jsonResult);

        return jsonResult;
    }
}
