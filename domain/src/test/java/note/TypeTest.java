package note;

import note.utils.JsonUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description: 序列化单测
 *
 * Create:      2019/5/4 15:26
 *
 * @author Marvin Yang
 */
public class TypeTest {

    @Test
    public void serialize() throws Exception {
        Type type = new Type();
        type.setName("thing");
        type.setId(1);
        type.setParent(-1);

        String typeStr = JsonUtils.serialize(type);
        System.out.println(typeStr);
    }

    @Test
    public void deserialize() throws Exception {
        String typeStr = "{\"id\":1,\"name\":\"thing\",\"key\":\"thing\"}";
        Type type = JsonUtils.deserialize(typeStr, Type.class);
        System.out.println(type.getId());
    }
}