package note.impl;

import note.Type;
import note.TypeRepository;
import note.TypeService;
import note.exceptions.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Description: 实体类型操作实现
 *
 * Create:      2019/5/3 17:52
 *
 * @author Marvin Yang
 */
@Service
public class TypeServiceImpl implements TypeService {
    /**
     * 存储一个实体
     *
     * @param node 节点
     * @return Type
     */
    @Override
    public Type saveOne(Type node) {
        Type org = typeRepository.findByName(node.getName());
        if (org != null) {
            return org;
        } else {
            return typeRepository.save(node);
        }
    }

    /**
     * 更新一个对象
     *
     * @param node 更新类别
     * @return a Type
     */
    @Override
    public Type updateOne(Type node) throws InvalidIdException {
       Optional<Type> res = typeRepository.findById(node.getId());
       if (res.isPresent()) {
           Type org = res.get();
           org.setName(node.getName());
           return typeRepository.save(org);
       } else {
           throw new InvalidIdException();
       }
    }

    /**
     * 查询一条记录
     *
     * @param node 查询条件
     * @return a Type
     */
    @Override
    public Type findOne(Type node) {
        Optional<Type> res = typeRepository.findOne(Example.of(node));
        return res.orElse(null);
    }

    /**
     * 查询记录
     *
     * @param node 查询条件
     * @return list of type
     */
    @Override
    public List<Type> find(Type node) {
        return typeRepository.findAll(Example.of(node));
    }

    @Autowired
    private TypeRepository typeRepository;

    private final static Logger LOG = LoggerFactory.getLogger(TypeServiceImpl.class);
}
