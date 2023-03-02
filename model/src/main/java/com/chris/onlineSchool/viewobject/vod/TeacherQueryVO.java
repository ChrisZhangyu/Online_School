package com.chris.onlineSchool.viewobject.vod;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chris
 * @date 2022/11/11
 * 分层领域模型规约
 * DO（ Data Object）：与数据库表结构一一对应，通过DAO层向上传输数据源对象。
 * DTO（ Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象。
 * BO（ Business Object）：业务对象。 由Service层输出的封装业务逻辑的对象。
 * AO（ Application Object）：应用对象。 在Web层与Service层之间抽象的复用对象模型，极为贴近展示层，复用度不高。
 * VO（ View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。
 * POJO（ Plain Ordinary Java Object）：在本手册中， POJO专指只有setter/getter/toString的简单类，包括DO/DTO/BO/VO等。
 * Query：数据查询对象，各层接收上层的查询请求。 注意超过2个参数的查询封装，禁止使用Map类来传输。
 */

@Data
public class TeacherQueryVO {
    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "入驻时间")
    private String joinDateBegin;

    @ApiModelProperty(value = "入驻时间")
    private String joinDateEnd;
}
