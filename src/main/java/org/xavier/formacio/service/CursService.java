package org.xavier.formacio.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xavier.formacio.anotacio.Cacheig;
import org.xavier.formacio.anotacio.LogeigTemps;

@Service
@Slf4j
public class CursService implements ICursService{

    @Override
    public void metode1() {
        log.info ("metode1");
    }

    @Override
    @LogeigTemps
    public int metode2() {
        log.info ("metode2");
        return 0;
    }

    @Override
    @LogeigTemps
    @Cacheig
    public int metode3(int num) {
        log.info ("metode3: num {}", num);
        return num*3;
    }

    @Override
    @LogeigTemps
    @Cacheig
    public String metode4(String num) {
        log.info ("metode4: num {}", num);
        return num.concat(" FI");
    }


}
