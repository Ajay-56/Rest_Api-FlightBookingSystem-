// package com.prjgrp.artf;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
// import com.prjgrp.artf.Controller.FlightController;
// import com.prjgrp.artf.Controller.HistoryController;
// import com.prjgrp.artf.Controller.UserController;
// import com.prjgrp.artf.Model.Flight;
// import com.prjgrp.artf.Model.History;
// import com.prjgrp.artf.Model.User;
// import com.prjgrp.artf.Repository.FlightRepository;
// import com.prjgrp.artf.Repository.HistoryRepository;
// import com.prjgrp.artf.Repository.UserRepository;
// import com.prjgrp.artf.Service.FlightService;
// import com.prjgrp.artf.Service.HistoryService;
// import com.prjgrp.artf.Service.UserService;
// import com.prjgrp.artf.configuration.SwaggerConfig;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.lang.reflect.Method;

// import org.junit.jupiter.api.BeforeEach;

// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Test;

// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import java.time.LocalDateTime;
// import java.io.File;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// class ArtfApplicationTests {
//     private static final String LOG_FOLDER_PATH = "logs";
//     private static final String LOG_FILE_PATH = "logs/application.log"; 
//     @Autowired
//     private MockMvc mockMvc;

//     // Mock dependencies for FlightController
//     @InjectMocks
//     private FlightController flightController;
//     @Mock
//     private FlightService flightService;

//     // Mock dependencies for HistoryController
//     @InjectMocks
//     private HistoryController historyController;
//     @Mock
//     private HistoryService historyService;

//     // Mock dependencies for UserController
//     @InjectMocks
//     private UserController userController;
//     @Mock
//     private UserService userService;

    
//     private ObjectMapper objectMapper;

    

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders
//                 .standaloneSetup(flightController, historyController, userController)
//                 .build();
//         objectMapper = new ObjectMapper();
//         objectMapper.registerModule(new JavaTimeModule());  // Handle LocalDateTime serialization
//     }

//     // Test if the context loads
//     @Order(1)
//     @Test
//     void contextLoads() {
//     }
    
//     // Test for User entity with Lombok annotations
//     @Test
//     @Order(2)
//     void Annotation_testUserHasLombokAnnotations() throws Exception {
//         // Path to the User entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/User.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if annotations like @Entity, @Data, and @NoArgsConstructor exist
//         assertTrue(entityFileContent.contains("@Entity"), "User entity should contain @Entity annotation");
//         assertTrue(entityFileContent.contains("@Data"), "User entity should contain @Data annotation");
//         assertTrue(entityFileContent.contains("@NoArgsConstructor"),
//                 "User entity should contain @NoArgsConstructor annotation");
//     }

//     // Test for History entity with Lombok annotations
//     @Test
//     @Order(3)
//     void Annotation_testHistoryHasLombokAnnotations() throws Exception {
//         // Path to the History entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/History.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if annotations like @Entity, @Data, and @NoArgsConstructor exist
//         assertTrue(entityFileContent.contains("@Entity"), "History entity should contain @Entity annotation");
//         assertTrue(entityFileContent.contains("@Data"), "History entity should contain @Data annotation");
//         assertTrue(entityFileContent.contains("@NoArgsConstructor"),
//                 "History entity should contain @NoArgsConstructor annotation");
//     }

//     // Test for Flight entity with Lombok annotations
//     @Test
//     @Order(4)
//     void Annotation_testFlightHasLombokAnnotations() throws Exception {
//         // Path to the Flight entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/Flight.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if annotations like @Entity, @Data, and @NoArgsConstructor exist
//         assertTrue(entityFileContent.contains("@Entity"), "Flight entity should contain @Entity annotation");
//         assertTrue(entityFileContent.contains("@Data"), "Flight entity should contain @Data annotation");
//         assertTrue(entityFileContent.contains("@NoArgsConstructor"),
//                 "Flight entity should contain @NoArgsConstructor annotation");
//     }

//     // Test for User entity with @JsonIgnore annotations
//     @Test
//     @Order(5)
//     void Annotation_testUserHasJSONIgnoreAnnotations() throws Exception {
//         // Path to the User entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/User.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if @JsonIgnore annotation exists in the User entity
//         assertTrue(entityFileContent.contains("@JsonIgnore"), "User entity should contain @JsonIgnore annotation");
//     }

