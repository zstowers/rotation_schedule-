package schedule;

public enum RotationNamesEnum {

    ANES_OR_UH("Anes/OR/UH") {
        public int maxAllowed() { return 12;}
    },
    ANES_CT_UH("Anes/CT/UH") {
        public int maxAllowed() { return 2;}
    },
    ANES_NEURO_UH("Anes/Neuro/UH") {
        public int maxAllowed() {return 1;}
    },
    ANES_PEDI_UH("Anes/Pedi/UH") {
        public int maxAllowed() {return 2;}
    },
    ADVANCED_ANES("Advanced Anes") {
        public int maxAllowed() {return 1;}
    },
    NORA("NORA") {
        public int maxAllowed() {return 1;}
    },
    ELECTIVE("Elective") {
        public int maxAllowed() {return 1;}
    },
    TAP_AIRWAY("TAP/Airway") {
        public int maxAllowed() {return 1;}
    },
    ANES_APS_REG_UH("Anes/APS-Reg/UH") {
        public int maxAllowed() {return 3;}
    },
    ANES_PACU_UH("Anes/PACU/UH") {
        public int maxAllowed() {return 1;}
    },
    ANES_RESEARCH_UH("Anes/Research/UH") {
        public int maxAllowed() {return 1;}
    },
    ANES_UPOMC_UH("Anes/UPOMC/UH") {
        public int maxAllowed() {return 1;}
    },
    ANES_OB_UH("Anes/OB/UH") {
        public int maxAllowed() {return 3;}
    },
    ACCM_CCM_VA("ACCM/CCM/VA") {
        public int maxAllowed() {return 4;}
    },
    ANES_OR_VA("Anes/OR/VA") {
        public int maxAllowed() {return 3;}
    },
    ANES_NEUROSURG_VA("Anes/NeuroSurg/VA") {
        public int maxAllowed() {return 1;}
    },
    ANES_CT_VA("Anes/CT/VA") {
        public int maxAllowed() {return 2;}
    },
    ANES_CPAIN_NON_HOS("Anes/CPain/NonHos") {
        public int maxAllowed() {return 1;}
    },
    ANES_PEDI_CSR("Anes/Pedi/CSR") {
        public int maxAllowed() {return 3;}
    },
    ANES_MATERNITY("Anes/Maternity") {
        public int maxAllowed() {return 2;}
    };

    public String rotationName;
    public abstract int maxAllowed();

    RotationNamesEnum(String rotationName) {
        this.rotationName = rotationName;
    }

}