package note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description: 实体接口
 *
 * Create:      2019/5/3 20:17
 *
 * @author Marvin Yang
 */
@Repository
public interface EntityRepository extends JpaRepository<Entity, Integer> {

    /**
     * 根据名称查找实体
     *
     * @param name  名称
     * @return a Entity
     */
    Entity findByName(String name);
}
