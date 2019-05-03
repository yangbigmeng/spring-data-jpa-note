package note;

import note.exceptions.InvalidIdException;

import java.util.List;

/**
 * Description: 实体类型操作接口
 *
 * Create:      2019/5/3 17:50
 *
 * @author Marvin Yang
 */
public interface TypeService {

    /**
     * 存储一个实体类别
     *
     * @param node  节点
     * @return Type
     */
    Type saveOne(Type node);

    /**
     * 更新一个对象
     *
     * @param node  更新类别
     * @return  a Type
     */
    Type updateOne(Type node) throws InvalidIdException;

    /**
     * 查询一条记录
     *
     * @param node  查询条件
     * @return  a Type
     */
    Type findOne(Type node);

    /**
     * 查询记录
     *
     * @param node  查询条件
     * @return list of type
     */
    List<Type> find(Type node);
}
