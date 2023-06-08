package com.example.mybatisdemospringmutildatasource.domain;

import java.io.Serializable;

/**
 * BOF
 */
public class BMMSM21 implements Serializable {
    /**
     * 跟数据库字段名一致,MyBatis可以直接使用javaType
     */
    private String REC_CREATOR;
    private String REC_CREATE_TIME;
    private String REC_REVISOR;
    private String REC_REVISE_TIME;
    private String ARCHIVE_FLAG;
    private String TC_SEQ_NO;
    private String TC_NO;
    private String TC_PROC_FLAG;
    private String TC_TRANS_TIME;
    private String TC_PROC_TIME;
    private String TC_TRANS_FROM;
    private String PRACT_COLL_MODE;
    private String PROD_SHIFT_NO;
    private String PROD_SHIFT_GROUP;
    private String PROD_TIME;
    private String PROD_MAKER;
    private String PROD_SEQ_NO;
    private String SCHDL_SEQ_NO;
    private String PONO;
    private String ST_NO;
    private String HEAT_NO;
    private String BOF_NO;
    private Integer FURNACE_ERA;
    private Integer FURNACE_AGE;
    private Integer STEEL_HOLE_ERA;
    private Integer STEEL_HOLE_AGE;
    private String MAIL_LANCE_NO;
    private Integer MAIL_LANCE_AGE;
    private String FIT_LANCE_NO;
    private Integer FIT_LANCE_AGE;
    private String SMELT_DIV;
    private String LADLE_NO;
    private Integer EMPTY_LADLE_WT;
    private String IRON_LADLE_NO;
    private String IRON_TEMP_TIME;
    private Integer IRON_TEMP;
    private String OUT_STEEL_TEMP_TIME;
    private Integer OUT_STEEL_TEMP;
    /**
     * mysql中decimal（8，0）插入的小数会自动截断
     */
    private Integer ST_C;
    private Integer ST_P;
    private Integer ST_S;
    private Integer ST_O_XP;
    private Integer OUT_STEEL_WT;
    private Integer STEEL_NUM;
    private Integer REBLOW_NUM;
    private Integer SMELT_CYCLE;
    private String BLOW_TEMP_TIME;
    private Integer BLOW_TEMP;
    private Integer FIN_C;
    private Integer FIN_P;
    private Integer FIN_S;
    private Integer SMELT_MODE;
    private String LOAD_START_TIME;
    private String LOAD_END_TIME;
    private String BLOW_START_TIME1;
    private String BLOW_END_TIME1;
    private String BLOW_START_TIME2;
    private String BLOW_END_TIME2;
    private String BLOW_START_TIME3;
    private String BLOW_END_TIME3;
    private String BLOW_START_TIME4;
    private String BLOW_END_TIME4;
    private String TAP_START_TIME;
    private String TAP_END_TIME;
    private String SLAG_START_TIME1;
    private String SLAG_END_TIME1;
    private String SLAG_START_TIME2;
    private String SLAG_END_TIME2;
    private Integer MOLTIRON_WT;
    private Integer SCRAP_STEEL_WT;
    private Integer RAW_IRON_WT;
    private String RETURN_HEAT_NO;
    private Integer RETURN_STEEL_WT;
    private Integer O2_SUM_COMSUME;
    private Integer N_SUM_COMSUME;
    private Integer AR_SUM_COMSUME;
    private Integer BTTM_N_COMSUME;
    private Integer BTTM_AR_COMSUME;
    private Integer SLAG_N_COMSUME;
    private Integer STEAM_OCCUR_VOL;
    private Integer WATER_WT;
    private Integer CO_RETURN_WT;
    private Integer WAITING_TIME;
    private String WAIT_CAUSE;
    private String HEAT_ABNR_CODE_1;
    private String HEAT_ABNR_CODE_2;
    private String HEAT_ABNR_CODE_3;
    private String HEAT_ABNR_CODE_4;
    private String IRON_LTREAT_NO;
    private String TPD_NO;
    private String SLAG_NO;
    private String SMP_NAME;
    private String RMV_SLAG_START_TIME;
    private String RMV_SLAG_END_TIME;
    private Integer ENCASE_TIME;
    private Integer BLOW_TIME;
    private Integer KILL_TIME;
    private Integer STEEL_TIME;
    private Integer SPATTER_SLAG_TIME;
    private Integer REMOVE_SLAG_TIME;
    private Integer MNBL_O_VOL;
    private Integer REAL_ALO_YEILD_C;
    private Integer REAL_ALO_YEILD_SI;
    private Integer REAL_ALO_YEILD_MN;
    private Integer REAL_ALO_YEILD_AL;
    private String SCRAP_LOAD_TIME;
    private String IRON_LOAD_TIME;
    private String O2_LANCE_NO;
    private Integer O2_LANCE_NUM;
    private Integer SURE_FIT_LANCE_DETECTOR_TOTAL;
    private Integer UN_FIT_LANCE_DETECTOR_TOTAL;
    private Integer SMELT_TIME;
    private Integer RETURN_STEEL_SCHDL_SEQ_NO;
    private String PONO_NO;
    private Integer FUTUO;
    private Integer SIMNALLOY;
    private Integer SIFEALLOY;
    private Integer SIMN;
    private Integer SIFE;
    private Integer ALLOY1;
    private Integer BA;
    private Integer GXAL;
    private Integer VFE;
    private Integer VN;
    private Integer C;
    private Integer ALMN;
    private Integer BACASI;
    private Integer ALMNTI;
    private Integer MN_MED;
    private Integer MN_HIGH;
    private Integer LT_NUM;
    private Integer LT_TEMP;
    private Integer LT_DIA;
    private Integer COUNT_LT;
    private String BLOW_LOW;
    private Integer CONTROL_O;
    private Integer LD_DEEP;
    private Integer XPT_TEMP;
    private Integer MN_LOW;
    private Integer CR_LOW;
    private Integer FENB;
    private Integer FEP;
    private Integer CR_MED;
    private Integer COPPER;
    private Integer ALUMINIUM;
    private Integer NI_BAN;
    private Integer FEMO;
    private Integer CUNI;
    private Integer FENI;
    private Integer C_ADD;
    private Integer AL_ADD;
    private Integer SLAG_YR;
    private Integer LADLE_LIFE;
    private Integer HECHENG;
    private Integer DHFT;
    private Integer MN;
    private Integer LMT;
    private String ZNLG;
    private String ZJCG;
    private String ART;
    private Integer CMG;
    private Integer FEV;
    private Integer QSMG;
    private Integer GBWD;
    private Integer TSC_C;
    private Integer TSC_TEMP;
    private Integer TSO_C;
    private Integer TSO_TEMP;
    private String PJQK;
    private Integer TSO_SC;
    private Integer CXO;
    private Integer HB_NUM;
    private Integer NSK_NUM;
    private String SHUANCAO;
    private String SHUANGZHA;
    private Integer SICABA;
    private Integer HISIMIDMN;
    private Integer DYNA_ASC_1;
    private Integer DYNA_ASC_2;
    private Integer DYNA_ASC_3;
    private Integer DYNA_ASC_4;
    private Integer DYNA_ASC_5;
    private Integer DYNA_ASC_6;
    private Integer DYNA_ASC_7;
    private Integer DYNA_ASC_8;
    private Integer DYNA_ASC_9;
    private Integer DYNA_ASC_10;
    private String GBJG;
    private Integer TSO_DETECTOR;
    private Integer TSC_DETECTOR;
    private String CC_MACH_NO;

