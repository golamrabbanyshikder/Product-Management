1.Project Architechture 


  com.product_management(This is project main package)
  
      controller(This Is controller package)
            ProductController.java(This is the controller class)
            
      dto (This Is the Data Transfer Object package)
            ProductRequestDto.java(This is the RequestDto class to receive data from the user)
            ProductResponseDto.java(This is the ResponseDto class to return data for the user)
            
      entites(This Is domain model package)
            Product.java(This is the entities class)
            
      repository(This Is DAO package)
            ProductRepository.java(This is the ProductRepository interface and its extended JpaRepository interface)
            
      service(This is the domain service package )
            IProductService.java(This is the service interface )
            ProductService.java(This is the service implementation class )
            
      ProductManagementApplication(This is the project's main class )


2. To Run Project
   
     Clone this project in your local pc and open it into a Spring Boot IDE
   
     Select Project -->Righ Click-->Run AS-->Spring Boot App(For STS4 IDE)
   
     The server port of this project is 9090(please Check application.properties file)
   
     To check your endpoint throw a postman. ( Download "/Product-Management.postman_collection.json" this file and Import it into Postman)
   
     I provided This file to the project.

3. Details on the domain model and application services.

     Domain Model contains some properties.

   AND
   
     Application services contain business logic. This has 2 parts one for declaration and connection to the controller and another is the implementation.

     In the implementation class when I receive data from a user via RequestDto then I convert it into an entity object and send it repository layer to save or update.

     In the implementation class when I return data to a user via ResponseDto then I convert it from an entity object.

     It's helped me to avoid receiving and returning unnecessary data.
   
