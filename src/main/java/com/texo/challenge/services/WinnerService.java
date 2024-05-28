package com.texo.challenge.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.texo.challenge.dtos.WinnerDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class WinnerService {
	
	@PersistenceContext
    private EntityManager entityManager;

	
	public List<WinnerDTO> getResultWinner(String order){
		StringBuilder strQuery = new StringBuilder();

		strQuery.append("SELECT ");
		strQuery.append("DATA.PRODUCER AS \"producer\", ");
		strQuery.append("DATA.previousWin AS \"previousWin\", ");
		strQuery.append("DATA.followingWin AS \"followingWin\", ");
		strQuery.append("DATA.interval_val AS \"interval\" ");
		strQuery.append("FROM ");
		strQuery.append("(");
		strQuery.append("  SELECT ");
		strQuery.append("    p.name AS PRODUCER, ");
		strQuery.append("    MIN(a.YEAR_AWARD) AS previousWin, ");
		strQuery.append("    MAX(a.YEAR_AWARD) AS followingWin, ");
		strQuery.append("    MAX(a.YEAR_AWARD) - MIN(a.YEAR_AWARD) AS interval_val ");
		strQuery.append("  FROM ");
		strQuery.append("    producer p ");
		strQuery.append("  JOIN ");
		strQuery.append("    AWARD_PRODUCER ap ON ap.PRODUCER_ID = p.id ");
		strQuery.append("  JOIN ");
		strQuery.append("    AWARD a ON a.ID = ap.AWARD_ID ");
		strQuery.append("  WHERE ");
		strQuery.append("    a.WINNER = TRUE ");
		strQuery.append("  GROUP BY ");
		strQuery.append("    p.name ");
		strQuery.append(") AS DATA ");
		strQuery.append("WHERE interval_val > 0 ");
		strQuery.append("ORDER BY DATA.interval_val " + order);
		strQuery.append(" LIMIT 2;");
		
		Query query = entityManager.createNativeQuery(strQuery.toString(), WinnerDTO.class);
		//query.setParameter("order", order );
		List<WinnerDTO> winnersDTO = query.getResultList();
		
		return winnersDTO;
	}
	
}
