package note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Description: 实体类别操作
 *
 * Create:      2019/5/3 14:56
 *
 * @author Marvin Yang
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    /**
     * 根据实体类别名称查找对象
     *
     * @param name  类别名称
     * @return  a Type
     */
    Type findByName(String name);
}
