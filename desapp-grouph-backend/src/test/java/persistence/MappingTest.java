package persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class MappingTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() {
        session.close();
    }

    @Test
    public void testHibernateMappings() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        boolean allOk = true;
        Map metadata = sessionFactory.getAllClassMetadata();
        for (Object ep : metadata.values()) {
            EntityPersister entityPersister = (EntityPersister) ep;
            String entityName = entityPersister.getEntityName();
            String className = getClassName(entityName);
            Class classBuilder = Class.forName("model.builders." + className + "Builder");
            Class classObject = Class.forName(entityName);
            Method build = classBuilder.getMethod("build");
            Object objectToPersist = build.invoke(classBuilder.newInstance());

            try {
                session.save(classObject.cast(objectToPersist));

            } catch (HibernateException e) {
                allOk = false;
            }
        }
        assertTrue(allOk);
    }

    private String getClassName(String entity){
        int n = entity.length() - reverseIt(entity).indexOf(".");
        return entity.substring(n);
    }


    private String reverseIt(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }

        return dest.toString();
    }
}
