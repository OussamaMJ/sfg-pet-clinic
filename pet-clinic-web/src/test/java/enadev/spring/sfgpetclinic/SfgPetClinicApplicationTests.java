package enadev.spring.sfgpetclinic;

import org.junit.jupiter.api.Assertions;

/*@ExtendWith(SpringExtension.class)
@SpringBootTest*/
public class SfgPetClinicApplicationTests {

/*	@Test
	@DisplayName("1 + 1 = 2")*/
	void addsTwoNumbers() {
		Assertions.assertEquals(2, 1+1, "1 - 1 should equal 2");
	}
}
