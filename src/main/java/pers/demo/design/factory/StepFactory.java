package pers.demo.design.factory;

import java.io.Serializable;

import pers.demo.design.StepVO;
import pers.demo.design.domain.Step;

/**
 * @author benjamin
 */
public abstract class StepFactory implements Serializable {
    private static final long serialVersionUID = 3760462011632552594L;

    abstract public Step createStep(StepVO vo);

    abstract public void validateStep(StepVO vo);
}
