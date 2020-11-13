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
    public void setSelfInfo(StepVO vo) {
        if (null == vo.getOperationVO()) {
            return;
        }
        this.setOperationId(vo.getOperationVO().getOperationId());
    }

    public Long getOperationId() {
        return operationId;
    }

    private void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
}
