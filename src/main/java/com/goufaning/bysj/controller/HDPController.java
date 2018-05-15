package com.goufaning.bysj.controller;


import com.goufaning.bysj.hdp.HDPGibbsSampler;
import com.goufaning.bysj.pojo.Result;
import com.goufaning.bysj.utils.DataUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@SpringBootApplication
@RestController
public class HDPController {

    @RequestMapping(value="/hdp",method = RequestMethod.GET)
    @ResponseBody
    public Result index(@RequestParam("times")int times, HttpSession session) throws IOException {
        String userId = session.getId();
        DataUtil.getResult(userId);
        Result result = HDPGibbsSampler.hdp(times);
        return result;
    }
}
