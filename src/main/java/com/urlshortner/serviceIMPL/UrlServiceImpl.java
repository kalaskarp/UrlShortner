package com.urlshortner.serviceIMPL;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.urlshortner.entity.UrlClass;
import com.urlshortner.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {

	String baseUrl = "http://short.ly/";

	final Map<String, String> codeToUrl = new HashMap<>();
	Random random = new Random();

	@Override
	public String shortenUrl(UrlClass url) {

		String longUrl = url.getUrl();
		int counter = 125;

		String encoderString = encoder(random.nextLong(1000));

		// long url
		codeToUrl.put(encoderString, longUrl);

		System.out.println(codeToUrl);

		return baseUrl + encoderString;
	}

	private static String encoder(long num) {

		final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final int BASE = CHAR_SET.length();

		if (num == 0)
			return String.valueOf(CHAR_SET.charAt(0));

		StringBuilder sb = new StringBuilder();

		while (num > 0) {

			int index = (int) (num % BASE);

			sb.append(CHAR_SET.charAt(index));

			num = num / BASE;

		}
		return sb.reverse().toString();

	}

	@Override
	public String expandUrl(UrlClass longUrl) {
		String url = longUrl.getUrl();
		String regex = "(?<=http://short\\.ly/)[a-zA-Z0-9]+";
		String urlExpand = null;

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);

		if (matcher.find()) {

			urlExpand = codeToUrl.get(matcher.group());

		} else {
			System.out.println("No short code found.");
		}

		return urlExpand;
	}

}
