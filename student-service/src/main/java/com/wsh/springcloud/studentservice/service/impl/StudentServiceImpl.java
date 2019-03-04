package com.wsh.springcloud.studentservice.service.impl;

import com.wsh.springcloud.studentservice.service.StudentService;
import com.wsh.springcloud.studentservice.vo.StudentVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/3/4 14:49
 */
@Service
public class StudentServiceImpl implements StudentService {

    private static Map<String, StudentVO> studentVOMap = new HashMap<>();

    static {
        studentVOMap.put("1", new StudentVO("1", "zhangsan", 12));
        studentVOMap.put("2", new StudentVO("2", "lisi", 14));
        studentVOMap.put("3", new StudentVO("3", "wangwu", 13));
        studentVOMap.put("4", new StudentVO("4", "zhaoliu", 16));
    }

    @Override
    public StudentVO getStudentDetail(String stuId) {
        if (StringUtils.isBlank(stuId)) {
            return null;
        }
        return studentVOMap.get(stuId);
    }
}
