package note.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import note.EntityNode;
import note.EntityService;
import note.exceptions.InvalidIdException;
import note.response.ResponseBuilder;
import note.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(value = "实体操作")
public class EntityController {

    @ApiOperation(value = "新增一个实体", notes = "save")
    @RequestMapping(value = "/saveOne", method = RequestMethod.POST)
    public String saveOne(EntityNode type) {
        EntityNode instance = entityService.saveOne(type);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instance));
    }

    /**
     * 更新实体类别
     *
     * @param type  待更新实体类别
     * @return a update type
     */
    @ApiOperation(value = "更新实体", notes = "update")
    @RequestMapping(value = "/updateOne", method = RequestMethod.POST)
    public String updateOne(EntityNode type) {
        try {
            EntityNode instance = entityService.updateOne(type);
            return JsonUtils.serialize(ResponseBuilder.buildSuccess(instance));
        } catch (InvalidIdException id) {
            return JsonUtils.serialize(ResponseBuilder.buildFailed(type, "Id无效"));
        }
    }

    /**
     * 查询多条记录
     *
     * @param type  查询条件
     * @return  list of entity
     */
    @ApiOperation(value = "查询全部实体", notes = "find")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String find(EntityNode type) {
        List<EntityNode> instances = entityService.find(type);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instances));
    }

    /**
     * 根据实体Id查询实体
     *
     * @param id    实体id
     * @return a entity
     */
    @ApiOperation(value = "查询一个实体", notes = "find")
    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public String findOne(long id) {
        EntityNode instance = entityService.findOne(id);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instance));
    }

    @Autowired
    private EntityService entityService;
}
