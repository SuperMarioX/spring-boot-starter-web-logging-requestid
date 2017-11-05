package com.iyher.spring.logging.requestid;

import static com.iyher.spring.logging.requestid.LoggingFilter.*;

import java.util.Optional;

import ch.qos.logback.classic.pattern.MDCConverter;
import ch.qos.logback.core.util.OptionHelper;

public class RequestIdConverter extends MDCConverter {

	/** @see  OptionHelper#DELIM_DEFAULT */
    final static String DELIM_DEFAULT = ":-";

    @Override
	public String getFirstOption() {
		return MDC_KEY + DELIM_DEFAULT + Optional.ofNullable(super.getFirstOption()).orElse("");
	}
}
