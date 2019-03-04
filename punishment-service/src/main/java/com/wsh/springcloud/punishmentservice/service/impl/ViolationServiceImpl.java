package com.wsh.springcloud.punishmentservice.service.impl;

import com.wsh.springcloud.punishmentservice.entity.ViolationPO;
import com.wsh.springcloud.punishmentservice.feignclient.StudentFeignClient;
import com.wsh.springcloud.punishmentservice.service.ViolationService;
import com.wsh.springcloud.punishmentservice.utils.MyBeanUtils;
import com.wsh.springcloud.punishmentservice.vo.StudentVO;
import com.wsh.springcloud.punishmentservice.vo.ViolationVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 违纪服务层实现层接口
 * @author: weishihuai
 * @Date: 2019/3/4 13:53
 */
@Service
public class ViolationServiceImpl implements ViolationService {

    @Autowired
    private StudentFeignClient studentFeignClient;

    /**
     * 模拟的违纪信息(具体需要查询数据库)
     */
    private static Map<String, ViolationPO> violationMap = new HashMap<>();

    static {
        violationMap.put("1", new ViolationPO("1", "违规使用手机", "日常违纪", "1"));
        violationMap.put("2", new ViolationPO("2", "考试作弊", "考试违纪", "2"));
    }

    @Override
    public ViolationVO getViolationDetail(String violationId) {
        if (StringUtils.isBlank(violationId)) {
            return null;
        }

        //查询违纪详情信息(模拟测试数据)
        ViolationPO violationPO = violationMap.get(violationId);
        ViolationVO violationVO = null;
        if (null != violationPO) {
            violationVO = MyBeanUtils.clonePoToVo(violationPO, ViolationVO.class);
            if (null != violationVO) {
                String violationStuId = violationVO.getViolationStuId();
                //调用学生服务查询学生基本信息
                StudentVO studentDetail = studentFeignClient.getStudentDetail(violationStuId);
                if (null != studentDetail) {
                    violationVO.setViolationStuName(StringUtils.isNotBlank(studentDetail.getName()) ? studentDetail.getName() : "");
                }
            }
        }
        return violationVO;
    }
}
