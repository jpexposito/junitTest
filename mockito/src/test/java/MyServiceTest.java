import es.iespuerto.test.MyService;
import es.iespuerto.test.dao.MyDao;
import es.iespuerto.test.entity.MyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

	@Mock MyDao myDao;

	@Test
	public void findByIdTest() {
		//MockitoAnnotations.initMocks(this);
		MyService myService = new MyService(myDao);
		myService.findById(1L);
		Mockito.verify(myDao).findById(1L);

	}
	
	@Test
	public void myServiceTest() {
		MyService myService = new MyService(myDao);
		Mockito.when(myDao.findById(1L)).thenReturn(createTestEntity());
		MyEntity actual = myService.findById(1L);
		Assertions.assertEquals("My first name", actual.getFirstName());
		Assertions.assertEquals("My surname", actual.getSurname());
		Mockito.verify(myDao).findById(1L);
	}
	
	private MyEntity createTestEntity() {
		MyEntity myEntity = new MyEntity();
		myEntity.setFirstName("My first name");
		myEntity.setSurname("My surname");
		return myEntity;
	}

}
