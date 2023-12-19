package com.example.AcortarUrl.Controller;

import com.example.AcortarUrl.Model.AcortadorUrl;
import com.example.AcortarUrl.Repository.AcortadorUrlRepository;
import com.example.AcortarUrl.Service.AcortadorUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/acortador")
public class AcortadorUrlController {
    private final AcortadorUrlService acortadorUrlService;

    @Autowired
    public AcortadorUrlController(AcortadorUrlService acortadorUrlService) {
        this.acortadorUrlService = acortadorUrlService;
    }

    @GetMapping
    public List<AcortadorUrl> obtenerAcortadorUrls(){
        return acortadorUrlService.obtenerAcortadorUrls();
    }

    @PostMapping
    public AcortadorUrl crearAcortadorUrl(@RequestBody AcortadorUrl acortadorUrl){
        return acortadorUrlService.crearAcortadorUrl(acortadorUrl);
    }

}
