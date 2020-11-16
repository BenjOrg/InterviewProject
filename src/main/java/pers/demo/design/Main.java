package pers.demo.design;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;

import com.alibaba.fastjson.JSON;
import pers.demo.design.domain.GroupStep;
import pers.demo.design.domain.OperationStep;
import pers.demo.design.domain.RouterLinkStep;
import pers.demo.design.factory.GroupStepFactory;
import pers.demo.design.factory.OperationStepFactory;
import pers.demo.design.factory.RouterLinkStepFactory;

public class Main {

    public static void main(String[] args) {
        StepVO vo1 = new StepVO();
        vo1.setStepId(1L);
        vo1.setRouterId(1L);
        vo1.setStepName("A");
        vo1.setStepDesc("A");
        vo1.setStepDesc("A");
        StepVO.InnerGroupVO groupVO = new StepVO.InnerGroupVO();
        groupVO.setGroupId(101L);
        vo1.setGroupVO(groupVO);

        StepVO vo2 = new StepVO();
        vo2.setStepId(2L);
        vo2.setRouterId(1L);
        vo2.setStepName("B");
        vo2.setStepDesc("B");
        vo2.setStepDesc("B");
        StepVO.InnerOperationVO operationVO = new StepVO.InnerOperationVO();
        operationVO.setOperationId(102L);
        vo2.setOperationVO(operationVO);

        StepVO vo3 = new StepVO();
        vo3.setStepId(3L);
        vo3.setRouterId(1L);
        vo3.setStepName("C");
        vo3.setStepDesc("C");
        vo3.setStepDesc("C");
        StepVO.InnerRouterLinkVO linkVO = new StepVO.InnerRouterLinkVO();
        linkVO.setLinkRouterId(3L);
        vo3.setRouterLinkVO(linkVO);

        System.out.println(JSON.toJSONString(vo1, PrettyFormat));
        System.out.println(JSON.toJSONString(vo2, PrettyFormat));
        System.out.println(JSON.toJSONString(vo3, PrettyFormat));

        GroupStepFactory gf = new GroupStepFactory();
        GroupStep s1 = gf.createStep(vo1);
        OperationStepFactory of = new OperationStepFactory();
        OperationStep s2 = of.createStep(vo2);
        RouterLinkStepFactory rf = new RouterLinkStepFactory();
        RouterLinkStep s3 = rf.createStep(vo3);

        System.out.println("-----------------result-----------------");
        System.out.println(JSON.toJSONString(s1, PrettyFormat));
        System.out.println(JSON.toJSONString(s2, PrettyFormat));
        System.out.println(JSON.toJSONString(s3, PrettyFormat));
    }
}
