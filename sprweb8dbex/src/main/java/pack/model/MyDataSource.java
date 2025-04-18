package pack.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MyDataSource extends DriverManagerDataSource{
	public MyDataSource() {
		setDriverClassName("org.mariadb.jdbc.Driver");
        setUrl("jdbc:mariadb://localhost:3306/test");
        setUsername("root");
        setPassword("123");
    }

}
