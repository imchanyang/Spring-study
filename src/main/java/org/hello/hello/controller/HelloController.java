package org.hello.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // 그냥 문자? string으로
    @GetMapping("Hello")
    // HttpMessageConverter가 동작
    // 없으면 viewResolver
    @ResponseBody
    public String hello (@RequestParam("name") String name) {
        return "hello" + name;
    }

    // JSON으로 넘겨준다 (객체라서 디폴트로 JSON 방식)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
