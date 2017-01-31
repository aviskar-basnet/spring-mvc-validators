# spring-mvc-validators


### Table Of Contents

#### [Overview](#overview-1)

##### [Detected Global Validator](#detected-global-validator-1)

##### [Custom Global Validator](#custom-global-validator-1)

##### [Custom Local Validator](#custom-local-validator-1)


---


## Overview

Spring provides a `Validator` interface that can be used for validation in all layers of an application. In Spring MVC you can configure it for use as a global `Validator` instance, to be used whenever an `@Valid` or `@Validated` controller method argument is encountered, and/or as a local `Validator` within a controller through an `@InitBinder` method. Global and local validator instances can be combined to provide composite validation.

`@Valid` & `@Validated` are no different for their task in Spring MVC. But, using `@Validated` is suggested as it's Spring specific.

Spring also supports JSR-303/JSR-349 Bean Validation via `LocalValidatorFactoryBean` which adapts the Spring `org.springframework.validation.Validator` interface to the Bean Validation `javax.validation.Validator` contract. This class can be plugged into Spring MVC as a global validator.

If the configured `Validator` is a type of `SmartValidator`, Spring MVC executes the  
`void validate(Object target, Errors errors, Object... validationHints);`
method of `SmartValidator` interface for bean validation. `SmartValidator` is a more specialized `Validator`.

If the configured `Validator` isn't a type of `SmartValidator` , Spring MVC executes the  
`void validate(Object target, Errors errors);` method of `Validator` interface for bean validation.


---


## Detected Global Validator

By default use of `@EnableWebMvc` or `<mvc:annotation-driven />` automatically registers Bean Validation support in Spring MVC through the `LocalValidatorFactoryBean` when a Bean Validation provider such as Hibernate Validator is detected on the classpath.


## Custom Global Validator

Custom global `Validator` can be configured instead of automatically detected global `Validator`. The global `Validator` are intended to be generic `Validator`.

For demonstration of custom global `Validator`, we've taken the support of `LocalValidatorFactoryBean`, which acts as generic `Validator`.

Sample of custom global `Validator`:

```java
public class GenericCustomValidator extends LocalValidatorFactoryBean {

	@Override
	public boolean supports(Class<?> clazz) {
		return super.supports(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("GenericCustomValidator :: Validation Started");
		super.validate(target, errors);
		System.out.println("GenericCustomValidator :: Validation Completed");
	}

	@Override
	public void validate(Object target, Errors errors, Object... validationHints) {
		System.out.println("GenericCustomValidator :: Validation Started");
		super.validate(target, errors, validationHints);
		System.out.println("GenericCustomValidator :: Validation Completed");
	}
}
```

1. #### Configuring custom global validator (xml)

   ```xml
   <beans ...>
      ...
      <mvc:annotation-driven validator="globalValidator" />
      <bean id="globalValidator"
          class="com.aviskar.sample.validator.custom.global.GenericCustomValidator" />
   </beans>
   ```
   
   Now, the *globalValidator* can also be used as autowiring candidate of `com.aviskar.sample.validator.custom.global.GenericCustomValidator` for injecting it with `@Autowired`.

2. #### Configuring custom global validator (annotation)

   There are two ways to configure custom global `Validator`:

   1. ##### With Bean
   
      While enabling Spring MVC with `@EnableMVC`, Spring registers a bean with name *mvcValidator* of type `org.springframework.validation.Validator`. This registered bean is used as global validator. And, we can override this registered bean with the help of `@Primary`.
   
      ```java
      @EnableWebMvc
      @ComponentScan
      public class CustomGlobalWithBeanConfig {
          ...

          @Bean
          @Primary
          public Validator mvcValidator() {
            return new GenericCustomValidator();
          }
      }
      ```
      
      Sometimes it’s convenient to have injected implementation type of `Validator` instead of `Validator` into a controller or another class. For that purpose, we can configure like this:
      
      ```java
      @EnableWebMvc
      @ComponentScan
      public class CustomGlobalWithBeanConfig {
          ...

          @Bean
          @Primary
          public GenericCustomValidator mvcValidator() {
            return new GenericCustomValidator();
          }
      }
      ```
      
      Now, the bean with name *mvcValidator* is a autowiring candidate of type `com.aviskar.sample.validator.custom.global.GenericCustomValidator`. 
   
   2. ##### With Configurer
   
      While enabling Spring MVC with `@EnableMVC`, Spring registers a bean with name *mvcValidator* of type `org.springframework.validation.Validator`. For registration of this bean, Spring delegates with  
      `Validator getValidator();` method of `WebMvcConfigurer` interface. And, we can configure custom global `Validator` by implementing `WebMvcConfigurer` interface & overriding `Validator getValidator();` method.
      
      ```java
      @EnableWebMvc
      @ComponentScan
      public class CustomGlobalWithBeanConfig extends WebMvcConfigurerAdapter {
          ...

          @Override
          public Validator getValidator() {
            return new GenericCustomValidator();
          }
      }
      ```
      
      Don't be confused with `WebMvcConfigurerAdapter`. It is bare implementation of `WebMvcConfigurer` interface. It is very useful for overriding only required methods of `WebMvcConfigurer` interface.


## Custom Local Validator

The custom local `Validator` can be configured without enabling Spring MVC. Local `Validator` are configured within a controller.

Sample for custom local `Validator`:

```java
@Component
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("StudentValidator :: Validation Started");
        Student student = (Student) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.student.name");
        if (student.getAge() < 1 || student.getAge() > 150) {
            errors.rejectValue("age", "Range.student.age");
        }
        System.out.println("StudentValidator :: Validation Completed");
    }
}
```

Sample controller for using custom local `Validator`:

```java
@Controller
public class StudentController {

    @Autowired
    private StudentValidator studentValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(studentValidator);
    }

    ...
}
```


---


For more, [docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-config-validation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-config-validation)...

> Follow me for upcoming guides & tutorials.  
> Happy Coding...!!
