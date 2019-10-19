//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.blake.health.julio.model.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JsonUtils
{

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils()
    {
    }

    public static <T> String serialise(final ObjectMapper objectMapper, final T objectToMap) throws JsonProcessingException
    {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectToMap);
    }

    public static <T> String serialise(final T objectToMap)
    {
        String result = "";

        try
        {
            result = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(objectToMap);
        }
        catch (JsonProcessingException var3)
        {
            log.error("Unable to write value", var3);
        }

        return result;
    }

    public static <T> String serialiseQuietly(final ObjectMapper objectMapper, final T objectToMap)
    {
        try
        {
            return serialise(objectMapper, objectToMap);
        }
        catch (JsonProcessingException var3)
        {
            return "{}";
        }
    }

    public static <T> T deserialise(final ObjectMapper objectMapper, final Class<T> clazz, final String serialised) throws IOException
    {
        return objectMapper.readValue(serialised, clazz);
    }

    public static <T> T deserialise(final Class<T> clazz, final String serialised)
    {
        T derserialised = null;
        try
        {
            derserialised = OBJECT_MAPPER.readValue(serialised, clazz);
        }
        catch (IOException e)
        {
            log.error("Unable to deserialise", e);
        }
        return derserialised;
    }

    public static <T> T deserialise(final TypeReference<T> typeReference, final String serialised) throws IOException
    {
        return OBJECT_MAPPER.readValue(serialised, typeReference);
    }

    public static <T> T deserialise(final Class<T> clazz, final File file)
    {
        Object result = null;

        try
        {
            result = OBJECT_MAPPER.readValue(file, clazz);
        }
        catch (IOException var4)
        {
            log.error("Unable to read value", var4);
        }

        return (T) result;
    }

    public static ObjectMapper getObjectMapper()
    {
        return OBJECT_MAPPER;
    }

    static
    {
        OBJECT_MAPPER.findAndRegisterModules();
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
}
