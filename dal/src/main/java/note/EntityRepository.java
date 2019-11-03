package note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Description: 实体接口
 *
 * Create:      2019/5/3 20:17
 *
 * @author Marvin Yang
 */
@Repository
public interface EntityRepository extends JpaRepository<EntityNode, Long> {

    /**
     * 根据名称查找实体
     *
     * @param name  名称
     * @return a EntityNode
     */
    EntityNode findByName(String name);

//    @Query("select e, e.type from EntityNode as e left join Type as t on t.id = e.typeId where e.id = ?1")
//    EntityNode getOne(long id);
}
