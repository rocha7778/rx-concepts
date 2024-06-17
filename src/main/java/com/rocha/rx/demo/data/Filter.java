package com.rocha.rx.demo.data;

import java.util.List;

public class Filter {
	
	private List<Data> filters;

	public Filter(List<Data> filters) {
		super();
		this.filters = filters;
	}

	public List<Data> getFilters() {
		return filters;
	}

	public void setFilters(List<Data> filters) {
		this.filters = filters;
	}

	public Filter() {
		super();
	}

}
