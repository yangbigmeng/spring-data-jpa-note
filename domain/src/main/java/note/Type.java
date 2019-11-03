package note;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description: 实体类型定义
 * <p>
 *     1. Entity中存储了type_id字段, 可以用@JoinColumn来关联两张表
 *     2. 由于使用了CascadeType.ALL关联, 删除Type的时候也会对应的处理Entity
 * </p>
 * Create:      2019/5/3 11:23
 *
 * @author Marvin Yang
 */
@Entity(name = "Type")
@Table(name = "type")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 实体类型名称 */
    @Column(name = "name")
    private String name;

    @Column(name = "parent")
    private Long parent = -1L;

    /**
     * (1) Entity表字段中定义了type_id
     * (2) 多个entity对应一个type
     * (3) JoinColumn在OneToMany下, name对应的字段是目标表的字段
     * (4) 不入库
     */
//    @Transient
//    private Set<EntityNode> entities;

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

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getParent() {
        return parent;
    }

//    @OneToMany(targetEntity = EntityNode.class, mappedBy = "typeId")
//    @JoinColumn(name="type_id")
//    public Set<EntityNode> getEntities() {
//        return entities;
//    }
//
//    public void setEntities(Set<EntityNode> entities) {
//        this.entities = entities;
//    }

}
