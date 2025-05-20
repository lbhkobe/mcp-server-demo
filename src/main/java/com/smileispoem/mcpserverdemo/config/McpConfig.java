package com.smileispoem.mcpserverdemo.config;


import com.smileispoem.mcpserverdemo.service.ProductService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider weatherTools(ProductService productService) {
        return MethodToolCallbackProvider.builder().toolObjects(productService).build();
    }

}
