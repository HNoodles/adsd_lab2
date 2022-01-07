package fd.adsd.report.controller;

import fd.adsd.report.dto.BaseResponse;
import fd.adsd.report.entiry.Report;
import fd.adsd.report.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/report/")
@Api(tags = "报表汇总")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/deptTasks")
    @ApiOperation("查询所有部门任务报表")
    public BaseResponse<List<Report>> allDeptReport(){
        return new BaseResponse<>(reportService.allDeptReport(),"success");
    }
}
