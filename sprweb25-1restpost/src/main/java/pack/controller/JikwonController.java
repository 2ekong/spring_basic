package pack.controller;

import pack.model.Gogek;
import pack.model.GogekRepository;
import pack.model.JikwonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JikwonController {
    @Autowired
    private GogekRepository gogekRepository;


    @PostMapping("/get-gogek")
    public List<Gogek> getCustomers(@RequestBody JikwonDto dto) {
        return gogekRepository.findCustomersByJikwon(dto.getJikwonno(), dto.getJikwonname());
    }
}