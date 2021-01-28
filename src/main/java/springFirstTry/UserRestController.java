package springFirstTry;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class UserRestController {
    ClientService myClientService;

    public UserRestController(ClientService myClientService) {
        this.myClientService = myClientService;
    }

    /**
     * duration":7,"is_buy_order":false,"issued":"2021-01-26T23:14:34Z","location_id":60003763,"min_volume":1,
     "order_id":5908728381,"price":102.3,"range":"region","system_id":30000140,"type_id":230,"volume_remain":21500,
     "volume_total":22000
     **/

    @RequestMapping (path = "/addNew/orderId/{orderId}/price/{price}")
    public String addEntity (@PathVariable("orderId") long orderId,
                             @PathVariable("price") double price) {
        int duration = 7;
        boolean isBuyOrder = false;
        int locationId = 60003763;
        int minVolume = 1;
        int typeId = 230;
        String range = "region";
        int systemId = 30000140;
        int volumeRemain = 21500;
        int volumeTotal = 22000;
        RequestEntity toAddEntity = new RequestEntity(orderId, price,isBuyOrder, duration, locationId, minVolume,
                range,systemId,typeId,volumeRemain,volumeTotal);
        myClientService.writeEntity(toAddEntity);
        return "We did it! -> Entity was created in repo!";
    }

    @RequestMapping (path = "/getNumberOfEntities")
    public String countEntities () {
        return " " + myClientService.countEntity() + " Entity(ies)";
    }
}
