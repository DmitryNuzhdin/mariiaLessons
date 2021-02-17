package springFirstTry.a;

import org.junit.jupiter.api.Test;
import springFirstTry.a.dto.ESIMarketOrderDTO;

import java.util.Collection;
import java.util.List;

import static org.junit.gen5.api.Assertions.assertTrue;


public class Tester {
    private static final int TYPE_ID = 230;

    @Test
    void testESIMarketReader(){
        ESIMarketDataReader apiReader = new ESIMarketDataReaderImpl();
        List<ESIMarketOrderDTO> lastAnswerList =  apiReader.readOrders(TYPE_ID);
        assertTrue(lastAnswerList.size() > 0);
    }
}
