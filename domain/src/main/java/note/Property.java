package note;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Description: 属性定义
 * <p>
 * Create:      2019/5/3 13:42
 *
 * @author Marvin Yang
 */
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

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
}
