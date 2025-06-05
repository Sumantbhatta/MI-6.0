package com.machinarymgmt.service.api.components;

import com.machinarymgmt.service.api.data.*;
import com.machinarymgmt.service.api.data.model.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final DesignationRepository designationRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final EquipmentCategoryRepository equipmentCategoryRepository;
    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;
    private final EquipmentRepository equipmentRepository;
    private final EmployeeAssignmentRepository employeeAssignmentRepository;
    private final EquipmentUtilizationRepository equipmentUtilizationRepository;
    private final IncidentReportRepository incidentReportRepository;
    private final ItemRepository itemRepository;
    private final MachineryMaintenanceLogRepository machineryMaintenanceLogRepository;
    private final MaintenancePartsUsedRepository maintenancePartsUsedRepository;
    private final MaintenanceReadingRepository maintenanceReadingRepository;
    private final MastAnchorageDetailsRepository mastAnchorageDetailsRepository;
    private final MaterialsConsumptionTransactionRepository materialsConsumptionTransactionRepository;
    private final OvertimeReportRepository overtimeReportRepository;
    private final PettyCashTransactionRepository pettyCashTransactionRepository;
    private final StockStatementRepository stockStatementRepository;
//    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) {
        log.info("Initializing database with sample data...");

        // Clear existing data
        clearData();

        // Initialize data in order of dependencies
        initializeDepartments();
        initializeDesignations();
        initializeEmployees();
        initializeProjects();
        initializeEquipmentCategories();
        initializeMakes();
        initializeModels();
        initializeEquipment();
        initializeEmployeeAssignments();
        initializeItems();
        initializeEquipmentUtilizations();
        initializeIncidentReports();
        initializeMachineryMaintenanceLogs();
        initializeMaintenanceReadings();
        initializeMaintenancePartsUsed();
        initializeMastAnchorageDetails();
        initializeMaterialsConsumptionTransactions();
        initializeOvertimeReports();
        initializePettyCashTransactions();
        initializeStockStatements();
