package com.gap.api.Model.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "org_units")
public class OrgUnit {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrgUnitType type;

    @OneToMany(mappedBy = "responsibleUnit", fetch = FetchType.LAZY)
    private List<ApprovalStage> approvalStages;

    public enum OrgUnitType {
        REITORIA,
        COORDENACAO,
        DIRECAO,
        SECRETARIA,
        DEPARTAMENTO,
        ESCOLA
    }

}