    public String getREC_CREATOR() {
        return REC_CREATOR;
    }

    public void setREC_CREATOR(String REC_CREATOR) {
        this.REC_CREATOR = REC_CREATOR;
    }

    public String getREC_CREATE_TIME() {
        return REC_CREATE_TIME;
    }

    public void setREC_CREATE_TIME(String REC_CREATE_TIME) {
        this.REC_CREATE_TIME = REC_CREATE_TIME;
    }

    public String getREC_REVISOR() {
        return REC_REVISOR;
    }

    public void setREC_REVISOR(String REC_REVISOR) {
        this.REC_REVISOR = REC_REVISOR;
    }

    public String getREC_REVISE_TIME() {
        return REC_REVISE_TIME;
    }

    public void setREC_REVISE_TIME(String REC_REVISE_TIME) {
        this.REC_REVISE_TIME = REC_REVISE_TIME;
    }

    public String getARCHIVE_FLAG() {
        return ARCHIVE_FLAG;
    }

    public void setARCHIVE_FLAG(String ARCHIVE_FLAG) {
        this.ARCHIVE_FLAG = ARCHIVE_FLAG;
    }

    public String getTC_SEQ_NO() {
        return TC_SEQ_NO;
    }

    public void setTC_SEQ_NO(String TC_SEQ_NO) {
        this.TC_SEQ_NO = TC_SEQ_NO;
    }

    public String getTC_NO() {
        return TC_NO;
    }

    public void setTC_NO(String TC_NO) {
        this.TC_NO = TC_NO;
    }

    public String getTC_PROC_FLAG() {
        return TC_PROC_FLAG;
    }

    public void setTC_PROC_FLAG(String TC_PROC_FLAG) {
        this.TC_PROC_FLAG = TC_PROC_FLAG;
    }

    public String getTC_TRANS_TIME() {
        return TC_TRANS_TIME;
    }

    public void setTC_TRANS_TIME(String TC_TRANS_TIME) {
        this.TC_TRANS_TIME = TC_TRANS_TIME;
    }

    public String getTC_PROC_TIME() {
        return TC_PROC_TIME;
    }

    public void setTC_PROC_TIME(String TC_PROC_TIME) {
        this.TC_PROC_TIME = TC_PROC_TIME;
    }

    public String getTC_TRANS_FROM() {
        return TC_TRANS_FROM;
    }

    public void setTC_TRANS_FROM(String TC_TRANS_FROM) {
        this.TC_TRANS_FROM = TC_TRANS_FROM;
    }

    public String getPRACT_COLL_MODE() {
        return PRACT_COLL_MODE;
    }

    public void setPRACT_COLL_MODE(String PRACT_COLL_MODE) {
        this.PRACT_COLL_MODE = PRACT_COLL_MODE;
    }

    public String getPROD_SHIFT_NO() {
        return PROD_SHIFT_NO;
    }

    public void setPROD_SHIFT_NO(String PROD_SHIFT_NO) {
        this.PROD_SHIFT_NO = PROD_SHIFT_NO;
    }

    public String getPROD_SHIFT_GROUP() {
        return PROD_SHIFT_GROUP;
    }

    public void setPROD_SHIFT_GROUP(String PROD_SHIFT_GROUP) {
        this.PROD_SHIFT_GROUP = PROD_SHIFT_GROUP;
    }

    public String getPROD_TIME() {
        return PROD_TIME;
    }

    public void setPROD_TIME(String PROD_TIME) {
        this.PROD_TIME = PROD_TIME;
    }

    public String getPROD_MAKER() {
        return PROD_MAKER;
    }

    public void setPROD_MAKER(String PROD_MAKER) {
        this.PROD_MAKER = PROD_MAKER;
    }

    public String getPROD_SEQ_NO() {
        return PROD_SEQ_NO;
    }

    public void setPROD_SEQ_NO(String PROD_SEQ_NO) {
        this.PROD_SEQ_NO = PROD_SEQ_NO;
    }

    public String getSCHDL_SEQ_NO() {
        return SCHDL_SEQ_NO;
    }

    public void setSCHDL_SEQ_NO(String SCHDL_SEQ_NO) {
        this.SCHDL_SEQ_NO = SCHDL_SEQ_NO;
    }

    public String getPONO() {
        return PONO;
    }

    public void setPONO(String PONO) {
        this.PONO = PONO;
    }

    public String getST_NO() {
        return ST_NO;
    }

    public void setST_NO(String ST_NO) {
        this.ST_NO = ST_NO;
    }

    public String getHEAT_NO() {
        return HEAT_NO;
    }

    public void setHEAT_NO(String HEAT_NO) {
        this.HEAT_NO = HEAT_NO;
    }

    public String getBOF_NO() {
        return BOF_NO;
    }

