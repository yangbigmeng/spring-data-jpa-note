package note.controller;

import note.Entity;
import note.EntityService;
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
 * Description: 实体控制层
 *
 * Create:      2019/5/3 20:23
 *
 * @author Marvin Yang
 */
@RestController
@RequestMapping("/note/kg/entity")
public class EntityController {

    @RequestMapping("/saveOne")
    public String saveOne(Entity type) {
        Entity instance = entityService.saveOne(type);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instance));
    }

    /**
     * 更新实体类别
     *
     * @param type  待更新实体类别
     * @return a update Type
     */
    @RequestMapping("/updateOne")
    public String updateOne(Entity type) {
        try {
            Entity instance = entityService.updateOne(type);
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
    public String find(Entity type) {
        List<Entity> instances = entityService.find(type);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instances));
    }

    @Autowired
    private EntityService entityService;
}
