package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProcess {
	@Autowired
	private GogekCrudRepository repository;

	// 전체자료 읽기
	public List<GogekDto> getDataAll() {
		List<Gogek> list = repository.findAll();
		return list.stream().map(GogekDto::fromEntity).collect(Collectors.toList());
	}

	public List<GogekDto> getFilteredData(String gender) {
		List<GogekDto> list = repository.findAll().stream().map(GogekDto::fromEntity).collect(Collectors.toList());

		if (!gender.equals("all")) {
			return list.stream().filter(dto -> dto.getGender().equals(gender.equals("male") ? "남성" : "여성"))
					.collect(Collectors.toList());
		}
		return list;
	}

	public int getFilteredCount(String gender) {
		return getFilteredData(gender).size();
	}

}