    public void setBOF_NO(String BOF_NO) {
        this.BOF_NO = BOF_NO;
    }

    public Integer getFURNACE_ERA() {
        return FURNACE_ERA;
    }

    public void setFURNACE_ERA(Integer FURNACE_ERA) {
        this.FURNACE_ERA = FURNACE_ERA;
    }

    public Integer getFURNACE_AGE() {
        return FURNACE_AGE;
    }

    public void setFURNACE_AGE(Integer FURNACE_AGE) {
        this.FURNACE_AGE = FURNACE_AGE;
    }

    public Integer getSTEEL_HOLE_ERA() {
        return STEEL_HOLE_ERA;
    }

    public void setSTEEL_HOLE_ERA(Integer STEEL_HOLE_ERA) {
        this.STEEL_HOLE_ERA = STEEL_HOLE_ERA;
    }

    public Integer getSTEEL_HOLE_AGE() {
        return STEEL_HOLE_AGE;
    }

    public void setSTEEL_HOLE_AGE(Integer STEEL_HOLE_AGE) {
        this.STEEL_HOLE_AGE = STEEL_HOLE_AGE;
    }

    public String getMAIL_LANCE_NO() {
        return MAIL_LANCE_NO;
    }

    public void setMAIL_LANCE_NO(String MAIL_LANCE_NO) {
        this.MAIL_LANCE_NO = MAIL_LANCE_NO;
    }

    public Integer getMAIL_LANCE_AGE() {
        return MAIL_LANCE_AGE;
    }

    public void setMAIL_LANCE_AGE(Integer MAIL_LANCE_AGE) {
        this.MAIL_LANCE_AGE = MAIL_LANCE_AGE;
    }

    public String getFIT_LANCE_NO() {
        return FIT_LANCE_NO;
    }

    public void setFIT_LANCE_NO(String FIT_LANCE_NO) {
        this.FIT_LANCE_NO = FIT_LANCE_NO;
    }

    public Integer getFIT_LANCE_AGE() {
        return FIT_LANCE_AGE;
    }

    public void setFIT_LANCE_AGE(Integer FIT_LANCE_AGE) {
        this.FIT_LANCE_AGE = FIT_LANCE_AGE;
    }

    public String getSMELT_DIV() {
        return SMELT_DIV;
    }

    public void setSMELT_DIV(String SMELT_DIV) {
        this.SMELT_DIV = SMELT_DIV;
    }

    public String getLADLE_NO() {
        return LADLE_NO;
    }

    public void setLADLE_NO(String LADLE_NO) {
        this.LADLE_NO = LADLE_NO;
    }

    public Integer getEMPTY_LADLE_WT() {
        return EMPTY_LADLE_WT;
    }

    public void setEMPTY_LADLE_WT(Integer EMPTY_LADLE_WT) {
        this.EMPTY_LADLE_WT = EMPTY_LADLE_WT;
    }

    public String getIRON_LADLE_NO() {
        return IRON_LADLE_NO;
    }

    public void setIRON_LADLE_NO(String IRON_LADLE_NO) {
        this.IRON_LADLE_NO = IRON_LADLE_NO;
    }

    public String getIRON_TEMP_TIME() {
        return IRON_TEMP_TIME;
    }

    public void setIRON_TEMP_TIME(String IRON_TEMP_TIME) {
        this.IRON_TEMP_TIME = IRON_TEMP_TIME;
    }

    public Integer getIRON_TEMP() {
        return IRON_TEMP;
    }

    public void setIRON_TEMP(Integer IRON_TEMP) {
        this.IRON_TEMP = IRON_TEMP;
    }

    public String getOUT_STEEL_TEMP_TIME() {
        return OUT_STEEL_TEMP_TIME;
    }

    public void setOUT_STEEL_TEMP_TIME(String OUT_STEEL_TEMP_TIME) {
        this.OUT_STEEL_TEMP_TIME = OUT_STEEL_TEMP_TIME;
    }

    public Integer getOUT_STEEL_TEMP() {
        return OUT_STEEL_TEMP;
    }

    public void setOUT_STEEL_TEMP(Integer OUT_STEEL_TEMP) {
        this.OUT_STEEL_TEMP = OUT_STEEL_TEMP;
    }

    public Integer getST_C() {
        return ST_C;
    }

    public void setST_C(Integer ST_C) {
        this.ST_C = ST_C;
    }

    public Integer getST_P() {
        return ST_P;
    }

    public void setST_P(Integer ST_P) {
        this.ST_P = ST_P;
    }

    public Integer getST_S() {
        return ST_S;
    }

    public void setST_S(Integer ST_S) {
        this.ST_S = ST_S;
    }

    public Integer getST_O_XP() {
        return ST_O_XP;
    }

    public void setST_O_XP(Integer ST_O_XP) {
        this.ST_O_XP = ST_O_XP;
    }

    public Integer getOUT_STEEL_WT() {
        return OUT_STEEL_WT;
    }

    public void setOUT_STEEL_WT(Integer OUT_STEEL_WT) {
        this.OUT_STEEL_WT = OUT_STEEL_WT;
    }

    public Integer getSTEEL_NUM() {
        return STEEL_NUM;
    }

    public void setSTEEL_NUM(Integer STEEL_NUM) {
        this.STEEL_NUM = STEEL_NUM;
    }

    public Integer getREBLOW_NUM() {
        return REBLOW_NUM;
    }

    public void setREBLOW_NUM(Integer REBLOW_NUM) {
        this.REBLOW_NUM = REBLOW_NUM;
    }

    public Integer getSMELT_CYCLE() {
        return SMELT_CYCLE;
    }

    public void setSMELT_CYCLE(Integer SMELT_CYCLE) {
        this.SMELT_CYCLE = SMELT_CYCLE;
    }

    public String getBLOW_TEMP_TIME() {
        return BLOW_TEMP_TIME;
    }

    public void setBLOW_TEMP_TIME(String BLOW_TEMP_TIME) {
        this.BLOW_TEMP_TIME = BLOW_TEMP_TIME;
    }

    public Integer getBLOW_TEMP() {
        return BLOW_TEMP;
    }

