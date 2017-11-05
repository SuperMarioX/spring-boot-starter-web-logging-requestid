package com.iyher.spring.logging.requestid;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.MDC.MDCCloseable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class LoggingFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	private final String key;

	private static final String DEFAULT_KEY = "X-Request-Id";

	public static final String MDC_KEY = "reuqestId";

	public LoggingFilter(@Value("${logging.request-id:" + DEFAULT_KEY + "}") final String key) {
		this.key = key;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String value = Optional.ofNullable(request.getHeader(key))
			.orElseGet(()->UUID.randomUUID().toString());

		if(logger.isDebugEnabled()) {
			logger.debug("requestId:"+ value);
		}

		try(MDCCloseable reqId = MDC.putCloseable(MDC_KEY, value)) {
			filterChain.doFilter(request, response);
		}

	}
}
