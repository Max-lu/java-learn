package cn.maxlu.ijava.lang.reflect.proxy.my.v1;

import cn.maxlu.ijava.lang.reflect.proxy.my.IService;

/**
 * Created by luwei on 2017/5/3.
 */
public class Proxy_v1 implements IService {

    private IService service;

    public Proxy_v1(IService service) {
        this.service = service;
    }

    @Override
    public void print() {
        System.out.println("===exec before===");
        service.print();
        System.out.println("===exec after===");
    }
}
