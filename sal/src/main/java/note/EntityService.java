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
    Entity saveOne(Entity node);

    /**
     * 更新一个对象
     *
     * @param node  更新类别
     * @return  a Entity
     */
    Entity updateOne(Entity node) throws InvalidIdException;

    /**
     * 查询记录
     *
     * @param node  查询条件
     * @return list of Entity
     */
    List<Entity> find(Entity node);
}
