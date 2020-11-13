package pers.demo.design;

import java.io.Serializable;

/**
 * @author benjamin
 */
public class StepVO implements Serializable {
    private static final long serialVersionUID = 6601576784112529406L;

    private Long stepId;
    private String stepName;
    private String stepDesc;
    private String stepType;

    private Long routerId;

    private InnerOperationVO operationVO;
    private InnerRouterLinkVO routerLinkVO;
    private InnerGroupVO groupVO;

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public Long getRouterId() {
        return routerId;
    }

    public void setRouterId(Long routerId) {
        this.routerId = routerId;
    }

    public InnerOperationVO getOperationVO() {
        return operationVO;
    }

    public void setOperationVO(InnerOperationVO operationVO) {
        this.operationVO = operationVO;
    }

    public InnerRouterLinkVO getRouterLinkVO() {
        return routerLinkVO;
    }

    public void setRouterLinkVO(InnerRouterLinkVO routerLinkVO) {
        this.routerLinkVO = routerLinkVO;
    }

    public InnerGroupVO getGroupVO() {
        return groupVO;
    }

    public void setGroupVO(InnerGroupVO groupVO) {
        this.groupVO = groupVO;
    }

    public static class InnerOperationVO implements Serializable{
        private static final long serialVersionUID = 6928189838426950616L;

        private Long operationId;

        public Long getOperationId() {
            return operationId;
        }

        public void setOperationId(Long operationId) {
            this.operationId = operationId;
        }
    }

    public static class InnerRouterLinkVO implements Serializable{
        private static final long serialVersionUID = 6303605127586839312L;

        private Long linkRouterId;

        public Long getLinkRouterId() {
            return linkRouterId;
        }

        public void setLinkRouterId(Long linkRouterId) {
            this.linkRouterId = linkRouterId;
        }
    }

    public static class InnerGroupVO implements Serializable{
        private static final long serialVersionUID = 1357035920152721665L;

        private Long groupId;

        public Long getGroupId() {
            return groupId;
        }

        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }
    }
}
