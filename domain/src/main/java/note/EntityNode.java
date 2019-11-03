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
@Entity(name = "EntityNode")
@Table(name = "entity")
public class EntityNode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * 实体所属类别Id
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 实体所属Type
     */
    @Transient
    private Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setType(Type type) {
        this.type = type;
    }

//    @ManyToOne(targetEntity = Type.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "type_id", referencedColumnName = "id")
    public Type getType() {
        return type;
    }
}
