package note;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Description: 实体类型定义
 * <p>
 * Create:      2019/5/3 11:23
 *
 * @author Marvin Yang
 */
@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** 实体类型名称 */
    @Column(name = "name")
    private String name;

    @Column(name = "parent")
    @JsonIgnore
    private Integer parent = -1;

    @Transient
    @JsonProperty("parent")
    private Type parentNode;

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

    public void setParentNode(Type parentNode) {
        this.parentNode = parentNode;
    }

    @OneToOne(targetEntity = Type.class, fetch = FetchType.LAZY, mappedBy = "parent")
    public Type getParentNode() {
        return parentNode;
    }
}
