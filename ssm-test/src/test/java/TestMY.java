import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.chery.ssm.modle.User;
import org.chery.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMY {
  private static Logger logger = Logger.getLogger(TestMY.class);
  @Resource
  private UserService userservice = null;
  
  @Test
  public void test01() {
	 User user = userservice.selectById(1);
	  logger.info(user);
  }
  
}
