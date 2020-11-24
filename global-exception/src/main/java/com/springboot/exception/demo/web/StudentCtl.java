package com.springboot.exception.demo.web;

import com.springboot.exception.demo.model.param.StudentParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Controller
@Validated
public class StudentCtl {

    @PostMapping(value = "/student/save")
    public ResponseEntity<?> saveStudent(StudentParam studentParam) {
        System.out.println("Aaaaaaaaaa");
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/student/findById")
    public ResponseEntity<?> saveStudent(@NotBlank(message = "id不能为空") String id) {
        return ResponseEntity.ok(null);
    }
}
