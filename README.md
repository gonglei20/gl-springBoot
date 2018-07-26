### Spring Boot学习笔记

---
* #### Spring发展  
  * Spring1.x时代    
    >在Spring1.x时代，都是通过xml文件配置bean，随着项目的不断扩大，需要将xml配置分放到不同的配置文件中，需要频繁的在java类和xml配置文件中切换。  

  * Spring2.x时代 
    >随着JDK 1.5带来的注解支持，Spring2.x可以使用注解对Bean进行申明和注入，大大的减少了xml配置文件，同时也大大简化了项目的开发。  
    那么，问题来了，究竟是应该使用xml还是注解呢？  
    最佳实践：
    1、应用的基本配置用xml，比如：数据源、资源文件等；
    2、业务开发用注解，比如：Service中注入bean等；
    
  * Spring3.x到Spring4.x
    >从Spring3.x开始提供了Java配置方式，使用Java配置方式可以更好的理解你配置的Bean，现在我们就处于这个时代，并且Spring4.x和Spring boot都推荐使用java配置的方式。
    
* #### Spring的Java配置方式
    >Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置.   

    * @Configuration 和 @Bean
      >Spring的Java配置方式是通过 @Configuration 和 @Bean 这两个注解实现的：  
    1、@Configuration 作用于类上，相当于一个xml配置文件; 
    2、@Bean 作用于方法上，相当于xml配置中的<bean>；  
    
    * 示例
         > 该示例演示了通过Java配置的方式进行配置Spring，并且实现了Spring IOC功能。 
         
        * 创建工程以及导入依赖
            ```
            <project xmlns="http://maven.apache.org/POM/4.0.0"xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        	<modelVersion>4.0.0</modelVersion>
        	<groupId>cn.itcast.springboot</groupId>
        	<artifactId>itcast-springboot</artifactId>
        	<version>1.0.0-SNAPSHOT</version>
        	<packaging>war</packaging>
        
        	<dependencies>
        		<dependency>
        			<groupId>org.springframework</groupId>
        			<artifactId>spring-webmvc</artifactId>
        			<version>4.3.7.RELEASE</version>
        		</dependency>
        		<!-- 连接池 -->
        		<dependency>
        			<groupId>com.jolbox</groupId>
        			<artifactId>bonecp-spring</artifactId>
        			<version>0.8.0.RELEASE</version>
        		</dependency>
        	</dependencies>
        	<build>
        		<finalName>${project.artifactId}</finalName>
        		<plugins>
        			<!-- 资源文件拷贝插件 -->
        			<plugin>
        				<groupId>org.apache.maven.plugins</groupId>
        				<artifactId>maven-resources-plugin</artifactId>
        				<configuration>
        					<encoding>UTF-8</encoding>
        				</configuration>
        			</plugin>
        			<!-- java编译插件 -->
        			<plugin>
        				<groupId>org.apache.maven.plugins</groupId>
        				<artifactId>maven-compiler-plugin</artifactId>
        				<configuration>
        					<source>1.7</source>
        					<target>1.7</target>
        					<encoding>UTF-8</encoding>
        				</configuration>
        			</plugin>
        		</plugins>
        		<pluginManagement>
        			<plugins>
        				<!-- 配置Tomcat插件 -->
        				<plugin>
        					<groupId>org.apache.tomcat.maven</groupId>
        					<artifactId>tomcat7-maven-plugin</artifactId>
        					<version>2.2</version>
        				</plugin>
        			</plugins>
        		</pluginManagement>
        	</build>
            </project>
            ```  
        * 编写User对象
            ```
            public class User {

                private String username;
            
                private String password;
            
                private Integer age;
            
                public String getUsername() {
                    return username;
                }
            
                public void setUsername(String username) {
                    this.username = username;
                }
            
                public String getPassword() {
                    return password;
                }
            
                public void setPassword(String password) {
                    this.password = password;
                }
            
                public Integer getAge() {
                    return age;
                }
            
                public void setAge(Integer age) {
                    this.age = age;
                }
        
          }
            ```  
        * 编写UserDAO 用于模拟与数据库的交互 
            ```
            public class UserDAO {
    
                public List<User> queryUserList(){
                    List<User> result = new ArrayList<User>();
                    // 模拟数据库的查询
                    for (int i = 0; i < 10; i++) {
                        User user = new User();
                        user.setUsername("username_" + i);
                        user.setPassword("password_" + i);
                        user.setAge(i + 1);
                        result.add(user);
                    }
                    return result;
                }
            }
            ```  
            
     ### SpringBoot学习笔记

---
* #### SpringBoot简介 
    * 什么是Spring Boot
        > 随着动态语言的流行（Ruby、Groovy、Scala、node.js）,java的开发显得格外的笨重：繁多的配置，低下的开发效率、复杂的部署流程以及第三方技术集成难度大。  
        在上述环境下，Spring Boot应运而生。它使用“习惯优于配置”（项目中存在大量的配置，此外还内置一个习惯性的配置，让你无需手动进行配置）的理念让你的项目快速的运行起来。使用Spring Boot很容易创建一个独立运行的应用（运行jar、内嵌servlet容器）、准生产级别的基于Spring框架的项目，使用Spring Boot你可以不用或者只需要很少的Spring配置。  
    
    * Spring　Boot的优缺点
        * 优点
        > 1、快速构建项目；  
          2、对主流开发框架的无配置集成；  
          3、项目可独立运行，无需外部的servlet容器；  
          4、提供运行时的应用监控；  
          5、极大的提高了开发、部署效率；  
          6、与云计算天然集成。  

        * 缺点  
        >1、书籍文档较少且不够深入；  
         2、如果不认同Spring框架，这或许是它的缺点。  
         
--- 
* #### 快速入门  
    * 设置spring boot的parent
        ```
        <parent>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-parent</artifactId>
    		<version>1.5.2.RELEASE</version>
	    </parent>
        ```  
        > 说明：Spring boot的项目必须要将parent设置为spring boot的parent，该parent包含了大量默认的配置，大大简化了我们的开发。  
        
    * 导入spring boot的web支持  
        ```
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		```  
		
	* 添加Spring boot的插件  
	    ```
	    <plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
		```  
		
	* 编写第一个Spring Boot的应用  
	    ```
	    @Controller
        @SpringBootApplication
        @Configuration
        public class HelloApplication {
            
            @RequestMapping("hello")
            @ResponseBody
            public String hello(){
                return "hello world！";
            }
            
            public static void main(String[] args) {
                SpringApplication.run(HelloApplication.class, args);
            }
        }
        ```  
        
        > 代码说明:  
        1、@SpringBootApplication：SpringBoot项目的核心注解，主要目的是开启自动配置；  
        2、@Configuration：这是一个配置Spring的配置类；  
        3、@Controller：标明这是一个SpringMVC的Controller控制器；  
        4、main方法：在main方法中启动一个应用，即：这个应用的入口；  
        
    * 启动应用  
        > 在Spring Boot项目中，启动的方式有两种，一种是直接run Java Application另外一种是通过Spring Boot的Maven插件运行。  
        1、第一种：![启动应用1](193924597BAF447FBAD434FD626172E4)  
        2、第二种：![启动应用2](B6A1157C672647D4A2086EAE90F07934)  
    
    * 启动效果  
        > ![启动效果](D85F1A1D335B43DEAD589C6E35127767)  
        
    * 测试  
        > 打开浏览器输入：localhost:8080/hello 即可看到如下效果  ![测试效果](3E7191148AFA49CEB7051F54BC7613FE)
        
    
