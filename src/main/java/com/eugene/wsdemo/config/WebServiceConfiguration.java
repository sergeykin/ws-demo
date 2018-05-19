package com.eugene.wsdemo.config;

import com.eugene.wsdemo.controller.CountryEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

    public static final String NAMESPACE_URI = "http://eugene.com/wsdemo/domain";

    @Bean
    public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "countries")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CountriesPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace(NAMESPACE_URI);
        definition.setSoapActions(generateSoapActions());
        definition.setSchema(countriesSchema);
        return definition;
    }

    private Properties generateSoapActions() {
        Properties properties = new Properties();
        Method[] declaredMethods = CountryEndpoint.class.getDeclaredMethods();

        for (Method declaredMethod: declaredMethods) {
            if (declaredMethod.getModifiers() == Modifier.PUBLIC) {
                String fieldName = declaredMethod.getName();
                properties.put(fieldName, NAMESPACE_URI + "/" +fieldName);
            }
        }
        return properties;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }
}
