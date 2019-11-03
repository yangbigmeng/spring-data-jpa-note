package note.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import note.Type;
import note.TypeService;
import note.exceptions.InvalidIdException;
import note.response.ResponseBuilder;
import note.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api("类型操作")
public class TypeController {

    @ApiOperation(value = "添加一个类型", notes = "save")
    @RequestMapping(value = "/saveOne", method = RequestMethod.POST)
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
    @ApiOperation(value = "更新一个类型", notes = "update")
    @RequestMapping(value = "/updateOne", method = RequestMethod.POST)
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
    @ApiOperation(value = "查询全部类型", notes = "find")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String find(Type type) {
        List<Type> instances = typeService.find(type);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instances));
    }

    /**
     * 根据Id删除一条记录
     *
     * @param id    类别Id
     * @return 删除OK
     */
    @ApiOperation(value = "删除一个类型", notes = "delete")
    @RequestMapping(value = "/deleteOne", method = RequestMethod.GET)
    public String deleteOne(long id) {
        typeService.deleteOne(id);
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(null));
    }

    @ApiOperation(value = "查询一个类型", notes = "find")
    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public String findOne(long id) {
        Type instance = typeService.findOne(id);
        if (instance == null) {
            return JsonUtils.serialize(ResponseBuilder.buildSuccess(null));
        }
        return JsonUtils.serialize(ResponseBuilder.buildSuccess(instance));
    }

    @Autowired
    private TypeService typeService;
}
