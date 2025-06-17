package com.mrbarda.restapp.repo;

import com.mrbarda.restapp.dto.ReporteDiarioDTO;
import com.mrbarda.restapp.model.ReporteDiario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReporteDiarioRepo extends JpaRepository<ReporteDiario, Integer> {

    @Query("SELECT new com.mrbarda.restapp.dto.ReporteDiarioDTO(r.id, r.fecha, r.totalVentas, r.pedidosAtendidos, r.reservasRegistradas, r.totalCaja) FROM ReporteDiario r")
    List<ReporteDiarioDTO> findAllProjected();

    @Query("SELECT new com.mrbarda.restapp.dto.ReporteDiarioDTO(r.id, r.fecha, r.totalVentas, r.pedidosAtendidos, r.reservasRegistradas, r.totalCaja) FROM ReporteDiario r WHERE r.fecha = :fecha")
    Optional<ReporteDiarioDTO> findByFecha(@Param("fecha") LocalDate fecha);
}


