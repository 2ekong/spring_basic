package pack.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.EtcMapper;
import pack.model.JikwonDto;
import pack.model.DeptCountDto;
import pack.model.DeptMaxPayDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	@Autowired
	private JikwonInter inter;

	@Autowired
	private EtcMapper etcMapper;

	@Override
	public void dataPrint() {
		List<JikwonDto> list = inter.selectAllList();

		System.out.println("[직원번호 / 직원명 / 부서명 / 입사년도]");
		for (JikwonDto s : list) {
			int year = (s.getJikwonibsail() != null) ? s.getJikwonibsail().toLocalDate().getYear() : 0;
			System.out.println(s.getJikwonno() + " / " +
							   s.getJikwonname() + " / " +
							   (s.getBusername() != null ? s.getBusername() : "무소속") + " / " +
							   year);
		}
	}

	public void printDeptInfo() {
		System.out.println("\n[1] 부서별 인원수");
		List<DeptCountDto> countList = etcMapper.getDeptCount();
		for (DeptCountDto dto : countList) {
			System.out.println(dto.getBusername() + " / " + dto.getCount());
		}

		System.out.println("\n[2] 부서별 최고급여자");
		List<DeptMaxPayDto> payList = etcMapper.getDeptMaxPay();
		for (DeptMaxPayDto dto : payList) {
			System.out.println(dto.getBusername() + " / " + dto.getJikwonname() + " / " + dto.getJikwonpay());
		}
	}
}
