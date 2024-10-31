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
