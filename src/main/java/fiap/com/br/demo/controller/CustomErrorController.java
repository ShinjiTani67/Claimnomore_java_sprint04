package fiap.com.br.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object path = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        Object error = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);
        Object timestamp = java.time.LocalDateTime.now();

        model.addAttribute("status", status);
        model.addAttribute("message", message != null ? message : "Erro inesperado");
        model.addAttribute("path", path);
        model.addAttribute("error", error);
        model.addAttribute("timestamp", timestamp);

        return "error";
    }
}