    public void setBLOW_TEMP(Integer BLOW_TEMP) {
        this.BLOW_TEMP = BLOW_TEMP;
    }

    public Integer getFIN_C() {
        return FIN_C;
    }

    public void setFIN_C(Integer FIN_C) {
        this.FIN_C = FIN_C;
    }

    public Integer getFIN_P() {
        return FIN_P;
    }

    public void setFIN_P(Integer FIN_P) {
        this.FIN_P = FIN_P;
    }

    public Integer getFIN_S() {
        return FIN_S;
    }

    public void setFIN_S(Integer FIN_S) {
        this.FIN_S = FIN_S;
    }

    public Integer getSMELT_MODE() {
        return SMELT_MODE;
    }

    public void setSMELT_MODE(Integer SMELT_MODE) {
        this.SMELT_MODE = SMELT_MODE;
    }

    public String getLOAD_START_TIME() {
        return LOAD_START_TIME;
    }

    public void setLOAD_START_TIME(String LOAD_START_TIME) {
        this.LOAD_START_TIME = LOAD_START_TIME;
    }

    public String getLOAD_END_TIME() {
        return LOAD_END_TIME;
    }

    public void setLOAD_END_TIME(String LOAD_END_TIME) {
        this.LOAD_END_TIME = LOAD_END_TIME;
    }

    public String getBLOW_START_TIME1() {
        return BLOW_START_TIME1;
    }

    public void setBLOW_START_TIME1(String BLOW_START_TIME1) {
        this.BLOW_START_TIME1 = BLOW_START_TIME1;
    }

    public String getBLOW_END_TIME1() {
        return BLOW_END_TIME1;
    }

    public void setBLOW_END_TIME1(String BLOW_END_TIME1) {
        this.BLOW_END_TIME1 = BLOW_END_TIME1;
    }

    public String getBLOW_START_TIME2() {
        return BLOW_START_TIME2;
    }

    public void setBLOW_START_TIME2(String BLOW_START_TIME2) {
        this.BLOW_START_TIME2 = BLOW_START_TIME2;
    }

    public String getBLOW_END_TIME2() {
        return BLOW_END_TIME2;
    }

    public void setBLOW_END_TIME2(String BLOW_END_TIME2) {
        this.BLOW_END_TIME2 = BLOW_END_TIME2;
    }

    public String getBLOW_START_TIME3() {
        return BLOW_START_TIME3;
    }

    public void setBLOW_START_TIME3(String BLOW_START_TIME3) {
        this.BLOW_START_TIME3 = BLOW_START_TIME3;
    }

    public String getBLOW_END_TIME3() {
        return BLOW_END_TIME3;
    }

    public void setBLOW_END_TIME3(String BLOW_END_TIME3) {
        this.BLOW_END_TIME3 = BLOW_END_TIME3;
    }

    public String getBLOW_START_TIME4() {
        return BLOW_START_TIME4;
    }

    public void setBLOW_START_TIME4(String BLOW_START_TIME4) {
        this.BLOW_START_TIME4 = BLOW_START_TIME4;
    }

    public String getBLOW_END_TIME4() {
        return BLOW_END_TIME4;
    }

    public void setBLOW_END_TIME4(String BLOW_END_TIME4) {
        this.BLOW_END_TIME4 = BLOW_END_TIME4;
    }

    public String getTAP_START_TIME() {
        return TAP_START_TIME;
    }

    public void setTAP_START_TIME(String TAP_START_TIME) {
        this.TAP_START_TIME = TAP_START_TIME;
    }

    public String getTAP_END_TIME() {
        return TAP_END_TIME;
    }

    public void setTAP_END_TIME(String TAP_END_TIME) {
        this.TAP_END_TIME = TAP_END_TIME;
    }

    public String getSLAG_START_TIME1() {
        return SLAG_START_TIME1;
    }

    public void setSLAG_START_TIME1(String SLAG_START_TIME1) {
        this.SLAG_START_TIME1 = SLAG_START_TIME1;
    }

    public String getSLAG_END_TIME1() {
        return SLAG_END_TIME1;
    }

    public void setSLAG_END_TIME1(String SLAG_END_TIME1) {
        this.SLAG_END_TIME1 = SLAG_END_TIME1;
    }

    public String getSLAG_START_TIME2() {
        return SLAG_START_TIME2;
    }

    public void setSLAG_START_TIME2(String SLAG_START_TIME2) {
        this.SLAG_START_TIME2 = SLAG_START_TIME2;
    }

    public String getSLAG_END_TIME2() {
        return SLAG_END_TIME2;
    }

    public void setSLAG_END_TIME2(String SLAG_END_TIME2) {
        this.SLAG_END_TIME2 = SLAG_END_TIME2;
    }

    public Integer getMOLTIRON_WT() {
        return MOLTIRON_WT;
    }

    public void setMOLTIRON_WT(Integer MOLTIRON_WT) {
        this.MOLTIRON_WT = MOLTIRON_WT;
    }

    public Integer getSCRAP_STEEL_WT() {
        return SCRAP_STEEL_WT;
    }

    public void setSCRAP_STEEL_WT(Integer SCRAP_STEEL_WT) {
        this.SCRAP_STEEL_WT = SCRAP_STEEL_WT;
    }

    public Integer getRAW_IRON_WT() {
        return RAW_IRON_WT;
    }

    public void setRAW_IRON_WT(Integer RAW_IRON_WT) {
        this.RAW_IRON_WT = RAW_IRON_WT;
    }

    public String getRETURN_HEAT_NO() {
        return RETURN_HEAT_NO;
    }

    public void setRETURN_HEAT_NO(String RETURN_HEAT_NO) {
        this.RETURN_HEAT_NO = RETURN_HEAT_NO;
    }

    public Integer getRETURN_STEEL_WT() {
        return RETURN_STEEL_WT;
    }

    public void setRETURN_STEEL_WT(Integer RETURN_STEEL_WT) {
        this.RETURN_STEEL_WT = RETURN_STEEL_WT;
    }

    public Integer getO2_SUM_COMSUME() {
        return O2_SUM_COMSUME;
    }

    public void setO2_SUM_COMSUME(Integer o2_SUM_COMSUME) {
        O2_SUM_COMSUME = o2_SUM_COMSUME;
    }

