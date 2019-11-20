package com.future.boot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeakProjectModel extends PeakCommonModel {

	private static final long serialVersionUID = 1L;

	private int id;

	private String projectTitle;

	private String projectArea;

	private String projectType;

	private String projectStart;

	private String projectEnd;

	private String projectDescription;
}
