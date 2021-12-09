package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
//Constructor injection
public class LogDemoService2 {
    private final MyLogger myLogger;

    public void logic(String id){
        myLogger.log("service id = " + id);
    }

}
