package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class JsonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T getTestData(String path, Class<T> type) {
        try (InputStream stream = ResourceLoader.getResources(path)) {
            return MAPPER.readValue(stream, type);
        }catch (Exception e) {
            LOG.error("unable to read test data {}", path, e);
        }
        return null;
    }
}
