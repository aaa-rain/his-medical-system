package org.example.controller;

import org.example.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    @Autowired
    private AppConfig appConfig;

    @GetMapping("/show")
    public Map<String, Object> showConfig() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("configName", appConfig.getName());
        result.put("configVersion", appConfig.getVersion());
        result.put("showMessage", appConfig.isShowMessage());
        result.put("message", "当前配置来自 Nacos 配置中心");
        return result;
    }
}