package pack.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.GogekDto;

@Controller
public class GogekController {
    @Autowired
    private DataProcess dataProcess;

    @GetMapping("/")
    public String start() {
        return "index";
    }

    @GetMapping("list")
    public String listProcess(@RequestParam(name = "gender", required = false, defaultValue = "all") String gender,
                              Model model) {
        List<GogekDto> list = dataProcess.getFilteredData(gender);
        int count = list.size();  

        model.addAttribute("datas", list);
        model.addAttribute("selectedGender", gender);
        model.addAttribute("gogekCount", count);
        return "list";
    }

    

}
