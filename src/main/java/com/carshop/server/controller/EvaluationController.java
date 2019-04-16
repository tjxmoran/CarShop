package com.carshop.server.controller;


import com.carshop.server.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/evaluation",produces = { "application/json;charset=UTF-8"})
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    //1:通过商户shopId拉取每个商户订单的评价
    //2:通过用户id和carId拉取每个用户的每个订单的评价
    //3:通过carId拉取每辆车的所有订单的评价
    @PostMapping("/getEvaluation")
    public Map<String,Object> getEvaluation(@RequestBody Map<String,String> params){
        return evaluationService.getEvaluation(params);
    }

    //用户对已完成的订单进行评价
    @PostMapping("/addEvaluation")
    public Map<String,Object> addEvaluation(@RequestBody Map<String,String> params){
        return evaluationService.addEvaluation(params);
    }


}
