import java.sql.Connection;
import java.sql.Statement;

import es.iespuerto.test.connection.DBConnection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DBConnectionTest {
	
	@InjectMocks private DBConnection dbConnection;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	@BeforeEach
	public void setUp() {

		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMockDBConnection() throws Exception {	
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
		int value = dbConnection.executeQuery("");
		Assertions.assertEquals(value, 1);
		Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
	}

}
