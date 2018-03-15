package com.nabryant.web;

import com.nabryant.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/10
 * Function:
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index (ModelMap map) {

        //加入一个属性。用来在模板中读取
        map.addAttribute("host", "http://blog.nabryant.com");
        //return模板文件名，对应index.html
        return "index";
    }

    @RequestMapping("/hello")
    public  String hello(ModelMap map) throws Exception{
        throw new  Exception("e");

    }

    @RequestMapping("/json")
    public String json() throws Exception {
        throw new MyException("222");
    }


}
