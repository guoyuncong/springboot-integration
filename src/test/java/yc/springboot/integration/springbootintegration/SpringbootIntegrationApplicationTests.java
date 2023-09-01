package yc.springboot.integration.springbootintegration;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootIntegrationApplicationTests {

	@Test
	void contextLoads() {
		String logisticsAcceptStatus = "[\"ACCEPT\",\"TRANSPORT\",\"SIGN\", NULL]";
		List<String> logisticsAcceptStatusList = JSON.parseArray(logisticsAcceptStatus, String.class);
		System.out.println(logisticsAcceptStatusList);
	}

}
