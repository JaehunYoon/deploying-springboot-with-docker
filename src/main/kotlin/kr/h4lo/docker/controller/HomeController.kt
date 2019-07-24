package kr.h4lo.docker.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {
    @RequestMapping(path = ["/"], method = [RequestMethod.GET])
    @ResponseBody
    fun home(): String {
        return "Hello, World!"
    }

    @RequestMapping(path = ["/hello/{name}"], method = [RequestMethod.GET])
    fun greeting(@PathVariable("name") name: String,
                 model: Model): String {
        model.addAttribute("name", name)
        return "greeting"
    }
}