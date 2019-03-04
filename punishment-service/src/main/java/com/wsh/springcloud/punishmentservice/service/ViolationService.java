package com.wsh.springcloud.punishmentservice.service;

import com.wsh.springcloud.punishmentservice.vo.ViolationVO;

/**
 * @Description: 违纪服务层接口
 * @author: weishihuai
 * @Date: 2019/3/4 13:46
 */
public interface ViolationService {

    /**
     * 根据违纪ID查询违纪详情信息
     *
     * @param violationId 违纪ID
     * @return
     */
    ViolationVO getViolationDetail(String violationId);

}
