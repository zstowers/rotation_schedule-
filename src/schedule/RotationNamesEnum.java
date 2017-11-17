package schedule;

public enum RotationNamesEnum {

    ANES_OR_UH("Anes/OR/UH"),
    ANES_CT_UH("Anes/CT/UH"),
    ANES_NEURO_UH("Anes/Neuro/UH"),
    ANES_PEDI_UH("Anes/Pedi/UH"),
    ADVANCED_ANES("Advanced Anes"),
    NORA("NORA"),
    ELECTIVE("Elective"),
    TAP_AIRWAY("TAP/Airway"),
    ANES_APS_REG_UH("Anes/APS-Reg/UH"),
    ANES_PACU_UH("Anes/PACU/UH"),
    ANES_RESEARCH_UH("Anes/Research/UH"),
    ANES_UPOMC_UH("Anes/UPOMC/UH"),
    ANES_OB_UH("Anes/OB/UH"),
    ACCM_CCM_VA("ACCM/CCM/VA"),
    ANES_OR_VA("Anes/OR/VA"),
    ANES_NEUROSURG_VA("Anes/NeuroSurg/VA"),
    ANES_CT_VA("Anes/CT/VA"),
    ANES_CPAIN_NON_HOS("Anes/CPain/NonHos"),
    ANES_PEDI_CSR("Anes/Pedi/CSR"),
    ANES_MATERNITY("Anes/Maternity");

    public String rotationName;

    RotationNamesEnum(String rotationName) {
        this.rotationName = rotationName;
    }

}