package com.chris.onlineSchool.viewobject.vod;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chris
 * @date 2022/11/17
 */

@Data
public class CourseQueryVo {

    @ApiModelProperty(value = "课程讲师ID")
    private Long teacherId;

    @ApiModelProperty(value = "课程专业ID")
    private Long subjectId;

    @ApiModelProperty(value = "课程专业父级ID")
    private Long subjectParentId;

    @ApiModelProperty(value = "课程标题")
    private String title;

}
