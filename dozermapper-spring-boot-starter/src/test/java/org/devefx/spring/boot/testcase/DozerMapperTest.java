package org.devefx.spring.boot.testcase;

import com.github.dozermapper.core.Mapper;
import org.devefx.spring.boot.demo.DozerDemoApplication;
import org.devefx.spring.boot.demo.domain.TestObject;
import org.devefx.spring.boot.demo.domain.TestObjectPrime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DozerMapperTest
 *
 * @author Yoke
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DozerDemoApplication.class)
public class DozerMapperTest {

    @Autowired
    private Mapper mapper;

    @Test
    public void test() {
        TestObject object = new TestObject();
        object.setDate(new Date());

        TestObjectPrime prime = mapper.map(object, TestObjectPrime.class);

        String time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(object.getDate());

        Assert.assertEquals(prime.getTime(), time);
    }
}
