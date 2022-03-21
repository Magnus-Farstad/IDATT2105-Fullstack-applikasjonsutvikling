package student.ntnu.no.oving_5.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import student.ntnu.no.oving_5.model.calculation.Calculation;
import java.util.List;

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

    public List<Calculation> getAllCalculations(int id) {
        System.out.println("Repository");
        List<Calculation> calculations = jdbcTemplate.query("SELECT calculation FROM calculation WHERE user_id = ? LIMIT 10", BeanPropertyRowMapper.newInstance(Calculation.class), id);
        calculations.forEach(System.out::println);
        return calculations;
    }
}