//     // Test for History entity with @JsonProperty annotations
//     @Test
//     @Order(6)
//     void Annotation_testHistoryHasJSONPropertyAnnotations() throws Exception {
//         // Path to the History entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/History.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if @JsonProperty annotation exists in the History entity
//         assertTrue(entityFileContent.contains("@JsonProperty"), "History entity should contain @JsonProperty annotation");
//     }

//     // Test to check if UserRepository file exists in the specified path
//     @Test
//     @Order(7)
//     public void Repository_testUserRepositoryFile() {
//         // Define the path to the UserRepository file
//         String filePath = "src/main/java/com/prjgrp/artf/Repository/UserRepository.java";
        
//         // Create a File object using the specified path
//         File file = new File(filePath);
        
//         // Check if the file exists and is indeed a file
//         assertTrue(file.exists() && file.isFile(), "UserRepository file should exist and be a file");
//     }

//     // Test to check if HistoryRepository file exists in the specified path
//     @Test
//     @Order(8)
//     public void Repository_testHistoryRepositoryFile() {
//         // Define the path to the HistoryRepository file
//         String filePath = "src/main/java/com/prjgrp/artf/Repository/HistoryRepository.java";
        
//         // Create a File object using the specified path
//         File file = new File(filePath);
        
//         // Check if the file exists and is indeed a file
//         assertTrue(file.exists() && file.isFile(), "HistoryRepository file should exist and be a file");
//     }

//     // Test to check if FlightRepository file exists in the specified path
//     @Test
//     @Order(9)
//     public void Repository_testFlightRepositoryFile() {
//         // Define the path to the FlightRepository file
//         String filePath = "src/main/java/com/prjgrp/artf/Repository/FlightRepository.java";
        
//         // Create a File object using the specified path
//         File file = new File(filePath);
        
//         // Check if the file exists and is indeed a file
//         assertTrue(file.exists() && file.isFile(), "FlightRepository file should exist and be a file");
//     }

//     // FlightController Test Cases (CRUD)

//     @Test
//     @Order(10)
//     void CRUD_testCreateFlight() throws Exception {
//         Flight flight = new Flight();
//         flight.setFlightNumber("AI202");
//         flight.setAirlineName("Air India");
//         flight.setDepartureLocation("Delhi");
//         flight.setArrivalLocation("Mumbai");
//         flight.setDepartureTime(LocalDateTime.now());
//         flight.setArrivalTime(LocalDateTime.now().plusHours(2));
//         flight.setTotalSeats(150);
//         flight.setAvailableSeats(50);
//         flight.setTicketPrice(2000.0);

//         when(flightService.create(any(Flight.class))).thenReturn(flight);

//         mockMvc.perform(post("/flights")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(flight)))
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.flightNumber").value("AI202"));
//     }

//     @Test
//     @Order(11)
//     void CRUD_testFindAllFlights() throws Exception {
//         mockMvc.perform(get("/flights"))
//                 .andExpect(status().isOk());
//     }

//     @Test
//     @Order(12)
//     void CRUD_testFindFlightById() throws Exception {
//         Flight flight = new Flight();
//         flight.setFlightNumber("AI202");
//         flight.setAirlineName("Air India");

//         when(flightService.findById(1L)).thenReturn(flight);

//         mockMvc.perform(get("/flights/{id}", 1L))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.flightNumber").value("AI202"));
//     }

//     @Test
//     @Order(13)
//     void CRUD_testUpdateFlight() throws Exception {
//         Flight flight = new Flight();
//         flight.setFlightNumber("AI202");
//         flight.setAirlineName("Air India");

//         when(flightService.update(eq(1L), any(Flight.class))).thenReturn(flight);

//         mockMvc.perform(put("/flights/{id}", 1L)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(flight)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.flightNumber").value("AI202"));
//     }

//     @Test
//     @Order(14)
//     void CRUD_testDeleteFlight() throws Exception {
//         doNothing().when(flightService).delete(1L);

//         mockMvc.perform(delete("/flights/{id}", 1L))
//                 .andExpect(status().isNoContent());
//     }

//     // HistoryController Test Cases (CRUD)

//     @Test
//     @Order(15)
//     void CRUD_testCreateHistory() throws Exception {
//         History history = new History();
//         history.setId(1L);
//         history.setBookingDate(LocalDateTime.now());
//         history.setStatus("Completed");
//         history.setAmountPaid(500.0);

