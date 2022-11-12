package com.arteni.mag;

import com.arteni.mag.dao.ProductDAOTest;
import com.arteni.mag.dao.UserDAOTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProductDAOTest.class,
        UserDAOTest.class,
})
public class JunitTest {
}
