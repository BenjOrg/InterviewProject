package pers.demo.design.factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import pers.demo.design.StepVO;
import pers.demo.design.domain.GroupStep;
import pers.demo.design.domain.OperationStep;

/**
 * @author benjamin
 */
public class GroupStepFactory extends StepFactory implements Serializable {
    private static final long serialVersionUID = 3245487074431212721L;

    @Override
    public GroupStep createStep(StepVO vo) {
        this.validateStep(vo);

        GroupStep step = new GroupStep();
        step.setStepId(vo.getStepId());
        step.setStepName(vo.getStepName());
        step.setStepDesc(vo.getStepDesc());
        step.setStepType("GROUP");
        step.setGroupId(vo.getGroupVO().getGroupId());

        step.isStepTypeValid();

        if (CollectionUtils.isNotEmpty(vo.getGroupVO().getGroupStepList())) {
            List<OperationStep> operationStepList = new ArrayList<>();
            for (StepVO stepVO : vo.getGroupVO().getGroupStepList()) {
                OperationStep opStep = new OperationStep();
                opStep.setStepId(stepVO.getStepId());
                opStep.setStepName(vo.getStepName());
                opStep.setStepDesc(vo.getStepDesc());
                opStep.setStepType("OPERATION");
                opStep.isStepTypeValid();
                operationStepList.add(opStep);
            }

            step.setGroupStepList(operationStepList);
        }
        return step;
    }

    @Override
    public void validateStep(StepVO vo) {

    }
}