//         when(historyService.create(any(History.class))).thenReturn(history);

//         mockMvc.perform(post("/histories")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(history)))
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.status").value("Completed"));
//     }

//     @Test
//     @Order(16)
//     void CRUD_testFindAllHistories() throws Exception {
//         mockMvc.perform(get("/histories"))
//                 .andExpect(status().isOk());
//     }

//     @Test
//     @Order(17)
//     void CRUD_testFindHistoryById() throws Exception {
//         History history = new History();
//         history.setStatus("Completed");

//         when(historyService.findById(1L)).thenReturn(history);

//         mockMvc.perform(get("/histories/{id}", 1L))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.status").value("Completed"));
//     }

//     @Test
//     @Order(18)
//     void CRUD_testUpdateHistory() throws Exception {
//         History history = new History();
//         history.setStatus("Completed");

//         when(historyService.update(eq(1L), any(History.class))).thenReturn(history);

//         mockMvc.perform(put("/histories/{id}", 1L)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(history)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.status").value("Completed"));
//     }

//     @Test
//     @Order(19)
//     void CRUD_testDeleteHistory() throws Exception {
//         doNothing().when(historyService).delete(1L);

//         mockMvc.perform(delete("/histories/{id}", 1L))
//                 .andExpect(status().isNoContent());
//     }

//     // UserController Test Cases

//     @Test
//     @Order(20)
//     void CRUD_testCreateUser() throws Exception {
//         User user = new User();
//         user.setUsername("john_doe");
//         user.setPassword("password123");
//         user.setEmail("john.doe@example.com");

//         when(userService.create(any(User.class))).thenReturn(user);

//         mockMvc.perform(post("/users")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(user)))
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.username").value("john_doe"));
//     }

//     @Test
//     @Order(21)
//     void CRUD_testFindAllUsers() throws Exception {
//         mockMvc.perform(get("/users"))
//                 .andExpect(status().isOk());
//     }

//     @Test
//     @Order(22)
//     void CRUD_testFindUserById() throws Exception {
//         User user = new User();
//         user.setUsername("john_doe");

//         when(userService.findById(1L)).thenReturn(user);

//         mockMvc.perform(get("/users/{id}", 1L))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.username").value("john_doe"));
//     }

//     @Test
//     @Order(23)
//     void CRUD_testUpdateUser() throws Exception {
//         User user = new User();
//         user.setUsername("john_doe");

//         when(userService.update(eq(1L), any(User.class))).thenReturn(user);

//         mockMvc.perform(put("/users/{id}", 1L)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(user)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.username").value("john_doe"));
//     }

//     @Test
//     @Order(24)
//     void CRUD_testDeleteUser() throws Exception {
//         doNothing().when(userService).delete(1L);

//         mockMvc.perform(delete("/users/{id}", 1L))
//                 .andExpect(status().isNoContent());
//     }

//      @Test
//     @Order(25)
//     void CRUD_testPathVariableAnnotations() throws Exception {
//         // Path to the UserController entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Controller/UserController.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if @PathVariable annotation exists in the UserController
//         assertTrue(entityFileContent.contains("@PathVariable"), "UserController should contain @PathVariable annotation");
//     }

//     @Test
//     @Order(26)
//     void CRUD_testRequestBodyAnnotations() throws Exception {
//         // Path to the HistoryController entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Controller/HistoryController.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if @RequestBody annotation exists in the HistoryController
//         assertTrue(entityFileContent.contains("@RequestBody"), "HistoryController should contain @RequestBody annotation");
//     }

//     @Test
//     @Order(27)
//     public void JPQL_testQueryStringExists() throws NoSuchMethodException {
//         // Retrieve the method from the repository
//         Method method = HistoryRepository.class.getMethod("findHistoriesByUserAndDateRange", 
//                 Long.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class);

//         // Get the @Query annotation from the method
//         org.springframework.data.jpa.repository.Query queryAnnotation = 
//                 method.getAnnotation(org.springframework.data.jpa.repository.Query.class);

//         // Verify the query string
//         String expectedQuery = "SELECT h FROM History h WHERE h.user.id = :userId AND h.bookingDate BETWEEN :startDate AND :endDate";
//         assertTrue(queryAnnotation.value().equals(expectedQuery), "The query string does not match the expected value.");

