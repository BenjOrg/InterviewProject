package pers.demo.design.factory;

import java.io.Serializable;

import pers.demo.design.StepVO;
import pers.demo.design.domain.OperationStep;
import pers.demo.design.domain.Step;

/**
 * @author benjamin
 */
public class OperationStepFactory extends StepFactory implements Serializable {
    private static final long serialVersionUID = 3515011620222188766L;

    @Override
    public OperationStep createStep(StepVO vo) {
        OperationStep step = new OperationStep();
        step.setStepId(vo.getStepId());
        step.setStepName(vo.getStepName());
        step.setStepDesc(vo.getStepDesc());
        step.setStepType("OPERATION");
        step.setSelfInfo(vo);
        return step;
    }

    @Override
    public void validateStep(Step vo) {

    }
}
