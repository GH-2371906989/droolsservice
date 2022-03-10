package com.gu.drools.Vo.base;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity<T extends Model> extends Model {

	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	@NotNull(message = "用户id不能为空", groups = {Update.class})
	private Long id;

	/**
	 * 创建日期 - 现在时表示主动创建
	 */
	@ApiModelProperty(value = "创建日期")
	@TableField(value = "create_time", updateStrategy = FieldStrategy.NEVER, fill = FieldFill.INSERT)
	@Past(message = "创建时间必须是过去时间")
	private Date createTime;

	/**
	 * 修改时间 - 过去分词表示被动更新
	 */
	@ApiModelProperty(value = "修改时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
