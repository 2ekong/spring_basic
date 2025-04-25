package pack.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BoardBean {
    private int num;
    private int readcnt, gnum, onum, nested;
    private String name, pass, mail, title, cont, bip, bdate;
    private String searchValue, searchName;

    public void setBdate() {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        this.bdate = year + "-" + month + "-" + day;

    }

}
