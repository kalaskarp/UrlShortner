package com.urlshortner.entity;

public class UrlClass {
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UrlClass(String url) {
		super();
		this.url = url;
	}
	public UrlClass() {
		
	}

	@Override
	public String toString() {
		return "UrlClass [url=" + url + "]";
	}
	
	

}