//         // Print to confirm in logs
//         System.out.println("Query string verified: " + queryAnnotation.value());
//     }

//     @Test
//     @Order(28)
//     public void JPQL_testFindUserByUsernameQueryExists() throws NoSuchMethodException {
//         // Get the method from the repository
//         Method method = UserRepository.class.getMethod("findUserByUsername", String.class);

//         // Retrieve the @Query annotation
//         org.springframework.data.jpa.repository.Query queryAnnotation = 
//                 method.getAnnotation(org.springframework.data.jpa.repository.Query.class);

//         // Check if the query exists
//         assertNotNull(queryAnnotation, "The @Query annotation should exist on the method.");

//         // Verify the query string
//         String expectedQuery = "SELECT u FROM User u WHERE u.username = :username";
//         assertEquals(expectedQuery, queryAnnotation.value(), "The query string does not match the expected value.");

//         // Print confirmation
//         // Print confirmation
//         System.out.println("Query string verified: " + queryAnnotation.value());
//     }
    
//     @Test
//     @Order(29)
//     void PaginateSorting_testPaginateAndSortUserController() throws Exception {
//     // Path to the UserController file
//     Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Controller/UserController.java");

//     // Read the content of the entity file as a string
//     String entityFileContent = Files.readString(entityFilePath);

//     // Check if pagination and sorting endpoint exists
//     assertTrue(entityFileContent.contains("public ResponseEntity<Page<User>> getAllUsersPaginateAndSort"),
//             "UserController should contain /paginate endpoint for pagination and sorting");
//     }

//     @Test
//     @Order(30)
//     void PaginateSorting_testPaginateAndSortUserService() throws Exception {
//         // Path to the UserService file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Service/UserService.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if pagination and sorting method exists in the service
//         assertTrue(entityFileContent.contains("public Page<User> getAllUsersPaginateAndSort"),
//                 "UserService should contain getAllUsersPaginateAndSort method for pagination and sorting");
//     }

//     @Test
//     @Order(31)
//     void MAPPING_testHistoryEntityContainsJoinColumnAnnotation() throws Exception {
//         // Path to the User entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/History.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if the @JoinTable annotation exists in the User entity file
//         assertTrue(entityFileContent.contains("@JoinColumn"), "History entity should contain @JoinColumn annotation for mapping relationships");
//     }

//     @Test
//     @Order(32)
//     void MAPPING_testFlightEntityContainsOneToManyAnnotation() throws Exception {
//         // Path to the Flight entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/Flight.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if the @ManyToMany annotation exists in the Flight entity file
//         assertTrue(entityFileContent.contains("@OneToMany"), "Flight entity should contain @OneToMany annotation for relationships");
//     }

//     @Test
//     @Order(33)
//     void MAPPING_testHistoryEntityContainsManyToOneAnnotation() throws Exception {
//         // Path to the History entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/History.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if the @ManyToOne annotation exists in the History entity file
//         assertTrue(entityFileContent.contains("@ManyToOne"), "History entity should contain @ManyToOne annotation for relationships");
//     }

//     @Test
//     @Order(34)
//     void MAPPING_testHistoryEntityContainsColumnAnnotation() throws Exception {
//         // Path to the History entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/History.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if the @Column annotation exists in the History entity file
//         assertTrue(entityFileContent.contains("@Column"), "History entity should contain @Column annotation for field mapping");
//     }

//     @Test
//     @Order(35)
//     void MAPPING_testUserEntityContainsOneToManyAnnotation() throws Exception {
//         // Path to the User entity file
//         Path entityFilePath = Paths.get("src/main/java/com/prjgrp/artf/Model/User.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Check if the @OneToMany annotation exists in the User entity file
//         assertTrue(entityFileContent.contains("@OneToMany"), "User entity should contain @OneToMany annotation for relationships");
//     }
    
//     @Test
//     @Order(36)
//     public void SwaggerUI_testConfigurationFolder() { 
//         String directoryPath = "src/main/java/com/prjgrp/artf/configuration"; // Replace with the path to your directory 
//         File directory = new File(directoryPath); 
//         assertTrue(directory.exists() && directory.isDirectory(), "The specified configuration folder should exist and be a directory.");
//     }

//     @Test
//     @Order(37)
//     public void SwaggerUI_testCustomOpenAPIBeanCreation() {
//         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwaggerConfig.class);
//         OpenAPI openAPI = context.getBean(OpenAPI.class);

