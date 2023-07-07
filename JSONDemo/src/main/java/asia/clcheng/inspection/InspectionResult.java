package asia.clcheng.inspection;

import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class InspectionResult implements Serializable {
    @JSONField(name = "MAT_ID")
    private String matId;

    @JSONField(name = "FAULTS")
    private FAULTS faults;

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId;
    }

    public FAULTS getFaults() {
        return faults;
    }

    public void setFaults(FAULTS faults) {
        this.faults = faults;
    }

    public class FAULTS {
        @JSONField(name = "NUM")
        private Integer NUM;
        @JSONField(name = "FAULT")
        private List<Fault> FAULT;
    }
    public class Fault {
        @JSONField(name = "TYPE")
        private String TYPE;
        @JSONField(name = "POS")
        private Double POS;

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public Double getPOS() {
            return POS;
        }

        public void setPOS(Double POS) {
            this.POS = POS;
        }

    }
}
