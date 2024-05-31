package com.texo.challenge.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.texo.challenge.dtos.ResultFinalWinnerDTO;
import com.texo.challenge.dtos.WinnerDTO;
import com.texo.challenge.enuns.ParameterEnum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
@Transactional
public class WinnerService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public ResultFinalWinnerDTO extractedResult() {
		List<WinnerDTO> min = getResultWinners(ParameterEnum.ASC.toString());
		List<WinnerDTO> max = getResultWinners(ParameterEnum.DESC.toString());
		
		ResultFinalWinnerDTO result = new ResultFinalWinnerDTO();
		result.setMin(min);
		result.setMax(max);
		return result;
	}

    public List<WinnerDTO> getResultWinners(String order) {
        String jpql = "SELECT NEW com.texo.challenge.dtos.WinnerDTO(" +
                      "p.name AS producer, " +
                      "MIN(a.year) AS previousWin, " +
                      "MAX(a.year) AS followingWin, " +
                      "(MAX(a.year) - MIN(a.year)) AS interval" +
                      ") " +
                      "FROM award a " +
                      "JOIN a.producers p " +
                      "WHERE a.winner = true " +
                      "GROUP BY p.name " +
                      "HAVING (MAX(a.year) - MIN(a.year)) > 0 " +
                      "ORDER BY (MAX(a.year) - MIN(a.year)) " + order;

        TypedQuery<WinnerDTO> query = entityManager.createQuery(jpql, WinnerDTO.class);
        query.setMaxResults(1);
        return query.getResultList();
    }
}