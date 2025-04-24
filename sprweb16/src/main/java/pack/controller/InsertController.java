package pack.controller;

import pack.model.BoardDaoProcess;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class InsertController {
    @Autowired
    private BoardDaoProcess daoProcess;

    @GetMapping("insert")
    public String insertForm() {
        return "insform";
    }

    @PostMapping("insert")
    public String insertprocess(BoardBean bean, Model model) {
        // client ip 얻기
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = request.getHeader("X_FORWARDED_FOR");
        if (ip == null) ip = request.getRemoteAddr();
        System.out.println("ip: " + ip);
        bean.setBip(ip);
        bean.setBdate();
        int newNum = daoProcess.currentMaxNum() + 1; // 새 글 번호로 사용
        bean.setNum(newNum);
        bean.setReadcnt(0);
        bean.setGnum(newNum);
        bean.setOnum(0);
        bean.setNested(0);

        try {
        	daoProcess.insert(bean);
        	return "redirect:/list";	//추가 후 목록보기
		} catch (Exception e) {
			model.addAttribute("msg", e);
			return "error";	//정적인 에러 페이지를 호출, 현재 컨트롤러가 직접 부를 응답
		}
    }
}
