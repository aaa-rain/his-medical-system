package org.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {

    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "护士列表查询成功");
        return result;
    }

    @GetMapping("/get/{id}")
    public Map<String, Object> get(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "护士信息查询成功");
        result.put("data", "护士ID：" + id);
        return result;
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "护士添加成功");
        result.put("data", params);
        return result;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Integer id, @RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "护士信息修改成功");
        result.put("data", "修改了ID为 " + id + " 的护士");
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "护士删除成功");
        result.put("data", "删除了ID为 " + id + " 的护士");
        return result;
    }
}