//         assertNotNull(openAPI, "OpenAPI bean should not be null.");
//         Info info = openAPI.getInfo();
//         assertNotNull(info, "OpenAPI Info should not be null.");
//         assertEquals("My API", info.getTitle(), "API title should match the expected value.");
//         assertEquals("1.0", info.getVersion(), "API version should match the expected value.");
//         assertEquals("API documentation using Swagger", info.getDescription(), "API description should match the expected value.");
//         context.close();
//     }

//     @Test
//     @Order(38)
//     public void SwaggerUI_testCustomOpenAPIMethodIsAnnotatedWithBean() throws NoSuchMethodException {
//         Method method = SwaggerConfig.class.getDeclaredMethod("customOpenAPI");
//         Bean beanAnnotation = method.getAnnotation(Bean.class);
//         assertTrue(beanAnnotation != null, "customOpenAPI method should be annotated with @Bean.");
//     }

//     @Test
//     @Order(39)
//     public void SwaggerUI_testConfigurationAnnotation() {
//         Configuration configurationAnnotation = SwaggerConfig.class.getAnnotation(Configuration.class);
//         assertTrue(configurationAnnotation != null, "SwaggerConfig should be annotated with @Configuration.");
//     }

//     @Test
//     @Order(40)
//     public void Log_testLogFolderAndFileCreation() {
//         // Check if the "logs" folder exists
//         File logFolder = new File(LOG_FOLDER_PATH);
//         assertTrue(logFolder.exists(), "Log folder should be created");

//         // Check if the "application.log" file exists inside the "logs" folder
//         File logFile = new File(LOG_FILE_PATH);
//         assertTrue(logFile.exists(), "Log file should be created inside 'logs' folder");
//     }

//     @Test
//     @Order(41)
//     void AOP_testAOPConfigFile() {
//         // Path to the LoggingAspect class file
//         String filePath = "src/main/java/com/prjgrp/artf/aspect/LoggingAspect.java";

//         // Create a File object
//         File file = new File(filePath);

//         // Assert that the file exists and is a valid file
//         assertTrue(file.exists() && file.isFile(), "LoggingAspect.java file should exist at the specified path.");
//     }

//     @Test
//     @Order(42)
//     void AOP_testAOPConfigFileAspect() throws Exception {
//         // Path to the LoggingAspect class file
//         Path aspectFilePath = Paths.get("src/main/java/com/prjgrp/artf/aspect/LoggingAspect.java");

//         // Read the content of the aspect file
//         String aspectFileContent = Files.readString(aspectFilePath);

//         // Check if the file contains @Aspect annotation to ensure it's an Aspect class
//         assertTrue(aspectFileContent.contains("@Aspect"), "The LoggingAspect.java should be annotated with @Aspect.");

//         // Check if the file contains the logger definition to ensure logging functionality is implemented
//         assertTrue(aspectFileContent.contains("private static final Logger logger"), "The LoggingAspect.java should define a logger for logging.");
//     }

//     @Test
//     @Order(43)
//     void AOP_testAspectMethods() throws Exception {
//         // Path to the LoggingAspect class file
//         Path aspectFilePath = Paths.get("src/main/java/com/prjgrp/artf/aspect/LoggingAspect.java");

//         // Read the content of the aspect file
//         String aspectFileContent = Files.readString(aspectFilePath);

//         // Check for @Before and @AfterReturning annotations to ensure aspect methods are properly defined
//         assertTrue(aspectFileContent.contains("@Before"), "@Before annotation should be present in the LoggingAspect.java");
//         assertTrue(aspectFileContent.contains("@AfterReturning"), "@AfterReturning annotation should be present in the LoggingAspect.java");
//     }

//     @Test
//     @Order(44)
//     void AOP_testLoggingStatements() throws Exception {
//         // Path to the LoggingAspect class file
//         Path aspectFilePath = Paths.get("src/main/java/com/prjgrp/artf/aspect/LoggingAspect.java");

//         // Read the content of the aspect file
//         String aspectFileContent = Files.readString(aspectFilePath);

//         // Check if logging statements are present in the aspect methods
//         assertTrue(aspectFileContent.contains("logger.info"), "The LoggingAspect.java should contain logger.info statements for logging.");
//     }
// }
