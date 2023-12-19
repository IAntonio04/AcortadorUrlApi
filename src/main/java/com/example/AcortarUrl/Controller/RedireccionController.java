package com.example.AcortarUrl.Controller;

import com.example.AcortarUrl.Model.AcortadorUrl;
import com.example.AcortarUrl.Repository.AcortadorUrlRepository;
import com.example.AcortarUrl.Service.AcortadorUrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("")
public class RedireccionController {
    private final AcortadorUrlService acortadorUrlService;

    @Autowired
    public RedireccionController(AcortadorUrlService acortadorUrlService) {
        this.acortadorUrlService = acortadorUrlService;
    }

    @GetMapping("/{urlCorto}")
    public void redireccionUrlOriginal(@PathVariable String urlCorto, HttpServletResponse response) throws IOException {
        try {
            AcortadorUrl acortadorUrl= acortadorUrlService.obetnerAcortadorPorUrlCorto(urlCorto);
            response.sendRedirect(acortadorUrl.getUrl());
        }catch (Exception e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "URL no encontrada");
        }


    }
}
