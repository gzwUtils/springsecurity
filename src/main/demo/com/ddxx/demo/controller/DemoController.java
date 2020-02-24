package com.ddxx.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangYiZhen
 * @version V1.0
 * @date 2018-09-13 14-16
 */
@RequestMapping("demo/demo")
@RestController
@Api(tags = { "demo"})
public class DemoController {
    @GetMapping(value = "demo")
    @ApiOperation("demo")
    public String demo() {
        return "success hot test";
    }
}
