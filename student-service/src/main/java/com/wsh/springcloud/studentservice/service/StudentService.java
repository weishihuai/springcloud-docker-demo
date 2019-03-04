package com.wsh.springcloud.studentservice.service;

import com.wsh.springcloud.studentservice.vo.StudentVO;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/3/4 14:48
 */
public interface StudentService {

    StudentVO getStudentDetail(String stuId);

}
