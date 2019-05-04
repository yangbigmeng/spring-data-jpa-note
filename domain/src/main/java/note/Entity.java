package note;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description: 实体定义
 * <p>
 * Create:      2019/5/3 13:41
 *
 * @author Marvin Yang
 */
@javax.persistence.Entity(name = "Entity")
@Table(name = "entity")
public class Entity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    /**
     * 实体所属类别Id
     *
     */
    @Column(name = "type_id")
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}
