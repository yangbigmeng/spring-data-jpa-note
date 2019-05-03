package note.impl;

import note.Entity;
import note.EntityRepository;
import note.EntityService;
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

    private final static Logger LOG = LoggerFactory.getLogger(EntityServiceImpl.class);

    /**
     * 存储一个实体
     *
     * @param node 节点
     * @return Type
     */
    @Override
    public Entity saveOne(Entity node) {
        Entity org = entityRepository.findByName(node.getName());
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
     * @return a Entity
     */
    @Override
    public Entity updateOne(Entity node) throws InvalidIdException {
        Optional<Entity> res = entityRepository.findById(node.getId());
        if (res.isPresent()) {
            Entity org = res.get();
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
     * @return list of Entity
     */
    @Override
    public List<Entity> find(Entity node) {
        return entityRepository.findAll(Example.of(node));
    }
}
