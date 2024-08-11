package com.chandu.Employee;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@PWA(name = "My Vaadin CRUD App", shortName = "CRUD App")
public class EmployeeApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
