package com.urlshortner.service;

import org.springframework.stereotype.Service;

import com.urlshortner.entity.UrlClass;

@Service
public interface UrlService {
	
	public String shortenUrl(UrlClass url);
	
	public String expandUrl(UrlClass longUrl);
	
	

}
