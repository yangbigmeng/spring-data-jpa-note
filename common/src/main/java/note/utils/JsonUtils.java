package note.utils;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: JSON对象序列化和反序列化
 *
 * Create:      2019/5/3 17:16
 *
 * @author Marvin Yang
 */
public class JsonUtils implements Serializable {

    /**
     * 序列化对象
     *
     * @param object    待序列化对象
     * @return  String
     */
    public static String serialize(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            return "";
        }
    }

    /**
     * 反序列化字符串
     *
     * @param jsonStr   字符串
     * @return  Map
     */
    public static Map deserialize(String jsonStr) {
        try {
            return deserialize(jsonStr, Map.class);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            return new HashMap();
        }
    }

    /**
     * 根据指定类型反序列化对象
     * <p>
     *     1. 对于缺失的属性值不处理
     * </p>
     *
     * @param jsonStr       字符串
     * @param classType     反序列化类型
     * @param <T>           类型
     * @return  T
     * @throws IOException  反序列化异常
     */
    public static <T> T deserialize(String jsonStr, Class<T> classType) throws IOException {
        return new ObjectMapper().
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).
                readValue(jsonStr, classType);
    }

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtils.class);
}
