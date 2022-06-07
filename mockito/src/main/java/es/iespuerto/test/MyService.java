package es.iespuerto.test;

import es.iespuerto.test.dao.MyDao;
import es.iespuerto.test.entity.MyEntity;

public class MyService {
	
	private MyDao myDao;
	
	public MyService(MyDao myDao) {
		this.myDao = myDao;
	}
	
	public MyEntity findById(long id) {
		return myDao.findById(id);
	}

}
