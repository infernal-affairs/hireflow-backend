package com.hireflow.health;

import com.hireflow.common.exception.BusinessException;
import com.hireflow.common.exception.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController//这个类负责接收HTTP请求，返回值自动转JSON
@RequestMapping("/api/v1/exception-demo")//这个类里的接口都有 /api/v1/exception-demo 前缀
public class ExceptionVerificationController {
    @GetMapping("/business-default")
    public void businessDefault(){
        //不指定自定义消息，使用ErrorCode中的默认消息
        throw new BusinessException(ErrorCode.NOT_FOUND);

    }
    //处理GET /api/v1/exception-demo/business-custom
    @GetMapping("/business-custom")
    public void businessCustom(){
        throw new BusinessException(ErrorCode.NOT_FOUND,"职位不存在");
    }
    @PostMapping("/validation")
    public void validation(@Valid @RequestBody ValidationDemoRequest request){
        //当前只验证参数校验异常，进入方法体后不执行其他业务
    }
    @GetMapping("/unknown")
    public void unknown(){
        throw new IllegalStateException("模拟数据库连接失败：敏感内部信息");
    }
}