    public Integer getN_SUM_COMSUME() {
        return N_SUM_COMSUME;
    }

    public void setN_SUM_COMSUME(Integer n_SUM_COMSUME) {
        N_SUM_COMSUME = n_SUM_COMSUME;
    }

    public Integer getAR_SUM_COMSUME() {
        return AR_SUM_COMSUME;
    }

    public void setAR_SUM_COMSUME(Integer AR_SUM_COMSUME) {
        this.AR_SUM_COMSUME = AR_SUM_COMSUME;
    }

    public Integer getBTTM_N_COMSUME() {
        return BTTM_N_COMSUME;
    }

    public void setBTTM_N_COMSUME(Integer BTTM_N_COMSUME) {
        this.BTTM_N_COMSUME = BTTM_N_COMSUME;
    }

    public Integer getBTTM_AR_COMSUME() {
        return BTTM_AR_COMSUME;
    }

    public void setBTTM_AR_COMSUME(Integer BTTM_AR_COMSUME) {
        this.BTTM_AR_COMSUME = BTTM_AR_COMSUME;
    }

    public Integer getSLAG_N_COMSUME() {
        return SLAG_N_COMSUME;
    }

    public void setSLAG_N_COMSUME(Integer SLAG_N_COMSUME) {
        this.SLAG_N_COMSUME = SLAG_N_COMSUME;
    }

    public Integer getSTEAM_OCCUR_VOL() {
        return STEAM_OCCUR_VOL;
    }

    public void setSTEAM_OCCUR_VOL(Integer STEAM_OCCUR_VOL) {
        this.STEAM_OCCUR_VOL = STEAM_OCCUR_VOL;
    }

    public Integer getWATER_WT() {
        return WATER_WT;
    }

    public void setWATER_WT(Integer WATER_WT) {
        this.WATER_WT = WATER_WT;
    }

    public Integer getCO_RETURN_WT() {
        return CO_RETURN_WT;
    }

    public void setCO_RETURN_WT(Integer CO_RETURN_WT) {
        this.CO_RETURN_WT = CO_RETURN_WT;
    }

    public Integer getWAITING_TIME() {
        return WAITING_TIME;
    }

    public void setWAITING_TIME(Integer WAITING_TIME) {
        this.WAITING_TIME = WAITING_TIME;
    }

    public String getWAIT_CAUSE() {
        return WAIT_CAUSE;
    }

    public void setWAIT_CAUSE(String WAIT_CAUSE) {
        this.WAIT_CAUSE = WAIT_CAUSE;
    }

    public String getHEAT_ABNR_CODE_1() {
        return HEAT_ABNR_CODE_1;
    }

    public void setHEAT_ABNR_CODE_1(String HEAT_ABNR_CODE_1) {
        this.HEAT_ABNR_CODE_1 = HEAT_ABNR_CODE_1;
    }

    public String getHEAT_ABNR_CODE_2() {
        return HEAT_ABNR_CODE_2;
    }

    public void setHEAT_ABNR_CODE_2(String HEAT_ABNR_CODE_2) {
        this.HEAT_ABNR_CODE_2 = HEAT_ABNR_CODE_2;
    }

    public String getHEAT_ABNR_CODE_3() {
        return HEAT_ABNR_CODE_3;
    }

    public void setHEAT_ABNR_CODE_3(String HEAT_ABNR_CODE_3) {
        this.HEAT_ABNR_CODE_3 = HEAT_ABNR_CODE_3;
    }

    public String getHEAT_ABNR_CODE_4() {
        return HEAT_ABNR_CODE_4;
    }

    public void setHEAT_ABNR_CODE_4(String HEAT_ABNR_CODE_4) {
        this.HEAT_ABNR_CODE_4 = HEAT_ABNR_CODE_4;
    }

    public String getIRON_LTREAT_NO() {
        return IRON_LTREAT_NO;
    }

    public void setIRON_LTREAT_NO(String IRON_LTREAT_NO) {
        this.IRON_LTREAT_NO = IRON_LTREAT_NO;
    }

    public String getTPD_NO() {
        return TPD_NO;
    }

    public void setTPD_NO(String TPD_NO) {
        this.TPD_NO = TPD_NO;
    }

    public String getSLAG_NO() {
        return SLAG_NO;
    }

    public void setSLAG_NO(String SLAG_NO) {
        this.SLAG_NO = SLAG_NO;
    }

    public String getSMP_NAME() {
        return SMP_NAME;
    }

    public void setSMP_NAME(String SMP_NAME) {
        this.SMP_NAME = SMP_NAME;
    }

    public String getRMV_SLAG_START_TIME() {
        return RMV_SLAG_START_TIME;
    }

    public void setRMV_SLAG_START_TIME(String RMV_SLAG_START_TIME) {
        this.RMV_SLAG_START_TIME = RMV_SLAG_START_TIME;
    }

    public String getRMV_SLAG_END_TIME() {
        return RMV_SLAG_END_TIME;
    }

    public void setRMV_SLAG_END_TIME(String RMV_SLAG_END_TIME) {
        this.RMV_SLAG_END_TIME = RMV_SLAG_END_TIME;
    }

    public Integer getENCASE_TIME() {
        return ENCASE_TIME;
    }

    public void setENCASE_TIME(Integer ENCASE_TIME) {
        this.ENCASE_TIME = ENCASE_TIME;
    }

    public Integer getBLOW_TIME() {
        return BLOW_TIME;
    }

    public void setBLOW_TIME(Integer BLOW_TIME) {
        this.BLOW_TIME = BLOW_TIME;
    }

    public Integer getKILL_TIME() {
        return KILL_TIME;
    }

    public void setKILL_TIME(Integer KILL_TIME) {
        this.KILL_TIME = KILL_TIME;
    }

    public Integer getSTEEL_TIME() {
        return STEEL_TIME;
    }

    public void setSTEEL_TIME(Integer STEEL_TIME) {
        this.STEEL_TIME = STEEL_TIME;
    }

    public Integer getSPATTER_SLAG_TIME() {
        return SPATTER_SLAG_TIME;
    }

