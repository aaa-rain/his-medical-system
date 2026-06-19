package org.example;

import org.example.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestControllerTest {

    @Autowired
    private TestController testController;

    @Test
    public void testHello() {
        Map<String, Object> result = testController.hello();
        assertEquals(200, result.get("code"));
        System.out.println("✅ 单元测试通过！返回结果：" + result);
    }

    @Test
    public void testList() {
        Map<String, Object> result = testController.list();
        assertEquals(200, result.get("code"));
        System.out.println("✅ 列表测试通过！返回结果：" + result);
    }

    @Test
    public void testGet() {
        Map<String, Object> result = testController.get(1);
        assertEquals(200, result.get("code"));
        System.out.println("✅ 查询单个测试通过！返回结果：" + result);
    }
}