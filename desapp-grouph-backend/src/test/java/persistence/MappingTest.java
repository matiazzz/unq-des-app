package persistence;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

import java.util.Iterator;
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
    public void testHibernateMappings() {
        boolean allOk = true;
        Map metadata = sessionFactory.getAllClassMetadata();
        for (Iterator i = metadata.values().iterator(); i.hasNext();) {
            EntityPersister persister = (EntityPersister) i.next();
            String entityName = persister.getEntityName();
            try {
                Query q = session.createQuery("from " + entityName);
                q.setMaxResults(1);
                q.uniqueResult();
            } catch (HibernateException e) {
                allOk = false;
            }
        }
        assertTrue(allOk);
    }
}
