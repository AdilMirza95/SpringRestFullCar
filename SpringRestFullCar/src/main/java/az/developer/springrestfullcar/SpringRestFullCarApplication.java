package az.developer.springrestfullcar;

import az.developer.springrestfullcar.model.Car;
import az.developer.springrestfullcar.model.Category;
import az.developer.springrestfullcar.model.Customer;
import az.developer.springrestfullcar.rest.model.request.CarDto;
import az.developer.springrestfullcar.service.Dao.CarService;
import az.developer.springrestfullcar.service.impl.CarServiceImpl;
import az.developer.springrestfullcar.service.impl.CategoryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringRestFullCarApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringRestFullCarApplication.class);
    }
    public static void main(String[] args){

        SpringApplication.run(SpringRestFullCarApplication.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();

    }



}
