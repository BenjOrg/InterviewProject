package pers.demo.design.domain;

import java.io.Serializable;

import pers.demo.design.StepVO;

/**
 * @author benjamin
 */
public class OperationStep extends Step implements Serializable {
    private static final long serialVersionUID = -2769414645352341419L;

    private Long operationId;

    @Override
    public void checkStepDetail() {

    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
}
