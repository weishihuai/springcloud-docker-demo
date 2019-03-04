package com.wsh.springcloud.studentservice.controller;

import com.wsh.springcloud.studentservice.service.StudentService;
import com.wsh.springcloud.studentservice.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/3/4 14:46
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentDetail/{stuId}")
    public StudentVO getStudentDetail(@PathVariable("stuId") String stuId) {
        return studentService.getStudentDetail(stuId);
    }

}
