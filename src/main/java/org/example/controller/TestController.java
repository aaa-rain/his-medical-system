package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 1. 原有的 hello 接口（带缓存）
    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> result = new HashMap<>();
        String cachedData = redisTemplate.opsForValue().get("test:hello");
        if (cachedData != null) {
            result.put("code", 200);
            result.put("message", "来自Redis缓存的数据");
            result.put("data", cachedData);
            result.put("fromCache", true);
            return result;
        }
        String dbData = "Hello，这是从数据库（模拟）获取的数据！";
        redisTemplate.opsForValue().set("test:hello", dbData, 60, TimeUnit.SECONDS);
        result.put("code", 200);
        result.put("message", "首次查询，数据已缓存到Redis");
        result.put("data", dbData);
        result.put("fromCache", false);
        return result;
    }

    // 2. 查询列表（带缓存）
    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        String cachedData = redisTemplate.opsForValue().get("test:list");
        if (cachedData != null) {
            result.put("code", 200);
            result.put("message", "来自Redis缓存的列表数据");
            result.put("data", cachedData);
            result.put("fromCache", true);
            return result;
        }
        String dbData = "测试列表：[数据A, 数据B, 数据C]";
        redisTemplate.opsForValue().set("test:list", dbData, 60, TimeUnit.SECONDS);
        result.put("code", 200);
        result.put("message", "首次查询，列表已缓存到Redis");
        result.put("data", dbData);
        result.put("fromCache", false);
        return result;
    }

    // 3. 查询单个（带缓存）
    @GetMapping("/get/{id}")
    public Map<String, Object> get(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        String cacheKey = "test:get:" + id;
        String cachedData = redisTemplate.opsForValue().get(cacheKey);
        if (cachedData != null) {
            result.put("code", 200);
            result.put("message", "来自Redis缓存的单条数据");
            result.put("data", cachedData);
            result.put("fromCache", true);
            return result;
        }
        String dbData = "测试数据：ID=" + id;
        redisTemplate.opsForValue().set(cacheKey, dbData, 60, TimeUnit.SECONDS);
        result.put("code", 200);
        result.put("message", "首次查询，单条数据已缓存到Redis");
        result.put("data", dbData);
        result.put("fromCache", false);
        return result;
    }

    // 4. 新增
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "测试数据新增成功！");
        result.put("data", params);
        return result;
    }

    // 5. 修改
    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Integer id, @RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "测试数据修改成功！");
        result.put("data", "修改了ID为 " + id + " 的数据，新数据为：" + params);
        return result;
    }

    // 6. 删除
    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "测试数据删除成功！");
        result.put("data", "删除了ID为 " + id + " 的数据");
        return result;
    }
}