package note;

import note.exceptions.InvalidIdException;

import java.util.List;

/**
 * Description: 实体操作接口
 *
 * Create:      2019/5/3 20:17
 *
 * @author Marvin Yang
 */
public interface EntityService {

    /**
     * 存储一个实体
     *
     * @param node  节点
     * @return Type
     */
    EntityNode saveOne(EntityNode node);

    /**
     * 更新一个对象
     *
     * @param node  更新类别
     * @return  a EntityNode
     */
    EntityNode updateOne(EntityNode node) throws InvalidIdException;

    /**
     * 查询记录
     *
     * @param node  查询条件
     * @return list of EntityNode
     */
    List<EntityNode> find(EntityNode node);

    /**
     * 根据id获取实体
     *
     * @param id    实体id
     * @return  a EntityNode
     */
    EntityNode findOne(long id);
}
