package note.controller;

import note.KnowledgeGraphApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: 实体测试
 *
 * Create:      2019/11/3 16:21
 *
 * @author Marvin Yang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KnowledgeGraphApplication.class)
public class EntityControllerTest {

    @Autowired
    private EntityController entityController;

    @Test
    public void findOne() {
        Assert.assertNotNull(entityController);
    }
}