package com.machinarymgmt.service.api.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

import com.machinarymgmt.service.dto.ItemRequestDto.ItemTypeEnum;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private Long id;
    
    @Column(name = "Item_Code", nullable = false, unique = true)
    private String code;
    
    @Column(name = "Item_Description", nullable = false, columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "UOM", nullable = false)
    private String uom;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Item_Type", nullable = false)
    private ItemType type;
    
    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockStatement> stockStatements;
    
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenancePartsUsed> partsUsed;
    
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PettyCashTransaction> pettyCashTransactions;
    
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaterialsConsumptionTransaction> materialsConsumptions;
    
    public enum ItemType {
        MATERIAL, SPARE, OTHER
    }
}
