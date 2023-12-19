package com.example.AcortarUrl.Repository;

import com.example.AcortarUrl.Model.AcortadorUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcortadorUrlRepository extends JpaRepository<AcortadorUrl,Long> {
    AcortadorUrl findByAcortadorUrl(String acortadorUrl);
}
