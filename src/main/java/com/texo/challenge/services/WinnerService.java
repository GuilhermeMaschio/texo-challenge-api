package com.texo.challenge.services;

import java.util.List;

import com.texo.challenge.repositories.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.texo.challenge.models.ResultFinalWinnerModel;
import com.texo.challenge.models.WinnerModel;
import com.texo.challenge.enuns.ParameterEnum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
@Transactional
public class WinnerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    AwardRepository awardRepository;

    public ResultFinalWinnerModel extractedResult() {
		List<WinnerModel> min = getResultWinners(ParameterEnum.ASC.toString());
		List<WinnerModel> max = getResultWinners(ParameterEnum.DESC.toString());

		ResultFinalWinnerModel result = new ResultFinalWinnerModel();
		result.setMin(min);
		result.setMax(max);
		return result;
	}

    public List<WinnerModel> getResultWinners(String order) {
        String jpql = "SELECT NEW com.texo.challenge.models.WinnerModel(" +
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

        TypedQuery<WinnerModel> query = entityManager.createQuery(jpql, WinnerModel.class);
        query.setMaxResults(1);
        return query.getResultList();
    }
}