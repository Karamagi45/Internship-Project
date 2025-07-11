package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.risk_assessment;
import com.internship2025.changemanagementsystem.Services.riskAssessmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risks")
public class riskAssessmentController {

    private final riskAssessmentService riskAssessmentService ;

    public riskAssessmentController(riskAssessmentService riskAssessmentService) {
        this.riskAssessmentService = riskAssessmentService;
    }

    @GetMapping("findAllRiskAssessment")
    public ApiResponse<?> findAllRiskAssessment(){
        return  riskAssessmentService.findAllRiskAssessment();
    }

    @PostMapping("saveRisks")
    public ApiResponse<?> saveRisks(@RequestBody  risk_assessment assessments){

        return  riskAssessmentService.saveRisks(assessments);
    }

}
