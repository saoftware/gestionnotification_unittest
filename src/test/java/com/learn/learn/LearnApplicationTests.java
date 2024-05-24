package com.learn.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
	properties = {
		"spring.config.location = classpath:application-integration-test.yml",
		"server.port=8080"
})
@TestExecutionListeners({
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@ActiveProfiles("dev")
@DatabaseSetup(value = "/test-dataset.xml")
@EnableCaching
@DbUnitConfiguration(dataSetLoader = ColumnSensingFlatXMLDataSetLoader.class)
public abstract class LearnApplicationTests {

	// Mettre a dispositions des composants néccessaire
	// pour faire les test sur les controleurs
	@Autowired
	protected MockMvc mvc;


	@Test
	void contextLoads() {
	}

}