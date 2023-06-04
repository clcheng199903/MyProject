package com.example.mybatisdemospringmutildatasource.domain;

import lombok.Data;

@Data
public class TPSSM11 {
    private String REC_CREATOR;
    private String REC_CREATE_TIME;
    private String REC_REVISOR;
    private String REC_REVISE_TIME;
    private String ARCHIVE_FLAG;
    private String MAIN_BACKLOG_CODE;
    /**
     * 制造命令号：一个炉号一个
     */
    private String PONO;
    private String SCHDL_SEQ_NO;
    /**
     * 执行标准号
     */
    private String ST_NO;
    /**
     * 精炼路径，L：1#精炼
     */
    private String REFINE_ROUTE_CODE;
    /**
     * 制造状态：81，82，83
     * 只有在浇：82（代码逻辑只识别在浇）
     * 浇了：83，在浇81（可能是大包车旋转状态是这两个标识）
     */
    private String PONO_STATUS;
    private String SMELT_MODE;
    /**
     * 炉号，BOF生产的，一共4个转炉，H234，23年的4号转炉，四个炉都可能浇到1#连铸
     * （之前听说1#精炼和2#精炼可能到1#连铸，基本上都是1#精炼到1#连铸，调度不够才用2#精炼）
     */
    private String HEAT_NO;
    private String STEEL_RETURN_CODE;
    private String RET_NUM;
    private String PLAN_TAP_WT;
    /**
     * 连铸机号（应该是连铸机号，一般都是空）
     * 可用CAST_NO首位标识连铸机
     */
    private String CC_MARK;
    /**
     * 浇次计划号，首位代表几号连铸产线，整个浇次一个号
     */
    private String CAST_NO;
    /**
     * 浇次生产的铸坯数量
     * （根据中间包寿命觉得一个浇次的通钢量，一般是60铸坯左右，需要换中间包，换下来的中间包需要修补）
     */
    private String CAST_DIV_NO;
    private String CAST_PONO_SUM;
    private String BACKLOG_EA;
    private String TD_CHG_FLG;
    private String PLAN_STYLE;
    private String CC_REQ_TIME;
    /**
     * 早到时间（比计划时间的差值）
     */
    private String EARLY_TIME;
    private String RUN_STATUS;
    private String PLAN_EDIT_FLAG;
    private String TPD_START_TIME;
    /**
     * 班别
     */
    private String SHIFT_NO;
    /**
     * 班组
     */
    private String SHIFT_GROUP;
    private String SEQ;
}