//        initializeUsers();

        log.info("Database initialization completed successfully!");
    }

    private void clearData() {
        // Clear data in reverse order of dependencies
        stockStatementRepository.deleteAll();
        pettyCashTransactionRepository.deleteAll();
        overtimeReportRepository.deleteAll();
        materialsConsumptionTransactionRepository.deleteAll();
        mastAnchorageDetailsRepository.deleteAll();
        maintenancePartsUsedRepository.deleteAll();
        maintenanceReadingRepository.deleteAll();
        machineryMaintenanceLogRepository.deleteAll();
        incidentReportRepository.deleteAll();
        equipmentUtilizationRepository.deleteAll();
        employeeAssignmentRepository.deleteAll();
        equipmentRepository.deleteAll();
        modelRepository.deleteAll();
        makeRepository.deleteAll();
        equipmentCategoryRepository.deleteAll();
        itemRepository.deleteAll();
        projectRepository.deleteAll();
        employeeRepository.deleteAll();
        designationRepository.deleteAll();
        departmentRepository.deleteAll();
//        userRepository.deleteAll();
    }

    private void initializeDepartments() {
        log.info("Initializing Departments...");
        Department dept1 = Department.builder()
                .name("Engineering")
                .description("Engineering Department")
                .build();
        Department dept2 = Department.builder()
                .name("Operations")
                .description("Operations Department")
                .build();
        Department dept3 = Department.builder()
                .name("Procurement")
                .description("Procurement Department")
                .build();
        Department dept4 = Department.builder()
                .name("Finance")
                .description("Finance Department")
                .build();
        Department dept5 = Department.builder()
                .name("HR")
                .description("Human Resources Department")
                .build();
        Department dept6 = Department.builder()
                .name("Logistics")
                .description("Logistics Department")
                .build();
        departmentRepository.saveAll(Arrays.asList(dept1, dept2, dept3, dept4, dept5, dept6));
    }

    private void initializeDesignations() {
        log.info("Initializing Designations...");
        Designation designation1 = Designation.builder()
                .name("Project Manager")
                .description("Manages projects and teams")
                .build();
        Designation designation2 = Designation.builder()
                .name("Equipment Operator")
                .description("Operates heavy machinery")
                .build();
        Designation designation3 = Designation.builder()
                .name("Site Engineer")
                .description("Supervises site work")
                .build();
        Designation designation4 = Designation.builder()
                .name("Accountant")
                .description("Handles accounts")
                .build();
        Designation designation5 = Designation.builder()
                .name("HR Executive")
                .description("Manages HR tasks")
                .build();
        Designation designation6 = Designation.builder()
                .name("Store Keeper")
                .description("Manages inventory")
                .build();
        designationRepository.saveAll(Arrays.asList(designation1, designation2, designation3, designation4, designation5, designation6));
    }

    private void initializeEmployees() {
        log.info("Initializing Employees...");
        Department dept1 = departmentRepository.findByName("Engineering");
        Department dept2 = departmentRepository.findByName("Operations");
        Department dept3 = departmentRepository.findByName("Procurement");
        Department dept4 = departmentRepository.findByName("Finance");
        Department dept5 = departmentRepository.findByName("HR");
        Department dept6 = departmentRepository.findByName("Logistics");

        Designation designation1 = designationRepository.findByName("Project Manager");
        Designation designation2 = designationRepository.findByName("Equipment Operator");
        Designation designation3 = designationRepository.findByName("Site Engineer");
        Designation designation4 = designationRepository.findByName("Accountant");
        Designation designation5 = designationRepository.findByName("HR Executive");
        Designation designation6 = designationRepository.findByName("Store Keeper");

        Employee employee1 = Employee.builder()
                .name("John Doe")
                .department(dept1)
                .designation(designation1)
                .remarks("Senior employee")
                .build();
        Employee employee2 = Employee.builder()
                .name("Jane Smith")
                .department(dept2)
                .designation(designation2)
                .remarks("Experienced operator")
                .build();
        Employee employee3 = Employee.builder()
                .name("Alice Brown")
                .department(dept3)
                .designation(designation3)
                .remarks("Site supervisor")
                .build();
        Employee employee4 = Employee.builder()
                .name("Bob White")
                .department(dept4)
                .designation(designation4)
                .remarks("Finance expert")
                .build();
        Employee employee5 = Employee.builder()
                .name("Carol Green")
                .department(dept5)
                .designation(designation5)
                .remarks("HR specialist")
                .build();
        Employee employee6 = Employee.builder()
                .name("David Black")
                .department(dept6)
                .designation(designation6)
                .remarks("Inventory manager")
                .build();
        employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6));
    }

    private void initializeProjects() {
        log.info("Initializing Projects...");
        Project project1 = Project.builder()
                .name("Highway Construction")
                .location("North Region")
                .description("Construction of 50km highway")
                .startDate("2023-01-01")
                .endDate("2024-12-31")
                .status("ACTIVE")
                .build();
        Project project2 = Project.builder()
                .name("Bridge Renovation")
                .location("South Region")
                .description("Renovation of old bridge")
                .startDate("2023-03-15")
                .endDate("2023-12-31")
                .status("PLANNING")
                .build();
        Project project3 = Project.builder()
                .name("Warehouse Expansion")
                .location("East Region")
                .description("Expansion of storage warehouse")
                .startDate("2023-05-01")
                .endDate("2024-05-31")
                .status("ACTIVE")
                .build();
        Project project4 = Project.builder()
                .name("Office Complex")
                .location("West Region")
                .description("Construction of new office complex")
                .startDate("2023-06-01")
                .endDate("2025-01-31")
                .status("PLANNING")
                .build();
        Project project5 = Project.builder()
                .name("Dam Repair")
                .location("Central Region")
                .description("Repair of main dam structure")
                .startDate("2023-07-01")
                .endDate("2024-07-31")
                .status("ACTIVE")
                .build();
        Project project6 = Project.builder()
                .name("Pipeline Installation")
                .location("Southwest Region")
                .description("Installation of water pipeline")
                .startDate("2023-08-01")
                .endDate("2024-08-31")
                .status("PLANNING")
                .build();
        projectRepository.saveAll(Arrays.asList(project1, project2, project3, project4, project5, project6));
    }

    private void initializeEquipmentCategories() {
        log.info("Initializing Equipment Categories...");
        EquipmentCategory category1 = EquipmentCategory.builder()
                .name("Heavy Machinery")
                .build();
        EquipmentCategory category2 = EquipmentCategory.builder()
                .name("Light Equipment")
                .build();
        EquipmentCategory category3 = EquipmentCategory.builder()
                .name("Power Tools")
                .build();
        EquipmentCategory category4 = EquipmentCategory.builder()
                .name("Vehicles")
                .build();
        EquipmentCategory category5 = EquipmentCategory.builder()
                .name("Lifting Equipment")
                .build();
        EquipmentCategory category6 = EquipmentCategory.builder()
                .name("Survey Instruments")
                .build();
        equipmentCategoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4, category5, category6));
    }

    private void initializeMakes() {
        log.info("Initializing Makes...");
        Make make1 = Make.builder()
                .name("Caterpillar")
                .build();
        Make make2 = Make.builder()
                .name("Komatsu")
                .build();
        Make make3 = Make.builder()
                .name("Volvo")
                .build();
        Make make4 = Make.builder()
                .name("JCB")
                .build();
        Make make5 = Make.builder()
                .name("Hitachi")
                .build();
        Make make6 = Make.builder()
                .name("Hyundai")
                .build();
        makeRepository.saveAll(Arrays.asList(make1, make2, make3, make4, make5, make6));
    }

    private void initializeModels() {
        log.info("Initializing Models...");
        Make make1 = makeRepository.findByName("Caterpillar");
        Make make2 = makeRepository.findByName("Komatsu");
        Make make3 = makeRepository.findByName("Volvo");
        Make make4 = makeRepository.findByName("JCB");
        Make make5 = makeRepository.findByName("Hitachi");
        Make make6 = makeRepository.findByName("Hyundai");

        Model model1 = Model.builder()
                .name("CAT-320")
                .make(make1)
                .build();
        Model model2 = Model.builder()
                .name("PC-200")
                .make(make2)
                .build();
        Model model3 = Model.builder()
                .name("EC-210")
                .make(make3)
                .build();
        Model model4 = Model.builder()
                .name("JS-220")
                .make(make4)
                .build();
        Model model5 = Model.builder()
                .name("ZX-200")
                .make(make5)
                .build();
        Model model6 = Model.builder()
                .name("R-220")
                .make(make6)
                .build();
        modelRepository.saveAll(Arrays.asList(model1, model2, model3, model4, model5, model6));
    }

    private void initializeEquipment() {
        log.info("Initializing Equipment...");
        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        EquipmentCategory category1 = equipmentCategoryRepository.findByName("Heavy Machinery");
        EquipmentCategory category2 = equipmentCategoryRepository.findByName("Light Equipment");
        EquipmentCategory category3 = equipmentCategoryRepository.findByName("Power Tools");
        EquipmentCategory category4 = equipmentCategoryRepository.findByName("Vehicles");
        EquipmentCategory category5 = equipmentCategoryRepository.findByName("Lifting Equipment");
        EquipmentCategory category6 = equipmentCategoryRepository.findByName("Survey Instruments");

        Model model1 = modelRepository.findByName("CAT-320");
        Model model2 = modelRepository.findByName("PC-200");
        Model model3 = modelRepository.findByName("EC-210");
        Model model4 = modelRepository.findByName("JS-220");
        Model model5 = modelRepository.findByName("ZX-200");
        Model model6 = modelRepository.findByName("R-220");

        Equipment equipment1 = Equipment.builder()
                .name("Excavator 1")
                .project(project1)
                .category(category1)
                .model(model1)
                .assetCode("EX-001")
                .yearOfManufacture(2020)
                .build();
        Equipment equipment2 = Equipment.builder()
                .name("Bulldozer 1")
                .project(project2)
                .category(category2)
                .model(model2)
                .assetCode("BD-001")
                .yearOfManufacture(2019)
                .build();
        Equipment equipment3 = Equipment.builder()
                .name("Loader 1")
                .project(project3)
                .category(category3)
                .model(model3)
                .assetCode("LD-001")
                .yearOfManufacture(2021)
                .build();
        Equipment equipment4 = Equipment.builder()
                .name("Crane 1")
                .project(project4)
                .category(category4)
                .model(model4)
                .assetCode("CR-001")
                .yearOfManufacture(2022)
                .build();
        Equipment equipment5 = Equipment.builder()
                .name("Forklift 1")
                .project(project5)
                .category(category5)
                .model(model5)
                .assetCode("FL-001")
                .yearOfManufacture(2020)
                .build();
        Equipment equipment6 = Equipment.builder()
                .name("Surveyor 1")
                .project(project6)
                .category(category6)
                .model(model6)
                .assetCode("SV-001")
                .yearOfManufacture(2023)
                .build();
        equipmentRepository.saveAll(Arrays.asList(equipment1, equipment2, equipment3, equipment4, equipment5, equipment6));
    }

    private void initializeEmployeeAssignments() {
        log.info("Initializing Employee Assignments...");
        Employee employee1 = employeeRepository.findByName("John Doe");
        Employee employee2 = employeeRepository.findByName("Jane Smith");
        Employee employee3 = employeeRepository.findByName("Alice Brown");
        Employee employee4 = employeeRepository.findByName("Bob White");
        Employee employee5 = employeeRepository.findByName("Carol Green");
        Employee employee6 = employeeRepository.findByName("David Black");

        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        EmployeeAssignment assignment1 = EmployeeAssignment.builder()
                .employee(employee1)
                .project(project1)
                .equipment(equipment1)
                .joiningDate(LocalDate.of(2023, 1, 15))
                .build();
        EmployeeAssignment assignment2 = EmployeeAssignment.builder()
                .employee(employee2)
                .project(project2)
                .equipment(equipment2)
                .joiningDate(LocalDate.of(2023, 3, 20))
                .build();
        EmployeeAssignment assignment3 = EmployeeAssignment.builder()
                .employee(employee3)
                .project(project3)
                .equipment(equipment3)
                .joiningDate(LocalDate.of(2023, 4, 10))
                .build();
        EmployeeAssignment assignment4 = EmployeeAssignment.builder()
                .employee(employee4)
                .project(project4)
                .equipment(equipment4)
                .joiningDate(LocalDate.of(2023, 5, 5))
                .build();
        EmployeeAssignment assignment5 = EmployeeAssignment.builder()
                .employee(employee5)
                .project(project5)
                .equipment(equipment5)
                .joiningDate(LocalDate.of(2023, 6, 1))
                .build();
        EmployeeAssignment assignment6 = EmployeeAssignment.builder()
                .employee(employee6)
                .project(project6)
                .equipment(equipment6)
                .joiningDate(LocalDate.of(2023, 7, 1))
                .build();
        employeeAssignmentRepository.saveAll(Arrays.asList(assignment1, assignment2, assignment3, assignment4, assignment5, assignment6));
    }

    private void initializeItems() {
        log.info("Initializing Items...");
        Item item1 = Item.builder()
                .code("MAT-001")
                .description("Cement")
                .uom("Bags")
                .type(Item.ItemType.MATERIAL)
                .build();
        Item item2 = Item.builder()
                .code("SPR-001")
                .description("Hydraulic Oil")
                .uom("Liters")
                .type(Item.ItemType.SPARE)
                .build();
        Item item3 = Item.builder()
                .code("MAT-002")
                .description("Steel Rods")
                .uom("Tons")
                .type(Item.ItemType.MATERIAL)
                .build();
        Item item4 = Item.builder()
                .code("SPR-002")
                .description("Engine Oil")
                .uom("Liters")
                .type(Item.ItemType.SPARE)
                .build();
        Item item5 = Item.builder()
                .code("MAT-003")
                .description("Sand")
                .uom("Cubic Meters")
                .type(Item.ItemType.MATERIAL)
                .build();
        Item item6 = Item.builder()
                .code("SPR-003")
                .description("Coolant")
                .uom("Liters")
                .type(Item.ItemType.SPARE)
                .build();
        itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5, item6));
    }

    private void initializeEquipmentUtilizations() {
        log.info("Initializing Equipment Utilizations...");
        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        EquipmentUtilization utilization1 = EquipmentUtilization.builder()
                .equipment(equipment1)
                .project(project1)
                .month(4)
                .year(2023)
                .targetHoursKms(new BigDecimal("200.00"))
                .startingHoursKms(new BigDecimal("1000.00"))
                .closingHoursKms(new BigDecimal("1150.00"))
                .breakdownHoursKms(new BigDecimal("10.00"))
                .dieselConsumedLtrs(new BigDecimal("500.00"))
                .avgFuelConsumption(new BigDecimal("3.33"))
                .availabilityHours(new BigDecimal("190.00"))
                .utilizationPercentage(new BigDecimal("95.00"))
                .remarks("Good performance")
                .build();
        EquipmentUtilization utilization2 = EquipmentUtilization.builder()
                .equipment(equipment2)
                .project(project2)
                .month(4)
                .year(2023)
                .targetHoursKms(new BigDecimal("180.00"))
                .startingHoursKms(new BigDecimal("800.00"))
                .closingHoursKms(new BigDecimal("920.00"))
                .breakdownHoursKms(new BigDecimal("15.00"))
                .dieselConsumedLtrs(new BigDecimal("450.00"))
                .avgFuelConsumption(new BigDecimal("3.75"))
                .availabilityHours(new BigDecimal("165.00"))
                .utilizationPercentage(new BigDecimal("91.67"))
                .remarks("Satisfactory performance")
                .build();
        EquipmentUtilization utilization3 = EquipmentUtilization.builder()
                .equipment(equipment3)
                .project(project3)
                .month(4)
                .year(2023)
                .targetHoursKms(new BigDecimal("150.00"))
                .startingHoursKms(new BigDecimal("600.00"))
                .closingHoursKms(new BigDecimal("750.00"))
                .breakdownHoursKms(new BigDecimal("8.00"))
                .dieselConsumedLtrs(new BigDecimal("300.00"))
                .avgFuelConsumption(new BigDecimal("2.50"))
                .availabilityHours(new BigDecimal("142.00"))
                .utilizationPercentage(new BigDecimal("94.67"))
                .remarks("Efficient usage")
                .build();
        EquipmentUtilization utilization4 = EquipmentUtilization.builder()
                .equipment(equipment4)
                .project(project4)
                .month(4)
                .year(2023)
                .targetHoursKms(new BigDecimal("170.00"))
                .startingHoursKms(new BigDecimal("900.00"))
                .closingHoursKms(new BigDecimal("1050.00"))
                .breakdownHoursKms(new BigDecimal("12.00"))
                .dieselConsumedLtrs(new BigDecimal("400.00"))
                .avgFuelConsumption(new BigDecimal("3.00"))
                .availabilityHours(new BigDecimal("158.00"))
                .utilizationPercentage(new BigDecimal("92.94"))
                .remarks("Smooth operation")
                .build();
        EquipmentUtilization utilization5 = EquipmentUtilization.builder()
                .equipment(equipment5)
                .project(project5)
                .month(4)
                .year(2023)
                .targetHoursKms(new BigDecimal("160.00"))
                .startingHoursKms(new BigDecimal("700.00"))
                .closingHoursKms(new BigDecimal("860.00"))
                .breakdownHoursKms(new BigDecimal("9.00"))
                .dieselConsumedLtrs(new BigDecimal("350.00"))
                .avgFuelConsumption(new BigDecimal("2.80"))
                .availabilityHours(new BigDecimal("151.00"))
                .utilizationPercentage(new BigDecimal("94.38"))
                .remarks("Minimal downtime")
                .build();
        EquipmentUtilization utilization6 = EquipmentUtilization.builder()
                .equipment(equipment6)
                .project(project6)
                .month(4)
                .year(2023)
                .targetHoursKms(new BigDecimal("140.00"))
                .startingHoursKms(new BigDecimal("500.00"))
                .closingHoursKms(new BigDecimal("640.00"))
                .breakdownHoursKms(new BigDecimal("7.00"))
                .dieselConsumedLtrs(new BigDecimal("250.00"))
                .avgFuelConsumption(new BigDecimal("2.20"))
                .availabilityHours(new BigDecimal("133.00"))
                .utilizationPercentage(new BigDecimal("95.00"))
                .remarks("Optimal performance")
                .build();
        equipmentUtilizationRepository.saveAll(Arrays.asList(utilization1, utilization2, utilization3, utilization4, utilization5, utilization6));
    }

    private void initializeIncidentReports() {
        log.info("Initializing Incident Reports...");
        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        IncidentReport incident1 = IncidentReport.builder()
                .equipment(equipment1)
                .project(project1)
                .incidentType(IncidentReport.IncidentType.MECHANICAL_FAILURE)
                .incidentDetails("Hydraulic system failure")
                .incidentDate(LocalDate.of(2023, 4, 10))
                .actionTaken("Replaced hydraulic hose")
                .estimatedCompletionDate(LocalDate.of(2023, 4, 12))
                .closedDate(LocalDate.of(2023, 4, 11))
                .status(IncidentReport.Status.CLOSED)
                .build();
        IncidentReport incident2 = IncidentReport.builder()
                .equipment(equipment2)
                .project(project2)
                .incidentType(IncidentReport.IncidentType.ELECTRICAL_FAILURE)
                .incidentDetails("Engine overheating")
                .incidentDate(LocalDate.of(2023, 4, 15))
                .actionTaken("Cooling system repair in progress")
                .estimatedCompletionDate(LocalDate.of(2023, 4, 18))
                .closedDate(LocalDate.of(2023, 7, 11))
                .status(IncidentReport.Status.IN_PROGRESS)
                .build();
        IncidentReport incident3 = IncidentReport.builder()
                .equipment(equipment3)
                .project(project3)
                .incidentType(IncidentReport.IncidentType.MECHANICAL_FAILURE)
                .incidentDetails("Transmission failure")
                .incidentDate(LocalDate.of(2023, 4, 20))
                .actionTaken("Transmission replaced")
                .estimatedCompletionDate(LocalDate.of(2023, 4, 22))
                .closedDate(LocalDate.of(2023, 4, 21))
                .status(IncidentReport.Status.CLOSED)
                .build();
        IncidentReport incident4 = IncidentReport.builder()
                .equipment(equipment4)
                .project(project4)
                .incidentType(IncidentReport.IncidentType.ELECTRICAL_FAILURE)
                .incidentDetails("Battery malfunction")
                .incidentDate(LocalDate.of(2023, 4, 25))
                .actionTaken("Battery replaced")
                .estimatedCompletionDate(LocalDate.of(2023, 4, 27))
                .closedDate(LocalDate.of(2023, 4, 26))
                .status(IncidentReport.Status.CLOSED)
                .build();
        IncidentReport incident5 = IncidentReport.builder()
                .equipment(equipment5)
                .project(project5)
                .incidentType(IncidentReport.IncidentType.MECHANICAL_FAILURE)
                .incidentDetails("Brake system failure")
                .incidentDate(LocalDate.of(2023, 4, 30))
                .actionTaken("Brake pads replaced")
                .estimatedCompletionDate(LocalDate.of(2023, 5, 2))
                .closedDate(LocalDate.of(2023, 5, 1))
                .status(IncidentReport.Status.CLOSED)
                .build();
        IncidentReport incident6 = IncidentReport.builder()
                .equipment(equipment6)
                .project(project6)
                .incidentType(IncidentReport.IncidentType.ELECTRICAL_FAILURE)
                .incidentDetails("Sensor malfunction")
                .incidentDate(LocalDate.of(2023, 5, 5))
                .actionTaken("Sensor replaced")
                .estimatedCompletionDate(LocalDate.of(2023, 5, 7))
                .closedDate(LocalDate.of(2023, 5, 6))
                .status(IncidentReport.Status.CLOSED)
                .build();
        incidentReportRepository.saveAll(Arrays.asList(incident1, incident2, incident3, incident4, incident5, incident6));
    }

    private void initializeMachineryMaintenanceLogs() {
        log.info("Initializing Machinery Maintenance Logs...");
        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        MachineryMaintenanceLog log1 = MachineryMaintenanceLog.builder()
                .equipment(equipment1)
                .date(LocalDate.of(2023, 4, 5))
                .startReading(1000)
                .closeReading(1050)
                .serviceHours(250)
                .serviceDate(LocalDate.of(2023, 4, 5))
                .balanceForService(200)
                .purposeActivities("Regular maintenance")
                .typeOfMaintenance("Preventive")
                .operatorName("John Doe")
                .operatorSignature("JD")
                .breakdownSynopsis("Oil leak from hydraulic pipe")
                .maintenanceSignature("MT")
                .feedback("Good condition")
                .remarks("No issues found")
                .build();
        MachineryMaintenanceLog log2 = MachineryMaintenanceLog.builder()
                .equipment(equipment2)
                .date(LocalDate.of(2023, 4, 8))
                .startReading(800)
                .closeReading(850)
                .serviceHours(200)
                .serviceDate(LocalDate.of(2023, 4, 8))
                .balanceForService(150)
                .purposeActivities("Oil change")
                .typeOfMaintenance("Preventive")
                .operatorName("Jane Smith")
                .operatorSignature("JS")
                .breakdownSynopsis("Control panel fuse blown")
                .maintenanceSignature("MT")
                .feedback("Satisfactory")
                .remarks("Oil filter replaced")
                .build();
        MachineryMaintenanceLog log3 = MachineryMaintenanceLog.builder()
                .equipment(equipment3)
                .date(LocalDate.of(2023, 4, 12))
                .startReading(600)
                .closeReading(650)
                .serviceHours(180)
                .serviceDate(LocalDate.of(2023, 4, 12))
                .balanceForService(120)
                .purposeActivities("Filter replacement")
                .typeOfMaintenance("Preventive")
                .operatorName("Alice Brown")
                .operatorSignature("AB")
                .breakdownSynopsis("Air filter clogged")
                .maintenanceSignature("MT")
                .feedback("Good")
                .remarks("Air filter replaced")
                .build();
        MachineryMaintenanceLog log4 = MachineryMaintenanceLog.builder()
                .equipment(equipment4)
                .date(LocalDate.of(2023, 4, 15))
                .startReading(900)
                .closeReading(950)
                .serviceHours(220)
                .serviceDate(LocalDate.of(2023, 4, 15))
                .balanceForService(180)
                .purposeActivities("Belt inspection")
                .typeOfMaintenance("Preventive")
                .operatorName("Bob White")
                .operatorSignature("BW")
                .breakdownSynopsis("Belt wear")
                .maintenanceSignature("MT")
                .feedback("Satisfactory")
                .remarks("Belt replaced")
                .build();
        MachineryMaintenanceLog log5 = MachineryMaintenanceLog.builder()
                .equipment(equipment5)
                .date(LocalDate.of(2023, 4, 18))
                .startReading(700)
                .closeReading(750)
                .serviceHours(190)
                .serviceDate(LocalDate.of(2023, 4, 18))
                .balanceForService(160)
                .purposeActivities("Battery check")
                .typeOfMaintenance("Preventive")
                .operatorName("Carol Green")
                .operatorSignature("CG")
                .breakdownSynopsis("Battery low")
                .maintenanceSignature("MT")
                .feedback("Good")
                .remarks("Battery charged")
                .build();
        MachineryMaintenanceLog log6 = MachineryMaintenanceLog.builder()
                .equipment(equipment6)
                .date(LocalDate.of(2023, 4, 22))
                .startReading(500)
                .closeReading(550)
                .serviceHours(150)
                .serviceDate(LocalDate.of(2023, 4, 22))
                .balanceForService(130)
                .purposeActivities("Calibration")
                .typeOfMaintenance("Preventive")
                .operatorName("David Black")
                .operatorSignature("DB")
                .breakdownSynopsis("Calibration drift")
                .maintenanceSignature("MT")
                .feedback("Satisfactory")
                .remarks("Calibration adjusted")
                .build();
        machineryMaintenanceLogRepository.saveAll(Arrays.asList(log1, log2, log3, log4, log5, log6));
    }

    private void initializeMaintenanceReadings() {
        log.info("Initializing Maintenance Readings...");
        MachineryMaintenanceLog log1 = machineryMaintenanceLogRepository.findAll().get(0);
        MachineryMaintenanceLog log2 = machineryMaintenanceLogRepository.findAll().get(1);
        MachineryMaintenanceLog log3 = machineryMaintenanceLogRepository.findAll().get(2);
        MachineryMaintenanceLog log4 = machineryMaintenanceLogRepository.findAll().get(3);
        MachineryMaintenanceLog log5 = machineryMaintenanceLogRepository.findAll().get(4);
        MachineryMaintenanceLog log6 = machineryMaintenanceLogRepository.findAll().get(5);

        MaintenanceReading reading1 = MaintenanceReading.builder()
                .maintenanceLog(log1)
                .oilPressure(new BigDecimal("45.5"))
                .engineTemperature(new BigDecimal("85.0"))
                .airPressure(new BigDecimal("30.0"))
                .hydraulicTemperature(new BigDecimal("65.0"))
                .hsdUsed(new BigDecimal("25.0"))
                .engineOil(new BigDecimal("5.0"))
                .hydraulicOil(new BigDecimal("10.0"))
                .gearOil(new BigDecimal("3.0"))
                .greaseUsed(new BigDecimal("2.0"))
                .build();
        MaintenanceReading reading2 = MaintenanceReading.builder()
                .maintenanceLog(log2)
                .oilPressure(new BigDecimal("42.0"))
                .engineTemperature(new BigDecimal("82.0"))
                .airPressure(new BigDecimal("28.5"))
                .hydraulicTemperature(new BigDecimal("62.0"))
                .hsdUsed(new BigDecimal("22.0"))
                .engineOil(new BigDecimal("4.5"))
                .hydraulicOil(new BigDecimal("9.0"))
                .gearOil(new BigDecimal("2.5"))
                .greaseUsed(new BigDecimal("1.5"))
                .build();
        MaintenanceReading reading3 = MaintenanceReading.builder()
                .maintenanceLog(log3)
                .oilPressure(new BigDecimal("40.0"))
                .engineTemperature(new BigDecimal("80.0"))
                .airPressure(new BigDecimal("27.0"))
                .hydraulicTemperature(new BigDecimal("60.0"))
                .hsdUsed(new BigDecimal("20.0"))
                .engineOil(new BigDecimal("4.0"))
                .hydraulicOil(new BigDecimal("8.0"))
                .gearOil(new BigDecimal("2.0"))
                .greaseUsed(new BigDecimal("1.0"))
                .build();
        MaintenanceReading reading4 = MaintenanceReading.builder()
                .maintenanceLog(log4)
                .oilPressure(new BigDecimal("43.0"))
                .engineTemperature(new BigDecimal("83.0"))
                .airPressure(new BigDecimal("29.0"))
                .hydraulicTemperature(new BigDecimal("63.0"))
                .hsdUsed(new BigDecimal("23.0"))
                .engineOil(new BigDecimal("4.7"))
                .hydraulicOil(new BigDecimal("9.5"))
                .gearOil(new BigDecimal("2.7"))
                .greaseUsed(new BigDecimal("1.7"))
                .build();
        MaintenanceReading reading5 = MaintenanceReading.builder()
                .maintenanceLog(log5)
                .oilPressure(new BigDecimal("41.0"))
                .engineTemperature(new BigDecimal("81.0"))
                .airPressure(new BigDecimal("28.0"))
                .hydraulicTemperature(new BigDecimal("61.0"))
                .hsdUsed(new BigDecimal("21.0"))
                .engineOil(new BigDecimal("4.2"))
                .hydraulicOil(new BigDecimal("8.5"))
                .gearOil(new BigDecimal("2.2"))
                .greaseUsed(new BigDecimal("1.2"))
                .build();
        MaintenanceReading reading6 = MaintenanceReading.builder()
                .maintenanceLog(log6)
                .oilPressure(new BigDecimal("44.0"))
                .engineTemperature(new BigDecimal("84.0"))
                .airPressure(new BigDecimal("29.5"))
                .hydraulicTemperature(new BigDecimal("64.0"))
                .hsdUsed(new BigDecimal("24.0"))
                .engineOil(new BigDecimal("4.8"))
                .hydraulicOil(new BigDecimal("9.8"))
                .gearOil(new BigDecimal("2.8"))
                .greaseUsed(new BigDecimal("1.8"))
                .build();
        maintenanceReadingRepository.saveAll(Arrays.asList(reading1, reading2, reading3, reading4, reading5, reading6));
    }

    private void initializeMaintenancePartsUsed() {
        log.info("Initializing Maintenance Parts Used...");
        MachineryMaintenanceLog log1 = machineryMaintenanceLogRepository.findAll().get(0);
        MachineryMaintenanceLog log2 = machineryMaintenanceLogRepository.findAll().get(1);
        MachineryMaintenanceLog log3 = machineryMaintenanceLogRepository.findAll().get(2);
        MachineryMaintenanceLog log4 = machineryMaintenanceLogRepository.findAll().get(3);
        MachineryMaintenanceLog log5 = machineryMaintenanceLogRepository.findAll().get(4);
        MachineryMaintenanceLog log6 = machineryMaintenanceLogRepository.findAll().get(5);

        Item item1 = itemRepository.findByCode("MAT-001");
        Item item2 = itemRepository.findByCode("SPR-001");
        Item item3 = itemRepository.findByCode("MAT-002");
        Item item4 = itemRepository.findByCode("SPR-002");
        Item item5 = itemRepository.findByCode("MAT-003");
        Item item6 = itemRepository.findByCode("SPR-003");

        MaintenancePartsUsed partsUsed1 = MaintenancePartsUsed.builder()
                .maintenanceLog(log1)
                .item(item1)
                .quantity(new BigDecimal("2.0"))
                .build();
        MaintenancePartsUsed partsUsed2 = MaintenancePartsUsed.builder()
                .maintenanceLog(log2)
                .item(item2)
                .quantity(new BigDecimal("5.0"))
                .build();
        MaintenancePartsUsed partsUsed3 = MaintenancePartsUsed.builder()
                .maintenanceLog(log3)
                .item(item3)
                .quantity(new BigDecimal("3.0"))
                .build();
        MaintenancePartsUsed partsUsed4 = MaintenancePartsUsed.builder()
                .maintenanceLog(log4)
                .item(item4)
                .quantity(new BigDecimal("4.0"))
                .build();
        MaintenancePartsUsed partsUsed5 = MaintenancePartsUsed.builder()
                .maintenanceLog(log5)
                .item(item5)
                .quantity(new BigDecimal("2.5"))
                .build();
        MaintenancePartsUsed partsUsed6 = MaintenancePartsUsed.builder()
                .maintenanceLog(log6)
                .item(item6)
                .quantity(new BigDecimal("3.5"))
                .build();
        maintenancePartsUsedRepository.saveAll(Arrays.asList(partsUsed1, partsUsed2, partsUsed3, partsUsed4, partsUsed5, partsUsed6));
    }

    private void initializeMastAnchorageDetails() {
        log.info("Initializing Mast Anchorage Details...");
        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        MastAnchorageDetails details1 = MastAnchorageDetails.builder()
                .project(project1)
                .equipment(equipment1)
                .status("Active")
                .location("North Tower")
                .mastAvailableAtSite(5)
                .mastFixedAtSite(3)
                .mastIdleAtSite(2)
                .totalMastRequirement(6)
                .anchorageAtSite(8)
                .anchorageFixedAtSite(6)
                .anchorageIdleAtSite(2)
                .totalAnchorageRequirement(10)
                .presentHeightOfHoist("30m")
                .presentBuildingHeight("40m")
                .totalBuildingHeight("60m")
                .remarks("On schedule")
                .build();
        MastAnchorageDetails details2 = MastAnchorageDetails.builder()
                .project(project2)
                .equipment(equipment2)
                .status("Active")
                .location("South Tower")
                .mastAvailableAtSite(4)
                .mastFixedAtSite(2)
                .mastIdleAtSite(2)
                .totalMastRequirement(5)
                .anchorageAtSite(6)
                .anchorageFixedAtSite(4)
                .anchorageIdleAtSite(2)
                .totalAnchorageRequirement(8)
                .presentHeightOfHoist("25m")
                .presentBuildingHeight("35m")
                .totalBuildingHeight("50m")
                .remarks("Slight delay")
                .build();
        MastAnchorageDetails details3 = MastAnchorageDetails.builder()
                .project(project3)
                .equipment(equipment3)
                .status("Active")
                .location("East Tower")
                .mastAvailableAtSite(6)
                .mastFixedAtSite(4)
                .mastIdleAtSite(2)
                .totalMastRequirement(7)
                .anchorageAtSite(9)
                .anchorageFixedAtSite(7)
                .anchorageIdleAtSite(2)
                .totalAnchorageRequirement(11)
                .presentHeightOfHoist("35m")
                .presentBuildingHeight("45m")
                .totalBuildingHeight("70m")
                .remarks("On track")
                .build();
        MastAnchorageDetails details4 = MastAnchorageDetails.builder()
                .project(project4)
                .equipment(equipment4)
                .status("Active")
                .location("West Tower")
                .mastAvailableAtSite(5)
                .mastFixedAtSite(3)
                .mastIdleAtSite(2)
                .totalMastRequirement(6)
                .anchorageAtSite(8)
                .anchorageFixedAtSite(6)
                .anchorageIdleAtSite(2)
                .totalAnchorageRequirement(10)
                .presentHeightOfHoist("32m")
                .presentBuildingHeight("42m")
                .totalBuildingHeight("65m")
                .remarks("Smooth progress")
                .build();
        MastAnchorageDetails details5 = MastAnchorageDetails.builder()
                .project(project5)
                .equipment(equipment5)
                .status("Active")
                .location("Central Tower")
                .mastAvailableAtSite(4)
                .mastFixedAtSite(2)
                .mastIdleAtSite(2)
                .totalMastRequirement(5)
                .anchorageAtSite(7)
                .anchorageFixedAtSite(5)
                .anchorageIdleAtSite(2)
                .totalAnchorageRequirement(9)
                .presentHeightOfHoist("28m")
                .presentBuildingHeight("38m")
                .totalBuildingHeight("55m")
                .remarks("Minor issues")
                .build();
        MastAnchorageDetails details6 = MastAnchorageDetails.builder()
                .project(project6)
                .equipment(equipment6)
                .status("Active")
                .location("Southwest Tower")
                .mastAvailableAtSite(5)
                .mastFixedAtSite(3)
                .mastIdleAtSite(2)
                .totalMastRequirement(6)
                .anchorageAtSite(8)
                .anchorageFixedAtSite(6)
                .anchorageIdleAtSite(2)
                .totalAnchorageRequirement(10)
                .presentHeightOfHoist("30m")
                .presentBuildingHeight("40m")
                .totalBuildingHeight("60m")
                .remarks("On schedule")
                .build();
        mastAnchorageDetailsRepository.saveAll(Arrays.asList(details1, details2, details3, details4, details5, details6));
    }

    private void initializeMaterialsConsumptionTransactions() {
        log.info("Initializing Materials Consumption Transactions...");
        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        Item item1 = itemRepository.findByCode("MAT-001");
        Item item2 = itemRepository.findByCode("SPR-001");
        Item item3 = itemRepository.findByCode("MAT-002");
        Item item4 = itemRepository.findByCode("SPR-002");
        Item item5 = itemRepository.findByCode("MAT-003");
        Item item6 = itemRepository.findByCode("SPR-003");

        MaterialsConsumptionTransaction transaction1 = MaterialsConsumptionTransaction.builder()
                .project(project1)
                .issueDate(LocalDate.of(2023, 4, 10))
                .equipment(equipment1)
                .item(item1)
                .quantity(50)
                .costPerUnit(new BigDecimal("350.00"))
                .totalCost(new BigDecimal("17500.00"))
                .remarks("For foundation work")
                .createdAt(LocalDateTime.now())
                .build();
        MaterialsConsumptionTransaction transaction2 = MaterialsConsumptionTransaction.builder()
                .project(project2)
                .issueDate(LocalDate.of(2023, 4, 12))
                .equipment(equipment2)
                .item(item2)
                .quantity(20)
                .costPerUnit(new BigDecimal("500.00"))
                .totalCost(new BigDecimal("10000.00"))
                .remarks("For maintenance")
                .createdAt(LocalDateTime.now())
                .build();
        MaterialsConsumptionTransaction transaction3 = MaterialsConsumptionTransaction.builder()
                .project(project3)
                .issueDate(LocalDate.of(2023, 4, 15))
                .equipment(equipment3)
                .item(item3)
                .quantity(30)
                .costPerUnit(new BigDecimal("400.00"))
                .totalCost(new BigDecimal("12000.00"))
                .remarks("For structural work")
                .createdAt(LocalDateTime.now())
                .build();
        MaterialsConsumptionTransaction transaction4 = MaterialsConsumptionTransaction.builder()
                .project(project4)
                .issueDate(LocalDate.of(2023, 4, 18))
                .equipment(equipment4)
                .item(item4)
                .quantity(25)
                .costPerUnit(new BigDecimal("450.00"))
                .totalCost(new BigDecimal("11250.00"))
                .remarks("For electrical work")
                .createdAt(LocalDateTime.now())
                .build();
        MaterialsConsumptionTransaction transaction5 = MaterialsConsumptionTransaction.builder()
                .project(project5)
                .issueDate(LocalDate.of(2023, 4, 20))
                .equipment(equipment5)
                .item(item5)
                .quantity(40)
                .costPerUnit(new BigDecimal("380.00"))
                .totalCost(new BigDecimal("15200.00"))
                .remarks("For plumbing work")
                .createdAt(LocalDateTime.now())
                .build();
        MaterialsConsumptionTransaction transaction6 = MaterialsConsumptionTransaction.builder()
                .project(project6)
                .issueDate(LocalDate.of(2023, 4, 25))
                .equipment(equipment6)
                .item(item6)
                .quantity(35)
                .costPerUnit(new BigDecimal("420.00"))
                .totalCost(new BigDecimal("14700.00"))
                .remarks("For finishing work")
                .createdAt(LocalDateTime.now())
                .build();
        materialsConsumptionTransactionRepository.saveAll(Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6));
    }

    private void initializeOvertimeReports() {
        log.info("Initializing Overtime Reports...");
        Employee employee1 = employeeRepository.findByName("John Doe");
        Employee employee2 = employeeRepository.findByName("Jane Smith");
        Employee employee3 = employeeRepository.findByName("Alice Brown");
        Employee employee4 = employeeRepository.findByName("Bob White");
        Employee employee5 = employeeRepository.findByName("Carol Green");
        Employee employee6 = employeeRepository.findByName("David Black");

        OvertimeReport report1 = OvertimeReport.builder()
                .date(LocalDate.of(2023, 4, 15))
                .employee(employee1)
                .presentDays(22)
                .otHours(new BigDecimal("15.5"))
                .remarks("Project deadline")
                .createdAt(LocalDateTime.now())
                .build();
        OvertimeReport report2 = OvertimeReport.builder()
                .date(LocalDate.of(2023, 4, 15))
                .employee(employee2)
                .presentDays(21)
                .otHours(new BigDecimal("12.0"))
                .remarks("Equipment maintenance")
                .createdAt(LocalDateTime.now())
                .build();
        OvertimeReport report3 = OvertimeReport.builder()
                .date(LocalDate.of(2023, 4, 15))
                .employee(employee3)
                .presentDays(20)
                .otHours(new BigDecimal("10.0"))
                .remarks("Site inspection")
                .createdAt(LocalDateTime.now())
                .build();
        OvertimeReport report4 = OvertimeReport.builder()
                .date(LocalDate.of(2023, 4, 15))
                .employee(employee4)
                .presentDays(19)
                .otHours(new BigDecimal("8.0"))
                .remarks("Financial audit")
                .createdAt(LocalDateTime.now())
                .build();
        OvertimeReport report5 = OvertimeReport.builder()
                .date(LocalDate.of(2023, 4, 15))
                .employee(employee5)
                .presentDays(18)
                .otHours(new BigDecimal("7.0"))
                .remarks("HR meeting")
                .createdAt(LocalDateTime.now())
                .build();
        OvertimeReport report6 = OvertimeReport.builder()
                .date(LocalDate.of(2023, 4, 15))
                .employee(employee6)
                .presentDays(17)
                .otHours(new BigDecimal("6.0"))
                .remarks("Inventory check")
                .createdAt(LocalDateTime.now())
                .build();
        overtimeReportRepository.saveAll(Arrays.asList(report1, report2, report3, report4, report5, report6));
    }

    private void initializePettyCashTransactions() {
        log.info("Initializing Petty Cash Transactions...");
        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        Item item1 = itemRepository.findByCode("MAT-001");
        Item item2 = itemRepository.findByCode("SPR-001");
        Item item3 = itemRepository.findByCode("MAT-002");
        Item item4 = itemRepository.findByCode("SPR-002");
        Item item5 = itemRepository.findByCode("MAT-003");
        Item item6 = itemRepository.findByCode("SPR-003");

        PettyCashTransaction transaction1 = PettyCashTransaction.builder()
                .project(project1)
                .reportDate(LocalDate.of(2023, 4, 18))
                .equipment(equipment1)
                .item(item1)
                .quantity(5)
                .rate(new BigDecimal("350.00"))
                .cumulativeTotalAmount(new BigDecimal("1750.00"))
                .amountSpent(new BigDecimal("1750.00"))
                .purposeJustification("Emergency repair")
                .remarks("Approved by site manager")
                .build();
        PettyCashTransaction transaction2 = PettyCashTransaction.builder()
                .project(project2)
                .reportDate(LocalDate.of(2023, 4, 19))
                .equipment(equipment2)
                .item(item2)
                .quantity(3)
                .rate(new BigDecimal("500.00"))
                .cumulativeTotalAmount(new BigDecimal("1500.00"))
                .amountSpent(new BigDecimal("1500.00"))
                .purposeJustification("Urgent maintenance")
                .remarks("Approved by project manager")
                .build();
        PettyCashTransaction transaction3 = PettyCashTransaction.builder()
                .project(project3)
                .reportDate(LocalDate.of(2023, 4, 20))
                .equipment(equipment3)
                .item(item3)
                .quantity(4)
                .rate(new BigDecimal("400.00"))
                .cumulativeTotalAmount(new BigDecimal("1600.00"))
                .amountSpent(new BigDecimal("1600.00"))
                .purposeJustification("Quick fix")
                .remarks("Approved by site supervisor")
                .build();
        PettyCashTransaction transaction4 = PettyCashTransaction.builder()
                .project(project4)
                .reportDate(LocalDate.of(2023, 4, 21))
                .equipment(equipment4)
                .item(item4)
                .quantity(6)
                .rate(new BigDecimal("450.00"))
                .cumulativeTotalAmount(new BigDecimal("2700.00"))
                .amountSpent(new BigDecimal("2700.00"))
                .purposeJustification("Routine maintenance")
                .remarks("Approved by office manager")
                .build();
        PettyCashTransaction transaction5 = PettyCashTransaction.builder()
                .project(project5)
                .reportDate(LocalDate.of(2023, 4, 22))
                .equipment(equipment5)
                .item(item5)
                .quantity(7)
                .rate(new BigDecimal("380.00"))
                .cumulativeTotalAmount(new BigDecimal("2660.00"))
                .amountSpent(new BigDecimal("2660.00"))
                .purposeJustification("Emergency supplies")
                .remarks("Approved by site engineer")
                .build();
        PettyCashTransaction transaction6 = PettyCashTransaction.builder()
                .project(project6)
                .reportDate(LocalDate.of(2023, 4, 23))
                .equipment(equipment6)
                .item(item6)
                .quantity(8)
                .rate(new BigDecimal("420.00"))
                .cumulativeTotalAmount(new BigDecimal("3360.00"))
                .amountSpent(new BigDecimal("3360.00"))
                .purposeJustification("Urgent supplies")
                .remarks("Approved by project coordinator")
                .build();
        pettyCashTransactionRepository.saveAll(Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6));
    }

    private void initializeStockStatements() {
        log.info("Initializing Stock Statements...");
        Project project1 = projectRepository.findByName("Highway Construction");
        Project project2 = projectRepository.findByName("Bridge Renovation");
        Project project3 = projectRepository.findByName("Warehouse Expansion");
        Project project4 = projectRepository.findByName("Office Complex");
        Project project5 = projectRepository.findByName("Dam Repair");
        Project project6 = projectRepository.findByName("Pipeline Installation");

        Equipment equipment1 = equipmentRepository.findByAssetCode("EX-001");
        Equipment equipment2 = equipmentRepository.findByAssetCode("BD-001");
        Equipment equipment3 = equipmentRepository.findByAssetCode("LD-001");
        Equipment equipment4 = equipmentRepository.findByAssetCode("CR-001");
        Equipment equipment5 = equipmentRepository.findByAssetCode("FL-001");
        Equipment equipment6 = equipmentRepository.findByAssetCode("SV-001");

        Item item1 = itemRepository.findByCode("MAT-001");
        Item item2 = itemRepository.findByCode("SPR-001");
        Item item3 = itemRepository.findByCode("MAT-002");
        Item item4 = itemRepository.findByCode("SPR-002");
        Item item5 = itemRepository.findByCode("MAT-003");
        Item item6 = itemRepository.findByCode("SPR-003");

        StockStatement statement1 = StockStatement.builder()
                .project(project1)
                .item(item1)
                .equipment(equipment1)
                .month(4)
                .year(2023)
                .balance(new BigDecimal("100.00"))
                .landedRate(new BigDecimal("350.00"))
                .landedValue(new BigDecimal("35000.00"))
                .lastReceiptOn(LocalDate.of(2023, 4, 5))
                .lastIssueOn(LocalDate.of(2023, 4, 10))
                .build();
        StockStatement statement2 = StockStatement.builder()
                .project(project2)
                .item(item2)
                .equipment(equipment2)
                .month(4)
                .year(2023)
                .balance(new BigDecimal("50.00"))
                .landedRate(new BigDecimal("500.00"))
                .landedValue(new BigDecimal("25000.00"))
                .lastReceiptOn(LocalDate.of(2023, 4, 8))
                .lastIssueOn(LocalDate.of(2023, 4, 12))
                .build();
        StockStatement statement3 = StockStatement.builder()
                .project(project3)
                .item(item3)
                .equipment(equipment3)
                .month(4)
                .year(2023)
                .balance(new BigDecimal("75.00"))
                .landedRate(new BigDecimal("400.00"))
                .landedValue(new BigDecimal("30000.00"))
                .lastReceiptOn(LocalDate.of(2023, 4, 10))
                .lastIssueOn(LocalDate.of(2023, 4, 15))
                .build();
        StockStatement statement4 = StockStatement.builder()
                .project(project4)
                .item(item4)
                .equipment(equipment4)
                .month(4)
                .year(2023)
                .balance(new BigDecimal("60.00"))
                .landedRate(new BigDecimal("450.00"))
                .landedValue(new BigDecimal("27000.00"))
                .lastReceiptOn(LocalDate.of(2023, 4, 12))
                .lastIssueOn(LocalDate.of(2023, 4, 18))
                .build();
        StockStatement statement5 = StockStatement.builder()
                .project(project5)
                .item(item5)
                .equipment(equipment5)
                .month(4)
                .year(2023)
                .balance(new BigDecimal("80.00"))
                .landedRate(new BigDecimal("380.00"))
                .landedValue(new BigDecimal("30400.00"))
                .lastReceiptOn(LocalDate.of(2023, 4, 15))
                .lastIssueOn(LocalDate.of(2023, 4, 20))
                .build();
        StockStatement statement6 = StockStatement.builder()
                .project(project6)
                .item(item6)
                .equipment(equipment6)
                .month(4)
                .year(2023)
                .balance(new BigDecimal("70.00"))
                .landedRate(new BigDecimal("420.00"))
                .landedValue(new BigDecimal("29400.00"))
                .lastReceiptOn(LocalDate.of(2023, 4, 18))
                .lastIssueOn(LocalDate.of(2023, 4, 25))
                .build();
        stockStatementRepository.saveAll(Arrays.asList(statement1, statement2, statement3, statement4, statement5, statement6));
    }
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initUsers() {
        if (userRepository.findAll().isEmpty()) {
            User admin = User.builder()
                    .email("admin@example.com")
                    .username("admin")
                    .password(new BCryptPasswordEncoder().encode("admin123"))
                    .role("admin")
                    .active(true)
                    .build();

            User employee = User.builder()
                    .email("employee@example.com")
                    .username("emp")
                    .password(new   BCryptPasswordEncoder().encode("emp123"))
                    .role("employee")
                    .active(true)
                    .build();

            userRepository.saveAll(List.of(admin, employee));
        }
    }}