    public void setSPATTER_SLAG_TIME(Integer SPATTER_SLAG_TIME) {
        this.SPATTER_SLAG_TIME = SPATTER_SLAG_TIME;
    }

    public Integer getREMOVE_SLAG_TIME() {
        return REMOVE_SLAG_TIME;
    }

    public void setREMOVE_SLAG_TIME(Integer REMOVE_SLAG_TIME) {
        this.REMOVE_SLAG_TIME = REMOVE_SLAG_TIME;
    }

    public Integer getMNBL_O_VOL() {
        return MNBL_O_VOL;
    }

    public void setMNBL_O_VOL(Integer MNBL_O_VOL) {
        this.MNBL_O_VOL = MNBL_O_VOL;
    }

    public Integer getREAL_ALO_YEILD_C() {
        return REAL_ALO_YEILD_C;
    }

    public void setREAL_ALO_YEILD_C(Integer REAL_ALO_YEILD_C) {
        this.REAL_ALO_YEILD_C = REAL_ALO_YEILD_C;
    }

    public Integer getREAL_ALO_YEILD_SI() {
        return REAL_ALO_YEILD_SI;
    }

    public void setREAL_ALO_YEILD_SI(Integer REAL_ALO_YEILD_SI) {
        this.REAL_ALO_YEILD_SI = REAL_ALO_YEILD_SI;
    }

    public Integer getREAL_ALO_YEILD_MN() {
        return REAL_ALO_YEILD_MN;
    }

    public void setREAL_ALO_YEILD_MN(Integer REAL_ALO_YEILD_MN) {
        this.REAL_ALO_YEILD_MN = REAL_ALO_YEILD_MN;
    }

    public Integer getREAL_ALO_YEILD_AL() {
        return REAL_ALO_YEILD_AL;
    }

    public void setREAL_ALO_YEILD_AL(Integer REAL_ALO_YEILD_AL) {
        this.REAL_ALO_YEILD_AL = REAL_ALO_YEILD_AL;
    }

    public String getSCRAP_LOAD_TIME() {
        return SCRAP_LOAD_TIME;
    }

    public void setSCRAP_LOAD_TIME(String SCRAP_LOAD_TIME) {
        this.SCRAP_LOAD_TIME = SCRAP_LOAD_TIME;
    }

    public String getIRON_LOAD_TIME() {
        return IRON_LOAD_TIME;
    }

    public void setIRON_LOAD_TIME(String IRON_LOAD_TIME) {
        this.IRON_LOAD_TIME = IRON_LOAD_TIME;
    }

    public String getO2_LANCE_NO() {
        return O2_LANCE_NO;
    }

    public void setO2_LANCE_NO(String o2_LANCE_NO) {
        O2_LANCE_NO = o2_LANCE_NO;
    }

    public Integer getO2_LANCE_NUM() {
        return O2_LANCE_NUM;
    }

    public void setO2_LANCE_NUM(Integer o2_LANCE_NUM) {
        O2_LANCE_NUM = o2_LANCE_NUM;
    }

    public Integer getSURE_FIT_LANCE_DETECTOR_TOTAL() {
        return SURE_FIT_LANCE_DETECTOR_TOTAL;
    }

    public void setSURE_FIT_LANCE_DETECTOR_TOTAL(Integer SURE_FIT_LANCE_DETECTOR_TOTAL) {
        this.SURE_FIT_LANCE_DETECTOR_TOTAL = SURE_FIT_LANCE_DETECTOR_TOTAL;
    }

    public Integer getUN_FIT_LANCE_DETECTOR_TOTAL() {
        return UN_FIT_LANCE_DETECTOR_TOTAL;
    }

    public void setUN_FIT_LANCE_DETECTOR_TOTAL(Integer UN_FIT_LANCE_DETECTOR_TOTAL) {
        this.UN_FIT_LANCE_DETECTOR_TOTAL = UN_FIT_LANCE_DETECTOR_TOTAL;
    }

    public Integer getSMELT_TIME() {
        return SMELT_TIME;
    }

    public void setSMELT_TIME(Integer SMELT_TIME) {
        this.SMELT_TIME = SMELT_TIME;
    }

    public Integer getRETURN_STEEL_SCHDL_SEQ_NO() {
        return RETURN_STEEL_SCHDL_SEQ_NO;
    }

    public void setRETURN_STEEL_SCHDL_SEQ_NO(Integer RETURN_STEEL_SCHDL_SEQ_NO) {
        this.RETURN_STEEL_SCHDL_SEQ_NO = RETURN_STEEL_SCHDL_SEQ_NO;
    }

    public String getPONO_NO() {
        return PONO_NO;
    }

    public void setPONO_NO(String PONO_NO) {
        this.PONO_NO = PONO_NO;
    }

    public Integer getFUTUO() {
        return FUTUO;
    }

    public void setFUTUO(Integer FUTUO) {
        this.FUTUO = FUTUO;
    }

    public Integer getSIMNALLOY() {
        return SIMNALLOY;
    }

    public void setSIMNALLOY(Integer SIMNALLOY) {
        this.SIMNALLOY = SIMNALLOY;
    }

    public Integer getSIFEALLOY() {
        return SIFEALLOY;
    }

    public void setSIFEALLOY(Integer SIFEALLOY) {
        this.SIFEALLOY = SIFEALLOY;
    }

    public Integer getSIMN() {
        return SIMN;
    }

    public void setSIMN(Integer SIMN) {
        this.SIMN = SIMN;
    }

    public Integer getSIFE() {
        return SIFE;
    }

    public void setSIFE(Integer SIFE) {
        this.SIFE = SIFE;
    }

    public Integer getALLOY1() {
        return ALLOY1;
    }

    public void setALLOY1(Integer ALLOY1) {
        this.ALLOY1 = ALLOY1;
    }

    public Integer getBA() {
        return BA;
    }

    public void setBA(Integer BA) {
        this.BA = BA;
    }

    public Integer getGXAL() {
        return GXAL;
    }

    public void setGXAL(Integer GXAL) {
        this.GXAL = GXAL;
    }

    public Integer getVFE() {
        return VFE;
    }

    public void setVFE(Integer VFE) {
        this.VFE = VFE;
    }

