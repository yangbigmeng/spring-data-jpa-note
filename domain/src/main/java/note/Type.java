package note;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Set;

/**
 * Description: 实体类型定义
 * <p>
 * Create:      2019/5/3 11:23
 *
 * @author Marvin Yang
 */
@Entity(name = "Type")
@Table(name = "type")
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 实体类型名称 */
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "parent")
    private Integer parent = -1;

    /**
     * (1) Entity表字段中定义了type_id
     * (2) 多个entity对应一个type
     * (3) JoinColumn在OneToMany下, name对应的字段是目标表的字段
     *
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Set<note.Entity> entities;

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

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getParent() {
        return parent;
    }

    public Set<note.Entity> getEntities() {
        return entities;
    }

    public void setEntities(Set<note.Entity> entities) {
        this.entities = entities;
    }

}
