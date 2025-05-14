package com.machinarymgmt.service.api.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.Year;
import java.util.List;

import org.hibernate.annotations.Fetch;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EquipmentID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ProjectID", nullable = false)
    private Project project;
    
    @Column(name = "Equipment_Name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private EquipmentCategory category;
    
    @ManyToOne
    @JoinColumn(name = "ModelID")
    private Model model;
    
    @Column(name = "Asset_Code", nullable = false, unique = true)
    private String assetCode;

    @Column(name = "vehicle_number", length = 20)
    private String vehicleNumber;

    @Column(name = "Year_of_Manufacture", nullable = false)
    private Integer yearOfManufacture;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockStatement> stockStatements;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EquipmentUtilization> utilizations;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IncidentReport> incidents;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAssignment> employeeAssignments;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MachineryMaintenanceLog> maintenanceLogs;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PettyCashTransaction> pettyCashTransactions;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaterialsConsumptionTransaction> materialsConsumptions;
    
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MastAnchorageDetails> mastAnchorageDetails;
}
