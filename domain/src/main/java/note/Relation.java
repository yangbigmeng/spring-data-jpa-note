package note;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Description: 关系定义
 * <p>
 * Create:      2019/5/3 13:43
 *
 * @author Marvin Yang
 */
@Entity
public class Relation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_entity_id")
    private Integer fromEntityId;

    @Column(name = "property_id")
    private Integer propertyId;

    @Column(name = "to_entity_id")
    private Integer toEntityId;

    @Column(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromEntityId() {
        return fromEntityId;
    }

    public void setFromEntityId(Integer fromEntityId) {
        this.fromEntityId = fromEntityId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getToEntityId() {
        return toEntityId;
    }

    public void setToEntityId(Integer toEntityId) {
        this.toEntityId = toEntityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
