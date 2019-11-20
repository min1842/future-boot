package com.future.boot.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PeakCommonModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String createBy;

	private String createTm;
}
