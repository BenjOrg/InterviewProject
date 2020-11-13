package pers.demo.design.domain;

import java.io.Serializable;

import pers.demo.design.StepVO;

/**
 * @author benjamin
 */
public class RouterLinkStep extends Step implements Serializable {
    private static final long serialVersionUID = -9080765003674080866L;

    private Long routerId;

    @Override
    public void setSelfInfo(StepVO vo) {
        if (null == vo.getRouterLinkVO()) {
            return;
        }
        this.setRouterId(vo.getRouterLinkVO().getLinkRouterId());
    }

    public Long getRouterId() {
        return routerId;
    }

    private void setRouterId(Long routerId) {
        this.routerId = routerId;
    }
}
