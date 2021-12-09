package com.asb.example.config;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

	private static final String RULES_AWARD_XLS = "rules/award.xlsx";
	private static final String RULES_REDEEM_XLS = "rules/redeem.xlsx";
	private static final KieServices kieServices = KieServices.Factory.get();

	@Bean
	public KieContainer kieContainer() {
		Resource dtAward = ResourceFactory.newClassPathResource(RULES_AWARD_XLS, getClass());
		Resource dtRedeem = ResourceFactory.newClassPathResource(RULES_REDEEM_XLS, getClass());
		
		//print DRL for debug
		SpreadsheetCompiler converter = new SpreadsheetCompiler();
		String drlAward = converter.compile(dtAward, InputType.XLS);
		System.out.println("AWARD DRL:\n"+drlAward);
		String drlRedeem = converter.compile(dtRedeem, InputType.XLS);
		System.out.println("REDEEM DRL:\n"+drlRedeem);
		
		//Kie read xls
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(dtAward);
		kieFileSystem.write(dtRedeem);
		
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
		return kieContainer;
	}
}
