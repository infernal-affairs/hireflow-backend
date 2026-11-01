package com.hireflow.health;

import jakarta.validation.constraints.NotBlank;

//DTO:只负责承载并校验这个验证接口的请求数据
public class ValidationDemoRequest {
    //字符串不能为null、空串或只包含空白字符
    @NotBlank(message = "名称不能为空" )
    private String name;
    //Jackson 反序列化请求体时需要无参构造方法
    public ValidationDemoRequest(){
    }
    //便于读取字段，当前验证接口暂时用不到
    public String getName() {
        return name;
    }
    //Jackson 需要通过setter把json的name写入对象
    public void setName(String name) {
        this.name = name;
    }



}
