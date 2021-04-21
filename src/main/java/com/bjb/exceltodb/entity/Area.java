package com.bjb.exceltodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {

	private Integer areaId;
	private Integer areaCode;
	private Integer superiorCode;
	private String areaName;
}
