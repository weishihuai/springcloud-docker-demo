package com.wsh.springcloud.punishmentservice.fallback;

import com.wsh.springcloud.punishmentservice.feignclient.StudentFeignClient;
import com.wsh.springcloud.punishmentservice.vo.StudentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 远程服务调用接口失败回调类
 * @author: weishihuai
 * @Date: 2019/3/4 14:41
 */
@Component
public class StudentFeignClientFallback implements StudentFeignClient {

    private static final Logger logger = LoggerFactory.getLogger(StudentFeignClientFallback.class);

    @Override
    public StudentVO getStudentDetail(String stuId) {
        logger.error("远程服务调用失败.");
        return null;
    }

}
