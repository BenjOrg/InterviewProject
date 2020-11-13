package pers.demo.design.domain;

import java.io.Serializable;

import pers.demo.design.StepVO;

/**
 * @author benjamin
 */
public class GroupStep extends Step implements Serializable {
    private static final long serialVersionUID = 7910897596591014662L;

    private Long groupId;

    @Override
    public void setSelfInfo(StepVO vo) {
        if (null == vo.getGroupVO()) {
            return;
        }
        this.setGroupId(vo.getGroupVO().getGroupId());
    }

    public Long getGroupId() {
        return groupId;
    }

    private void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
