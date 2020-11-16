package pers.demo.design.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author benjamin
 */
public abstract class Step implements Serializable {
    private static final long serialVersionUID = 4661818535949668298L;

    private Long stepId;
    private String stepName;
    private String stepDesc;
    private String stepType;
    private Long sequence;

    private Boolean keyStepFlag;
    private Boolean entryStepFlag;
    private Boolean doneStepFlag;
    private Boolean returnStepFlag;

    abstract public void checkStepDetail();

    public void isStepTypeValid() {
        if (!Arrays.asList("OPERATION", "GROUP", "ROUTER").contains(stepType)) {
            throw new RuntimeException("type is not valid");
        }
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Boolean getKeyStepFlag() {
        return keyStepFlag;
    }

    public Boolean getEntryStepFlag() {
        return entryStepFlag;
    }

    public Boolean getDoneStepFlag() {
        return doneStepFlag;
    }

    public Boolean getReturnStepFlag() {
        return returnStepFlag;
    }

    public void enableKeyStep() {
        this.keyStepFlag = Boolean.TRUE;
    }

    public void disableKeyStep() {
        this.keyStepFlag = Boolean.FALSE;
    }

    public void enableEntryStep() {
        this.entryStepFlag = Boolean.TRUE;
    }

    public void disableEntryStep() {
        this.entryStepFlag = Boolean.FALSE;
    }

    public void enableDoneStep() {
        this.doneStepFlag = Boolean.TRUE;
    }

    public void disableDoneStep() {
        this.doneStepFlag = Boolean.FALSE;
    }

    public void enableReturnStep() {
        this.returnStepFlag = Boolean.TRUE;
    }

    public void disableReturnStep() {
        this.returnStepFlag = Boolean.FALSE;
    }
}