    public Integer getVN() {
        return VN;
    }

    public void setVN(Integer VN) {
        this.VN = VN;
    }

    public Integer getC() {
        return C;
    }

    public void setC(Integer c) {
        C = c;
    }

    public Integer getALMN() {
        return ALMN;
    }

    public void setALMN(Integer ALMN) {
        this.ALMN = ALMN;
    }

    public Integer getBACASI() {
        return BACASI;
    }

    public void setBACASI(Integer BACASI) {
        this.BACASI = BACASI;
    }

    public Integer getALMNTI() {
        return ALMNTI;
    }

    public void setALMNTI(Integer ALMNTI) {
        this.ALMNTI = ALMNTI;
    }

    public Integer getMN_MED() {
        return MN_MED;
    }

    public void setMN_MED(Integer MN_MED) {
        this.MN_MED = MN_MED;
    }

    public Integer getMN_HIGH() {
        return MN_HIGH;
    }

    public void setMN_HIGH(Integer MN_HIGH) {
        this.MN_HIGH = MN_HIGH;
    }

    public Integer getLT_NUM() {
        return LT_NUM;
    }

    public void setLT_NUM(Integer LT_NUM) {
        this.LT_NUM = LT_NUM;
    }

    public Integer getLT_TEMP() {
        return LT_TEMP;
    }

    public void setLT_TEMP(Integer LT_TEMP) {
        this.LT_TEMP = LT_TEMP;
    }

    public Integer getLT_DIA() {
        return LT_DIA;
    }

    public void setLT_DIA(Integer LT_DIA) {
        this.LT_DIA = LT_DIA;
    }

    public Integer getCOUNT_LT() {
        return COUNT_LT;
    }

    public void setCOUNT_LT(Integer COUNT_LT) {
        this.COUNT_LT = COUNT_LT;
    }

    public String getBLOW_LOW() {
        return BLOW_LOW;
    }

    public void setBLOW_LOW(String BLOW_LOW) {
        this.BLOW_LOW = BLOW_LOW;
    }

    public Integer getCONTROL_O() {
        return CONTROL_O;
    }

    public void setCONTROL_O(Integer CONTROL_O) {
        this.CONTROL_O = CONTROL_O;
    }

    public Integer getLD_DEEP() {
        return LD_DEEP;
    }

    public void setLD_DEEP(Integer LD_DEEP) {
        this.LD_DEEP = LD_DEEP;
    }

    public Integer getXPT_TEMP() {
        return XPT_TEMP;
    }

    public void setXPT_TEMP(Integer XPT_TEMP) {
        this.XPT_TEMP = XPT_TEMP;
    }

    public Integer getMN_LOW() {
        return MN_LOW;
    }

    public void setMN_LOW(Integer MN_LOW) {
        this.MN_LOW = MN_LOW;
    }

    public Integer getCR_LOW() {
        return CR_LOW;
    }

    public void setCR_LOW(Integer CR_LOW) {
        this.CR_LOW = CR_LOW;
    }

    public Integer getFENB() {
        return FENB;
    }

    public void setFENB(Integer FENB) {
        this.FENB = FENB;
    }

    public Integer getFEP() {
        return FEP;
    }

    public void setFEP(Integer FEP) {
        this.FEP = FEP;
    }

    public Integer getCR_MED() {
        return CR_MED;
    }

    public void setCR_MED(Integer CR_MED) {
        this.CR_MED = CR_MED;
    }

    public Integer getCOPPER() {
        return COPPER;
    }

    public void setCOPPER(Integer COPPER) {
        this.COPPER = COPPER;
    }

    public Integer getALUMINIUM() {
        return ALUMINIUM;
    }

    public void setALUMINIUM(Integer ALUMINIUM) {
        this.ALUMINIUM = ALUMINIUM;
    }

    public Integer getNI_BAN() {
        return NI_BAN;
    }

    public void setNI_BAN(Integer NI_BAN) {
        this.NI_BAN = NI_BAN;
    }

    public Integer getFEMO() {
        return FEMO;
    }

    public void setFEMO(Integer FEMO) {
        this.FEMO = FEMO;
    }

    public Integer getCUNI() {
        return CUNI;
    }

    public void setCUNI(Integer CUNI) {
        this.CUNI = CUNI;
    }

    public Integer getFENI() {
        return FENI;
    }

    public void setFENI(Integer FENI) {
        this.FENI = FENI;
    }

    public Integer getC_ADD() {
        return C_ADD;
    }

    public void setC_ADD(Integer c_ADD) {
        C_ADD = c_ADD;
    }

    public Integer getAL_ADD() {
        return AL_ADD;
    }

    public void setAL_ADD(Integer AL_ADD) {
        this.AL_ADD = AL_ADD;
    }

    public Integer getSLAG_YR() {
        return SLAG_YR;
    }

    public void setSLAG_YR(Integer SLAG_YR) {
        this.SLAG_YR = SLAG_YR;
    }

    public Integer getLADLE_LIFE() {
        return LADLE_LIFE;
    }

    public void setLADLE_LIFE(Integer LADLE_LIFE) {
        this.LADLE_LIFE = LADLE_LIFE;
    }

    public Integer getHECHENG() {
        return HECHENG;
    }

    public void setHECHENG(Integer HECHENG) {
        this.HECHENG = HECHENG;
    }

    public Integer getDHFT() {
        return DHFT;
    }

    public void setDHFT(Integer DHFT) {
        this.DHFT = DHFT;
    }

    public Integer getMN() {
        return MN;
    }

    public void setMN(Integer MN) {
        this.MN = MN;
    }

    public Integer getLMT() {
        return LMT;
    }

    public void setLMT(Integer LMT) {
        this.LMT = LMT;
    }

    public String getZNLG() {
        return ZNLG;
    }

    public void setZNLG(String ZNLG) {
        this.ZNLG = ZNLG;
    }

    public String getZJCG() {
        return ZJCG;
    }

    public void setZJCG(String ZJCG) {
        this.ZJCG = ZJCG;
    }

    public String getART() {
        return ART;
    }

    public void setART(String ART) {
        this.ART = ART;
    }

