package com.smileispoem.mcpserverdemo.service;

import com.alibaba.fastjson2.JSONObject;
import com.smileispoem.mcpserverdemo.entiy.Product;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class ProductService {



    @Tool(description = "根据MSC商品名称返回商品信息")
    public String queryProductInfo(String productName) {

        Product productInfo;
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
        return JSONObject.toJSONString(productInfo);
    }
}
