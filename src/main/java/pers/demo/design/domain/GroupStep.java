package pers.demo.design.domain;

import java.io.Serializable;
import java.util.List;

import pers.demo.design.StepVO;

/**
 * @author benjamin
 */
public class GroupStep extends Step implements Serializable {
    private static final long serialVersionUID = 7910897596591014662L;

    private Long groupId;

    private List<OperationStep> groupStepList;

    @Override
    public void checkStepDetail() {
        super.isStepTypeValid();


    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<OperationStep> getGroupStepList() {
        return groupStepList;
    }

    public void setGroupStepList(List<OperationStep> groupStepList) {
        this.groupStepList = groupStepList;
    }
}
