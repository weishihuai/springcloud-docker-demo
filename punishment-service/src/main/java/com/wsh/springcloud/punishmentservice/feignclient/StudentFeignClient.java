package com.wsh.springcloud.punishmentservice.feignclient;

import com.wsh.springcloud.punishmentservice.fallback.StudentFeignClientFallback;
import com.wsh.springcloud.punishmentservice.vo.StudentVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 远程服务调用接口
 * @author: weishihuai
 * @Date: 2019/3/4 14:37
 * 说明: 声明该类为远程服务调用接口,并且制定需指定要调用服务的serviceId,并且可以指定远程调用失败回调类
 */
@FeignClient(value = "student-service", fallback = StudentFeignClientFallback.class)
public interface StudentFeignClient {

    /**
     * 根据学生ID查询学生信息
     *
     * @param stuId 学生ID
     * @return
     * 注意: 这里不能使用组合注解@GetMapping
     */
    @RequestMapping(value = "/getStudentDetail/{stuId}", method = RequestMethod.GET)
    StudentVO getStudentDetail(@PathVariable("stuId") String stuId);

}
