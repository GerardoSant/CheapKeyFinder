import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito.*;

public class ConditionTest {

    @Test
    public void shouldAnswerWithTrue(){
        // Conf
        // Configure mock (collaborators)
        ConcreteSensor concreteSensorMock= mock(ConcreteSensor.class);
        doReturn(0).when(concreteSensorMock).getValue();

        // Configure SUT
        Object treshold = new Object();
        Operator operator = new Operator();
        Condition condition = new Condition(treshold,operator,concreteSensorMock);

        // Exec

        int vValue= (int) condition.getSensor().getValue();
        int vValue1= (int) condition.getSensor().getValue();

        // Verify

        assertTrue(vValue==0);
        assertTrue(vValue1==0);

        // Finalize

    }
}
