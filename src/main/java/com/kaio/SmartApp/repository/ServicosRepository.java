package com.kaio.SmartApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaio.SmartApp.DTO.servicos.response.IServiceCompleteResponse;
import com.kaio.SmartApp.entity.Servicos;

public interface ServicosRepository extends JpaRepository<Servicos, Integer> {

    List<Servicos> findAllByProIdAndAtive(int proId, boolean ative);

    @Query(value = """
                        SELECT
             s.id as serviceId,
             s.name as serviceName,
             s.price as servicePrice,
             u.id as profissionalId,
             u.complete_name as profissionalName
            FROM servicos s join users u on u.id = s.pro_id
            WHERE s.ative = 1;
                        """, nativeQuery = true)
    List<IServiceCompleteResponse> findAllResponse();

}
