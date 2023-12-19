package com.example.AcortarUrl.Service;

import com.example.AcortarUrl.Model.AcortadorUrl;
import com.example.AcortarUrl.Repository.AcortadorUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AcortadorUrlService {
    private final AcortadorUrlRepository acortadorUrlRepository;
    @Autowired
    public AcortadorUrlService(AcortadorUrlRepository acortadorUrlRepository) {
        this.acortadorUrlRepository = acortadorUrlRepository;
    }
    public List<AcortadorUrl> obtenerAcortadorUrls(){
        return acortadorUrlRepository.findAll();
    }
    public AcortadorUrl obetnerAcortadorPorUrlCorto(String urlCorto){
            return acortadorUrlRepository.findByAcortadorUrl(urlCorto);
    }
    public AcortadorUrl crearAcortadorUrl(AcortadorUrl acortadorUrl){
        acortadorUrl.setCreated(obtenerFechayHoraActual());
        acortadorUrl.setAcortadorUrl(generarCodigoCortoUnico());
        return acortadorUrlRepository.save(acortadorUrl);
    }
    private String generarCodigoCortoUnico() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    private Date obtenerFechayHoraActual(){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Lima"));
        return  Date.from(localDateTime.atZone(ZoneId.of("America/Lima")).toInstant());
    }
}