    public Integer getCMG() {
        return CMG;
    }

    public void setCMG(Integer CMG) {
        this.CMG = CMG;
    }

    public Integer getFEV() {
        return FEV;
    }

    public void setFEV(Integer FEV) {
        this.FEV = FEV;
    }

    public Integer getQSMG() {
        return QSMG;
    }

    public void setQSMG(Integer QSMG) {
        this.QSMG = QSMG;
    }

    public Integer getGBWD() {
        return GBWD;
    }

    public void setGBWD(Integer GBWD) {
        this.GBWD = GBWD;
    }

    public Integer getTSC_C() {
        return TSC_C;
    }

    public void setTSC_C(Integer TSC_C) {
        this.TSC_C = TSC_C;
    }

    public Integer getTSC_TEMP() {
        return TSC_TEMP;
    }

    public void setTSC_TEMP(Integer TSC_TEMP) {
        this.TSC_TEMP = TSC_TEMP;
    }

    public Integer getTSO_C() {
        return TSO_C;
    }

    public void setTSO_C(Integer TSO_C) {
        this.TSO_C = TSO_C;
    }

    public Integer getTSO_TEMP() {
        return TSO_TEMP;
    }

    public void setTSO_TEMP(Integer TSO_TEMP) {
        this.TSO_TEMP = TSO_TEMP;
    }

    public String getPJQK() {
        return PJQK;
    }

    public void setPJQK(String PJQK) {
        this.PJQK = PJQK;
    }

    public Integer getTSO_SC() {
        return TSO_SC;
    }

    public void setTSO_SC(Integer TSO_SC) {
        this.TSO_SC = TSO_SC;
    }

    public Integer getCXO() {
        return CXO;
    }

    public void setCXO(Integer CXO) {
        this.CXO = CXO;
    }

    public Integer getHB_NUM() {
        return HB_NUM;
    }

    public void setHB_NUM(Integer HB_NUM) {
        this.HB_NUM = HB_NUM;
    }

    public Integer getNSK_NUM() {
        return NSK_NUM;
    }

    public void setNSK_NUM(Integer NSK_NUM) {
        this.NSK_NUM = NSK_NUM;
    }

    public String getSHUANCAO() {
        return SHUANCAO;
    }

    public void setSHUANCAO(String SHUANCAO) {
        this.SHUANCAO = SHUANCAO;
    }

    public String getSHUANGZHA() {
        return SHUANGZHA;
    }

    public void setSHUANGZHA(String SHUANGZHA) {
        this.SHUANGZHA = SHUANGZHA;
    }

    public Integer getSICABA() {
        return SICABA;
    }

    public void setSICABA(Integer SICABA) {
        this.SICABA = SICABA;
    }

    public Integer getHISIMIDMN() {
        return HISIMIDMN;
    }

    public void setHISIMIDMN(Integer HISIMIDMN) {
        this.HISIMIDMN = HISIMIDMN;
    }

    public Integer getDYNA_ASC_1() {
        return DYNA_ASC_1;
    }

    public void setDYNA_ASC_1(Integer DYNA_ASC_1) {
        this.DYNA_ASC_1 = DYNA_ASC_1;
    }

    public Integer getDYNA_ASC_2() {
        return DYNA_ASC_2;
    }

    public void setDYNA_ASC_2(Integer DYNA_ASC_2) {
        this.DYNA_ASC_2 = DYNA_ASC_2;
    }

    public Integer getDYNA_ASC_3() {
        return DYNA_ASC_3;
    }

    public void setDYNA_ASC_3(Integer DYNA_ASC_3) {
        this.DYNA_ASC_3 = DYNA_ASC_3;
    }

    public Integer getDYNA_ASC_4() {
        return DYNA_ASC_4;
    }

    public void setDYNA_ASC_4(Integer DYNA_ASC_4) {
        this.DYNA_ASC_4 = DYNA_ASC_4;
    }

    public Integer getDYNA_ASC_5() {
        return DYNA_ASC_5;
    }

    public void setDYNA_ASC_5(Integer DYNA_ASC_5) {
        this.DYNA_ASC_5 = DYNA_ASC_5;
    }

    public Integer getDYNA_ASC_6() {
        return DYNA_ASC_6;
    }

    public void setDYNA_ASC_6(Integer DYNA_ASC_6) {
        this.DYNA_ASC_6 = DYNA_ASC_6;
    }

    public Integer getDYNA_ASC_7() {
        return DYNA_ASC_7;
    }

    public void setDYNA_ASC_7(Integer DYNA_ASC_7) {
        this.DYNA_ASC_7 = DYNA_ASC_7;
    }

    public Integer getDYNA_ASC_8() {
        return DYNA_ASC_8;
    }

    public void setDYNA_ASC_8(Integer DYNA_ASC_8) {
        this.DYNA_ASC_8 = DYNA_ASC_8;
    }

    public Integer getDYNA_ASC_9() {
        return DYNA_ASC_9;
    }

    public void setDYNA_ASC_9(Integer DYNA_ASC_9) {
        this.DYNA_ASC_9 = DYNA_ASC_9;
    }

    public Integer getDYNA_ASC_10() {
        return DYNA_ASC_10;
    }

    public void setDYNA_ASC_10(Integer DYNA_ASC_10) {
        this.DYNA_ASC_10 = DYNA_ASC_10;
    }

    public String getGBJG() {
        return GBJG;
    }

    public void setGBJG(String GBJG) {
        this.GBJG = GBJG;
    }

    public Integer getTSO_DETECTOR() {
        return TSO_DETECTOR;
    }

    public void setTSO_DETECTOR(Integer TSO_DETECTOR) {
        this.TSO_DETECTOR = TSO_DETECTOR;
    }

    public Integer getTSC_DETECTOR() {
        return TSC_DETECTOR;
    }

    public void setTSC_DETECTOR(Integer TSC_DETECTOR) {
        this.TSC_DETECTOR = TSC_DETECTOR;
    }

    public String getCC_MACH_NO() {
        return CC_MACH_NO;
    }

    public void setCC_MACH_NO(String CC_MACH_NO) {
        this.CC_MACH_NO = CC_MACH_NO;
    }

}
