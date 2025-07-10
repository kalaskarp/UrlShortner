package com.urlshortner.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortner.entity.UrlClass;
import com.urlshortner.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/url")
public class UrlController {

	@Autowired
	UrlService service;

	@PostMapping("/GenerateUrl")
	ResponseEntity<?> shortUrl(@RequestBody UrlClass url) {

		String shortenUrl = service.shortenUrl(url);

		return new ResponseEntity<String>(shortenUrl, HttpStatus.OK);

	}

	@GetMapping("/ExpandUrl")
	ResponseEntity<?> LongUrl(@RequestBody UrlClass url) {

		String expandUrl = service.expandUrl(url);

		return ResponseEntity.status(HttpStatus.FOUND)
				.location(URI.create(expandUrl))
				.build();

	}
}
