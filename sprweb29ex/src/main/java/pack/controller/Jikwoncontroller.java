package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class Jikwoncontroller {
    
    @Autowired
    private DataDao dataDao;
    
    @GetMapping("jikwonlist")
    public String jikwonProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
        Integer gogekno = (Integer) request.getSession().getAttribute("gogekok");
        if (gogekno == null) {
            return "redirect:/login";
        }

        List<Jikwon> jlist = dataDao.findJikwonByGogekno(gogekno);
        model.addAttribute("jlist", jlist);
        return "jikshow";
    }
}
