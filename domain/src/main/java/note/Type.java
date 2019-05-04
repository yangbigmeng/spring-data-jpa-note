package note;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Set;

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
//@JsonIgnoreProperties(ignoreUnknown = true)
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
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "type_id")
//    private Set<note.Entity> entities;

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

//    public Set<note.Entity> getEntities() {
//        return entities;
//    }
//
//    public void setEntities(Set<note.Entity> entities) {
//        this.entities = entities;
//    }

}
