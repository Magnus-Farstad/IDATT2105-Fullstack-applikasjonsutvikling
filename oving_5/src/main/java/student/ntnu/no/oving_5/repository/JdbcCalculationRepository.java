package student.ntnu.no.oving_5.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import student.ntnu.no.oving_5.model.Calculation;

@Repository
public class JdbcCalculationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(JdbcCalculationRepository.class);

    public int saveCalculation(int userId, String calculation) {
        logger.info("JdbcCalculationRepository");
        logger.info(calculation);
        return jdbcTemplate.update("INSERT INTO calculation (id, calculation, user_id) VALUES (DEFAULT ,?,?)",
                new Object[] {calculation, userId});
    }
}
