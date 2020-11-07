package creditcard.detectcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;



@WebMvcTest
public class CreditCardHelperTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditCardService service;

    @Test
    public void processCardsTest() throws Exception {

    }

}
