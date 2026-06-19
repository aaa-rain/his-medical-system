package org.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "预约列表查询成功");
        return result;
    }

    @GetMapping("/get/{id}")
    public Map<String, Object> get(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "预约信息查询成功");
        result.put("data", "预约ID：" + id);
        return result;
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "预约创建成功");
        result.put("data", params);
        return result;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Integer id, @RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "预约信息修改成功");
        result.put("data", "修改了ID为 " + id + " 的预约");
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "预约取消成功");
        result.put("data", "取消了ID为 " + id + " 的预约");
        return result;
    }
}