package net.class101.classmate.util;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.util.HashMap;
import java.util.Map;

public class EscapedPatternLayout extends PatternLayout {
    private Map<String, String> defaultConverterMap = new HashMap<>();

    @Override
    public void start() {
        this.defaultConverterMap = new HashMap<>(super.getDefaultConverterMap());
        this.defaultConverterMap.put("m", JsonSafeMessageConverter.class.getName());
        this.defaultConverterMap.put("msg", JsonSafeMessageConverter.class.getName());
        this.defaultConverterMap.put("message", JsonSafeMessageConverter.class.getName());
        this.defaultConverterMap.put("metric", CustomJsonSafeMessageConverter.class.getName());

        this.defaultConverterMap.put("ex", JsonSafeThrowableProxyConverter.class.getName());
        this.defaultConverterMap.put("exception", JsonSafeThrowableProxyConverter.class.getName());
        this.defaultConverterMap.put("rEx", JsonSafeRootCauseFirstThrowableProxyConverter.class.getName());
        this.defaultConverterMap.put("rootException", JsonSafeRootCauseFirstThrowableProxyConverter.class.getName());

        super.start();
    }

    public Map<String, String> getDefaultConverterMap() {
        return defaultConverterMap;
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        return super.doLayout(event);
    }

    static String jsonSafeReplace(String origin) {
        return StringEscapeUtils.escapeJson(origin);
    }

    /**
     * sonSafeReplace 에서 "/" 문자를 치환하는 부분을 제거하기 위해서 정의함.
     */
    static String customJsonSafeReplace(String origin) {
        String message = StringUtils.replace(origin, "\t", "\\t");
        message = StringUtils.replace(message, "\n", "\\n");
        message = StringUtils.replace(message, "\r", "\\r");
        return StringUtils.replace(message, "\"", "\\\"");
    }

    public static class JsonSafeMessageConverter extends MessageConverter {
        @Override
        public String convert(ILoggingEvent event) {
            return jsonSafeReplace(super.convert(event));
        }
    }

    public static class CustomJsonSafeMessageConverter extends MessageConverter {
        @Override
        public String convert(ILoggingEvent event) {
            return customJsonSafeReplace(super.convert(event));
        }
    }

    public static class JsonSafeThrowableProxyConverter extends ThrowableProxyConverter {
        @Override
        public String convert(ILoggingEvent event) {
            return jsonSafeReplace(super.convert(event));
        }
    }

    public static class JsonSafeRootCauseFirstThrowableProxyConverter extends RootCauseFirstThrowableProxyConverter {
        @Override
        public String convert(ILoggingEvent event) {
            return jsonSafeReplace(super.convert(event));
        }
    }
}
