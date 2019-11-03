package note.impl;

import note.*;
import note.exceptions.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Description: 实体操作接口实现
 *
 * Create:      2019/5/3 20:18
 *
 * @author Marvin Yang
 */
@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private TypeRepository typeRepository;

    private final static Logger LOG = LoggerFactory.getLogger(EntityServiceImpl.class);

    /**
     * 存储一个实体
     *
     * @param node 节点
     * @return Type
     */
    @Override
    public EntityNode saveOne(EntityNode node) {
        EntityNode org = entityRepository.findByName(node.getName());
        if (org != null) {
            return org;
        } else {
            return entityRepository.save(node);
        }
    }

    /**
     * 更新一个对象
     *
     * @param node 更新类别
     * @return a EntityNode
     */
    @Override
    public EntityNode updateOne(EntityNode node) throws InvalidIdException {
        Optional<EntityNode> res = entityRepository.findById(node.getId());
        if (res.isPresent()) {
            EntityNode org = res.get();
            org.setName(node.getName());
            return entityRepository.save(org);
        } else {
            throw new InvalidIdException();
        }
    }

    /**
     * 查询记录
     *
     * @param node 查询条件
     * @return list of EntityNode
     */
    @Override
    public List<EntityNode> find(EntityNode node) {
        return entityRepository.findAll(Example.of(node));
    }

    /**
     * 根据id获取实体
     *
     * @param id 实体id
     * @return a EntityNode
     */
    @Override
    public EntityNode findOne(long id) {
        EntityNode entityNode = entityRepository.getOne(id);
        if (entityNode != null) {
            Type type = typeRepository.getOne(entityNode.getTypeId());
            entityNode.setType(type);
        }
        return entityNode;
    }
}
