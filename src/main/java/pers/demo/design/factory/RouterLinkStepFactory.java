package pers.demo.design.factory;

import java.io.Serializable;

import pers.demo.design.StepVO;
import pers.demo.design.domain.RouterLinkStep;
import pers.demo.design.domain.Step;

/**
 * @author benjamin
 */
public class RouterLinkStepFactory extends StepFactory implements Serializable {
    private static final long serialVersionUID = -4714658166369439492L;

    @Override
    public RouterLinkStep createStep(StepVO vo) {
        this.validateStep(vo);

        RouterLinkStep step = new RouterLinkStep();
        step.setStepId(vo.getStepId());
        step.setStepName(vo.getStepName());
        step.setStepDesc(vo.getStepDesc());
        step.setStepType("LINK");
        step.setRouterId(vo.getRouterLinkVO().getLinkRouterId());
        return step;
    }

    @Override
    public void validateStep(StepVO vo) {

    }
}
