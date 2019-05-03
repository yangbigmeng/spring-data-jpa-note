package note.controller;

import note.Type;
import note.TypeService;
import note.exceptions.InvalidIdException;
import note.response.ResponseBuilder;
import note.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: 实体类型Controller
 * <p>
 * Create:      2019/5/3 13:30
 *
 * @author Marvin Yang
 */
@RestController
@RequestMapping("/note/kg/type")
public class TypeController {

    @RequestMapping("/saveOne")
    public String saveOne(Type type) {
        Type instance = typeService.saveOne(type);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instance));
    }

    /**
     * 更新实体类别
     *
     * @param type  待更新实体类别
     * @return a update Type
     */
    @RequestMapping("/updateOne")
    public String updateOne(Type type) {
        try {
            Type instance = typeService.updateOne(type);
            return JsonUtils.serialize(ResponseBuilder.buildSuccess(instance));
        } catch (InvalidIdException id) {
            return JsonUtils.serialize(ResponseBuilder.buildFailed(type, "Id无效"));
        }
    }

    /**
     * 查询多条记录
     *
     * @param type  查询条件
     * @return  list of type
     */
    @RequestMapping("/findAll")
    public String find(Type type) {
        List<Type> instances = typeService.find(type);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instances));
    }

    @Autowired
    private TypeService typeService;
}
