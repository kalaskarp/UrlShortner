package com.urlshortner.serviceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.urlshortner.entity.UrlClass;
import com.urlshortner.service.UrlService;

@ExtendWith(MockitoExtension.class)
public class MethodTest {
	
	@InjectMocks
	UrlService service;
	
	
	@Test
	void shortenUrlTest() {
		System.out.println("Test run");
		UrlClass url = new UrlClass();
		service.shortenUrl(url);
		
	}
}
