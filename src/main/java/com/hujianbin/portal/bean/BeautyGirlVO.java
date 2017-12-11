package com.hujianbin.portal.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.hujianbin.basis.bean.BeautyGirl;

public class BeautyGirlVO {

	@Getter
	@Setter
	private List<BeautyGirl> beautyGirlList;
	@Getter
	@Setter
	private long minTimestamp;

}
