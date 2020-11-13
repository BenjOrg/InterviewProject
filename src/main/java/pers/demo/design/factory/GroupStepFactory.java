package pers.demo.design.factory;

import java.io.Serializable;

import pers.demo.design.StepVO;
import pers.demo.design.domain.GroupStep;
import pers.demo.design.domain.Step;

/**
 * @author benjamin
 */
public class GroupStepFactory extends StepFactory implements Serializable {
    private static final long serialVersionUID = 3245487074431212721L;

    @Override
    public GroupStep createStep(StepVO vo) {
        GroupStep step = new GroupStep();
        step.setStepId(vo.getStepId());
        step.setStepName(vo.getStepName());
        step.setStepDesc(vo.getStepDesc());
        step.setStepType("GROUP");
        step.setSelfInfo(vo);
        return step;
    }

    @Override
    public void validateStep(Step vo) {

    }
}
