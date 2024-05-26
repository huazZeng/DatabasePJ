package service;

import org.example.springboot.Application;
import org.example.springboot.entity.Caterer;
import org.example.springboot.service.ICatererService;
import org.example.springboot.service.impl.CatererServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Application.class)
public class ICaterServiceTest {

    @Autowired
    ICatererService iCatererService;

    @Test
    void testFindCaterBySearch(){//id=2的也被搜出来，很奇怪
        List<Caterer> list=iCatererService.findCaterBySearch("H");
        for (Caterer caterer:list){
            System.out.println(caterer);
        }
    }


}
