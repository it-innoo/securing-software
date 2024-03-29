package sec.calculator;

import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
@Points("3.1 3.2 3.3 3.4 3.5")
public class CalculatorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addTest() throws Exception {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int first = rand.nextInt(1000000) - 500000;
            int second = rand.nextInt(1000000) - 500000;

            this.mockMvc.perform(get("/add?first=" + first + "&second=" + second))
                    .andExpect(content().string("" + (first + second)));
        }
    }

    @Test
    public void multiplyTest() throws Exception {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int first = rand.nextInt(1000000) - 500000;
            int second = rand.nextInt(1000000) - 500000;

            this.mockMvc.perform(get("/multiply?first=" + first + "&second=" + second))
                    .andExpect(content().string("" + (first * second)));
        }
    }
}
