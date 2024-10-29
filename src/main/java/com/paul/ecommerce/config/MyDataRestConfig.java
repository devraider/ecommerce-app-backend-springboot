package com.paul.ecommerce.config;

import com.paul.ecommerce.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

//    @Value("${spring.data.rest.base-path}")
//    private String allowedOrigins;

    @Value("${allowed.origins}")
    private String[] allowedOrigins;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        // disable actions for states
        disableHTTPMethods(Product.class, config, unsupportedActions);
        disableHTTPMethods(ProductCategory.class, config, unsupportedActions);
        disableHTTPMethods(Country.class, config, unsupportedActions);
        disableHTTPMethods(State.class, config, unsupportedActions);
        disableHTTPMethods(Order.class, config, unsupportedActions);


        // call internal helper method to help to expose ids
        exposeIds(config);
//        config.exposeIdsFor(ProductCategory.class);


        // config cors mapping
        cors.addMapping(config.getBasePath() + "/**").allowedOrigins("https://localhost:4200");
    }

    private static void disableHTTPMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration().forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
    }

    public void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids

        // get list of all entity classed from entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create array of entity types
        List<Class> entityClasses  = new ArrayList<>();

        // get entity type from entities
        for (EntityType entity: entities) {
            entityClasses.add(entity.getJavaType());
        }

        // expose entity ids for array entity/domain type
        Class[] domainType = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainType);
    }
}
