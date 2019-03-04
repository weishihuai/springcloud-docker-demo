package com.wsh.springcloud.punishmentservice.controller;

import com.wsh.springcloud.punishmentservice.service.ViolationService;
import com.wsh.springcloud.punishmentservice.vo.ViolationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/3/4 14:08
 */
@RestController
public class ViolationController {
    @Autowired
    private ViolationService violationService;

    @GetMapping("/getViolationDetail/{violationId}")
    public ViolationVO getViolationDetail(@PathVariable("violationId") String violationId) {
        return violationService.getViolationDetail(violationId);
    }

}
