package com.jetbrains.mufaddal.ApplicationLauncher;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class MyFancyPdfInvoices {
//
//	public static void main(String[] args) {
//		SpringApplication.run(MyFancyPdfInvoices.class, args);
//	}
//
//}
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {

	public static void main(String[] args) throws LifecycleException {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8088);
		tomcat.getConnector();

		Context ctx = tomcat.addContext("", null);
		Wrapper servlet = Tomcat.addServlet(ctx, "myFirstServlet", new MyFirstServlet());
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/*");

		tomcat.start();
	}
}